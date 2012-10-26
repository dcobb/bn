package com.bignlp.opm;

import java.nio.file.Paths;

public class AnnotationEngineMain {
	private static final int QUEUE_SIZE = 1000;
	private static final int NUM_THREADS = 10;
	private static final int NUM_ITERATIONS = 1;

	public static void main(String[] args) {
		AnnotationEngine annotationEngine = new AnnotationEngine();
		try {
			annotationEngine.setNumThreads(NUM_THREADS);
			annotationEngine.setQueueSize(QUEUE_SIZE);
			annotationEngine.init();
			for (int i = 0; i < NUM_ITERATIONS; ++i) {
				annotationEngine.annotate(Paths.get("../com.bignlp/testdata"),
						"*.txt");
			}
		} finally {
			annotationEngine.destroy();
		}
	}
}
