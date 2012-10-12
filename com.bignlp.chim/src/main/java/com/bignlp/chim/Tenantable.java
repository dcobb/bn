package com.bignlp.chim;

import java.math.BigInteger;

public abstract class Tenantable extends Model {
	private BigInteger tenantId;

	public Tenantable() {
		super();
	}

	public BigInteger getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(BigInteger argTenantId) {
		this.tenantId = argTenantId;
	}

}
