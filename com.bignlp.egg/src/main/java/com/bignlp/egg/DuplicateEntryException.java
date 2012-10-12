package com.bignlp.egg;

public class DuplicateEntryException extends EggException {

	/**
	 * Default SerialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateEntryException() {
	}

	public DuplicateEntryException(String argMessage) {
		super(argMessage);
	}

	public DuplicateEntryException(String argMessage, Throwable argCause) {
		super(argMessage, argCause);
	}

	public DuplicateEntryException(String argMessage, Throwable argCause,
			boolean argEnableSuppression, boolean argWritableStackTrace) {
		super(argMessage, argCause, argEnableSuppression, argWritableStackTrace);
	}

	public DuplicateEntryException(Throwable argCause) {
		super(argCause);
	}

}
