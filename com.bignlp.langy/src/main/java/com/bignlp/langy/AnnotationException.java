package com.bignlp.langy;

public class AnnotationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AnnotationException() {
		super();
	}

	public AnnotationException(String argMessage, Throwable argCause,
			boolean argEnableSuppression, boolean argWritableStackTrace) {
		super(argMessage, argCause, argEnableSuppression, argWritableStackTrace);
	}

	public AnnotationException(String argMessage, Throwable argCause) {
		super(argMessage, argCause);
	}

	public AnnotationException(String argMessage) {
		super(argMessage);
	}

	public AnnotationException(Throwable argCause) {
		super(argCause);
	}

}
