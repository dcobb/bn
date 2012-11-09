package com.bignlp.langy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PosAnnotator {
	private static Logger logger = LoggerFactory.getLogger(PosAnnotator.class);
	private static final String MODELS_EN_POS_MAXENT_BIN = "../com.bignlp/models/en-pos-maxent.bin";
	private static POSModel model = new POSModelLoader().load(new File(
			MODELS_EN_POS_MAXENT_BIN));

	public PosAnnotator() {
		// Default Constructor
	}

	public void annotate(Path argFilePath) {
		POSTaggerME tagger = new POSTaggerME(model);

		ObjectStream<String> lineStream = null;
		BufferedWriter bw = null;

		try {
			lineStream = new PlainTextByLineStream(new BufferedReader(
					new FileReader(argFilePath.toFile())));
			Path posTextFilePath = Paths.get(argFilePath.toFile()
					.getAbsolutePath()
					+ System.currentTimeMillis()
					+ ".pos.txt");
			bw = new BufferedWriter(new FileWriter(posTextFilePath.toFile()));
			String line = null;
			while ((line = lineStream.read()) != null) {
				String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
						.tokenize(line);
				String[] tags = tagger.tag(whitespaceTokenizerLine);
				POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
				bw.write(sample.toString());
			}
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
			if (bw != null) {
				try {
					bw.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}
}
