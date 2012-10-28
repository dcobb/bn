var jsonFromServer = {
	"document" : {
		"documentId" : "1234",
		"contentType" : "application/ms-word",
		"fileName" : "MedicalTranscription-Encounter-Cardialogy-2012-10-25.docx",
		"dateCreated" : "2012-10-28",
		"dateAnnotated" : "2012-10-29"
	},
	"input" : {
		"contentId" : "4567",
		"contentType" : "text/type",
		"charSet" : "UTF-8",
		"content" : "DATE OF CONSULTATION:  MM/DD/YYYY\nREFERRING PHYSICIAN:  John Doe, MD\nCONSULTING PHYSICIAN:  Jane Doe, MD\nREASON FOR CONSULTATION:  Surgical evaluation for coronary artery disease. \n\nHISTORY OF PRESENT ILLNESS:  The patient is a (XX)-year-old female who has a known history of coronary artery disease.  She underwent previous PTCA and stenting procedures in December and most recently in August.  Since that time, she has been relatively stable with medical management.  However, in the past several weeks, she started to notice some exertional dyspnea with chest pain.  For the most part, the pain subsides with rest.  For this reason, she was re-evaluated with a cardiac catheterization.  This demonstrated 3-vessel coronary artery disease with a 70% lesion to the right coronary artery; this was a proximal lesion.  The left main had a 70% stenosis.  The circumflex also had a 99% stenosis.  Overall left ventricular function was mildly reduced with an ejection fraction of about 45%.  The left ventriculogram did note some apical hypokinesis.  In view of these findings, surgical consultation was requested and the patient was seen and evaluated by Dr. Doe.\n\nPAST MEDICAL HISTORY: \n\n1.  Coronary artery disease as described above with previous PTCA and stenting procedures. \n2.  Dyslipidemia.\n3.  Hypertension.\n4.  Status post breast lumpectomy for cancer with followup radiation therapy to the chest.\n\nALLERGIES:  None.\n\nMEDICATIONS:  Aspirin 81 mg daily, Plavix 75 mg daily, Altace 2.5 mg daily, metoprolol 50 mg b.i.d. and Lipitor 10 mg q.h.s.\n\nSOCIAL HISTORY:  She quit smoking approximately 8 months ago.  Prior to that time, she had about a 35- to 40-pack-year history.  She does not abuse alcohol.\n\nFAMILY MEDICAL HISTORY:  Mother died prematurely of breast cancer.  Her father died prematurely of gastric carcinoma. \n\nREVIEW OF SYSTEMS:  There is no history of any CVAs, TIAs or seizures.  No chronic headaches.  No asthma, TB, hemoptysis or productive cough.  There is no congenital heart abnormality or rheumatic fever history.  She has no palpitations.  She notes no nausea, vomiting, constipation, diarrhea, but immediately prior to admission, she did develop some diffuse abdominal discomfort.  She says that since then, this has resolved.  No diabetes or thyroid problem.  There is no depression or psychiatric problems.  There is no musculoskeletal disorders or history of gout. There are no hematologic problems or blood dyscrasias.  No bleeding tendencies.  Again, she had a history of breast cancer and underwent lumpectomy procedures for this with followup radiation therapy.  She has been followed in the past 10 years and mammography shows no evidence of any recurrent problems.  There is no recent fevers, malaise, changes in appetite or changes in weight.\n\nPHYSICAL EXAMINATION:  Her blood pressure is 120/70, pulse is 80.  She is in a sinus rhythm on the EKG monitor.  Respirations are 18 and unlabored. Temperature is 98.2 degrees Fahrenheit.  She weighs 160 pounds, she is 5 feet 4 inches.  In general, this was an elderly-appearing, pleasant female who currently is not in acute distress.  Skin color and turgor are good.  Pupils were equal and reactive to light.  Conjunctivae clear.  Throat is benign. Mucosa was moist and noncyanotic.  Neck veins not distended at 90 degrees.  Carotids had 2+ upstrokes bilaterally without bruits.  No lymphadenopathy was appreciated.  Chest had a normal AP diameter. The lungs were clear in the apices and bases, no wheezing or egophony appreciated.  The heart had a normal S1, S2.  No murmurs, clicks or gallops.  The abdomen was soft, nontender, nondistended.  Good bowel sounds present.  No hepatosplenomegaly was appreciated.  No pulsatile masses were felt.  No abdominal bruits were heard.  Her pulses are 2+ and equal bilaterally in the upper and lower extremities.  No clubbing is appreciated.  She is oriented x3.  Demonstrated a good amount of strength in the upper and lower extremities.  Face was symmetrical.  She had a normal gait.\n\nIMPRESSION:  This is a (XX)-year-old female with significant multivessel coronary artery disease.  The patient also has a left main lesion.  She has undergone several PTCA and stenting procedures within the last year to year and a half.  At this point, in order to reduce the risk of any possible ischemia in the future, surgical myocardial revascularization is recommended.\n\nPLAN:  We will plan to proceed with surgical myocardial revascularization.  The risks and benefits of this procedure were explained to the patient.  All questions pertaining to this procedure were answered."
	},
	"annotations" : [{
		"startPosition" : 158,
		"endPosition" : 181,
		"phrase" : "coronary artery disease",
		"tags" : ["Disease"],
		"details" : {
			"phraseParts" : [{
				"startPosition" : 158,
				"endPosition" : 165,
				"phrase" : "coronary",
				"tags" : ["Organ Component"],
				"summary" : "Here goes the test explaining what coronary is"
			}, {
				"startPosition" : 167,
				"endPosition" : 173,
				"phrase" : "artery",
				"tags" : ["Organ Component"],
				"summary" : "Here goes the test explaining what artery is"
			}, {
				"startPosition" : 175,
				"endPosition" : 181,
				"phrase" : "disease",
				"tags" : ["Qualitative"],
				"summary" : "Here goes the test explaining what the disease is"
			}],
			"ontologyReferences" : [{
				"ontology" : "UMLS",
				"version" : "2012",
				"code" : "CONCEPT.CO.DE.FOR.CORONARY_ARTERY_DISEASE_FROM_UMLS"
			}, {
				"ontology" : "Medline",
				"version" : "2011",
				"code" : "CONCEPT.CO.DE.FOR.CORONARY_ARTERY_DISEASE_FROM_MEDLINE"
			}, {
				"ontology" : "MeSH",
				"version" : "2012",
				"code" : "CONCEPT.CO.DE.FOR.CORONARY_ARTERY_DISEASE_FROM_MESH"
			}, {
				"ontology" : "SNOMED",
				"version" : "2012",
				"code" : "CONCEPT.CO.DE.FOR.CORONARY_ARTERY_DISEASE_FROM_SNOMED"
			}],
			"webReferences" : [{
				"source" : "Wikipedia",
				"url" : "http://en.wikipedia.org/Coronary_Artery_Disease",
				"summary" : "Here goes the summary of coronary artery disease from wikipeida pages",
			}, {
				"source" : "WebMD",
				"url" : "http://www.webmd.com/Coronary_Artery_Disease",
				"summary" : "Here goes the summary of coronary artery disease from WebMD pages",
			}]
		}
	}, {
		// second annotation goes here
	}, {
		// third annotation goes here
	}]
}