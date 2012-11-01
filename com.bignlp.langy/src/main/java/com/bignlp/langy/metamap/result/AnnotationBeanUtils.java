package com.bignlp.langy.metamap.result;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bignlp.langy.metamap.MmClient;
import com.google.gson.Gson;

public class AnnotationBeanUtils {
	private static final int FIRST_ELEMENT = 0;

	public static DocumentAnnotationsBean createDocumentAnnotationsBean(
			List<MetaMapResult> argMmResults) {
		DocumentAnnotationsBean documentAnnotationsBean = new DocumentAnnotationsBean();
		DocumentBean documentBean = createDocument();
		documentAnnotationsBean.setDocument(documentBean);
		InputBean inputBean = createInputBean();
		documentAnnotationsBean.setInput(inputBean);
		List<AnnotationBean> annotationBeans = createAnnotationBean(argMmResults);
		documentAnnotationsBean.setAnnotations(annotationBeans);
		return documentAnnotationsBean;
	}

	private static InputBean createInputBean() {
		InputBean inputBean = new InputBean();
		inputBean.setContentId("4567");
		inputBean.setCharSet("UTF-8");
		inputBean.setContentType("text/plain");
		inputBean
				.setContent("Heregoesall the tika extracted content which was saved to isr");
		return inputBean;
	}

	private static DocumentBean createDocument() {
		DocumentBean documentBean = new DocumentBean();
		documentBean.setDocumentId("1234");
		documentBean.setContentType("application/ms-word");
		documentBean.setDateCreated("2012-10-18");
		documentBean.setDateAnnotated("2012-10-20");
		documentBean.setFileName("sample1.doc");
		return documentBean;
	}

	public static List<AnnotationBean> createAnnotationBean(
			List<MetaMapResult> argMetaMapResult) {
		if (argMetaMapResult != null && !argMetaMapResult.isEmpty()) {
			List<AnnotationBean> annotationBeans = new ArrayList<AnnotationBean>();
			for (MetaMapResult mmResult : argMetaMapResult) {
				if (mmResult != null) {
					List<MetaMapAcronym> mmAcronyms = mmResult.getAcronyms();
					if (mmAcronyms != null && !mmAcronyms.isEmpty()) {
						for (MetaMapAcronym mmAcronym : mmAcronyms) {
							// handle acronyms and abbreviations
						}
					}

					List<MetaMapNegation> mmNegations = mmResult.getNegations();
					if (mmNegations != null && !mmNegations.isEmpty()) {
						for (MetaMapNegation mmNegation : mmNegations) {
							// handle Negations
						}
					}

					List<MetaMapUtterance> mmUtterances = mmResult
							.getUtterences();
					List<AnnotationBean> utteranceAnnotationBeans = createAnnotationBeans(mmUtterances);
					if (utteranceAnnotationBeans != null
							&& !utteranceAnnotationBeans.isEmpty()) {
						annotationBeans.addAll(utteranceAnnotationBeans);
					}
				}
			}
			return annotationBeans;
		}
		return null;
	}

	private static List<AnnotationBean> createAnnotationBeans(
			List<MetaMapUtterance> mmUtterances) {
		if (mmUtterances != null && !mmUtterances.isEmpty()) {
			List<AnnotationBean> annotationBeans = new ArrayList<AnnotationBean>();
			for (MetaMapUtterance mmUtterance : mmUtterances) {
				if (mmUtterance != null) {
					List<MetaMapPhraseCandidateMapping> pcms = mmUtterance
							.getPhraseConceptMappings();
					if (pcms != null && !pcms.isEmpty()) {
						for (MetaMapPhraseCandidateMapping pcm : pcms) {
							if (pcm != null) {
								AnnotationBean annotationBean = createAnnotationBean(pcm);
								annotationBeans.add(annotationBean);
							}
						}
					}
				}
			}
			return annotationBeans;
		}
		return null;
	}

