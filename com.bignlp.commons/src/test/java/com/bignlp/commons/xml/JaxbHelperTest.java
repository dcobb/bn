package com.bignlp.commons.xml;

public class JaxbHelperTest {

	private static final String XSD_FILE_PATH = "./xsd/data-protection-schemes.xsd";
	
	public void initialize() {
		JaxbHelper.unmarshalWithXsdValidation("", "", "");
	}
}
