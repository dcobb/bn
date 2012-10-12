package com.bignlp.commons;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicThreadPoolExecutor extends ThreadPoolExecutor {
	private static Logger logger = LoggerFactory
			.getLogger(BasicThreadPoolExecutor.class);

	public static ExecutorService createExecutorService(int argQueueSize,
			int argNumThreads) {
		BlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>(
				argQueueSize);
		ThreadPoolExecutor threadPoolExecutor = new BasicThreadPoolExecutor(
				argNumThreads, argNumThreads, 3, TimeUnit.SECONDS,
				linkedBlockingQueue, new ThreadPoolExecutor.CallerRunsPolicy());
		return threadPoolExecutor;
	}

	public static void shutdown(ExecutorService argExecutorService) {
		if (logger.isInfoEnabled()) {
			logger.info("Shutting down Thread Pool Executor: "
					+ argExecutorService);
		}
		argExecutorService.shutdown();
		try {
			while (!argExecutorService.awaitTermination(1L, TimeUnit.SECONDS)) {
				// Await task completion.
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(
					"Exception while shutting down Thread Pool Executor: "
							+ argExecutorService, e);
		}
		if (logger.isInfoEnabled()) {
			logger.info("Shutdown completed successfully. Thread Pool Executor: "
					+ argExecutorService);
		}
	}

	public BasicThreadPoolExecutor(int argCorePoolSize, int argMaximumPoolSize,
			long argKeepAliveTime, TimeUnit argUnit,
			BlockingQueue<Runnable> argWorkQueue) {
		super(argCorePoolSize, argMaximumPoolSize, argKeepAliveTime, argUnit,
				argWorkQueue);
	}

	public BasicThreadPoolExecutor(int argCorePoolSize, int argMaximumPoolSize,
			long argKeepAliveTime, TimeUnit argUnit,
			BlockingQueue<Runnable> argWorkQueue,
			RejectedExecutionHandler argHandler) {
		super(argCorePoolSize, argMaximumPoolSize, argKeepAliveTime, argUnit,
				argWorkQueue, argHandler);
	}

	public BasicThreadPoolExecutor(int argCorePoolSize, int argMaximumPoolSize,
			long argKeepAliveTime, TimeUnit argUnit,
			BlockingQueue<Runnable> argWorkQueue, ThreadFactory argThreadFactory) {
		super(argCorePoolSize, argMaximumPoolSize, argKeepAliveTime, argUnit,
				argWorkQueue, argThreadFactory);
	}

	public BasicThreadPoolExecutor(int argCorePoolSize, int argMaximumPoolSize,
			long argKeepAliveTime, TimeUnit argUnit,
			BlockingQueue<Runnable> argWorkQueue,
			ThreadFactory argThreadFactory, RejectedExecutionHandler argHandler) {
		super(argCorePoolSize, argMaximumPoolSize, argKeepAliveTime, argUnit,
				argWorkQueue, argThreadFactory, argHandler);
	}

}
