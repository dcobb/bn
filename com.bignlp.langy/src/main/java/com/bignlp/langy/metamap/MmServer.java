package com.bignlp.langy.metamap;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import com.bignlp.langy.medpost.TaggerServer;

public class MmServer {
	private static final MmServer instance = new MmServer();
	private MetaMapConfig metaMapConfig;
	private Process mmServerProcess;

	public static MmServer getInstance() {
		return instance;
	}

	public MmServer() {
		this(MetaMapConfig.getInstance());
	}

	public MmServer(MetaMapConfig argMetaMapConfig) {
		super();
		this.metaMapConfig = argMetaMapConfig;
	}

	public void startTaggerServer() {
		System.setProperty(MetaMapConfig.TAGGER_SERVER_PORT,
				this.metaMapConfig.getTaggerServerPortAsString());
		System.setProperty(MetaMapConfig.TAGGER_SERVER_LEX_DB,
				MetaMapConfig.DEFAULT_TAGGER_SERVER_LEX_DB);
		System.setProperty(MetaMapConfig.TAGGER_SERVER_NGRAM_ONE,
				MetaMapConfig.DEFAULT_TAGGER_SERVER_NGRAM_ONE);
		TaggerServer.main(new String[] {});
	}

	public void startDisambiguationServer() {
		startWsdServer(this.metaMapConfig.getWsdServerPath(),
				this.metaMapConfig.getWsdServerProcessName());
	}

	public void startMetaMapServer() {
		// if (this.mmServerProcess != null) {
		// try {
		// this.mmServerProcess.destroy();
		// } catch (Exception ignore) {
		// ignore.printStackTrace();
		// }
		// }
		this.mmServerProcess = null;
		startServer(this.metaMapConfig.getMmServerPath(),
				this.metaMapConfig.getMmServerProcessName());
	}

	private Process startServer(final String argServerPath,
			String argProcessName) {
		if (argServerPath != null && !argServerPath.isEmpty()) {
			List<Integer> ports = MetaMapConfig.getInstance().getPorts();
			for (int port : ports) {
				startMetaMapServerInNewThread(argServerPath, port);
			}
		}
		return null;
	}

	private void startMetaMapServerInNewThread(final String argServerPath,
			int port) {
		final int finalPort = port;
		new Thread() {
			@Override
			public void run() {
				startMetaMapProcess(argServerPath, finalPort);
			}
		}.start();
	}

	public void startMetaMapServerInNewThread(int port) {
		final int finalPort = port;
		new Thread() {
			@Override
			public void run() {
				startMetaMapProcess(MetaMapConfig.getInstance()
						.getMmServerPath(), finalPort);
			}
		}.start();
	}

	private Process startMetaMapProcess(String argServerPath, int port) {
		try {
			ProcessBuilder pb = new ProcessBuilder(argServerPath, "-CP",
					String.valueOf(port));
			try {
				pb.directory(new File(this.metaMapConfig.getMmServerBinDir()));
				// pb.redirectOutput(Redirect.INHERIT);
				// pb.redirectError(Redirect.INHERIT);
				pb.redirectError(new File("logs/mms/error" + port + ".log"));
				pb.redirectOutput(new File("logs/mms/output" + port + ".log"));
				Process p = pb.start();
				Thread.sleep(2000);
				return p;
			} catch (InterruptedException e) {
				throw new RuntimeException(
						"Excception while starting server: ", e);
			}
		} catch (IOException e) {
			throw new RuntimeException("Excception while starting MM Server", e);
		}
	}

	private Process startWsdServer(String argServerPath, String argProcessName) {
		if (argServerPath != null && !argServerPath.isEmpty()) {
			try {
				try {
					ProcessBuilder pb = new ProcessBuilder(argServerPath,
							"start");
					pb.directory(new File(this.metaMapConfig
							.getMmServerBinDir()));
					pb.redirectOutput(Redirect.INHERIT);
					pb.redirectError(Redirect.INHERIT);
					Process process = pb.start();
					Thread.sleep(2000);
					return process;
				} catch (InterruptedException e) {
					throw new RuntimeException(
							"Excception while starting server: ", e);
				}
			} catch (IOException e) {
				throw new RuntimeException(
						"Excception while starting MM Server", e);
			}
		}
		return null;
	}

	public void startAll() {
		startTaggerServerInNewThread();
		startWsdServerInNewThread();
		startMetaMapServer();
	}

	public void startMetaMapServerInNewThread() {
		new Thread() {
			@Override
			public void run() {
				startMetaMapServer();
			}
		}.start();
	}

	public void startWsdServerInNewThread() {
		new Thread() {
			@Override
			public void run() {
				startDisambiguationServer();
			}
		}.start();
	}

	public void startTaggerServerInNewThread() {
		new Thread() {
			@Override
			public void run() {
				startTaggerServer();
			}
		}.start();
	}

}
