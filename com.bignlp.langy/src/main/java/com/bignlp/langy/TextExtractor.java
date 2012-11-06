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

	public TextExtractor() {
		// Default Constructor
	}

	public TextExtractor(Path argsSourcePath, Path argsDestPath) {
		super();
		this.srcPath = argsSourcePath;
		this.destPath = argsDestPath;
	}

	public Path getSrcPath() {
		return this.srcPath;
	}

	public void setSrcPath(Path argsSrcPath) {
		this.srcPath = argsSrcPath;
	}

	public Path getDestPath() {
		return this.destPath;
	}

	public void setDestPath(Path argsDestPath) {
		this.destPath = argsDestPath;
	}

	public void extract() {
		Writer textWriter = null;
		try {
			textWriter = new FileWriter(destPath.toFile());
			extract(srcPath, textWriter);
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

	public static void extract(Path argSrcPath, Writer textWriter) {
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
	}

	private static URL getUrl(Path argPath) {
		try {
			URL url = argPath.toUri().toURL();
			return url;
		} catch (Exception e) {
			throw new RuntimeException("Could not create the URL", e);
		}
	}
}
