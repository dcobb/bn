package com.bignlp.opm;

import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bignlp.commons.BasicThreadPoolExecutor;
import com.bignlp.commons.FileProcessingMetricsRegistry;
import com.bignlp.commons.FileProcessingVisitor;
import com.bignlp.commons.FileProcessorFactory;
import com.bignlp.commons.FileSystemWalker;
import com.yammer.metrics.Metrics;
import com.yammer.metrics.reporting.ConsoleReporter;

public class AnnotationEngine {
	private static final long METRICS_REPORT_INTERVAL = 60;
	private static Logger logger = LoggerFactory
			.getLogger(AnnotationEngine.class);
	private int queueSize;
	private int numThreads;
	private ExecutorService executorService;
	private FileProcessorFactory fileProcessorFactory;

	public AnnotationEngine() {
		super();
	}

	public int getQueueSize() {
		return this.queueSize;
	}

	public void setQueueSize(int argQueueSize) {
		this.queueSize = argQueueSize;
	}

	public int getNumThreads() {
		return this.numThreads;
	}

	public void setNumThreads(int argNumThreads) {
		this.numThreads = argNumThreads;
	}

	public void init() {
		this.executorService = BasicThreadPoolExecutor.
				createExecutorService(this.queueSize, this.numThreads);
//				.singleThreadExecutorService();
		this.fileProcessorFactory = new FileAnnotatorFactory();
		if (logger.isInfoEnabled()) {
			logger.info("initializing file processing metrics");
		}
		FileProcessingMetricsRegistry.set(Metrics.defaultRegistry());
		ConsoleReporter.enable(METRICS_REPORT_INTERVAL, TimeUnit.SECONDS);
		if (logger.isInfoEnabled()) {
			logger.info("Done.");
		}
	}

	public void destroy() {
		BasicThreadPoolExecutor.shutdown(this.executorService);
		if (logger.isInfoEnabled()) {
			logger.info("Reporting metrics on console");
		}
		// FileAnnotator.medicalAnnotator.close();
		ConsoleReporter consoleReporter = new ConsoleReporter(System.out);
		consoleReporter.run();
		if (logger.isInfoEnabled()) {
			logger.info("Done.");
		}
	}

	public void annotate(Path argDataDir, String... argPatterns) {
		FileProcessingVisitor visitor = new FileProcessingVisitor(
				executorService, fileProcessorFactory, argPatterns);
		FileSystemWalker walker = new FileSystemWalker(argDataDir, true,
				visitor);
		walker.walk();
	}
}
