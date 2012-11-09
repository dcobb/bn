/**
 * GenericJaxbHelper
 *
 * Copyright (C) 2010 CipherCloud, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * CipherCloud, Inc. ("Confidential Information"). 
 * 
 * For more information, visit http://www.ciphercloud.com
 */
package com.bignlp.commons.xml;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericJaxbHelper.
 * 
 * @param <T>
 *            the generic type
 */
public class JaxbHelper<T> {

	/** The Constant JAXB_FORMATTED_OUTPUT_DEFAULT. */
	private static final Boolean JAXB_FORMATTED_OUTPUT_DEFAULT = Boolean.TRUE;

	/** The Constant XMLNS_PACKAGES. */
	public static final String XMLNS_PACKAGES =
			"com.ciphercloud.xmlns.configuration.v1";

	/** The jaxb context. */
	private JAXBContext jaxbContext;

	/**
	 * Instantiates a new generic jaxb helper.
	 * 
	 * @param argPackages
	 *            the packages
	 */
	public JaxbHelper(String argPackages) {
		try {
			this.jaxbContext = JAXBContext.newInstance(argPackages);
		} catch (JAXBException e) {
			throw new RuntimeException(
					"could not cretae JAXBContext for packages: " + argPackages,
					e);
		}
	}

	/**
	 * Unmarshal.
	 * 
	 * @param argFilePath
	 *            the file path
	 * @return the jAXB element
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public JAXBElement<T> unmarshal(String argFilePath)
			throws FileNotFoundException, JAXBException {
		File file = new File(argFilePath);
		return unmarshal(file);
	}

	/**
	 * Unmarshal.
	 * 
	 * @param argFilePath
	 *            the file path
	 * @param argSchemaPath
	 *            the schema path
	 * @return the jAXB element
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public JAXBElement<T> unmarshalWithSchemaValidation(String argFilePath,
			String argSchemaPath) throws FileNotFoundException, JAXBException {
		File file = new File(argFilePath);
		return unmarshal(file, new File(argSchemaPath));
	}

	/**
	 * Unmarshal.
	 * 
	 * @param argFile
	 *            the file
	 * @return the jAXB element
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public JAXBElement<T> unmarshal(File argFile) throws JAXBException,
			FileNotFoundException {
		if (argFile != null) {
			InputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(argFile);
				return unmarshal(fileInputStream);
			} finally {
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (Exception ignore) {
						// ignore
					}
				}
			}
		}
		throw new IllegalArgumentException("argFile cannot be null");
	}

	/**
	 * Unmarshal.
	 * 
	 * @param argFile
	 *            the file
	 * @param argSchemaFile
	 *            the schema file
	 * @return the jAXB element
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public JAXBElement<T> unmarshal(File argFile, File argSchemaFile)
			throws JAXBException, FileNotFoundException {
		if (argFile != null) {
			InputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(argFile);
				return unmarshal(fileInputStream, argSchemaFile);
			} finally {
				if (fileInputStream != null) {
					try {
						fileInputStream.close();
					} catch (Exception ignore) {
						// ignore
					}
				}
			}
		}
		throw new IllegalArgumentException("argFile cannot be null");
	}

	/**
	 * Unmarshal.
	 * 
	 * @param fileInputStream
	 *            the file input stream
	 * @return the jAXB element
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public JAXBElement<T> unmarshal(InputStream fileInputStream)
			throws JAXBException {
		Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<T> element =
				(JAXBElement<T>) unmarshaller.unmarshal(fileInputStream);
		return element;
	}

	/**
	 * Unmarshal.
	 * 
	 * @param argFileInputStream
	 *            the file input stream
	 * @param argSchemaLocation
	 *            the schema location
	 * @param argConfigurationFile
	 *            TODO
	 * @return the jAXB element
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public JAXBElement<T> unmarshal(InputStream argFileInputStream,
			String argSchemaLocation, String argConfigurationFile)
			throws JAXBException {
		Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
		try {
			SchemaFactory sf =
					SchemaFactory
							.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
			File schemaFile = new File(argSchemaLocation);
			Schema schema = sf.newSchema(schemaFile);
			unmarshaller.setSchema(schema);
			@SuppressWarnings("unchecked")
			JAXBElement<T> element =
					(JAXBElement<T>) unmarshaller.unmarshal(argFileInputStream);
			return element;
		} catch (SAXException e) {
			throw new RuntimeException("Error while Validating the XSD :"
					+ argSchemaLocation);
		}
	}

	/**
	 * Unmarshal by validating the xsd provided.
	 * 
	 * @param fileInputStream
	 *            the file input stream
	 * @param argSchemaFile
	 *            the schema file
	 * @return the jAXB element
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	@SuppressWarnings("unchecked")
	public JAXBElement<T> unmarshal(InputStream fileInputStream,
			File argSchemaFile) throws JAXBException {
		Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
		try {
			SchemaFactory sf =
					SchemaFactory
							.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(argSchemaFile);
			unmarshaller.setSchema(schema);
			JAXBElement<T> element =
					(JAXBElement<T>) unmarshaller.unmarshal(fileInputStream);
			return element;
		} catch (SAXException e) {
			throw new RuntimeException("Error while unmarshaling the XSD :"
					+ argSchemaFile);
		}
	}

	/**
	 * Unmarshal string content.
	 * 
	 * @param argXmlSource
	 *            the xml source
	 * @return the jAXB element
	 * @throws Exception
	 *             the exception
	 */
	public JAXBElement<T> unmarshalStringContent(String argXmlSource)
			throws Exception {
		ByteArrayInputStream inputStream =
				new ByteArrayInputStream(argXmlSource.getBytes());
		Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<T> element =
				(JAXBElement<T>) unmarshaller.unmarshal(inputStream);
		return element;
	}

