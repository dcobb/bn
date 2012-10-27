package com.bignlp.opm;

import java.nio.file.Paths;
import java.util.Arrays;

import com.bignlp.langy.metamap.MetaMapConfig;
import com.bignlp.langy.metamap.MmServer;

public class AnnotationEngineMain {
	private static final int QUEUE_SIZE = 1000;
	private static final int NUM_THREADS = 70;
	private static final int NUM_ITERATIONS = 100;

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
				annotationEngine.annotate(Paths.get("../com.bignlp/testdata/psr"),
						"*.txt");
			}
		} finally {
			annotationEngine.destroy();
		}
	}

	private static void startMetaMapServers() {
		MetaMapConfig metaMapConfig = new MetaMapConfig();
		metaMapConfig.setPorts(Arrays.asList(40000, 40001, 40002, 40003, 40004,
				40005, 40006, 40007, 40008, 40009));
		MetaMapConfig.initialize(metaMapConfig);
		MmServer.getInstance().startAll();
		try {
			Thread.sleep(20 * 000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
