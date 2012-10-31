package com.bignlp.opm;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.bignlp.commons.FileProcessor;
import com.bignlp.langy.MedicalAnnotator;
import com.bignlp.langy.PosAnnotator;
import com.bignlp.langy.TextExtractor;

public class FileAnnotator extends FileProcessor {
	private PosAnnotator posAnnotator;
	public MedicalAnnotator medicalAnnotator;
	static {
	}

	public FileAnnotator(Path argPath) {
		super(argPath);
		this.posAnnotator = new PosAnnotator();
		this.medicalAnnotator = new MedicalAnnotator();
	}

	@Override
	public void process() {
		Path destPath = Paths.get(this.getPath().toFile().getAbsolutePath()
				+ System.currentTimeMillis() + ".extracted.txt");
		TextExtractor textExtractor = new TextExtractor(this.getPath(),
				destPath);
		textExtractor.extract();
		this.posAnnotator.annotate(destPath);
		this.medicalAnnotator.annotate(destPath);
	}

	public void destroy() {
		if (this.medicalAnnotator != null) {
			this.medicalAnnotator.close();
		}
	}
}
