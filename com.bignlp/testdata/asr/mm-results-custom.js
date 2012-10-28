var mmResults = [{
	"inputText" : "DATE OF CONSULTATION:  MM/DD/YYYY",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "DATE OF CONSULTATION:  MM/DD/YYYY",
		"position" : {
			"x" : 0,
			"y" : 33
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "REFERRING PHYSICIAN:  John Doe, MD",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "REFERRING PHYSICIAN:  John Doe, MD",
		"position" : {
			"x" : 0,
			"y" : 34
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "REASON FOR CONSULTATION:  Evaluation and diabetes management.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "REASON FOR CONSULTATION:  Evaluation and diabetes management.",
		"position" : {
			"x" : 0,
			"y" : 61
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "HISTORY OF PRESENT ILLNESS:  The patient is a (XX)-year-old man with a history of coronary artery disease, aortic stenosis and CABG, who was admitted with increasing shortness of breath and diagnosed with CHF. The patient has had diabetes for (X) years and was originally on oral medications, but for a number of years now, he has been on insulin. His current regimen is 70/30 insulin, 30 units twice a day. He uses insulin vial and sometimes does not take his medications. Denies significant hypoglycemia and checks his blood sugar three times a day with most readings between 100 and 300. He sees an ophthalmologist for eye care and apparently has had laser therapy for retinopathy. Has renal insufficiency and elevated BUN and creatinine and currently undergoing evaluation by Dr. Doe. Has a history of peripheral neuropathy with amputation of his fifth right digit and skin grafting. He does not know what his most recent A1c is and consultation was requested for diabetes management.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 474,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0020615",
			"preferredName" : "HYPOGLYCAEMIA"
		}],
		"conceptPositions" : [{
			"x" : 493,
			"y" : 12
		}]
	}, {
		"type" : "nega",
		"trigger" : "not",
		"triggerPositions" : [{
			"x" : 896,
			"y" : 3
		}],
		"conceptPairs" : [{
			"conceptId" : "C0011849",
			"preferredName" : "Diabetes"
		}, {
			"conceptId" : "C0011847",
			"preferredName" : "Diabetes"
		}],
		"conceptPositions" : [{
			"x" : 968,
			"y" : 8
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "HISTORY OF PRESENT ILLNESS:  The patient is a (XX)-year-old man with a history of coronary artery disease, aortic stenosis and CABG, who was admitted with increasing shortness of breath and diagnosed with CHF. ",
		"position" : {
			"x" : 0,
			"y" : 210
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "The patient has had diabetes for (X) years and was originally on oral medications, but for a number of years now, he has been on insulin. ",
		"position" : {
			"x" : 210,
			"y" : 138
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "His current regimen is 70/30 insulin, 30 units twice a day. ",
		"position" : {
			"x" : 348,
			"y" : 60
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "He uses insulin vial and sometimes does not take his medications. ",
		"position" : {
			"x" : 408,
			"y" : 66
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "Denies significant hypoglycemia and checks his blood sugar three times a day with most readings between 100 and 300. ",
		"position" : {
			"x" : 474,
			"y" : 117
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.6",
		"text" : "He sees an ophthalmologist for eye care and apparently has had laser therapy for retinopathy. ",
		"position" : {
			"x" : 591,
			"y" : 94
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.7",
		"text" : "Has renal insufficiency and elevated BUN and creatinine and currently undergoing evaluation by Dr. ",
		"position" : {
			"x" : 685,
			"y" : 99
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.8",
		"text" : "Doe. ",
		"position" : {
			"x" : 784,
			"y" : 5
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.9",
		"text" : "Has a history of peripheral neuropathy with amputation of his fifth right digit and skin grafting. ",
		"position" : {
			"x" : 789,
			"y" : 99
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.10",
		"text" : "He does not know what his most recent A1c is and consultation was requested for diabetes management.",
		"position" : {
			"x" : 888,
			"y" : 100
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "CURRENT MEDICATIONS:  Amiodarone, aspirin 325 daily, Zithromax, Plavix, guaifenesin, codeine, Lexapro 10 mg daily, Combivent 2 puffs q.i.d. p.r.n., Advair 1 puff b.i.d., Lasix 80 mg b.i.d., insulin 70/30 b.i.d., metoprolol 50 mg b.i.d.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "CURRENT MEDICATIONS:  Amiodarone, aspirin 325 daily, Zithromax, Plavix, guaifenesin, codeine, Lexapro 10 mg daily, Combivent 2 puffs q.i.d. p.r.n., Advair 1 puff b.i.d., Lasix 80 mg b.i.d., insulin 70/30 b.i.d., metoprolol 50 mg b.i.d.",
		"position" : {
			"x" : 0,
			"y" : 235
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "ALLERGIES:  NO KNOWN ALLERGIES.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 12,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0262580",
			"preferredName" : "No known allergies"
		}],
		"conceptPositions" : [{
			"x" : 12,
			"y" : 18
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "ALLERGIES:  NO KNOWN ALLERGIES.",
		"position" : {
			"x" : 0,
			"y" : 31
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PAST SURGICAL HISTORY:  CABG (X) years ago and amputation of his fifth right toe with skin grafting.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PAST SURGICAL HISTORY:  CABG (X) years ago and amputation of his fifth right toe with skin grafting.",
		"position" : {
			"x" : 0,
			"y" : 100
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "SOCIAL HISTORY:  The patient is a former smoker. Does not drink alcohol.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "SOCIAL HISTORY:  The patient is a former smoker. ",
		"position" : {
			"x" : 0,
			"y" : 49
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Does not drink alcohol.",
		"position" : {
			"x" : 49,
			"y" : 23
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "FAMILY HISTORY:  Negative for diabetes.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 17,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0011849",
			"preferredName" : "Diabetes"
		}, {
			"conceptId" : "C0011847",
			"preferredName" : "Diabetes"
		}],
		"conceptPositions" : [{
			"x" : 30,
			"y" : 8
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "FAMILY HISTORY:  Negative for diabetes.",
		"position" : {
			"x" : 0,
			"y" : 39
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "REVIEW OF SYSTEMS:  CONSTITUTIONAL:  He states he has gained a lot of weight recently perhaps due to fluid retention.  HEENT:  Follows with Ophthalmology.  CARDIOVASCULAR:  History of CABG and also aortic stenosis.  RESPIRATORY:  Some dyspnea.  GASTROINTESTINAL:  Denies constipation, diarrhea or liver disease.  GENITOURINARY:  No history of kidney stones or infection.  MUSCULOSKELETAL:  Denies fractures or joint pains.  Review of systems otherwise unremarkable.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 264,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963087",
			"preferredName" : "Constipation"
		}, {
			"conceptId" : "C0009806",
			"preferredName" : "Constipation"
		}],
		"conceptPositions" : [{
			"x" : 271,
			"y" : 12
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 264,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963091",
			"preferredName" : "Diarrhea"
		}, {
			"conceptId" : "C0011991",
			"preferredName" : "DIARRHOEA"
		}],
		"conceptPositions" : [{
			"x" : 285,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 264,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0023895",
			"preferredName" : "LIVER DISEASE"
		}],
		"conceptPositions" : [{
			"x" : 297,
			"y" : 13
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 329,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C2004062",
			"preferredName" : "History"
		}, {
			"conceptId" : "C0262926",
			"preferredName" : "History"
		}],
		"conceptPositions" : [{
			"x" : 332,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 329,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0021311",
			"preferredName" : "Infection"
		}],
		"conceptPositions" : [{
			"x" : 360,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 329,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0022650",
			"preferredName" : "Kidney Stones"
		}, {
			"conceptId" : "C1833683",
			"preferredName" : "KIDNEY STONES"
		}],
		"conceptPositions" : [{
			"x" : 343,
			"y" : 13
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 390,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0016658",
			"preferredName" : "Fractures"
		}],
		"conceptPositions" : [{
			"x" : 397,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 390,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0003862",
			"preferredName" : "JOINT PAINS"
		}],
		"conceptPositions" : [{
			"x" : 410,
			"y" : 11
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "REVIEW OF SYSTEMS:  CONSTITUTIONAL:  He states he has gained a lot of weight recently perhaps due to fluid retention.  ",
		"position" : {
			"x" : 0,
			"y" : 119
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "HEENT:  Follows with Ophthalmology.  ",
		"position" : {
			"x" : 119,
			"y" : 37
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "CARDIOVASCULAR:  History of CABG and also aortic stenosis.  ",
		"position" : {
			"x" : 156,
			"y" : 60
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "RESPIRATORY:  Some dyspnea.  ",
		"position" : {
			"x" : 216,
			"y" : 29
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "GASTROINTESTINAL:  Denies constipation, diarrhea or liver disease.  ",
		"position" : {
			"x" : 245,
			"y" : 68
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.6",
		"text" : "GENITOURINARY:  No history of kidney stones or infection.  ",
		"position" : {
			"x" : 313,
			"y" : 59
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.7",
		"text" : "MUSCULOSKELETAL:  Denies fractures or joint pains.  ",
		"position" : {
			"x" : 372,
			"y" : 52
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.8",
		"text" : "Review of systems otherwise unremarkable.",
		"position" : {
			"x" : 424,
			"y" : 41
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PHYSICAL EXAMINATION:\nGENERAL:  The patient is a pleasant, cooperative man.\nVITAL SIGNS:  Blood pressure 102/46, temperature 98.5, pulse 62 and regular, respirations 20.\nHEENT:  Head is normocephalic. External ears unremarkable. Conjunctivae clear. Pupils equal and reactive to light. Dentition is poor but there are no intraoral lesions.\nNECK:  Supple with no thyroid masses.\nCHEST:  Symmetrical. Healed midline surgical scar.\nLUNGS:  Clear to percussion, but diffuse bronchospasm bilaterally with prolonged expiration.\nHEART:  Heart sounds distant, but appears in regular sinus rhythm, difficult to appreciate murmurs.\nABDOMEN:  Healed surgical scars. No masses or tenderness appreciated.\nGENITAL/RECTAL:  Deferred.\nEXTREMITIES:  No clubbing, cyanosis or edema. He has deformity in his right foot from amputation of his fifth toe and fifth metatarsal and skin grafting of this area. No edema at this time.\nSKIN:  Clear without lesions.\nLYMPHS:  There is no cervical or axillary lymphadenopathy.\nNEUROLOGIC:  Cranial nerves II through XII are grossly intact. Proprioception and light touch normal.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 317,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0221198",
			"preferredName" : "lesions"
		}],
		"conceptPositions" : [{
			"x" : 330,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "with no",
		"triggerPositions" : [{
			"x" : 353,
			"y" : 7
		}],
		"conceptPairs" : [{
			"conceptId" : "C0349453",
			"preferredName" : "Thyroid mass"
		}],
		"conceptPositions" : [{
			"x" : 361,
			"y" : 14
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 654,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0577559",
			"preferredName" : "Mass"
		}],
		"conceptPositions" : [{
			"x" : 657,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 654,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0684239",
			"preferredName" : "tenderness"
		}, {
			"conceptId" : "C0234233",
			"preferredName" : "Tenderness"
		}],
		"conceptPositions" : [{
			"x" : 667,
			"y" : 10
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 732,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0149651",
			"preferredName" : "Clubbing"
		}, {
			"conceptId" : "C0009080",
			"preferredName" : "Clubbing"
		}],
		"conceptPositions" : [{
			"x" : 735,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 732,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0010520",
			"preferredName" : "Cyanosis"
		}],
		"conceptPositions" : [{
			"x" : 745,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 732,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0013604",
			"preferredName" : "Edema"
		}],
		"conceptPositions" : [{
			"x" : 757,
			"y" : 5
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 885,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0013604",
			"preferredName" : "Edema"
		}],
		"conceptPositions" : [{
			"x" : 888,
			"y" : 5
		}]
	}, {
		"type" : "nega",
		"trigger" : "without",
		"triggerPositions" : [{
			"x" : 921,
			"y" : 7
		}],
		"conceptPairs" : [{
			"conceptId" : "C0221198",
			"preferredName" : "lesions"
		}],
		"conceptPositions" : [{
			"x" : 929,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 956,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0578735",
			"preferredName" : "Axillary lymphadenopathy"
		}],
		"conceptPositions" : [{
			"x" : 971,
			"y" : 24
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PHYSICAL EXAMINATION: GENERAL:  The patient is a pleasant, cooperative man. ",
		"position" : {
			"x" : 0,
			"y" : 76
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "VITAL SIGNS:  Blood pressure 102/46, temperature 98.5, pulse 62 and regular, respirations 20. ",
		"position" : {
			"x" : 76,
			"y" : 94
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "HEENT:  Head is normocephalic. ",
		"position" : {
			"x" : 170,
			"y" : 31
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "External ears unremarkable. ",
		"position" : {
			"x" : 201,
			"y" : 28
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "Conjunctivae clear. ",
		"position" : {
			"x" : 229,
			"y" : 20
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.6",
		"text" : "Pupils equal and reactive to light. ",
		"position" : {
			"x" : 249,
			"y" : 36
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.7",
		"text" : "Dentition is poor but there are no intraoral lesions. ",
		"position" : {
			"x" : 285,
			"y" : 54
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.8",
		"text" : "NECK:  Supple with no thyroid masses. ",
		"position" : {
			"x" : 339,
			"y" : 38
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.9",
		"text" : "CHEST:  Symmetrical. ",
		"position" : {
			"x" : 377,
			"y" : 21
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.10",
		"text" : "Healed midline surgical scar. ",
		"position" : {
			"x" : 398,
			"y" : 30
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.11",
		"text" : "LUNGS:  Clear to percussion, but diffuse bronchospasm bilaterally with prolonged expiration. ",
		"position" : {
			"x" : 428,
			"y" : 93
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.12",
		"text" : "HEART:  Heart sounds distant, but appears in regular sinus rhythm, difficult to appreciate murmurs. ",
		"position" : {
			"x" : 521,
			"y" : 100
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.13",
		"text" : "ABDOMEN:  Healed surgical scars. ",
		"position" : {
			"x" : 621,
			"y" : 33
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.14",
		"text" : "No masses or tenderness appreciated. ",
		"position" : {
			"x" : 654,
			"y" : 37
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.15",
		"text" : "GENITAL/RECTAL:  Deferred. ",
		"position" : {
			"x" : 691,
			"y" : 27
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.16",
		"text" : "EXTREMITIES:  No clubbing, cyanosis or edema. ",
		"position" : {
			"x" : 718,
			"y" : 46
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.17",
		"text" : "He has deformity in his right foot from amputation of his fifth toe and fifth metatarsal and skin grafting of this area. ",
		"position" : {
			"x" : 764,
			"y" : 121
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.18",
		"text" : "No edema at this time. ",
		"position" : {
			"x" : 885,
			"y" : 23
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.19",
		"text" : "SKIN:  Clear without lesions. ",
		"position" : {
			"x" : 908,
			"y" : 30
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.20",
		"text" : "LYMPHS:  There is no cervical or axillary lymphadenopathy. ",
		"position" : {
			"x" : 938,
			"y" : 59
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.21",
		"text" : "NEUROLOGIC:  Cranial nerves II through XII are grossly intact. ",
		"position" : {
			"x" : 997,
			"y" : 63
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.22",
		"text" : "Proprioception and light touch normal.",
		"position" : {
			"x" : 1060,
			"y" : 38
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "LABORATORY DATA:  WBC 15,500, hemoglobin 10.8, hematocrit 31.4. Had absolute increase in neutrophils. Creatinine 2.4, BUN 50. CK 664, CK-MB 6.2, troponin I 0.64. Cholesterol 196, triglycerides 114, HDL 40, LDL 136. No chest x-ray is available, recent A1c or BNP.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "LABORATORY DATA:  WBC 15,500, hemoglobin 10.8, hematocrit 31.4. ",
		"position" : {
			"x" : 0,
			"y" : 64
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Had absolute increase in neutrophils. ",
		"position" : {
			"x" : 64,
			"y" : 38
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "Creatinine 2.4, BUN 50. ",
		"position" : {
			"x" : 102,
			"y" : 24
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "CK 664, CK-MB 6.2, troponin I 0.64. ",
		"position" : {
			"x" : 126,
			"y" : 36
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "Cholesterol 196, triglycerides 114, HDL 40, LDL 136. ",
		"position" : {
			"x" : 162,
			"y" : 53
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.6",
		"text" : "No chest x-ray is available, recent A1c or BNP.",
		"position" : {
			"x" : 215,
			"y" : 47
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "ASSESSMENT: \n1.  Diabetes mellitus type 2. Fair control on 70/30 insulin, 30 units b.i.d. but no recent A1c test. Diabetic complications with peripheral retinopathy with laser therapy, renal insufficiency and peripheral neuropathy status post amputation of fifth right toe and skin grafting.\n2.  Dyspnea. Possible pneumonia and/or congestive heart failure, but no chest x-ray or BNP available.\n3.  Coronary artery disease, status post coronary artery bypass grafting.\n4.  Hypertension.\n5.  Dyslipidemia.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "ASSESSMENT:  1.  ",
		"position" : {
			"x" : 0,
			"y" : 17
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Diabetes mellitus type 2. ",
		"position" : {
			"x" : 17,
			"y" : 26
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "Fair control on 70/30 insulin, 30 units b.i.d. but no recent A1c test. ",
		"position" : {
			"x" : 43,
			"y" : 71
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "Diabetic complications with peripheral retinopathy with laser therapy, renal insufficiency and peripheral neuropathy status post amputation of fifth right toe and skin grafting. ",
		"position" : {
			"x" : 114,
			"y" : 178
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "2.  ",
		"position" : {
			"x" : 292,
			"y" : 4
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.6",
		"text" : "Dyspnea. ",
		"position" : {
			"x" : 296,
			"y" : 9
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.7",
		"text" : "Possible pneumonia and/or congestive heart failure, but no chest x-ray or BNP available. ",
		"position" : {
			"x" : 305,
			"y" : 89
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.8",
		"text" : "3.  ",
		"position" : {
			"x" : 394,
			"y" : 4
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.9",
		"text" : "Coronary artery disease, status post coronary artery bypass grafting. ",
		"position" : {
			"x" : 398,
			"y" : 70
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.10",
		"text" : "4.  ",
		"position" : {
			"x" : 468,
			"y" : 4
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.11",
		"text" : "Hypertension. ",
		"position" : {
			"x" : 472,
			"y" : 14
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.12",
		"text" : "5.  ",
		"position" : {
			"x" : 486,
			"y" : 4
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.13",
		"text" : "Dyslipidemia.",
		"position" : {
			"x" : 490,
			"y" : 13
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PLAN:\n1.  We will continue 70/30 insulin 30 units b.i.d.\n2.  Check hemoglobin A1c.\n3.  We will adjust medications as appropriate.\n",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PLAN: 1.  ",
		"position" : {
			"x" : 0,
			"y" : 10
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "We will continue 70/30 insulin 30 units b.i.d. ",
		"position" : {
			"x" : 10,
			"y" : 47
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "2.  ",
		"position" : {
			"x" : 57,
			"y" : 4
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "Check hemoglobin A1c. ",
		"position" : {
			"x" : 61,
			"y" : 22
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "3.  ",
		"position" : {
			"x" : 83,
			"y" : 4
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.6",
		"text" : "We will adjust medications as appropriate.",
		"position" : {
			"x" : 87,
			"y" : 42
		},
		"phraseConceptMappings" : []
	}]
}]