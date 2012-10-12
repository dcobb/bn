package com.bignlp.egg.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import com.bignlp.egg.EggException;

public class FileGlossary<V extends Serializable> extends AbstractGlossary<V> {
	private Entry<V> current;
	private File file;
	private BufferedReader fileReader;
	private boolean opened;

	public FileGlossary(String argFilePath) {
		if (argFilePath != null) {
			this.file = new File(argFilePath);
		}
	}

	public void close() {
		this.opened = false;
		if (this.fileReader != null) {
			try {
				this.fileReader.close();
			} catch (Exception ignore) {
				// ignore
			}
		}
	}

	public boolean hasNext() {
		if (!opened) {
			this.open();
		}
		return this.current != null;
	}

	public Entry<V> next() {
		Entry<V> result = this.current;
		try {
			this.readLine();
		} catch (IOException e) {
			throw new EggException("Could not read from file: "
					+ this.file.getAbsolutePath());
		}
		return result;
	}

	public void open() {
		if (!opened) {
			try {
				this.fileReader = new BufferedReader(new FileReader(this.file));
				this.readLine();
				this.opened = true;
			} catch (Exception e) {
				throw new EggException("could not read file: "
						+ this.file.getAbsolutePath(), e);
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void readLine() throws IOException {
		String line = this.fileReader.readLine();
		if (line != null) {
			this.current = new AbstractGlossary.DefaultGlossaryEntry<V>(line,
					(V) DEFAULT_VALUE);
		} else {
			this.current = null;
		}
	}

	public void reset() {
		opened = false;
		this.close();
	}
}
