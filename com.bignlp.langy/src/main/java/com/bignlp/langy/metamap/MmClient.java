package com.bignlp.langy.metamap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MmClient {
	private static Logger logger = LoggerFactory.getLogger(MmClient.class);
	private MetaMapApi api;
	private String host;
	private int port;

	public MmClient() {
		this.api = new MetaMapApiImpl();
	}

	public MmClient(String serverHostname, int serverPort) {
		this.host = serverHostname;
		this.port = serverPort;
		this.api = new MetaMapApiImpl();
		this.api.setHost(serverHostname);
		this.api.setPort(serverPort);
	}

	@Override
	public String toString() {
		return "MmClient [host=" + this.host + ", port=" + this.port + "]";
	}

	public void setTimeout(int interval) {
		this.api.setTimeout(interval);
	}

	public static String readInputFile(File inFile)
			throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader br = new BufferedReader(new FileReader(inFile));
		return readFile(br);
	}

	private static String readFile(BufferedReader br) throws IOException {
		try {
			StringBuffer inputBuf = new StringBuffer();
			String line = "";
			while ((line = br.readLine()) != null) {
				inputBuf.append(line).append('\n');
			}
			return inputBuf.toString();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ignore) {
					// ignore
				}
			}
		}
	}

	public List<Result> process(String terms, PrintStream out) throws Exception {
		try {
			List<Result> results = api.processCitationsFromString(terms);
			// writeResults(results, out);
			return results;
		} catch (Exception e) {
			// MmServer.getInstance().startMetaMapServerInNewThread(this.port);
			// throw e;
		}
		return null;
	}

	private void writeResults(List<Result> results, PrintStream out)
			throws Exception {
		for (Result result : results) {
			if (result != null) {
				writeResultTo(result, out);
			} else {
				out.println("NULL result instance! ");
			}
		}
	}

	private void writeResultTo(Result result, PrintStream out) throws Exception {
		out.println("input text: ");
		out.println(" " + result.getInputText());
		writeAcronymsAbbrevs(result, out);
		writeNegations(result, out);
		for (Utterance utterance : result.getUtteranceList()) {
			writeUtterance(utterance, out);
		}
	}

	private void writeUtterance(Utterance utterance, PrintStream out)
			throws Exception {
		out.println("Utterance:");
		out.println(" Id: " + utterance.getId());
		out.println(" Utterance text: " + utterance.getString());
		out.println(" Position: " + utterance.getPosition());
		for (PCM pcm : utterance.getPCMList()) {
			writePcm(out, pcm);
		}
	}

	private void writePcm(PrintStream out, PCM pcm) throws Exception {
		out.println("Phrase:");
		out.println(" text: " + pcm.getPhrase().getPhraseText());
		out.println(" Minimal Commitment Parse: "
				+ pcm.getPhrase().getMincoManAsString());
		out.println("Candidates:");
		for (Ev ev : pcm.getCandidateList()) {
			writeCandidate(ev, out);
		}

		out.println("Mappings:");
		for (Mapping map : pcm.getMappingList()) {
			out.println(" Map Score: " + map.getScore());
			for (Ev mapEv : map.getEvList()) {
				writeConcept(out, mapEv);
			}
		}
	}

	private void writeConcept(PrintStream out, Ev mapEv) throws Exception {
		out.println("   Score: " + mapEv.getScore());
		out.println("   Concept Id: " + mapEv.getConceptId());
		out.println("   Concept Name: " + mapEv.getConceptName());
		out.println("   Preferred Name: " + mapEv.getPreferredName());
		out.println("   Matched Words: " + mapEv.getMatchedWords());
		out.println("   Semantic Types: " + mapEv.getSemanticTypes());
		out.println("   MatchMap: " + mapEv.getMatchMap());
		out.println("   MatchMap alt. repr.: " + mapEv.getMatchMapList());
		out.println("   is Head?: " + mapEv.isHead());
		out.println("   is Overmatch?: " + mapEv.isOvermatch());
		out.println("   Sources: " + mapEv.getSources());
		out.println("   Positional Info: " + mapEv.getPositionalInfo());
	}

	private void writeCandidate(Ev ev, PrintStream out) throws Exception {
		out.println(" Candidate:");
		out.println("  Score: " + ev.getScore());
		out.println("  Concept Id: " + ev.getConceptId());
		out.println("  Concept Name: " + ev.getConceptName());
		out.println("  Preferred Name: " + ev.getPreferredName());
		out.println("  Matched Words: " + ev.getMatchedWords());
		out.println("  Semantic Types: " + ev.getSemanticTypes());
		out.println("  MatchMap: " + ev.getMatchMap());
		out.println("  MatchMap alt. repr.: " + ev.getMatchMapList());
		out.println("  is Head?: " + ev.isHead());
		out.println("  is Overmatch?: " + ev.isOvermatch());
		out.println("  Sources: " + ev.getSources());
		out.println("  Positional Info: " + ev.getPositionalInfo());
	}

	private void writeNegations(Result result, PrintStream out)
			throws Exception {
		List<Negation> negList = result.getNegationList();
		if (negList.size() > 0) {
			out.println("Negations:");
			for (Negation e : negList) {
				out.println("type: " + e.getType());
				out.print("Trigger: " + e.getTrigger() + ": [");
				for (Position pos : e.getTriggerPositionList()) {
					out.print(pos + ",");
				}
				out.println("]");
				out.print("ConceptPairs: [");
				for (ConceptPair pair : e.getConceptPairList()) {
					out.print(pair + ",");
				}
				out.println("]");
				out.print("ConceptPositionList: [");
				for (Position pos : e.getConceptPositionList()) {
					out.print(pos + ",");
				}
				out.println("]");
			}
		}
	}

	private void writeAcronymsAbbrevs(Result result, PrintStream out)
			throws Exception {
		List<AcronymsAbbrevs> aaList = result.getAcronymsAbbrevsList();
		if (aaList.size() > 0) {
			out.println("Acronyms and Abbreviations:");
			for (AcronymsAbbrevs e : aaList) {
				out.println("Acronym: " + e.getAcronym());
				out.println("Expansion: " + e.getExpansion());
				out.println("Count list: " + e.getCountList());
				out.println("CUI list: " + e.getCUIList());
			}
		}
	}

	public void close() {
		if (this.api != null) {
			try {
				this.api.disconnect();
			} catch (Exception ignore) {
				// ignore
			}
		}
	}
}
