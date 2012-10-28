package com.bignlp.langy.metamap;

import java.io.Serializable;

/**
 * A container for a concept id (CUI) and its associated preferred name.
 * <p>
 * 
 * Created: Fri Oct 9 10:48:05 2009
 * 
 * @author <a href="mailto:wrogers@nlm.nih.gov">Willie Rogers</a>
 * @version 1.0
 */
public interface ConceptPair extends Serializable {
	String getConceptId();

	String getPreferredName();
}
