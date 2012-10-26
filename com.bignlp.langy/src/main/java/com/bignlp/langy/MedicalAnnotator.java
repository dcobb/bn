package com.bignlp.langy;

import gov.nih.nlm.nls.metamap.Result;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedicalAnnotator {
	private static Logger logger = LoggerFactory
			.getLogger(MedicalAnnotator.class);
	private MmClient mmClient;

	public MedicalAnnotator() {
		this.mmClient = new MmClient("localhost", 8066);
		this.mmClient.setTimeout(-1);
	}

	public String annotate(Path argFilePath) {
		try {
			List<Result> results = new ArrayList<Result>();
			this.mmClient.process(MmClient.readInputFile(argFilePath.toFile()),
					System.out);
			// MetaMapApiTest.main(new String[] { "--input",
			// argFilePath.toFile().getAbsolutePath() });
			StringBuilder sb = new StringBuilder();
			if (results != null && !results.isEmpty()) {
				for (Result result : results) {
					if (result != null) {
						String machineOutput = result.getMachineOutput();
						sb.append(machineOutput);
					}
				}
			}
			String annotatedString = sb.toString();
			if (logger.isDebugEnabled()) {
				logger.debug(annotatedString);
			}
			return annotatedString;
		} catch (Exception e) {
			throw new AnnotationException(
					"Exception while performing POS Annotation", e);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("Done processing file: " + argFilePath);
			}
		}
	}

	public void close() {
		if (this.mmClient != null) {
			try {
				this.mmClient.close();
			} catch (Exception ignore) {
				// ignore
			}
		}
	}
}
