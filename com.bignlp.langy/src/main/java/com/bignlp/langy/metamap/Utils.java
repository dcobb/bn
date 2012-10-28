package com.bignlp.langy.metamap;

/**
 * Describe class Utils here.
 * 
 * 
 * Created: Thu Jan 7 08:40:30 2010
 * 
 * @author <a href="mailto:wrogers@nlm.nih.gov">Willie Rogers</a>
 * @version 1.0
 */
public class Utils {

	/**
	 * Get pmid portion of metamap id.
	 * 
	 * @param id
	 *            string in form of <pmid>.<location>.<sequence number>
	 * @return string containing pmid portion of metamap id.
	 */
	public static String getPmidFromId(String id) {
		return id.substring(0, id.indexOf("."));
	}

	/**
	 * Get location portion of metamap id.
	 * 
	 * @param id
	 *            string in form of <pmid>.<location>.<sequence number>
	 * @return string containing location portion of metamap id.
	 */
	public static String getLocationFromId(String id) {
		return id.substring(id.indexOf("."), id.lastIndexOf("."));
	}

	/**
	 * Get sequence number portion of metamap id.
	 * 
	 * @param id
	 *            string in form of <pmid>.<location>.<sequence number>
	 * @return string containing sequence number portion of metamap id.
	 */
	public static String getSequenceNumberFromId(String id) {
		return id.substring(id.lastIndexOf("."));
	}
}
