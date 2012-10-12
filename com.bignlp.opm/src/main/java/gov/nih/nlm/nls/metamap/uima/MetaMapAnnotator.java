package gov.nih.nlm.nls.metamap.uima;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

import gov.nih.nlm.nls.metamap.*;
import gov.nih.nlm.nls.metamap.uima.ts.AcronymAbbrev;
import gov.nih.nlm.nls.metamap.uima.ts.Document;

import org.apache.uima.util.Level;
import org.apache.uima.UimaContext;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.jcas.cas.IntegerArray;
import org.apache.uima.analysis_component.AnalysisComponent;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.resource.ResourceInitializationException;
import org.metamap.uima.ts.CuiConcept;
import org.metamap.uima.ts.Span;

public class MetaMapAnnotator extends JCasAnnotator_ImplBase implements
		AnalysisComponent {
	private static final String MESSAGE_DIGEST = "AnnotatorMessages";

	public static final String MMSERVER_PATH_PARAMETER = "metamap_server_path";
	public static final String TEMPDIR_PATH_PARAMETER = "tempdir_path";
	public static final String SKRMEDPOSTCTL_PATH_PARAMETER = "skrmedpostctl_path";
	public static final String WSDSERVERCTL_PATH_PARAMETER = "wsdserverctl_path";
	public static final String METAMAP_OPTIONS_PARAMETER = "metamap_options";
	public static final String METAMAP_TIMEOUT_PARAMETER = "0";

	private String mmserverPath;
	private String skrmedpostctlPath;
	private String wsdserverctlPath;
	private String metamapOptions;
	private String apiTimeoutInterval;
	MetaMapApi api;

	/**
	 * @generated
	 * @ordered
	 */
	public final static int typeIndexID = JCasRegistry
			.register(MetaMapAnnotator.class);
	/**
	 * @generated
	 * @ordered
	 */
	public final static int type = typeIndexID;

	/** @generated */
	public int getTypeIndexID() {
		return typeIndexID;
	}

	/**
	 * Creates a new <code>MetaMapAnnotator</code> instance.
	 * 
	 */
	public MetaMapAnnotator() {

	}

	/**
	 * <!-- begin-user-doc --> Write your own initialization here <!--
	 * end-user-doc -->
	 * 
	 * @generated modifiable
	 */
	// private void readObject() {
	// }

	/** Performs any startup tasks required by this component. */
	public void initialize(UimaContext aContext)
			throws ResourceInitializationException {
		super.initialize(aContext);
		this.getParameters();
		this.api = new MetaMapApiImpl(0);
		this.startTaggerServer();
		this.startDisambiguationServer();
		this.startMetaMapServer();
		this.setupMetaMapOptions();
	}

	/** Completes the processing of a batch of CASes. */
	// public void batchProcessComplete() {
	// }

	/**
	 * Notifies this AnalysisComponent that processing of an entire collection
	 * has been completed.
	 */
	// public void collectionProcessComplete() {
	// }

	/** Frees all resources held by this AnalysisComponent. */
	public void destroy() {

	}

	/**
	 * Returns the specific CAS interface that this AnalysisComponent requires
	 * the framework to pass to its process(AbstractCas) method.
	 */
	// public Class<AbstractCas> getRequiredCasInterface() { return null; }

	/** Inputs a CAS to the AnalysisComponent. */
	public void process(JCas jcas) {
		String docText = jcas.getDocumentText();
		List<Result> resultList = this.api.processCitationsFromString(docText
				.trim());
		int resultStartIndex = 0;
		for (Result result : resultList) {
			if (result != null) {
				try {
					int citationStart = docText.indexOf(result.getInputText(),
							resultStartIndex);
					Document item = new gov.nih.nlm.nls.metamap.uima.ts.Document(
							jcas, citationStart, citationStart
									+ result.getInputText().length());

					List<gov.nih.nlm.nls.metamap.uima.ts.AcronymAbbrev> acronymsAbbrevs = processAcronymsAbbrevs(
							jcas, result.getAcronymsAbbrevsList());
					FSArray aaArray = new FSArray(jcas, acronymsAbbrevs.size());
					aaArray.copyFromArray(
							acronymsAbbrevs
									.toArray(new gov.nih.nlm.nls.metamap.uima.ts.AcronymAbbrev[0]),
							0, 0, aaArray.size());
					item.setAcronymsAbbrevs(aaArray);
					aaArray.addToIndexes(jcas);

					List<org.metamap.uima.ts.Negation> negations = processNegations(
							jcas, result.getNegationList(), citationStart);
					FSArray negationArray = new FSArray(jcas, negations.size());
					negationArray.copyFromArray(negations
							.toArray(new org.metamap.uima.ts.Negation[0]), 0,
							0, negationArray.size());
					item.setNegations(negationArray);
					negationArray.addToIndexes(jcas);

					List<org.metamap.uima.ts.Utterance> utterances = processUtterances(
							jcas, result.getUtteranceList(), citationStart);
					FSArray utteranceArray = new FSArray(jcas,
							utterances.size());
					utteranceArray.copyFromArray(utterances
							.toArray(new org.metamap.uima.ts.Utterance[0]), 0,
							0, utteranceArray.size());
					item.setUtterances(utteranceArray);
					utteranceArray.addToIndexes(jcas);

					item.addToIndexes(jcas);

				} catch (Exception e) {
					e.printStackTrace();
				}
				resultStartIndex = resultStartIndex
						+ result.getInputText().length();
			}
		}
	}

	List<gov.nih.nlm.nls.metamap.uima.ts.AcronymAbbrev> processAcronymsAbbrevs(
			JCas jcas, List<AcronymsAbbrevs> acronymsAbbrevsList)
			throws Exception {
		List<gov.nih.nlm.nls.metamap.uima.ts.AcronymAbbrev> acronymAbbrevList = new ArrayList<gov.nih.nlm.nls.metamap.uima.ts.AcronymAbbrev>(
				acronymsAbbrevsList.size());

		for (AcronymsAbbrevs aa : acronymsAbbrevsList) {
			AcronymAbbrev currentAA = new AcronymAbbrev(jcas);

			currentAA.setAcronym(aa.getAcronym());
			currentAA.setExpansion(aa.getExpansion());

			int i = 0;
			int[] countVector = new int[aa.getCountList().size()];
			for (Integer count : aa.getCountList()) {
				countVector[i] = count.intValue();
				i++;
			}
			IntegerArray countArray = new IntegerArray(jcas, countVector.length);
			countArray.copyFromArray(countVector, 0, 0, countVector.length);
			currentAA.setCountList(countArray);
			countArray.addToIndexes(jcas);

			StringArray cuiArray = new StringArray(jcas, aa.getCUIList().size());
			cuiArray.copyFromArray(aa.getCUIList().toArray(new String[0]), 0,
					0, aa.getCUIList().size());
			currentAA.setCuiList(cuiArray);
			cuiArray.addToIndexes(jcas);
			acronymAbbrevList.add(currentAA);
			currentAA.addToIndexes(jcas);
		}
		return acronymAbbrevList;
	}

	List<org.metamap.uima.ts.Negation> processNegations(JCas jcas,
			List<Negation> aNegationList, int citationStart) throws Exception {
		/** uima types from metamap uima package */
		List<org.metamap.uima.ts.Negation> negationList = new ArrayList<org.metamap.uima.ts.Negation>(
				aNegationList.size());

		CuiConcept currentCuiConcept = null;
		List<CuiConcept> cuiConcepts = null;

		// System.out.println("MetaMapAnnotator: result.getNegationList(): " +
		// result.getNegationList());
		for (Negation neg : aNegationList) {
			org.metamap.uima.ts.Negation currentNegation = new org.metamap.uima.ts.Negation(
					jcas);

			cuiConcepts = new ArrayList<CuiConcept>();

			currentNegation.setNegType(neg.getType());
			currentNegation.setNegTrigger(neg.getTrigger());

			FSArray fsArray = createSpanFSArray(jcas,
					neg.getTriggerPositionList(), citationStart);
			currentNegation.setNtSpans(fsArray);
			fsArray.addToIndexes();

			for (ConceptPair conceptPair : neg.getConceptPairList()) {
				currentCuiConcept = new CuiConcept(jcas);
				currentCuiConcept.setNegExConcept(conceptPair
						.getPreferredName());
				currentCuiConcept.setNegExCui(conceptPair.getConceptId());
				cuiConcepts.add(currentCuiConcept);
				currentCuiConcept.addToIndexes();
			}

			fsArray = createSpanFSArray(jcas, neg.getConceptPositionList(),
					citationStart);
			currentNegation.setNcSpans(fsArray);
			fsArray.addToIndexes();

			fsArray = new FSArray(jcas, cuiConcepts.size());
			fsArray.copyFromArray(cuiConcepts.toArray(new CuiConcept[0]), 0, 0,
					fsArray.size());
			currentNegation.setCuiConcepts(fsArray);
			fsArray.addToIndexes();
			currentNegation.addToIndexes();

			negationList.add(currentNegation);
		}
		return negationList;
	}

	List<org.metamap.uima.ts.Utterance> processUtterances(JCas jcas,
			List<Utterance> anUtteranceList, int citationStart)
			throws Exception {
		String docText = jcas.getDocumentText();
		/** uima types from metamap uima package */
		List<org.metamap.uima.ts.Utterance> utteranceList = new ArrayList<org.metamap.uima.ts.Utterance>(
				anUtteranceList.size());

		// System.out.println("MetaMapAnnotator: result.getUtteranceList(): " +
		// anUtteranceList);
		for (Utterance utterance : anUtteranceList) {
			int utteranceStart = docText.indexOf(utterance.getString(),
					citationStart + utterance.getPosition().getX());
			org.metamap.uima.ts.Utterance currentUtterance = new org.metamap.uima.ts.Utterance(
					jcas, utteranceStart, utteranceStart
							+ utterance.getPosition().getY());
			currentUtterance.setPmid(utterance.getId());
			processPCMList(jcas, utterance, currentUtterance, citationStart);
			currentUtterance.addToIndexes();
			utteranceList.add(currentUtterance);
		}
		return utteranceList;
	}

	void processPCMList(JCas jcas, gov.nih.nlm.nls.metamap.Utterance utterance,
			org.metamap.uima.ts.Utterance currentUtterance, int citationStart)
			throws Exception {
		String docText = jcas.getDocumentText();
		org.metamap.uima.ts.Phrase currentPhrase;
		// org.metamap.uima.ts.CuiConcept currentCuiConcept = null;
		List<org.metamap.uima.ts.Phrase> phrases = null;
		List<org.metamap.uima.ts.Candidate> candidates = null;
		List<org.metamap.uima.ts.Mapping> mappings = null;
		phrases = new ArrayList<org.metamap.uima.ts.Phrase>();
		mappings = new ArrayList<org.metamap.uima.ts.Mapping>();

		// System.out.println("MetaMapAnnotator: utterance.getPCMList(): " +
		// utterance.getPCMList());
		for (PCM pcm : utterance.getPCMList()) {
			// System.out.println("MetaMapAnnotator: pcm.getPhrase().getPhraseText(): "
			// + pcm.getPhrase().getPhraseText());

			int phraseStart = docText.indexOf(pcm.getPhrase().getPhraseText(),
					citationStart + pcm.getPhrase().getPosition().getX());
			currentPhrase = new org.metamap.uima.ts.Phrase(jcas, phraseStart,
					phraseStart + pcm.getPhrase().getPosition().getY());
			phrases.add(currentPhrase);

			candidates = processCandidates(jcas, pcm.getCandidateList(),
					citationStart);
			FSArray fsArray = new FSArray(jcas, candidates.size());
			fsArray.copyFromArray(
					candidates.toArray(new org.metamap.uima.ts.Candidate[0]),
					0, 0, fsArray.size());
			currentPhrase.setCandidates(fsArray);
			fsArray.addToIndexes();

			mappings = processMappings(jcas, pcm, citationStart);
			fsArray = new FSArray(jcas, mappings.size());
			fsArray.copyFromArray(
					mappings.toArray(new org.metamap.uima.ts.Mapping[0]), 0, 0,
					fsArray.size());
			currentPhrase.setMappings(fsArray);
			fsArray.addToIndexes();
			currentPhrase.addToIndexes();
		}
		currentUtterance.setLocation(utterance.getId().substring(
				utterance.getId().indexOf("."),
				utterance.getId().lastIndexOf(".")));
		FSArray fsArray = new FSArray(jcas, phrases.size());
		fsArray.copyFromArray(
				phrases.toArray(new org.metamap.uima.ts.Phrase[0]), 0, 0,
				fsArray.size());

		currentUtterance.setPhrases(fsArray);
		fsArray.addToIndexes();
	}

	List<org.metamap.uima.ts.Candidate> processCandidates(JCas jcas,
			List<Ev> candidateList, int citationStart) throws Exception {
		String docText = jcas.getDocumentText();
		org.metamap.uima.ts.Candidate currentCandidate;
		List<org.metamap.uima.ts.Candidate> candidates = new ArrayList<org.metamap.uima.ts.Candidate>();

		for (Ev ev : candidateList) {
			// System.out.println("MetaMapAnnotator: ev.getScore(): " +
			// ev.getScore());
			// System.out.println("MetaMapAnnotator: ev.getConceptId(): " +
			// ev.getConceptId());
			int begin = 9999;
			int end = 0;
			for (Position pos : ev.getPositionalInfo()) {
				begin = Math.min(begin, (int) pos.getX());
				end = Math.max(end, pos.getX() + pos.getY());
				// System.out.println("span: [" + pos.getX() + "," + pos.getX()
				// + pos.getY() + "]");
			}
			int start = citationStart + begin;
			int finish = citationStart + end;

			// System.out.println("maximal span: [" + begin + "," + end + "]");
			currentCandidate = new org.metamap.uima.ts.Candidate(jcas, start,
					finish);
			currentCandidate.setScore(ev.getScore());
			currentCandidate.setCui(ev.getConceptId());
			currentCandidate.setConcept(ev.getConceptName());
			currentCandidate.setPreferred(ev.getPreferredName());
			currentCandidate.setHead(ev.isHead());
			currentCandidate.setOvermatch(ev.isOvermatch());

			List<gov.nih.nlm.nls.metamap.uima.ts.MatchMap> matchMaps = new ArrayList<gov.nih.nlm.nls.metamap.uima.ts.MatchMap>();
			gov.nih.nlm.nls.metamap.uima.ts.MatchMap currentMatchMap;
			for (MatchMap matchMap : ev.getMatchMapList()) {
				currentMatchMap = new gov.nih.nlm.nls.metamap.uima.ts.MatchMap(
						jcas);
				currentMatchMap.setPhraseMatchStart(matchMap
						.getPhraseMatchStart());
				currentMatchMap.setPhraseMatchEnd(matchMap.getPhraseMatchEnd());
				currentMatchMap.setConceptMatchStart(matchMap
						.getConceptMatchStart());
				currentMatchMap.setConceptMatchEnd(matchMap
						.getConceptMatchEnd());
				currentMatchMap
						.setLexVariation(matchMap.getLexMatchVariation());
				matchMaps.add(currentMatchMap);
			}
			FSArray matchMapArray = new FSArray(jcas, ev.getMatchMapList()
					.size());
			matchMapArray.copyFromArray(matchMaps
					.toArray(new gov.nih.nlm.nls.metamap.uima.ts.MatchMap[0]),
					0, 0, matchMapArray.size());
			currentCandidate.setMatchMap(matchMapArray);
			matchMapArray.addToIndexes();

			StringArray sourceArray = new StringArray(jcas, ev.getSources()
					.size());
			// ev.getSources().toArray()
			sourceArray.copyFromArray(ev.getSources().toArray(new String[0]),
					0, 0, ev.getSources().size());
			currentCandidate.setSources(sourceArray);
			sourceArray.addToIndexes();

			StringArray semTypeArray = new StringArray(jcas, ev
					.getSemanticTypes().size());
			// ev.getSemanticTypes().toArray()
			semTypeArray.copyFromArray(
					ev.getSemanticTypes().toArray(new String[0]), 0, 0, ev
							.getSemanticTypes().size());
			currentCandidate.setSemanticTypes(semTypeArray);
			semTypeArray.addToIndexes();

			StringArray matchedWordArray = new StringArray(jcas, ev
					.getMatchedWords().size());
			matchedWordArray.copyFromArray(
					ev.getMatchedWords().toArray(new String[0]), 0, 0, ev
							.getMatchedWords().size());
			currentCandidate.setMatchedwords(matchedWordArray);
			matchedWordArray.addToIndexes();

			FSArray fsArray = createSpanFSArray(jcas, ev.getPositionalInfo(),
					citationStart);
			currentCandidate.setSpans(fsArray);
			fsArray.addToIndexes();

			candidates.add(currentCandidate);
			currentCandidate.addToIndexes();
		}
		return candidates;
	}

	List<org.metamap.uima.ts.Mapping> processMappings(JCas jcas, PCM pcm,
			int citationStart) throws Exception {
		org.metamap.uima.ts.Mapping currentMapping;
		List<org.metamap.uima.ts.Candidate> candidates;
		List<org.metamap.uima.ts.Mapping> mappings = new ArrayList<org.metamap.uima.ts.Mapping>();

		for (gov.nih.nlm.nls.metamap.Mapping map : pcm.getMappingList()) {
			// System.out.println("MetaMapAnnotator: map.getScore(): " +
			// map.getScore());
			currentMapping = new org.metamap.uima.ts.Mapping(jcas);

			candidates = processCandidates(jcas, map.getEvList(), citationStart);

			FSArray mappedCandidatesFSArray = new FSArray(jcas,
					candidates.size());
			mappedCandidatesFSArray.copyFromArray(
					candidates.toArray(new org.metamap.uima.ts.Candidate[0]),
					0, 0, mappedCandidatesFSArray.size());
			currentMapping.setCandidates(mappedCandidatesFSArray);
			mappedCandidatesFSArray.addToIndexes();
			mappings.add(currentMapping);
			currentMapping.setScore(map.getScore());
			currentMapping.addToIndexes();
		}
		return mappings;
	}

	public FSArray createSpanFSArray(JCas jcas, List<Position> positionList,
			int citationStart) {
		List<Span> spans = createSpanList(jcas, positionList, citationStart);
		FSArray fsArray = new FSArray(jcas, spans.size());
		fsArray.copyFromArray(spans.toArray(new org.metamap.uima.ts.Span[0]),
				0, 0, fsArray.size());
		return fsArray;
	}

	public List<Span> createSpanList(JCas jcas, List<Position> positionList,
			int citationStart) {
		List<Span> spans = new ArrayList<Span>();
		for (Position pos : positionList) {
			Span currentSpan = new Span(jcas);
			;
			if (pos != null) {
				currentSpan.setBegin(citationStart + pos.getX());
				currentSpan.setEnd(citationStart + pos.getX() + pos.getY()); // getY()
																				// actually
																				// is
																				// the
																				// Span
																				// length
																				// (http://skr.nlm.nih.gov/Help/MMO_08_Info.html)
			} else {
				System.err
						.println("Null positional information in pos: " + pos);
			}
			spans.add(currentSpan);
			currentSpan.addToIndexes();
		}
		return spans;
	}

	/*
	 * Alerts this AnalysisComponent that the values of its configuration
	 * parameters or external resources have changed.
	 */
	// public void reconfigure() {
	// }

	/** Sets the ResultSpecification that this AnalysisComponent should use. */
	// public void setResultSpecification(ResultSpecification aResultSpec) {
	// }

	/**
	 * add any extra options (besides machine output) to be used for processing,
	 * see parameter <name>metamap_options</name>
	 */
	private void setupMetaMapOptions() {
		// Mandatory options.
		if ((this.metamapOptions != null) && (!this.metamapOptions.isEmpty())) {
			this.api.setOptions(metamapOptions);
		}
	}

	/**
	 * Modified version of getParameters() from Kai Schlamp's
	 * BasicMetaMapAnnotator.
	 */
	private void getParameters() {
		this.mmserverPath = (String) getContext().getConfigParameterValue(
				MMSERVER_PATH_PARAMETER);
		this.skrmedpostctlPath = (String) getContext().getConfigParameterValue(
				SKRMEDPOSTCTL_PATH_PARAMETER);
		this.wsdserverctlPath = (String) getContext().getConfigParameterValue(
				WSDSERVERCTL_PATH_PARAMETER);
		// tempdirPath = (String)
		// getContext().getConfigParameterValue(TEMPDIR_PATH_PARAMETER);
		this.metamapOptions = (String) getContext().getConfigParameterValue(
				METAMAP_OPTIONS_PARAMETER);
		this.apiTimeoutInterval = (String) getContext()
				.getConfigParameterValue(METAMAP_TIMEOUT_PARAMETER);
	}

	/**
	 * Taken from Kai Schlamp's BasicMetaMapAnnotator.
	 * 
	 */
	private void startTaggerServer() {
		File skrmedpostctlFile = null;
		if (this.skrmedpostctlPath != null && !this.skrmedpostctlPath.isEmpty()) {
			skrmedpostctlFile = new File(this.skrmedpostctlPath);
			if (!skrmedpostctlFile.isFile()) {
				getContext().getLogger().logrb(Level.WARNING, null, null,
						MESSAGE_DIGEST, "wrong_skrmedpostctl_path");
				skrmedpostctlFile = null;
			}
			if (!skrmedpostctlFile.canExecute()) {
				getContext().getLogger().logrb(Level.WARNING, null, null,
						MESSAGE_DIGEST, "not_executable_skrmedpostctl");
				skrmedpostctlFile = null;
			}
		}

		boolean taggerServerRunning = false;
		String os = System.getProperty("os.name");
		if ((skrmedpostctlFile != null)
				&& (os.contains("Linux") || os.contains("linux"))) {
			try {
				taggerServerRunning = checkProcess("taggerServer");
				if (!taggerServerRunning && skrmedpostctlFile != null) {
					ProcessBuilder taggerServerStartProcessBuilder = new ProcessBuilder(
							skrmedpostctlFile.getAbsolutePath(), "start");
					try {
						taggerServerStartProcessBuilder.start().waitFor();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						getContext().getLogger().logrb(Level.WARNING, null,
								null, MESSAGE_DIGEST,
								"failure_tagger_server_start", e);
					}
				}
			} catch (IOException e) {
				getContext().getLogger()
						.logrb(Level.WARNING, null, null, MESSAGE_DIGEST,
								"failure_searching_server_processes", e);
			}
		}
	}

	/**
	 * Taken from Kai Schlamp's BasicMetaMapAnnotator.
	 * 
	 */
	private void startDisambiguationServer() {
		File wsdserverctlFile = null;
		if (this.wsdserverctlPath != null && !this.wsdserverctlPath.isEmpty()) {
			wsdserverctlFile = new File(this.wsdserverctlPath);
			if (!wsdserverctlFile.isFile()) {
				getContext().getLogger().logrb(Level.WARNING, null, null,
						MESSAGE_DIGEST, "wrong_wsdserverctl_path");
				wsdserverctlFile = null;
			}
			if (!wsdserverctlFile.canExecute()) {
				getContext().getLogger().logrb(Level.WARNING, null, null,
						MESSAGE_DIGEST, "not_executable_wsdserverctl");
				wsdserverctlFile = null;
			}
		}

		boolean disambiguatorServerRunning = false;
		String os = System.getProperty("os.name");
		if ((wsdserverctlFile != null)
				&& (os.contains("Linux") || os.contains("linux"))) {
			try {
				disambiguatorServerRunning = checkProcess("wsd.server.DisambiguatorServer");
				if (!disambiguatorServerRunning && wsdserverctlFile != null) {
					ProcessBuilder disambiguatorStartProcessBuilder = new ProcessBuilder(
							wsdserverctlFile.getAbsolutePath(), "start");
					try {
						disambiguatorStartProcessBuilder.start().waitFor();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						getContext().getLogger().logrb(Level.WARNING, null,
								null, MESSAGE_DIGEST,
								"failure_disambiguator_server_start", e);
					}
				}
			} catch (IOException e) {
				getContext().getLogger()
						.logrb(Level.WARNING, null, null, MESSAGE_DIGEST,
								"failure_searching_server_processes", e);
			}
		}
	}

	/**
	 * Taken from Kai Schlamp's BasicMetaMapAnnotator.
	 * 
	 */
	private boolean checkProcess(String processName) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder("ps", "-ef");
		Process psProcess = processBuilder.start();
		BufferedReader input = new BufferedReader(new InputStreamReader(
				psProcess.getInputStream()));
		String line;
		while ((line = input.readLine()) != null) {
			if (line.contains(processName)) {
				return true;
			}
		}
		input.close();
		return false;
	}

	private void startMetaMapServer() {
		File mmserverFile = null;
		if (this.mmserverPath != null && !this.mmserverPath.isEmpty()) {
			mmserverFile = new File(this.mmserverPath);
			if (!mmserverFile.isFile()) {
				getContext().getLogger().logrb(Level.WARNING, null, null,
						MESSAGE_DIGEST, "wrong_mmserver_path");
				mmserverFile = null;
			}
			if (mmserverFile != null && !mmserverFile.canExecute()) {
				getContext().getLogger().logrb(Level.WARNING, null, null,
						MESSAGE_DIGEST, "not_executable_mmserver");
				mmserverFile = null;
			}
		}

		boolean disambiguatorServerRunning = false;
		String os = System.getProperty("os.name");
		if ((mmserverFile != null)
				&& (os.contains("Linux") || os.contains("linux"))) {
			try {
				disambiguatorServerRunning = checkProcess("mmserver");
				if (!disambiguatorServerRunning && mmserverFile != null) {
					ProcessBuilder disambiguatorStartProcessBuilder = new ProcessBuilder(
							mmserverFile.getAbsolutePath(), "start");
					try {
						disambiguatorStartProcessBuilder.start().waitFor();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						getContext().getLogger().logrb(Level.WARNING, null,
								null, MESSAGE_DIGEST,
								"failure_disambiguator_server_start", e);
					}
				}
			} catch (IOException e) {
				getContext().getLogger()
						.logrb(Level.WARNING, null, null, MESSAGE_DIGEST,
								"failure_searching_server_processes", e);
			}
		}
	}

}
