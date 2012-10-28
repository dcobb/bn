package com.bignlp.langy.metamap;

import static com.bignlp.langy.metamap.MetaMapConfigConstants.DEFAULT_TAGGER_SERVER_LEX_DB;
import static com.bignlp.langy.metamap.MetaMapConfigConstants.DEFAULT_TAGGER_SERVER_NGRAM_ONE;
import static com.bignlp.langy.metamap.MetaMapConfigConstants.MM_SERVER_BIN;
import static com.bignlp.langy.metamap.MetaMapConfigConstants.MM_SERVER_EXE;
import static com.bignlp.langy.metamap.MetaMapConfigConstants.MM_SERVER_PROCESS_NAME;
import static com.bignlp.langy.metamap.MetaMapConfigConstants.WSD_SERVER_EXE;
import static com.bignlp.langy.metamap.MetaMapConfigConstants.WSD_SERVER_PROCESS_NAME;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MetaMapConfig implements Serializable {

	private static final long serialVersionUID = 6470711839142914908L;

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
