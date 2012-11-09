package com.bignlp.web.main;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bignlp.web.server.CraftServer;
import com.bignlp.web.server.CraftServerConfiguration;

public class DefaultCraftServerLauncher {

	private static Logger logger = LoggerFactory
			.getLogger(DefaultCraftServerLauncher.class);

	CraftServer server = null;

	public void start() {
		if (logger.isInfoEnabled()) {
			logger.info("Starting CraftServer");
		}
		Properties craftProps = new Properties();
		InputStream is = null;
		try {
			is = this.getClass().getResourceAsStream("/craft.conf");
			craftProps.load(is);
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Error while initializing CraftServer Config.", e);
			}
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("Successfully loaded CraftServer Config");
			logger.info("Initializing CraftAppCache");
		}
		try {
			// CraftAppCache.getInstance();
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Failed to initialize CraftAppCache", e);
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("CraftAppCache initialized successfully");
		}
		String confFileLocation = this.getClass().getResource("/craft.conf")
				.getFile();
		File confFile = new File(confFileLocation);
		File webAppDir = new File(confFile.getParentFile().getParentFile()
				.getAbsolutePath()
				+ "/webapp");
		try {
			if (webAppDir.exists() && webAppDir.isDirectory()) {
				this.server = new CraftServerConfiguration(true).addWebApp("/",
						webAppDir.getAbsolutePath(), "localhost").build();
			} else {
				throw new RuntimeException("WebApp Directory does not exists.");
			}
			this.server.start();
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("Failed to start CraftServer", e);
			}
		}
		if (logger.isInfoEnabled()) {
			logger.info("CraftServer started on port 80 and 443.");
		}
	}

	public void stop() throws Exception {
		if (server != null) {
			if (logger.isInfoEnabled()) {
				logger.info("Shutting down CraftServer.");
			}
			try {
				this.server.stop();
			} catch (Exception e) {
				if (logger.isErrorEnabled()) {
					logger.error("Failed to stop CraftServer properly", e);
				}
			}
			if (logger.isInfoEnabled()) {
				logger.info("CraftServer stopped.");
			}
		} else {
			if (logger.isErrorEnabled()) {
				logger.error("CraftServer not running. Nothing to stop.");
			}
		}
	}

	public static void main(String[] args) {
		DefaultCraftServerLauncher server = new DefaultCraftServerLauncher();
		server.start();
	}

}
