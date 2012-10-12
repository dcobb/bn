package com.bignlp.commons;

public class FileProcessingResult {
	public enum Status {
		initialized, queued, waiting, completedWithErrors, completedSuccessfully
	}

	private Throwable throwable;
	private Status status;
	
	public FileProcessingResult() {
		super();
	}

	public Throwable getThrowable() {
		return this.throwable;
	}

	public void setThrowable(Throwable argThrowable) {
		this.throwable = argThrowable;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status argStatus) {
		this.status = argStatus;
	}

}
