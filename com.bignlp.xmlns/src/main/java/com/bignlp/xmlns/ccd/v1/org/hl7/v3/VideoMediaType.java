//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.09 at 06:14:21 PM IST 
//


package com.bignlp.xmlns.ccd.v1.org.hl7.v3;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VideoMediaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VideoMediaType">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="video/mpeg"/>
 *     &lt;enumeration value="video/x-avi"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VideoMediaType")
@XmlEnum
public enum VideoMediaType {

    @XmlEnumValue("video/mpeg")
    VIDEO_MPEG("video/mpeg"),
    @XmlEnumValue("video/x-avi")
    VIDEO_X_AVI("video/x-avi");
    private final String value;

    VideoMediaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VideoMediaType fromValue(String v) {
        for (VideoMediaType c: VideoMediaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
