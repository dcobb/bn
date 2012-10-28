package com.bignlp.langy.metamap;

import java.util.Arrays;
import java.util.List;

public final class MetaMapConfigConstants {
	private static final List<Integer> PORTS_1 = Arrays.asList(40000);
	private static final List<Integer> PORTS_10 = Arrays.asList(40000, 40001,
			40002, 40003, 40004, 40005, 40006, 40007, 40008, 40009);
	public static final List<Integer> PORTS = PORTS_1;

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

	private MetaMapConfigConstants() {
		// Prevent Instantiation
	}

}
