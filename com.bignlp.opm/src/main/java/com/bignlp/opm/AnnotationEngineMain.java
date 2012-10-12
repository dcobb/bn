package com.bignlp.opm;

import java.nio.file.Paths;

public class AnnotationEngineMain {
	public static void main(String[] args) {
		AnnotationEngine annotationEngine = new AnnotationEngine();
		try {
			annotationEngine.setNumThreads(10);
			annotationEngine.setQueueSize(1000);
			annotationEngine.init();
			annotationEngine.annotate(Paths.get("../com.bignlp/testdata"),
					"*.txt");
		} finally {
			annotationEngine.destroy();
		}
	}
}
