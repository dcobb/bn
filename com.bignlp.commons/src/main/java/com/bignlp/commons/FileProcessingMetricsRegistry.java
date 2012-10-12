package com.bignlp.commons;

import com.yammer.metrics.core.MetricsRegistry;

public class FileProcessingMetricsRegistry {
	public static final ThreadLocal<MetricsRegistry> metricsRegistry = new ThreadLocal<MetricsRegistry>();

	public static MetricsRegistry get() {
		return metricsRegistry.get();
	}

	public static void remove() {
		metricsRegistry.remove();
	}

	public static void set(MetricsRegistry argMetricsRegistry) {
		metricsRegistry.set(argMetricsRegistry);
	}
}
