package com.bignlp.langy;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bignlp.langy.metamap.MetaMapConfig;
import com.bignlp.langy.metamap.MmClient;
import com.bignlp.langy.metamap.Result;

public class MedicalAnnotator {
	private static Logger logger = LoggerFactory
			.getLogger(MedicalAnnotator.class);
	private MmClient mmClient;

	public MedicalAnnotator() {
		this.mmClient = new MmClient("127.0.0.1", MetaMapConfig.getInstance()
				.getRoundRobinPort());
		this.mmClient.setTimeout(-1);
		if (logger.isDebugEnabled()) {
			logger.debug("Round-robin MmClinet choice: " + mmClient);
		}
	}

	public String annotate(Path argFilePath) {
		try {
			List<Result> results = new ArrayList<Result>();
			mmClient.process(MmClient.readInputFile(argFilePath.toFile()),
					System.out);
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
