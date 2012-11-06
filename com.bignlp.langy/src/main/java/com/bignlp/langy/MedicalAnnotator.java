package com.bignlp.langy;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import se.sics.prologbeans.PBTerm;

import com.bignlp.langy.metamap.MetaMapConfig;
import com.bignlp.langy.metamap.MmClient;
import com.bignlp.langy.metamap.Result;
import com.bignlp.langy.metamap.ResultImpl;
import com.bignlp.langy.metamap.result.AnnotationBeanUtils;
import com.bignlp.langy.metamap.result.DocumentAnnotationsBean;
import com.bignlp.langy.metamap.result.MetaMapResult;
import com.bignlp.langy.metamap.result.MetaMapUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

	public void annotate(Path argFilePath) {
		try {
			String inputFileContentAsString = MmClient
					.readInputFile(argFilePath.toFile());
			List<Result> results = mmClient.process(inputFileContentAsString,
					System.out);
			this.writeJson(
					Paths.get(argFilePath.toFile().getAbsolutePath() + "."
							+ System.currentTimeMillis()
							+ ".medicalannotator.js"), results);

			List<MetaMapResult> mmResults = MetaMapUtils
					.createMetaMapResults(results);
			DocumentAnnotationsBean documentAnnotationsBean = AnnotationBeanUtils
					.createDocumentAnnotationsBean(inputFileContentAsString,
							mmResults);
			this.writeDocumentAnnotationsBeanJson(
					Paths.get(argFilePath.toFile().getAbsolutePath() + "."
							+ System.currentTimeMillis() + ".dab.js"),
					documentAnnotationsBean);
		} catch (Exception e) {
			throw new AnnotationException(
					"Exception while performing POS Annotation", e);
		} finally {
			if (logger.isDebugEnabled()) {
				logger.debug("Done processing file: " + argFilePath);
			}
		}
	}

	private void writeDocumentAnnotationsBeanJson(Path argFilePath,
			DocumentAnnotationsBean documentAnnotationsBean) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(argFilePath.toFile()));
			gson.toJson(documentAnnotationsBean, writer);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error(
						"exception while serializing the result for file: "
								+ argFilePath.toFile().getAbsolutePath(), e);
			}
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	private void writeJson(Path argFilePath, List<Result> results) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(argFilePath.toFile()));
			gson.toJson(MetaMapUtils.createMetaMapResults(results), writer);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error(
						"exception while serializing the result for file: "
								+ argFilePath.toFile().getAbsolutePath(), e);
			}
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void writeJavaObject(Path argFilePath, List<Result> results) {
		List<MetaMapResult> mmResults = MetaMapUtils
				.createMetaMapResults(results);
		ObjectOutputStream oos = null;
		try {
			String serFileName = argFilePath.toAbsolutePath()
					+ ".medicalannotator.ser";
			oos = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(serFileName)));
			oos.writeObject(mmResults);
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
	}

	@SuppressWarnings("unused")
	private void writePrologMachineOutput(Path argFilePath, List<Result> results) {
		if (results != null && !results.isEmpty()) {
			Writer writer = null;
			try {
				writer = new BufferedWriter(
						new FileWriter(argFilePath.toFile()));
				for (Result result : results) {
					if (result != null) {
						String machineOutput = result.getMachineOutput();
						String inputText = result.getInputText();
						PBTerm pbTerm = PBTerm.makeTerm(machineOutput);
						System.out
								.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% class name of MMOPBList() : "
										+ pbTerm.getClass().getName());
						Result actualResult = new ResultImpl(pbTerm, inputText);
						String actualMachineOutput = result.getMachineOutput();
						System.out
								.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ assertion of machine output ser/deser: "
										+ machineOutput
												.equals(actualMachineOutput));
						writer.write(machineOutput);
						writer.write("\n");
					}
				}
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error(
							"exception while serializing the result for file: "
									+ argFilePath.toFile().getAbsolutePath(), e);
				}
			} finally {
				if (writer != null) {
					try {
						writer.close();
					} catch (Exception ignore) {
						// ignore
					}
				}
			}
		}
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
