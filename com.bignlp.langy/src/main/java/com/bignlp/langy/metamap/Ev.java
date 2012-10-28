package com.bignlp.langy.metamap;

import java.util.List;

import se.sics.prologbeans.PBTerm;

/**
 * Representation of MetaMap Evaluation (Ev) instance.
 * <p>
 * 
 * <pre>
 * for (Utterance utterance : result.getUtteranceList()) {
 * 	for (PCM pcm : utterance.getPCMList()) {
 * 		for (Mapping map : pcm.getMappingList()) {
 * 			for (Ev mapEv : map.getEvList()) {
 * 				System.out.println(&quot;   Score: &quot; + mapEv.getScore());
 * 				System.out.println(&quot;   Concept Id: &quot; + mapEv.getConceptId());
 * 				System.out
 * 						.println(&quot;   Concept Name: &quot; + mapEv.getConceptName());
 * 				System.out.println(&quot;   Preferred Name: &quot;
 * 						+ mapEv.getPreferredName());
 * 				System.out.println(&quot;   Matched Words: &quot;
 * 						+ mapEv.getMatchedWords());
 * 				System.out.println(&quot;   Semantic Types: &quot;
 * 						+ mapEv.getSemanticTypes());
 * 				System.out.println(&quot;   MatchMap: &quot; + mapEv.getMatchMap());
 * 				System.out.println(&quot;   is Head?: &quot; + mapEv.isHead());
 * 				System.out.println(&quot;   is Overmatch?: &quot; + mapEv.isOvermatch());
 * 				System.out.println(&quot;   Sources: &quot; + mapEv.getSources());
 * 				System.out.println(&quot;   Positional Info: &quot;
 * 						+ mapEv.getPositionalInfo());
 * 				System.out.println(&quot;   Pruning Status: &quot;
 * 						+ mapEv.getPruningStatus());
 * 			}
 * 		}
 * 	}
 * }
 * </pre>
 * <p>
 * Created: Wed Apr 29 16:01:18 2009
 * 
 * @author <a href="mailto:wrogers@nlm.nih.gov">Willie Rogers</a>
 * @version 1.0
 */
public interface Ev extends MetaMapElement {
	int getScore() throws Exception;

	String getConceptId() throws Exception;

	String getConceptName() throws Exception;

	String getPreferredName() throws Exception;

	List<String> getMatchedWords() throws Exception;

	List<String> getSemanticTypes() throws Exception;

	/**
	 * This returns a recursive list of objects where the elements can be
	 * Integer classes or List classes containing Lists or Integers.
	 * 
	 * @return List of Objects.
	 */
	List<Object> getMatchMap() throws Exception;

	/**
	 * This returns a list of MatchMap objects
	 * 
	 * @return List of MatchMap.
	 */
	List<MatchMap> getMatchMapList() throws Exception;

	boolean isHead() throws Exception;

	boolean isOvermatch() throws Exception;

	List<String> getSources() throws Exception;

	List<Position> getPositionalInfo() throws Exception;

	PBTerm getTerm() throws Exception;

	/**
	 * Get pruning status of ev term.
	 * <p>
	 * <ul>
	 * <li>1: if the candidate was excluded,
	 * <li>2: if the candidate was pruned, and
	 * <li>0: otherwise, i.e., if the candidate was retained.
	 * </ul>
	 */
	int getPruningStatus() throws Exception;
}
