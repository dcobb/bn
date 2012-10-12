package com.bignlp.chim;

import java.util.List;
import java.util.Map;

public abstract class Person extends Tenantable {
	private String title;
	private String firstName;
	private String middleName;
	private String lastName;
	private String suffix;
	private List<String> alternateNames;

	private Address homeAddress;
	private Address mailingAddress;
	private Map<String, Address> otherAddresses;

	public Person() {
		super();
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String argTitle) {
		this.title = argTitle;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String argFirstName) {
		this.firstName = argFirstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String argMiddleName) {
		this.middleName = argMiddleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String argLastName) {
		this.lastName = argLastName;
	}

	public String getSuffix() {
		return this.suffix;
	}

	public void setSuffix(String argSuffix) {
		this.suffix = argSuffix;
	}

	public List<String> getAlternateNames() {
		return this.alternateNames;
	}

	public void setAlternateNames(List<String> argAlternateNames) {
		this.alternateNames = argAlternateNames;
	}

	public Address getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(Address argHomeAddress) {
		this.homeAddress = argHomeAddress;
	}

	public Address getMailingAddress() {
		return this.mailingAddress;
	}

	public void setMailingAddress(Address argMailingAddress) {
		this.mailingAddress = argMailingAddress;
	}

	public Map<String, Address> getOtherAddresses() {
		return this.otherAddresses;
	}

	public void setOtherAddresses(Map<String, Address> argOtherAddresses) {
		this.otherAddresses = argOtherAddresses;
	}

}
