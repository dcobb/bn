function getAnnotationArray(json) {
	var annotationArr = [];
	var uttaranceArray = json["MMOs"]["MMO"]["Utterances"]["Utterance"];
	for(var i=0, l=uttaranceArray.length; i<l; i++) {
		var phraseArray = uttaranceArray[i]["Phrases"]["Phrase"];
		for(var j=0, k=phraseArray.length; j<k;j++) {
			var candidates = phraseArray[j]["Candidates"]
			if(!candidates || !candidates["Candidate"]) {
				continue;
			}
			var candidate = candidates["Candidate"].length ?  candidates["Candidate"][0]:  candidates["Candidate"];
			var symType = candidate["SemTypes"].SemType;
			
			var conceptPIs = candidate["ConceptPIs"]["ConceptPI"];
			var conceptPI = conceptPIs.length ? conceptPIs[0] : conceptPIs; 
			var startPos = parseInt(conceptPI["StartPos"]);
			var endPos = startPos + parseInt(conceptPI["Length"]);
			var annotation = {
				"startPosition" : startPos,
				"endPosition" : endPos,
				"phrase" : candidate.CandidateMatched,
				"tags" : [SemanticsMap[symType]]
			};
			annotationArr.push(annotation);
		}
	}
	return annotationArr;
}

function updateInUI(json) {
	var latestData = {
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
			"content" : "PATIENT NAME:  jayanthchowdary\nMRNO: xxxxxxxxxx \nDATE OF BIRTH: XXX \nDATE OF VISIT: XXX \nREFERRING PHYSICIAN:  Dr. Suresh Prasad.\nCHIEF COMPLAINT:  Colon cancer screening.\nHISTORY OF PRESENT ILLNESS:  The patient is a 75-year-old female who is being evaluated for routine colon cancer screening.  The patient denies any abdominal pain.  No history of any bleeding.  No history of any change in bowel habits and no history of any weight loss.  No history of prior colonoscopy.\nPAST MEDICAL HISTORY:  \n1.	Coronary artery disease.\nSOCIAL HISTORY:  The patient denies any alcohol or smoking.\nFAMILY HISTORY:  Negative for any GI malignancies.	\nCURRENT MEDICATIONS:  Include:  \n1.	Darvocet.\n2.	Lotrel.\n3.	Plavix.\n4.	Naprosyn.\n5.	Metoprolol.\n6.	Fosamax.\nMEDICATION ALLERGIES: \n1.	The patient is allergic to PENICILLIN.\nREVIEW OF SYSTEMS:  \nGENERAL:  Denies any unusual weakness, fatigue, or fever.\nSKIN:  Positive for occasional itching.  No rashes or skin lesions.\nHEENT:  Positive for decreased hearing.  Head:  Negative for history of head injury, headache, or dizziness.\nEYES:  No recent change in vision.  Denies blurring of vision or diplopia.\nEARS:  Negative for tinnitus, vertigo, or earaches.\nNOSE:  Negative for hay fever, nasal discharge, and nasal stuffiness.\nTHROAT:  Negative for sore throat or hoarseness.\nNECK:  No swollen glands, lumps, pain, or stiffness.\nRESPIRATORY:  Negative for cough, sputum production, hemoptysis, or shortness of breath.\nCARDIOVASCULAR:  No dyspnea, orthopnea, chest pain, or palpitations.\nGASTROINTESTINAL:  Appetite is good.  Negative for dysphagia, odynophagia, nausea, vomiting, indigestion, diarrhea, or constipation.  No abdominal pain.  Bowel movements are regular.  No hematochezia or melena. \nGENITOURINARY:  No frequency, dysuria, hematuria, or urinary incontinence. \nPERIPHERAL VASCULAR:  No history of phlebitis or leg pain.  Negative for intermittent claudication.\nMUSCULOSKELETAL:  Denies arthralgia, injury, or swelling.  Denies any muscle stiffness, arthritis, gout, backache, or limitation of motion or activity.\nNEUROLOGICAL:  No fainting, seizures, motor, or sensory loss.  Long-term and short-term memory is intact.  Denies frequent headaches, weakness of the extremities, or slurring of the speech.\nPSYCHIATRIC:  No history of depression or treatment for psychiatric disorders. \nPHYSICAL EXAMINATION:  \nVital signs:  Blood pressure:  118/73 mmHg.  Pulse:  96.  Temperature:  97.1.\nGeneral:  The patient is in no acute distress.  Alert, awake, and comfortable.\nHEENT:  Head:  Normocephalic and atraumatic.  Hair of average textures.  Scalp without lesions.\nSkin:  No infections, jaundice, rash, or petechiae.\nEyes:  Conjunctiva moist and pink.  PERRLA.\nEars:  Auditory, acuity good to whispered voice.\nNose:  Mucosa is pink.  No sinus tenderness.  No nasal discharge.\nMouth:  Oral mucosa is moist and pink.  No gingivitis.\nNeck:  Supple.  Trachea is midline.  No thyromegaly.  No lymphadenopathy.  Carotid, no bruits.\nHeart:  S1 and S2 regular.  No S3 or S4.  No murmurs.  No jugular vein distention.\nThorax:  Symmetric with good excursion.\nLungs:  Clear.  No rales, wheezing, or rhonchi.\nAbdomen:  Soft, nontender, and non-distended.  No masses.  No costovertebral angle tenderness.  Bowel sounds are active.\nPeripheral vascular:  Negative for ankle edema.  No stasis, pigmentation, or ulcers.  Radial pulses are 2+.  Dorsalis pedis 2+.\nMusculoskeletal:  No joint deformities.  Good range of motion.\nASSESSMENT:  \n1.	Colon cancer screening.\nPLAN:  \n1.	The patient was advised and instructed regarding the risks and benefits of colonoscopy.  The patient agreed and consented for the procedure.\n2.	She was advised to stop Plavix four to five days, if okay with her cardiologist.\n3.	Further recommendations will be made based on the colonoscopic findings.\nThank you Dr. Prasad for allowing us to participate in the care of this patient.\n____________________\nSyam Vemulapalli, M.D.\nRje/hma\ncc:	Dr. Suresh Prasad\n\n"
		},
		"annotations" : getAnnotationArray(json)
	};
	updateUI(latestData, document.getElementById("leftpanel"), document.getElementById("rightpanel"));
}

updateInUI(json);

/*
$.get('intersemanticsample1.xml', function(xml){
	var json = $.xml2json(xml);
	updateInUI(json);
});
*/