	/**
	 * Unmarshal.
	 * 
	 * @param argReader
	 *            the reader
	 * @return the jAXB element
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public JAXBElement<T> unmarshal(Reader argReader) throws JAXBException {
		Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<T> element =
				(JAXBElement<T>) unmarshaller.unmarshal(argReader);
		return element;
	}

	/**
	 * Marshal.
	 * 
	 * @param argFilePath
	 *            the file path
	 * @param argXmlObject
	 *            the xml object
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public void marshal(String argFilePath, JAXBElement<T> argXmlObject)
			throws FileNotFoundException, JAXBException {
		File file = new File(argFilePath);
		marshal(file, argXmlObject);
	}

	/**
	 * Marshal.
	 * 
	 * @param argFile
	 *            the file
	 * @param argXmlObject
	 *            the xml object
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws FileNotFoundException
	 *             the file not found exception
	 */
	public void marshal(File argFile, JAXBElement<T> argXmlObject)
			throws JAXBException, FileNotFoundException {
		if (argFile != null) {
			if (argXmlObject != null) {
				{
					OutputStream fileOutputStream = null;
					try {
						fileOutputStream = new FileOutputStream(argFile);
						marshal(argXmlObject, fileOutputStream);
					} finally {
						if (fileOutputStream != null) {
							try {
								fileOutputStream.close();
							} catch (Exception ignore) {
								// ignore
							}
						}
					}
				}
			} else {
				throw new IllegalArgumentException("argElement cannot be null");
			}
		} else {
			throw new IllegalArgumentException("argFile cannot be null");
		}
	}

