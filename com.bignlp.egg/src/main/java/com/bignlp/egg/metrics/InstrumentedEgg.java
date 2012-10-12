package com.bignlp.egg.metrics;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

import objectexplorer.MemoryMeasurer;
import objectexplorer.ObjectGraphMeasurer;
import objectexplorer.ObjectGraphMeasurer.Footprint;

import com.bignlp.egg.DuplicateEntryException;
import com.bignlp.egg.Egg;
import com.bignlp.egg.EggException;
import com.bignlp.egg.impl.trie.TrieEggNodeFactory;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;

public class InstrumentedEgg<V extends Serializable> implements Egg<V> {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private Egg<V> delegate;

	private transient Counter duplicateInserts;
	private transient Counter failedInserts;
	private transient Counter failedLookups;

	private transient Timer insertTimer;
	private transient Timer lookupTimer;
	private transient Counter nullInserts;
	private transient Counter successfulInserts;
	private transient Counter successfulLookups;
	private transient Counter totalInserts;

	private transient Counter totalLookups;

	private transient AtomicLong maxEntries = new AtomicLong(100 * 1000 * 1000);

	public InstrumentedEgg(Egg<V> argEgg) {
		super();
		this.delegate = argEgg;
		initializeMetrics();
	}

	public V find(CharSequence argCharSequence) {
		if (argCharSequence != null) {
			this.totalLookups.inc();
		}
		TimerContext timerContext = this.lookupTimer.time();
		V result = null;
		try {
			result = this.delegate.find(argCharSequence);
		} finally {
			timerContext.stop();
			if (result != null) {
				this.successfulLookups.inc();
			} else {
				this.failedLookups.inc();
			}
		}
		return result;
	}

	public TrieEggNodeFactory<V> getEggNodeFactory() {
		return this.getEggNodeFactory();
	}

	public void initializeMetrics() {
		this.totalLookups = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "totalLookups");
		this.successfulLookups = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "successfulLookups");
		this.failedLookups = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "failedLookups");
		this.totalInserts = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "totalInserts");
		this.successfulInserts = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "successfulInserts");
		this.failedInserts = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "failedInserts");
		this.nullInserts = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "nullInserts");
		this.duplicateInserts = EggMetricsRegistry.get().newCounter(
				InstrumentedEgg.class, "duplicateInserts");
		this.lookupTimer = EggMetricsRegistry.get().newTimer(InstrumentedEgg.class,
				"lookupTimer", TimeUnit.MICROSECONDS, TimeUnit.SECONDS);
		this.insertTimer = EggMetricsRegistry.get().newTimer(InstrumentedEgg.class,
				"insertTimer", TimeUnit.MICROSECONDS, TimeUnit.SECONDS);
	}

	public void insert(CharSequence argCharSequence, V argValue) {
		if (argCharSequence != null) {
			this.totalInserts.inc();
		} else {
			this.nullInserts.inc();
		}
		TimerContext timerContext = insertTimer.time();
		try {
			this.delegate.insert(argCharSequence, argValue);
			this.successfulInserts.inc();
			if (this.successfulInserts.count() >= maxEntries.get()) {
				throw new EggException(
						"maxEntries inserted. Cant take no more! entriesCount:"
								+ this.successfulInserts.count());
			}
		} catch (DuplicateEntryException e) {
			this.duplicateInserts.inc();
			// throw e;
		} catch (Exception e) {
			this.failedInserts.inc();
			throw new EggException("Insert Failed", e);
		} finally {
			timerContext.stop();
		}
	}

	public void setEggNodeFactory(TrieEggNodeFactory<V> argEggNodeFactory) {
		this.setEggNodeFactory(argEggNodeFactory);
	}

	public long getMemory() {
		long memory = MemoryMeasurer.measureBytes(this);
		return memory;
	}

	public Footprint getFootPrint() {
		return ObjectGraphMeasurer.measure(this);
	}
}
