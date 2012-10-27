package com.bignlp.langy.metamap;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MetaMapConfig implements Serializable {
	public static final String MM_SERVER_HOME = "D:/bn/research/umls/public_mm_win32_main_2011/public_mm/";
	public static final String MM_SERVER_BIN = MM_SERVER_HOME + "bin/";
	public static final String MM_SERVER_EXE = "mmserver11.bat";
	public static final String MM_SERVER_PROCESS_NAME = "mmserver";
	public static final String MMSERVER_PORT = "MMSERVER_PORT";

	public static final String WSD_SERVER_EXE = "wsdserverctl_start.bat";
	public static final String WSD_SERVER_PROCESS_NAME = "wsd.server.DisambiguatorServer";

	public static final String TAGGER_SERVER_PORT = "taggerserver.port";
	public static final String TAGGER_SERVER_LEX_DB = "lexFile";
	public static final String DEFAULT_TAGGER_SERVER_LEX_DB = "../com.bignlp/models/lexDB.serial";
	public static final String TAGGER_SERVER_NGRAM_ONE = "ngramOne";
	public static final String DEFAULT_TAGGER_SERVER_NGRAM_ONE = "../com.bignlp/models/ngramOne.serial";

	private static MetaMapConfig instance;

	private List<Integer> ports;
	private String mmServerBinDir;
	private String mmServerPath;
	private String mmServerProcessName;
	private String wsdServerPath;
	private String wsdServerProcessName;
	private int taggerServerPort;
	private String taggerServerLexDb;
	private String taggerServerNgramOne;
	private int next;
	private int totalPorts;

	public static MetaMapConfig getInstance() {
		return instance;
	}

	public static void initialize(MetaMapConfig argMetaMapConfig) {
		instance = argMetaMapConfig;
	}

	public MetaMapConfig() {
		this(new ArrayList<Integer>());
	}

	public MetaMapConfig(List<Integer> argPorts) {
		super();
		this.setPorts(argPorts);
		this.mmServerBinDir = MM_SERVER_BIN;
		this.mmServerPath = this.getMmServerBinDir() + File.separator
				+ MM_SERVER_EXE;
		this.mmServerProcessName = MM_SERVER_PROCESS_NAME;
		this.wsdServerPath = this.getMmServerBinDir() + File.separator
				+ WSD_SERVER_EXE;
		this.wsdServerProcessName = WSD_SERVER_PROCESS_NAME;
		this.taggerServerLexDb = DEFAULT_TAGGER_SERVER_LEX_DB;
		this.taggerServerNgramOne = DEFAULT_TAGGER_SERVER_NGRAM_ONE;
		this.taggerServerPort = 1795;
	}

	public List<Integer> getPorts() {
		return this.ports;
	}

	public void setPorts(List<Integer> argPorts) {
		this.ports = argPorts;
		this.totalPorts = argPorts.size();
	}

	public synchronized int getRoundRobinPort() {
		int result = this.next % this.totalPorts;
		++this.next;
		if (this.next == this.totalPorts) {
			this.next = 0;
		}
		return this.getPorts().get(result);
	}

	public String getMmServerBinDir() {
		return this.mmServerBinDir;
	}

	public void setMmServerBinDir(String argMmServerBinDir) {
		this.mmServerBinDir = argMmServerBinDir;
	}

	public String getMmServerPath() {
		return this.mmServerPath;
	}

	public void setMmServerPath(String argMmServerPath) {
		this.mmServerPath = argMmServerPath;
	}

	public String getMmServerProcessName() {
		return this.mmServerProcessName;
	}

	public void setMmServerProcessName(String argMmServerProcessName) {
		this.mmServerProcessName = argMmServerProcessName;
	}

	public String getWsdServerPath() {
		return this.wsdServerPath;
	}

	public void setWsdServerPath(String argWsdServerPath) {
		this.wsdServerPath = argWsdServerPath;
	}

	public String getWsdServerProcessName() {
		return this.wsdServerProcessName;
	}

	public void setWsdServerProcessName(String argWsdServerProcessName) {
		this.wsdServerProcessName = argWsdServerProcessName;
	}

	public int getTaggerServerPort() {
		return this.taggerServerPort;
	}

	public void setTaggerServerPort(int argTaggerServerPort) {
		this.taggerServerPort = argTaggerServerPort;
	}

	public String getTaggerServerLexDb() {
		return this.taggerServerLexDb;
	}

	public void setTaggerServerLexDb(String argTaggerServerLexDb) {
		this.taggerServerLexDb = argTaggerServerLexDb;
	}

	public String getTaggerServerNgramOne() {
		return this.taggerServerNgramOne;
	}

	public void setTaggerServerNgramOne(String argTaggerServerNgramOne) {
		this.taggerServerNgramOne = argTaggerServerNgramOne;
	}

	public String getTaggerServerPortAsString() {
		return String.valueOf(this.getTaggerServerPort());
	}
}