	private static AnnotationBean createAnnotationBean(
			MetaMapPhraseCandidateMapping pcm) {
		if (pcm != null) {
			MetaMapPhrase mmPhrase = pcm.getPhrase();
			AnnotationBean annotationBean = new AnnotationBean();
			AnnotationDetailsBean annotationDetailsBean = new AnnotationDetailsBean();
			annotationBean.setDetails(annotationDetailsBean);
			String phrase = mmPhrase.getPhraseText();
			annotationBean.setPhrase(phrase);
			MetaMapPosition mmPosition = mmPhrase.getPosition();
			if (mmPosition != null) {
				int startPosition = mmPosition.getX();
				int length = mmPosition.getY();
				int endPosition = startPosition + length - 1;
				annotationBean.setStartPosition(startPosition);
				annotationBean.setEndPosition(endPosition);
			}
			List<MetaMapEvaluation> evs = pcm.getCandidates();
			if (evs != null && !evs.isEmpty()) {
				List<PhrasePartBean> phrasePartBeans = new ArrayList<PhrasePartBean>();
				annotationDetailsBean.setPhraseParts(phrasePartBeans);
				for (MetaMapEvaluation ev : evs) {
					if (ev != null) {
						PhrasePartBean phrasePartBean = createPhrasePartBean(ev);
						phrasePartBeans.add(phrasePartBean);
					}
				}
			}
			return annotationBean;
		}
		return null;
	}

	private static PhrasePartBean createPhrasePartBean(MetaMapEvaluation ev) {
		if (ev != null) {
			PhrasePartBean phrasePartBean = new PhrasePartBean();
			String conceptId = ev.getConceptId();
			String conceptName = ev.getConceptName();
			phrasePartBean.setPhrase(conceptName);
			List<String> semanticTypes = ev.getSemanticTypes();
			phrasePartBean.setTags(semanticTypes);
			String preferredName = ev.getPreferredName();
			int score = ev.getScore();
			phrasePartBean.setSummary(getPhasePartSummaryFromConceptId(
					conceptId, conceptName, preferredName, score));
			List<MetaMapPosition> mmPositions = ev.getPositions();
			if (mmPositions != null && !mmPositions.isEmpty()) {
				MetaMapPosition mmPosition = mmPositions.get(FIRST_ELEMENT);
				if (mmPosition != null) {
					int startPosition = mmPosition.getX();
					int length = mmPosition.getY();
					int endPosition = startPosition + length - 1;
					phrasePartBean.setStartPosition(startPosition);
					phrasePartBean.setEndPosition(endPosition);
				}
			}
			return phrasePartBean;
		}
		return null;
	}

	private static String getPhasePartSummaryFromConceptId(
			String argsConceptId, String argConceptName,
			String argsPreferredName, int argsScore) {
		return "Here goes the summary for conceptId:" + argsConceptId
				+ " concept:" + argConceptName + " preferredName:"
				+ argsPreferredName + " score:" + argsScore;
	}

	public static DocumentAnnotationsBean create(String argJson) {
		Gson gson = new Gson();
		DocumentAnnotationsBean documentAnnotationsBean = gson.fromJson(
				argJson, DocumentAnnotationsBean.class);
		System.out
				.println("======================= BEGIN DocumentAnnotationsBean.toString() =================== ");
		System.out.println(documentAnnotationsBean.toString());
		System.out
				.println("======================= END DocumentAnnotationsBean.toString() =================== ");
		String serializedJson = gson.toJson(documentAnnotationsBean);
		System.out
				.println("======================= BEGIN DocumentAnnotationsBean.serializedJson() =================== ");
		System.out.println(serializedJson);
		System.out
				.println("======================= END DocumentAnnotationsBean.serializedJson() =================== ");
		DocumentAnnotationsBean documentAnnotationsBeanDeserialized = gson
				.fromJson(serializedJson, DocumentAnnotationsBean.class);

		boolean same = documentAnnotationsBeanDeserialized
				.equals(documentAnnotationsBean);
		System.out.println(same);
		return same ? documentAnnotationsBean : null;
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		String json = MmClient.readInputFile(new File(
				"../com.bignlp/testdata/api/annotations/sample1.js"));
		DocumentAnnotationsBean documentAnnotationsBean = create(json);
	}
}
