package com.bignlp.commons;

import static com.google.common.base.Preconditions.checkNotNull;

import java.nio.file.Path;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bignlp.commons.FileProcessingResult.Status;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;

public class FileProcessor implements Callable<FileProcessingResult> {
	private static Logger logger = LoggerFactory.getLogger(FileProcessor.class);
	private final Path path;
	private final FileProcessingResult result;
	private Timer timer;

	public FileProcessor(Path path) {
		this.path = checkNotNull(path);
		this.result = new FileProcessingResult();
		this.result.setStatus(Status.initialized);
	}

	public Path getPath() {
		return this.path;
	}

	public FileProcessingResult getResult() {
		return this.result;
	}

	public Timer getTimer() {
		return this.timer;
	}

	public void setTimer(Timer argTimer) {
		this.timer = argTimer;
	}

	public FileProcessingResult call() throws Exception {
		TimerContext tc = this.getTimer().time();
		try {
			process();
		} finally {
			tc.stop();
		}
		return this.result;
	}

	public void process() {
		this.result.setStatus(Status.completedSuccessfully);
		if (logger.isDebugEnabled()) {
			logger.debug("Processed file: " + this.path + " status: "
					+ this.result.getStatus());
		}
	}

}