	/**
	 * Marshal.
	 * 
	 * @param argXmlObject
	 *            the xml object
	 * @param argOutputStream
	 *            the output stream
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public void marshal(JAXBElement<T> argXmlObject,
			OutputStream argOutputStream) throws JAXBException {
		Marshaller marshaller = createMarshaller();
		marshaller.marshal(argXmlObject, argOutputStream);
	}

	/**
	 * Creates the marshaller.
	 * 
	 * @return the marshaller
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	private Marshaller createMarshaller() throws JAXBException {
		Marshaller marshaller = this.jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
				JAXB_FORMATTED_OUTPUT_DEFAULT);
		return marshaller;
	}

	/**
	 * Marshal.
	 * 
	 * @param argXmlObject
	 *            the xml object
	 * @param argWriter
	 *            the writer
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public void marshal(JAXBElement<T> argXmlObject, Writer argWriter)
			throws JAXBException {
		Marshaller marshaller = createMarshaller();
		marshaller.marshal(argXmlObject, argWriter);
	}

	/**
	 * Marshal.
	 * 
	 * @param argXmlObject
	 *            the xml object
	 * @return the string
	 * @throws JAXBException
	 *             the jAXB exception
	 */
	public String marshal(JAXBElement<T> argXmlObject) throws JAXBException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Marshaller marshaller = createMarshaller();
		marshaller.marshal(argXmlObject, outputStream);
		return outputStream.toString();
	}

	/**
	 * Unmarshal.
	 * 
	 * @param argFilePath
	 *            the file path
	 * @param argProcessXinclude
	 *            the process xinclude
	 * @return the jAXB element
	 * @throws JAXBException
	 *             the jAXB exception
	 * @throws SAXException
	 *             the sAX exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public JAXBElement<T> unmarshal(String argFilePath,
			boolean argProcessXinclude) throws JAXBException, SAXException,
			ParserConfigurationException, IOException {
		if (!argProcessXinclude) {
			return unmarshal(argFilePath);
		}
		UnmarshallerHandler uh =
				this.jaxbContext.createUnmarshaller().getUnmarshallerHandler();

		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setNamespaceAware(true);
		XMLReader xr = spf.newSAXParser().getXMLReader();

//		XIncludeFilter includer = new XIncludeFilter();
//		includer.setParent(xr);
//		includer.setContentHandler(uh);
//
		InputSource xmlToParse =
				new InputSource(new FileInputStream(argFilePath));
//		includer.parse(xmlToParse);
		return (JAXBElement<T>) uh.getResult();
	}

	/**
	 * Unmarshal.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param argConfigurationFile
	 *            the configuration file
	 * @param argPackageName
	 *            the package name
	 * @return the t
	 */
	public static <T> T unmarshalWithConfigurationFile(
			String argConfigurationFile, String argPackageName) {
		if (argConfigurationFile != null && !argConfigurationFile.isEmpty()
				&& argPackageName != null && !argPackageName.isEmpty()) {
			try {
				T value;
				JaxbHelper<T> helper =
						new JaxbHelper<T>(argPackageName);
				InputStream inputStream =
						JaxbHelper.class
								.getResourceAsStream(argConfigurationFile);
				JAXBElement<T> jaxbElement = helper.unmarshal(inputStream);
				value = jaxbElement.getValue();
				return value;
			} catch (Exception e) {
				throw new RuntimeException(
						"Error while unmarshalling the config file : "
								+ argConfigurationFile, e);
			}
		}
		return null;
	}

	/**
	 * Unmarshal with xsd validation.
	 * 
	 * @param <T>
	 *            the generic type
	 * @param argConfigurationFile
	 *            the configuration file
	 * @param argSchemaFileLocation
	 *            the schema file location
	 * @param argPackageName
	 *            the package name
	 * @return the t
	 */
	public static <T> T unmarshalWithXsdValidation(String argConfigurationFile,
			String argSchemaFileLocation, String argPackageName) {
		if (argConfigurationFile != null && !argConfigurationFile.isEmpty()
				&& argPackageName != null && !argPackageName.isEmpty()) {
			try {
				T value;
				JaxbHelper<T> helper =
						new JaxbHelper<T>(argPackageName);
				InputStream inputStream =
						JaxbHelper.class
								.getResourceAsStream(argConfigurationFile);
				JAXBElement<T> jaxbElement =
						helper.unmarshal(inputStream, argSchemaFileLocation,
								argConfigurationFile);
				value = jaxbElement.getValue();
				return value;
			} catch (Exception e) {
				throw new RuntimeException(
						"Error while unmarshalling the config file : "
								+ argConfigurationFile, e);
			}
		}
		return null;
	}

}
