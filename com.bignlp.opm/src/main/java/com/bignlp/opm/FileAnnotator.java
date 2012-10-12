package com.bignlp.opm;

import java.nio.file.Path;

import com.bignlp.commons.FileProcessor;
import com.bignlp.langy.PosAnnotator;

public class FileAnnotator extends FileProcessor {
	private PosAnnotator posAnnotator;

	public FileAnnotator(Path argPath) {
		super(argPath);
		this.posAnnotator = new PosAnnotator();
	}

	@Override
	public void process() {
		this.posAnnotator.annotate(this.getPath());
	}
}
