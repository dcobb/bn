package com.bignlp.langy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;

import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

public class PosAnnotator {
	private static final String MODELS_EN_POS_MAXENT_BIN = "../com.bignlp/models/en-pos-maxent.bin";
	private POSModel model;

	public PosAnnotator() {
		this.model = new POSModelLoader().load(new File(
				MODELS_EN_POS_MAXENT_BIN));
	}

	public void annotate(Path argFilePath) {
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);

		ObjectStream<String> lineStream = null;

		try {
			lineStream = new PlainTextByLineStream(new BufferedReader(
					new FileReader(argFilePath.toFile())));

			perfMon.start();
			String line;
			while ((line = lineStream.read()) != null) {

				String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
						.tokenize(line);
				String[] tags = tagger.tag(whitespaceTokenizerLine);

				POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
				System.out.println(sample.toString());

				perfMon.incrementCounter();
			}
			perfMon.stopAndPrintFinalResult();
		} catch (Exception e) {
			throw new AnnotationException(
					"Exception while performing POS Annotation", e);
		} finally {
			if (lineStream != null) {
				try {
					lineStream.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}
}
