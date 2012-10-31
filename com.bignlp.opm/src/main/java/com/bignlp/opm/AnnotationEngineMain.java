package com.bignlp.opm;

import static com.bignlp.langy.metamap.MetaMapConfigConstants.PORTS;

import java.nio.file.Paths;

import com.bignlp.langy.metamap.MetaMapConfig;
import com.bignlp.langy.metamap.MmServer;

public class AnnotationEngineMain {
	private static final String EXTENSIONS = "*.doc";
	private static final String BASE_DIR = "../com.bignlp/testdata/psr/transcriptions";
	private static final int QUEUE_SIZE = 1000;
	private static final int NUM_THREADS = 1;
	private static final int NUM_ITERATIONS = 1;

	public static void main(String[] args) {
		process();
	}

	public static void process() {
		startMetaMapServers();
		annotate();
	}

	private static void annotate() {
		AnnotationEngine annotationEngine = new AnnotationEngine();
		try {
			annotationEngine.setNumThreads(NUM_THREADS);
			annotationEngine.setQueueSize(QUEUE_SIZE);
			annotationEngine.init();
			for (int i = 0; i < NUM_ITERATIONS; ++i) {
				annotationEngine.annotate(Paths.get(BASE_DIR), EXTENSIONS);
			}
		} finally {
			annotationEngine.destroy();
		}
	}

	private static void startMetaMapServers() {
		MetaMapConfig metaMapConfig = new MetaMapConfig();
		metaMapConfig.setPorts(PORTS);
		MetaMapConfig.initialize(metaMapConfig);
		MmServer.getInstance().startAll();
		try {
			Thread.sleep(20 * 000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
