package com.bignlp.chim;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

public class Model implements Serializable {
	private BigInteger id;
	private Date dateCreated;
	private Date dateLastModified;
	private BigInteger createdBy;
	private BigInteger modifiedBy;

	public Model() {
		super();
	}

	public BigInteger getId() {
		return this.id;
	}

	public void setId(BigInteger argId) {
		this.id = argId;
	}

	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date argDateCreated) {
		this.dateCreated = argDateCreated;
	}

	public Date getDateLastModified() {
		return this.dateLastModified;
	}

	public void setDateLastModified(Date argDateLastModified) {
		this.dateLastModified = argDateLastModified;
	}

	public BigInteger getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(BigInteger argCreatedBy) {
		this.createdBy = argCreatedBy;
	}

	public BigInteger getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(BigInteger argModifiedBy) {
		this.modifiedBy = argModifiedBy;
	}

}
