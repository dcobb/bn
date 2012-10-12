package com.bignlp.commons;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.core.Timer;

public class FileProcessingVisitor extends SimpleFileVisitor<Path> {
	private static final PathMatcherCache PATH_MATCHER_CACHE = new PathMatcherCache();
	private final List<PathMatcher> pathMatchers;
	private final ExecutorService executorService;
	private final FileProcessorFactory fileProcessorFactory;
	private Timer timer;

	public FileProcessingVisitor(ExecutorService argExecutorService,
			FileProcessorFactory argFileProcessorFactory, String... argPatterns) {
		this.executorService = checkNotNull(argExecutorService,
				"argExecutorService cannot be null");
		this.fileProcessorFactory = checkNotNull(argFileProcessorFactory,
				"argFileProcessorFactory cannot be null");
		String[] patterns = checkNotNull(argPatterns,
				"argPatterns cannot be null");
		checkArgument(argPatterns.length > 0, "argPatterns cannot be empty");
		this.pathMatchers = new ArrayList<PathMatcher>();
		for (String pattern : patterns) {
			pattern = checkNotNull(pattern, "pattern cannot be null");
			PathMatcher matcher = this.getPathMatcherCache().getPathMatcher(
					pattern);
			this.pathMatchers.add(matcher);
		}
		this.timer = FileProcessingMetricsRegistry.get().newTimer(
				FileProcessingVisitor.class, "fileProcessingTimer",
				TimeUnit.MICROSECONDS, TimeUnit.SECONDS);
	}

	private PathMatcherCache getPathMatcherCache() {
		return PATH_MATCHER_CACHE;
	}

	private void process(Path argPath) {
		Path path = checkNotNull(argPath, "argPath cannot be null");
		Path fileName = path.getFileName();
		if (fileName != null) {
			for (PathMatcher pathMatcher : this.pathMatchers) {
				checkNotNull(pathMatcher);
				if (pathMatcher.matches(fileName)) {
					FileProcessor fileProcessor = this.fileProcessorFactory
							.newFileProcessor(path);
					fileProcessor.setTimer(this.timer);
					Future<FileProcessingResult> fileProcessingResult = this.executorService
							.submit(fileProcessor);
					return;
				}
			}
		}
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		return super.preVisitDirectory(dir, attrs);
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		process(file);
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		return super.visitFileFailed(file, exc);
	}

	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		return super.postVisitDirectory(dir, exc);
	}

}
