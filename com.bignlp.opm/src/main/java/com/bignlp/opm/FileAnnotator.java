package com.bignlp.opm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.bignlp.commons.FileProcessingException;
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
		Path extractedTextFilePath = Paths.get(this.getPath().toFile()
				.getAbsolutePath()
				+ System.currentTimeMillis() + ".extracted.txt");
		Path trimmedTextFilePath = Paths.get(this.getPath().toFile()
				.getAbsolutePath()
				+ System.currentTimeMillis() + ".trimmed.txt");
		TextExtractor textExtractor = new TextExtractor(this.getPath(),
				extractedTextFilePath);
		textExtractor.extract();
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new FileReader(
					extractedTextFilePath.toFile()));
			bw = new BufferedWriter(
					new FileWriter(trimmedTextFilePath.toFile()));
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					bw.write(line);
					bw.write("\n");
				}
			}
		} catch (Exception e) {
			throw new FileProcessingException(
					"Exception while removing blank lines from: "
							+ extractedTextFilePath.toFile().getAbsolutePath(),
					e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
		this.posAnnotator.annotate(trimmedTextFilePath);
		this.medicalAnnotator.annotate(trimmedTextFilePath);
	}

	public void destroy() {
		if (this.medicalAnnotator != null) {
			this.medicalAnnotator.close();
		}
	}
}
