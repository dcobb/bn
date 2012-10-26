package com.bignlp.langy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class MmUtils {
	private String mmserverPath;

	private void startTaggerServer() {
		System.setProperty("taggerserver.port", "1795");
		System.getProperty(
				"lexFile",
				"../com.bignlp/models/lexDB.serial");
		System.getProperty(
				"ngramOne",
				"../com.bignlp/models/ngramOne.serial");
		MmTaggerServer.main(new String[] {});
	}

	private void startDisambiguationServer() {
	}

	private boolean checkProcess(String processName) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("ps", "-ef");
		Process psProcess = processBuilder.start();
		BufferedReader input = new BufferedReader(new InputStreamReader(
				psProcess.getInputStream()));
		String line;
		while ((line = input.readLine()) != null) {
			if (line.contains(processName)) {
				return true;
			}
		}
		input.close();
		return false;
	}

	private void startMetaMapServer() {
		File mmserverFile = null;
		if (this.mmserverPath != null && !this.mmserverPath.isEmpty()) {
			mmserverFile = new File(this.mmserverPath);
		}

		boolean disambiguatorServerRunning = false;
		String os = System.getProperty("os.name");
		if ((mmserverFile != null)
				&& (os.contains("Linux") || os.contains("linux"))) {
			try {
				disambiguatorServerRunning = checkProcess("mmserver");
				if (!disambiguatorServerRunning && mmserverFile != null) {
					ProcessBuilder disambiguatorStartProcessBuilder = new ProcessBuilder(
							mmserverFile.getAbsolutePath(), "start");
					try {
						disambiguatorStartProcessBuilder.start().waitFor();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						throw new RuntimeException(
								"Excception while starting MM Server", e);
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(
						"Excception while starting MM Server", e);
			}
		}
	}

}
