package com.bignlp.egg.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.bignlp.commons.BasicThreadPoolExecutor;
import com.bignlp.egg.Egg;
import com.bignlp.egg.EggDeserializer;
import com.bignlp.egg.EggFactory;
import com.bignlp.egg.EggSerializer;
import com.bignlp.egg.Glossary;
import com.bignlp.egg.Glossary.Entry;
import com.bignlp.egg.metrics.EggMetricsRegistry;
import com.bignlp.egg.metrics.InstrumentedEgg;
import com.yammer.metrics.Metrics;
import com.yammer.metrics.reporting.ConsoleReporter;

public abstract class AbstractEggFactoryTest {
	private static class EntryLookupRunnable implements Runnable {

		private Egg<Integer> egg2;
		private Glossary.Entry<Integer> entry;

		public EntryLookupRunnable(Entry<Integer> argEntry, Egg<Integer> argEgg) {
			super();
			this.entry = argEntry;
			this.egg2 = argEgg;
		}

		public void run() {
			totalLooupsFromRunnable.incrementAndGet();
			if (entry != null) {
				Integer value = egg2.find(entry.getCharSequence());
				Assert.assertSame(entry.getValue(), value);
			}
		}

	}

	private static int maxThreads = 9;
	private static int numIterations = 100;
	private static final long METRICS_REPORT_INTERVAL = 60;

	private static int numThreads = numIterations > maxThreads ? maxThreads
			: (numIterations - 1);
	private static int queueSize = 100;

	private static final AtomicLong totalLooupsFromRunnable = new AtomicLong();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("initializing egg metrics...");
		EggMetricsRegistry.set(Metrics.defaultRegistry());
		ConsoleReporter.enable(METRICS_REPORT_INTERVAL, TimeUnit.SECONDS);
		System.out.println("Done.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearing down egg metrics...");
		EggMetricsRegistry.get().shutdown();
		System.out.println("Done.");
		System.out.println("Reporting metrics on console...");
		ConsoleReporter consoleReporter = new ConsoleReporter(System.out);
		consoleReporter.run();
		System.out.println("Done.");
	}

	private Egg<Integer> egg;

	private EggFactory<Integer> eggFactory;

	private Glossary<Integer> glossary;

	private Glossary<Integer> lookupGlossary;

	public AbstractEggFactoryTest(EggFactory<Integer> argEggFactory) {
		super();
		this.eggFactory = argEggFactory;
	}

	public void setUpLoremGlossary() {
		System.out.println("Setting up lorem glossary");
		this.glossary = new PersistedGlossary<Integer>(
				new LoremGlossary<Integer>(25 * 1000 * 1000), this.getClass()
						.getName() + ".lorem");
		this.lookupGlossary = new FileGlossary<Integer>(this.getClass()
				.getName() + ".lorem");
	}

	public void setUpNeverEndingLoremGlossary() {
		System.out.println("Setting up lorem glossary");
		this.glossary = new LoremGlossary<Integer>();
		this.lookupGlossary = new FileGlossary<Integer>(this.getClass()
				.getName() + ".lorem");
	}

	public void setUpNeverEndingRandomGlossary() {
		System.out.println("Setting up lorem glossary");
		this.glossary = new RandomEnglishGlossary<Integer>();
		this.lookupGlossary = new FileGlossary<Integer>(this.getClass()
				.getName() + ".lorem");
	}

	public void setUpFileGlossary() {
		System.out.println("Setting up file glossary");
		this.glossary = new FileGlossary<Integer>(this.getClass().getName()
				+ ".lorem");
		this.lookupGlossary = new FileGlossary<Integer>(this.getClass()
				.getName() + ".lorem");
	}

	public void setUpSmallFileGlossary() {
		String filePath = "src/test/resources/wordlist/words.txt";
		System.out.println("Setting up file glossary");
		this.glossary = new FileGlossary<Integer>(filePath);
		this.lookupGlossary = new FileGlossary<Integer>(filePath);
	}

	public void setUp3mnFileGlossary() {
		String filePath = "src/test/resources/wordlist/hugewordlistcleaned.txt";
		System.out.println("Setting up file glossary");
		this.glossary = new FileGlossary<Integer>(filePath);
		this.lookupGlossary = new FileGlossary<Integer>(filePath);
	}

	@Before
	public void setUp() throws Exception {
		setUp3mnFileGlossary();
		System.out.println("Seting up eggs...");
		System.out.println("Using " + this.glossary + " as Glossary");
		System.out.println("Using " + this.getEggFactory() + " as EggFactory");
		this.egg = this.getEggFactory().newEgg(this.glossary);
		System.out.println("Using " + this.egg.getClass() + " as Egg");
		collectGarbage();
		this.glossary.close();
		// Footprint footprint = ((InstrumentedEgg<Integer>) this.egg)
		// .getFootPrint();
		// System.out.println(footprint);
		long memory = ((InstrumentedEgg<Integer>) this.egg).getMemory();
		System.out.println("Total Memory Consumed by " + this.getClass()
				+ " is:" + memory);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearing down...");
		if (this.glossary != null) {
			this.glossary.close();
		}
		if (this.lookupGlossary != null) {
			this.lookupGlossary.close();
		}
		System.out.println("Done.");
		collectGarbage();
	}

	@Test
	@Ignore
	public void testDummy() throws Exception {
		System.out.println("Dummy test");
	}

	@Ignore
	@Test
	public void testPersistedLoremGlossary() throws Exception {
		int i = 0;
		for (Glossary.Entry<Integer> entry : this.glossary) {
			if (entry != null) {
				++i;
			}
		}
		System.out.println("Total Words: " + i);
		this.glossary.close();
	}

	@Test
	@Ignore
	public void testEggSerializer() throws Exception {
		EggSerializer<Integer> serializer = new StandardJavaEggSerializer<Integer>();
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(this.getClass()
					.getName() + ".egg"));
			serializer.write(this.egg, bos);
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	@Test
	@Ignore
	public void testEggDeserializer() throws Exception {
		EggDeserializer<Integer> deserializer = new StandardJavaEggDeserializer<Integer>();
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(this.getClass()
					.getName() + ".egg"));
			this.egg = deserializer.read(bis);
			Assert.assertNotNull(this.egg);
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	@Test
	@Ignore
	public void testLookup() throws Exception {
		collectGarbage();
		ExecutorService executorService = BasicThreadPoolExecutor
				.createExecutorService(queueSize, numThreads);

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < numIterations; ++i) {
			for (Glossary.Entry<Integer> entry : this.lookupGlossary) {
				Runnable runnable = new EntryLookupRunnable(entry, this.egg);
				executorService.execute(runnable);
			}
			this.lookupGlossary.reset();
		}
		BasicThreadPoolExecutor.shutdown(executorService);

		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Time taken to test EggTrie: " + totalTime
				+ " milliseconds. Total Lookups: " + totalLooupsFromRunnable
				+ " TPS: "
				+ ((double) totalLooupsFromRunnable.get() * 1000 / totalTime)
				+ " lookups/second.");
	}

	private void collectGarbage() {
		System.out.println("collecting garbage...");
		System.gc();
		System.out
				.println("Sleeping for 10 sec to finish garbage collection...");
		try {
			Thread.sleep(10 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

	private EggFactory<Integer> getEggFactory() {
		return eggFactory;
	}
}
