package com.bignlp.chim;

import java.math.BigDecimal;

public class Address extends Tenantable {
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private BigDecimal longitude;
	private BigDecimal latitude;

	public Address() {
		super();
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String argStreetAddress) {
		this.streetAddress = argStreetAddress;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String argCity) {
		this.city = argCity;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String argState) {
		this.state = argState;
	}

	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String argZipCode) {
		this.zipCode = argZipCode;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal argLongitude) {
		this.longitude = argLongitude;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal argLatitude) {
		this.latitude = argLatitude;
	}

}
