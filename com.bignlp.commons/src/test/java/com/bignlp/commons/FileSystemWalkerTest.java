package com.bignlp.commons;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.reporting.ConsoleReporter;

public class FileSystemWalkerTest {
	private static Logger logger = LoggerFactory
			.getLogger(FileSystemWalkerTest.class);
	private static final long METRICS_REPORT_INTERVAL = 60;
	private FileSystemWalker walker;
	private FileProcessingVisitor visitor;
	private int queueSize = 100;
	private int numThreads = 10;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("initializing file processing metrics");
		}
		FileProcessingMetricsRegistry.set(Metrics.defaultRegistry());
		ConsoleReporter.enable(METRICS_REPORT_INTERVAL, TimeUnit.SECONDS);
		if (logger.isInfoEnabled()) {
			logger.info("Done.");
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info("Reporting metrics on console");
		}
		ConsoleReporter consoleReporter = new ConsoleReporter(System.out);
		consoleReporter.run();
		if (logger.isInfoEnabled()) {
			logger.info("Done.");
		}
	}

	@Before
	public void setUp() throws Exception {
		this.visitor = new FileProcessingVisitor(
				BasicThreadPoolExecutor.createExecutorService(queueSize,
						numThreads), new FileProcessorFactory(), "*.exe");
		this.walker = new FileSystemWalker(Paths.get("D:\\devhome"), true,
				this.visitor);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWalk() {
		if (logger.isDebugEnabled()) {
			logger.debug("executing testWalk()...");
		}
		this.walker.walk();
	}

}
