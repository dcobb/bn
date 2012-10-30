package com.bignlp.langy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import com.google.common.io.Files;

public class TextExtractor {
	private Path srcPath;
	private Path destPath;
	private String extractedText;

	public TextExtractor() {
		// Default Constructor
	}

	public TextExtractor(Path argsSourcePath) {
		super();
		this.srcPath = argsSourcePath;
	}

	public TextExtractor(Path argsSourcePath, Path argsDestPath) {
		super();
		this.srcPath = argsSourcePath;
		this.destPath = argsDestPath;
	}

	public void extract() {
		Writer textWriter = null;
		try {
			textWriter = this.destPath != null ? new FileWriter(
					destPath.toFile()) : new StringWriter();
			this.extractedText = extract(srcPath, textWriter);
		} catch (Exception e) {
			throw new RuntimeException("Could not extract text from: "
					+ srcPath + " and write to:" + destPath, e);
		} finally {
			if (textWriter != null) {
				try {
					textWriter.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	public String getExtractedText() {
		try {
			return this.destPath != null ? Files.toString(
					this.destPath.toFile(), Charset.forName("UTF-8"))
					: this.extractedText;
		} catch (IOException e) {
			throw new RuntimeException("could not read text from file: "
					+ this.destPath);
		}
	}

	public static String extract(Path argSrcPath, Writer textWriter) {
		TikaInputStream tikaInputStream = null;
		try {
			Metadata metadata = new Metadata();
			URL url = getUrl(argSrcPath);
			tikaInputStream = TikaInputStream.get(url, metadata);
			ContentHandler handler = new BodyContentHandler(textWriter);
			ParseContext context = new ParseContext();
			Parser parser = new AutoDetectParser(new DefaultDetector());
			context.set(Parser.class, parser);
			parser.parse(tikaInputStream, handler, metadata, context);
		} catch (Exception e) {
			throw new RuntimeException("Could not extract text from: "
					+ argSrcPath, e);
		} finally {
			if (tikaInputStream != null) {
				try {
					tikaInputStream.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
			if (textWriter != null) {
				try {
					textWriter.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
		String extractedText = textWriter.toString();
		return extractedText;
	}

	private static URL getUrl(Path argPath) {
		try {
			URL url = argPath.toUri().toURL();
			return url;
		} catch (Exception e) {
			throw new RuntimeException("Could not create the URL", e);
		}
	}

	public static void main(String args[]) throws Exception {
		TextExtractor textExtractor = new TextExtractor(
				Paths.get("../com.bignlp/testdata/psr/transcriptions/sample1.doc"));
		textExtractor.extract();
		String extractedText = textExtractor.getExtractedText();
		System.out.println(extractedText);
	}
}
