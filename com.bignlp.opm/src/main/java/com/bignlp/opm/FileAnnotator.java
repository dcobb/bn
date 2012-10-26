package com.bignlp.opm;

import java.nio.file.Path;

import com.bignlp.commons.FileProcessor;
import com.bignlp.langy.MedicalAnnotator;
import com.bignlp.langy.PosAnnotator;

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
		this.posAnnotator.annotate(this.getPath());
		this.medicalAnnotator.annotate(this.getPath());
	}

	public void destroy() {
		if (this.medicalAnnotator != null) {
			this.medicalAnnotator.close();
		}
	}
}
