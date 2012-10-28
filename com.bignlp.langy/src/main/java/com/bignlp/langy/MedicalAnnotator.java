package com.bignlp.langy;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bignlp.langy.metamap.MetaMapConfig;
import com.bignlp.langy.metamap.MmClient;
import com.bignlp.langy.metamap.Result;
import com.google.gson.Gson;

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
			List<Result> results = mmClient.process(
					MmClient.readInputFile(argFilePath.toFile()), System.out);
			String annotatedString = this.asMachineOutputString(results);
			// this.toString(results);
			// this.toJsonString(results);
			// this.serializeResultsToDisk(argFilePath,results);
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

	private String toJsonString(List<Result> results) {
		Gson gson = new Gson();
		// new GsonBuilder().setPrettyPrinting().create();
		String jsonOutput = gson.toJson(results);
		return jsonOutput;
	}

	@SuppressWarnings("unused")
	private String serializeResultsToDisk(Path argFilePath, List<Result> results) {
		ObjectOutputStream oos = null;
		try {
			String serFileName = argFilePath.toAbsolutePath()
					+ ".medicalannotator.ser";
			oos = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(serFileName)));
			oos.writeObject(results);
			return serFileName;
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error(
						"exception while serializing the result for file: "
								+ argFilePath.toFile().getAbsolutePath(), e);
			}
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unused")
	private String toString(List<Result> results) {
		StringBuilder sb = new StringBuilder();
		if (results != null && !results.isEmpty()) {
			for (Result result : results) {
				if (result != null) {
					String machineOutput = result.toString();
					sb.append(machineOutput);
				}
			}
		}
		String annotatedString = sb.toString();
		return annotatedString;
	}

	private String asMachineOutputString(List<Result> results) {
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
	}

	private Result readFromMachineOutput(String argMachineOutputString) {

		return null;
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
