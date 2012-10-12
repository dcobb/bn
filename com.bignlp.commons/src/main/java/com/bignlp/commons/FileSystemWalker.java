package com.bignlp.commons;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileSystemWalker {
	private static Logger logger = LoggerFactory
			.getLogger(FileSystemWalker.class);
	private final Path startDir;
	private final boolean recursive;
	private final FileProcessingVisitor fileVisitor;

	public FileSystemWalker(Path argStartDir, boolean argRecusive,
			FileProcessingVisitor argFileVisitor) {
		this.startDir = checkNotNull(argStartDir, "argStartDir cannot be null");
		File file = argStartDir.toFile();
		checkArgument(file.exists(), "argStartDir does not exist");
		checkArgument(file.isDirectory(), "argStartDir is not a directory");
		this.recursive = argRecusive;
		this.fileVisitor = checkNotNull(argFileVisitor);
	}

	public void walk() {
		if (this.recursive) {
			if (logger.isDebugEnabled()) {
				logger.debug("Walking file tree starting with directory: "
						+ this.startDir);
			}
			try {
				Files.walkFileTree(this.startDir, this.fileVisitor);
			} catch (IOException e) {
				throw new FileProcessingException(
						"exception while walking the file tree in recursive mode",
						e);
			}
		} else {
			throw new UnsupportedOperationException(
					"feature not implemented yet");
		}
	}

}
