package com.bignlp.egg.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import com.bignlp.egg.EggException;
import com.bignlp.egg.Glossary;

public class PersistedGlossary<V extends Serializable> extends
		AbstractGlossary<V> {
	private Glossary<V> delegate;
	private File file;
	private BufferedWriter fileWriter;
	private boolean opened;

	public PersistedGlossary(Glossary<V> argDelegate, String argFilePath) {
		this.delegate = argDelegate;
		this.file = new File(argFilePath);
	}

	public boolean hasNext() {
		if (!opened) {
			this.open();
		}
		return this.delegate.hasNext();
	}

	public com.bignlp.egg.Glossary.Entry<V> next() {
		Glossary.Entry<V> entry = this.delegate.next();
		if (entry != null) {
			try {
				this.writeLine(entry.getCharSequence());
			} catch (IOException e) {
				throw new EggException("Could not write to file: "
						+ this.file.getAbsolutePath());
			}
		}
		return entry;
	}

	public void open() {
		if (!opened) {
			try {
				this.fileWriter = new BufferedWriter(new FileWriter(this.file));
				this.opened = true;
			} catch (Exception e) {
				throw new EggException("could not read file: "
						+ this.file.getAbsolutePath(), e);
			}
		}
	}

	private void writeLine(CharSequence argCharSequence) throws IOException {
		this.fileWriter.write(argCharSequence.toString());
		this.fileWriter.write(System.lineSeparator());
	}

	public void close() {
		this.opened = false;
		if (this.fileWriter != null) {
			try {
				this.fileWriter.close();
			} catch (Exception ignore) {
				// ignore
			}
		}
	}

	public void remove() {
		this.delegate.remove();
	}

	public void reset() {
		this.opened = false;
	}

}
