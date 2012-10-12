package com.bignlp.opm;

import java.nio.file.Path;

import com.bignlp.commons.FileProcessorFactory;

public class FileAnnotatorFactory extends FileProcessorFactory {
	@Override
	public FileAnnotator newFileProcessor(Path argPath) {
		return new FileAnnotator(argPath);
	}
}
