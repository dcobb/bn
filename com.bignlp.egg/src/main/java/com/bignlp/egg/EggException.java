package com.bignlp.egg;

public class EggException extends RuntimeException {

	/**
	 * Default serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public EggException() {
	}

	public EggException(String argMessage) {
		super(argMessage);
	}

	public EggException(String argMessage, Throwable argCause) {
		super(argMessage, argCause);
	}

	public EggException(String argMessage, Throwable argCause,
			boolean argEnableSuppression, boolean argWritableStackTrace) {
		super(argMessage, argCause, argEnableSuppression, argWritableStackTrace);
	}

	public EggException(Throwable argCause) {
		super(argCause);
	}

}
