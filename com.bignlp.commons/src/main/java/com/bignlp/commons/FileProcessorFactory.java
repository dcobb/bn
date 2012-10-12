package com.bignlp.commons;

import java.nio.file.Path;

public class FileProcessorFactory {
	public FileProcessor newFileProcessor(Path argPath) {
		return new FileProcessor(argPath);
	}
}
