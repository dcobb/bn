//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.09 at 06:14:21 PM IST 
//


package com.bignlp.xmlns.ccd.v1.org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Currency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Currency">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="ARS"/>
 *     &lt;enumeration value="AUD"/>
 *     &lt;enumeration value="BRL"/>
 *     &lt;enumeration value="CAD"/>
 *     &lt;enumeration value="CHF"/>
 *     &lt;enumeration value="CLF"/>
 *     &lt;enumeration value="CNY"/>
 *     &lt;enumeration value="DEM"/>
 *     &lt;enumeration value="ESP"/>
 *     &lt;enumeration value="EUR"/>
 *     &lt;enumeration value="FIM"/>
 *     &lt;enumeration value="FRF"/>
 *     &lt;enumeration value="GBP"/>
 *     &lt;enumeration value="ILS"/>
 *     &lt;enumeration value="INR"/>
 *     &lt;enumeration value="JPY"/>
 *     &lt;enumeration value="KRW"/>
 *     &lt;enumeration value="MXN"/>
 *     &lt;enumeration value="NLG"/>
 *     &lt;enumeration value="NZD"/>
 *     &lt;enumeration value="PHP"/>
 *     &lt;enumeration value="RUR"/>
 *     &lt;enumeration value="THB"/>
 *     &lt;enumeration value="TRL"/>
 *     &lt;enumeration value="TWD"/>
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="ZAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Currency")
@XmlEnum
public enum Currency {

    ARS,
    AUD,
    BRL,
    CAD,
    CHF,
    CLF,
    CNY,
    DEM,
    ESP,
    EUR,
    FIM,
    FRF,
    GBP,
    ILS,
    INR,
    JPY,
    KRW,
    MXN,
    NLG,
    NZD,
    PHP,
    RUR,
    THB,
    TRL,
    TWD,
    USD,
    ZAR;

    public String value() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

}
