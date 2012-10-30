[{
	"inputText" : "Permian Gastroenterology Associates LLP",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Permian Gastroenterology Associates LLP",
		"position" : {
			"x" : 0,
			"y" : 39
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "315 E 5th Street, Odessa, TX 79761",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "315 E 5th Street, Odessa, TX 79761",
		"position" : {
			"x" : 0,
			"y" : 34
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Ravikumar P. Vemuru, M.D.\nSyam Vemulapalli, M.D.\n\t                                       Board certified in Gastroenterology and Internal medicine. ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Ravikumar P. ",
		"position" : {
			"x" : 0,
			"y" : 13
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Vemuru, M.D. ",
		"position" : {
			"x" : 13,
			"y" : 13
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "Syam Vemulapalli, M.D.                                         ",
		"position" : {
			"x" : 26,
			"y" : 63
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "Board certified in Gastroenterology and Internal medicine.",
		"position" : {
			"x" : 89,
			"y" : 58
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PATIENT NAME:  XXXXXX\t\t\t\t\t\t        MRNO:  ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PATIENT NAME:  XXXXXX              MRNO:",
		"position" : {
			"x" : 0,
			"y" : 40
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "DATE OF BIRTH:  XXXXXX\nDATE OF VISIT:  XXXXXX",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "DATE OF BIRTH:  XXXXXX DATE OF VISIT:  XXXXXX",
		"position" : {
			"x" : 0,
			"y" : 45
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "REFERRING PHYSICIAN:  Dr. Dar.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "REFERRING PHYSICIAN:  Dr. ",
		"position" : {
			"x" : 0,
			"y" : 26
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Dar.",
		"position" : {
			"x" : 26,
			"y" : 4
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "CHIEF COMPLAINT:  Gastroesophageal reflux disease.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "CHIEF COMPLAINT:  Gastroesophageal reflux disease.",
		"position" : {
			"x" : 0,
			"y" : 50
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "HISTORY OF PRESENT ILLNESS:  The patient is a 56-year-old male who complains of chronic acid reflux and increased belching for almost three months.  He has been taking Protonix without any relief of symptoms.  His symptoms are increased with food.  He also complains of occasional solid food dysphagia.  No history of any nausea or vomiting.  No history of any abdominal pain.  No history of any bleeding.  No history of any weight loss.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "without",
		"triggerPositions" : [{
			"x" : 177,
			"y" : 7
		}],
		"conceptPairs" : [{
			"conceptId" : "C0564405",
			"preferredName" : "Relief"
		}],
		"conceptPositions" : [{
			"x" : 189,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "without",
		"triggerPositions" : [{
			"x" : 177,
			"y" : 7
		}],
		"conceptPairs" : [{
			"conceptId" : "C1457887",
			"preferredName" : "Symptoms"
		}],
		"conceptPositions" : [{
			"x" : 199,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 304,
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
			"x" : 307,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 304,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963179",
			"preferredName" : "Nausea"
		}, {
			"conceptId" : "C0027497",
			"preferredName" : "Nausea"
		}],
		"conceptPositions" : [{
			"x" : 322,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 304,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963281",
			"preferredName" : "Vomiting"
		}, {
			"conceptId" : "C0042963",
			"preferredName" : "Vomiting"
		}],
		"conceptPositions" : [{
			"x" : 332,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 343,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0000737",
			"preferredName" : "Abdominal Pain"
		}],
		"conceptPositions" : [{
			"x" : 361,
			"y" : 14
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 343,
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
			"x" : 346,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 378,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0019080",
			"preferredName" : "Bleeding"
		}],
		"conceptPositions" : [{
			"x" : 396,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 378,
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
			"x" : 381,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 407,
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
			"x" : 410,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 407,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C2911645",
			"preferredName" : "Weight loss"
		}, {
			"conceptId" : "C0043096",
			"preferredName" : "WEIGHTLOSS"
		}],
		"conceptPositions" : [{
			"x" : 425,
			"y" : 11
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "HISTORY OF PRESENT ILLNESS:  The patient is a 56-year-old male who complains of chronic acid reflux and increased belching for almost three months.  ",
		"position" : {
			"x" : 0,
			"y" : 149
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "He has been taking Protonix without any relief of symptoms.  ",
		"position" : {
			"x" : 149,
			"y" : 61
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "His symptoms are increased with food.  ",
		"position" : {
			"x" : 210,
			"y" : 39
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "He also complains of occasional solid food dysphagia.  ",
		"position" : {
			"x" : 249,
			"y" : 55
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "No history of any nausea or vomiting.  ",
		"position" : {
			"x" : 304,
			"y" : 39
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.6",
		"text" : "No history of any abdominal pain.  ",
		"position" : {
			"x" : 343,
			"y" : 35
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.7",
		"text" : "No history of any bleeding.  ",
		"position" : {
			"x" : 378,
			"y" : 29
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.8",
		"text" : "No history of any weight loss.",
		"position" : {
			"x" : 407,
			"y" : 30
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PAST MEDICAL HISTORY:  ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PAST MEDICAL HISTORY:",
		"position" : {
			"x" : 0,
			"y" : 21
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "History of CVA.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "History of CVA.",
		"position" : {
			"x" : 0,
			"y" : 15
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Chronic gastroesophageal reflux disease.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Chronic gastroesophageal reflux disease.",
		"position" : {
			"x" : 0,
			"y" : 40
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "SOCIAL HISTORY:  The patient denies any alcohol or smoking.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "SOCIAL HISTORY:  The patient denies any alcohol or smoking.",
		"position" : {
			"x" : 0,
			"y" : 59
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "FAMILY HISTORY:  Negative for any GI malignancies.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 17,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0006826",
			"preferredName" : "MALIGNANCIES"
		}],
		"conceptPositions" : [{
			"x" : 37,
			"y" : 12
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "FAMILY HISTORY:  Negative for any GI malignancies.",
		"position" : {
			"x" : 0,
			"y" : 50
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "CURRENT MEDICATIONS:  Include:  ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "CURRENT MEDICATIONS:  Include:",
		"position" : {
			"x" : 0,
			"y" : 30
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Plavix.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Plavix.",
		"position" : {
			"x" : 0,
			"y" : 7
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Lortab.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Lortab.",
		"position" : {
			"x" : 0,
			"y" : 7
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Protonix.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Protonix.",
		"position" : {
			"x" : 0,
			"y" : 9
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "MEDICATION ALLERGIES:  NKDA.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "MEDICATION ALLERGIES:  NKDA.",
		"position" : {
			"x" : 0,
			"y" : 28
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "REVIEW OF SYSTEMS:  ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "REVIEW OF SYSTEMS:",
		"position" : {
			"x" : 0,
			"y" : 18
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "GENERAL:  Denies any unusual weakness, fatigue, or fever.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 10,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0015672",
			"preferredName" : "Fatigue"
		}],
		"conceptPositions" : [{
			"x" : 39,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 10,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0015967",
			"preferredName" : "Fever"
		}],
		"conceptPositions" : [{
			"x" : 51,
			"y" : 5
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 10,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0086525",
			"preferredName" : "weakness"
		}, {
			"conceptId" : "C1883552",
			"preferredName" : "Weakness"
		}, {
			"conceptId" : "C0004093",
			"preferredName" : "Weakness"
		}],
		"conceptPositions" : [{
			"x" : 29,
			"y" : 8
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "GENERAL:  Denies any unusual weakness, fatigue, or fever.",
		"position" : {
			"x" : 0,
			"y" : 57
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "SKIN:  No rashes or skin lesions.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0015230",
			"preferredName" : "Rashes"
		}],
		"conceptPositions" : [{
			"x" : 10,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0037284",
			"preferredName" : "Skin lesion"
		}],
		"conceptPositions" : [{
			"x" : 20,
			"y" : 12
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "SKIN:  No rashes or skin lesions.",
		"position" : {
			"x" : 0,
			"y" : 33
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "HEENT:  Head:  Negative for history of head injury, headache, or dizziness.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 15,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0042571",
			"preferredName" : "dizziness"
		}, {
			"conceptId" : "C1963093",
			"preferredName" : "Dizziness"
		}, {
			"conceptId" : "C0012833",
			"preferredName" : "Dizziness"
		}],
		"conceptPositions" : [{
			"x" : 65,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 15,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0018681",
			"preferredName" : "HEAD ACHE"
		}],
		"conceptPositions" : [{
			"x" : 52,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 15,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C2004062",
			"preferredName" : "History"
		}, {
			"conceptId" : "C0262926",
			"preferredName" : "History"
		}],
		"conceptPositions" : [{
			"x" : 28,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 15,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0018674",
			"preferredName" : "Injury, Head"
		}],
		"conceptPositions" : [{
			"x" : 39,
			"y" : 11
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "HEENT:  Head:  Negative for history of head injury, headache, or dizziness.",
		"position" : {
			"x" : 0,
			"y" : 75
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "EYES:  No recent change in vision.  Denies blurring of vision or diplopia.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 36,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0344232",
			"preferredName" : "BLURRING"
		}],
		"conceptPositions" : [{
			"x" : 43,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 36,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0012569",
			"preferredName" : "Diplopia"
		}],
		"conceptPositions" : [{
			"x" : 65,
			"y" : 8
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "EYES:  No recent change in vision.  ",
		"position" : {
			"x" : 0,
			"y" : 36
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Denies blurring of vision or diplopia.",
		"position" : {
			"x" : 36,
			"y" : 38
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "EARS:  Negative for tinnitus, vertigo, or earaches.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0013456",
			"preferredName" : "Earaches"
		}],
		"conceptPositions" : [{
			"x" : 42,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963249",
			"preferredName" : "Tinnitus"
		}, {
			"conceptId" : "C0040264",
			"preferredName" : "Tinnitus"
		}],
		"conceptPositions" : [{
			"x" : 20,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0042571",
			"preferredName" : "Vertigo"
		}],
		"conceptPositions" : [{
			"x" : 30,
			"y" : 7
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "EARS:  Negative for tinnitus, vertigo, or earaches.",
		"position" : {
			"x" : 0,
			"y" : 51
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "NOSE:  Negative for hay fever, nasal discharge, and nasal stuffiness.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0018621",
			"preferredName" : "Hay fever"
		}],
		"conceptPositions" : [{
			"x" : 20,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0264273",
			"preferredName" : "Nasal discharge"
		}],
		"conceptPositions" : [{
			"x" : 31,
			"y" : 15
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0027424",
			"preferredName" : "Nasal stuffiness"
		}],
		"conceptPositions" : [{
			"x" : 52,
			"y" : 16
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "NOSE:  Negative for hay fever, nasal discharge, and nasal stuffiness.",
		"position" : {
			"x" : 0,
			"y" : 69
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "THROAT:  Negative for sore throat or hoarseness.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 9,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0019825",
			"preferredName" : "Hoarseness"
		}],
		"conceptPositions" : [{
			"x" : 37,
			"y" : 10
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 9,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0031350",
			"preferredName" : "sore throat"
		}, {
			"conceptId" : "C0242429",
			"preferredName" : "SORETHROAT"
		}],
		"conceptPositions" : [{
			"x" : 22,
			"y" : 11
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "THROAT:  Negative for sore throat or hoarseness.",
		"position" : {
			"x" : 0,
			"y" : 48
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "NECK:  No swollen glands, lumps, pain, or stiffness.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0427008",
			"preferredName" : "\u0027Stiffness\u0027"
		}],
		"conceptPositions" : [{
			"x" : 42,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C1962977",
			"preferredName" : "Pain NOS"
		}, {
			"conceptId" : "C0030193",
			"preferredName" : "Pain"
		}],
		"conceptPositions" : [{
			"x" : 33,
			"y" : 4
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0497156",
			"preferredName" : "swollen glands"
		}, {
			"conceptId" : "C1706304",
			"preferredName" : "SWOLLEN GLANDS"
		}],
		"conceptPositions" : [{
			"x" : 10,
			"y" : 14
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "NECK:  No swollen glands, lumps, pain, or stiffness.",
		"position" : {
			"x" : 0,
			"y" : 52
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "?\nXXXXXX\t\t\t\t\t\t\t\t\t\t   PAGE TWO",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "? XXXXXX             PAGE TWO",
		"position" : {
			"x" : 0,
			"y" : 29
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "XXXXXX",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "XXXXXX",
		"position" : {
			"x" : 0,
			"y" : 6
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "RESPIRATORY:  Negative for cough, sputum production, hemoptysis, or shortness of breath.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 14,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C1961131",
			"preferredName" : "Cough"
		}, {
			"conceptId" : "C0010200",
			"preferredName" : "Cough"
		}],
		"conceptPositions" : [{
			"x" : 27,
			"y" : 5
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 14,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0019079",
			"preferredName" : "HAEMOPTYSIS"
		}],
		"conceptPositions" : [{
			"x" : 53,
			"y" : 10
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "RESPIRATORY:  Negative for cough, sputum production, hemoptysis, or shortness of breath.",
		"position" : {
			"x" : 0,
			"y" : 88
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "CARDIOVASCULAR:  No dyspnea, orthopnea, chest pain, or palpitations.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 17,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0008031",
			"preferredName" : "Chest Pain"
		}],
		"conceptPositions" : [{
			"x" : 40,
			"y" : 10
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 17,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0013404",
			"preferredName" : "DYSPNOEA"
		}],
		"conceptPositions" : [{
			"x" : 20,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 17,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0085619",
			"preferredName" : "Orthopnea"
		}],
		"conceptPositions" : [{
			"x" : 29,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 17,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0030252",
			"preferredName" : "Palpitations"
		}],
		"conceptPositions" : [{
			"x" : 55,
			"y" : 12
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "CARDIOVASCULAR:  No dyspnea, orthopnea, chest pain, or palpitations.",
		"position" : {
			"x" : 0,
			"y" : 68
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "GASTROINTESTINAL:  Appetite is good.  Negative for dysphagia, odynophagia, nausea, vomiting, indigestion, diarrhea, or constipation.  No abdominal pain.  Bowel movements are regular.  No hematochezia or melena. ",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 38,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963087",
			"preferredName" : "Constipation"
		}, {
			"conceptId" : "C0009806",
			"preferredName" : "Constipation"
		}],
		"conceptPositions" : [{
			"x" : 119,
			"y" : 12
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 38,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963091",
			"preferredName" : "Diarrhea"
		}, {
			"conceptId" : "C0011991",
			"preferredName" : "DIARRHOEA"
		}],
		"conceptPositions" : [{
			"x" : 106,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 38,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0011168",
			"preferredName" : "Dysphagia"
		}],
		"conceptPositions" : [{
			"x" : 51,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 38,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0013395",
			"preferredName" : "Indigestion"
		}],
		"conceptPositions" : [{
			"x" : 93,
			"y" : 11
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 38,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963179",
			"preferredName" : "Nausea"
		}, {
			"conceptId" : "C0027497",
			"preferredName" : "Nausea"
		}],
		"conceptPositions" : [{
			"x" : 75,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 38,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0221150",
			"preferredName" : "Odynophagia"
		}],
		"conceptPositions" : [{
			"x" : 62,
			"y" : 11
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 38,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C1963281",
			"preferredName" : "Vomiting"
		}, {
			"conceptId" : "C0042963",
			"preferredName" : "Vomiting"
		}],
		"conceptPositions" : [{
			"x" : 83,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 134,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0000737",
			"preferredName" : "Abdominal Pain"
		}],
		"conceptPositions" : [{
			"x" : 137,
			"y" : 14
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 184,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0018932",
			"preferredName" : "Hematochezia"
		}],
		"conceptPositions" : [{
			"x" : 187,
			"y" : 12
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 184,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0025222",
			"preferredName" : "MELAENA"
		}],
		"conceptPositions" : [{
			"x" : 203,
			"y" : 6
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "GASTROINTESTINAL:  Appetite is good.  ",
		"position" : {
			"x" : 0,
			"y" : 38
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Negative for dysphagia, odynophagia, nausea, vomiting, indigestion, diarrhea, or constipation.  ",
		"position" : {
			"x" : 38,
			"y" : 96
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "No abdominal pain.  ",
		"position" : {
			"x" : 134,
			"y" : 20
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "Bowel movements are regular.  ",
		"position" : {
			"x" : 154,
			"y" : 30
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "No hematochezia or melena.",
		"position" : {
			"x" : 184,
			"y" : 26
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "GENITOURINARY:  No frequency, dysuria, hematuria, or urinary incontinence. ",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 16,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0013428",
			"preferredName" : "Dysuria"
		}],
		"conceptPositions" : [{
			"x" : 30,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 16,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0018965",
			"preferredName" : "HAEMATURIA"
		}],
		"conceptPositions" : [{
			"x" : 39,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 16,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0042024",
			"preferredName" : "Urinary Incontinence"
		}, {
			"conceptId" : "C1962973",
			"preferredName" : "Incontinence, urinary"
		}],
		"conceptPositions" : [{
			"x" : 53,
			"y" : 20
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "GENITOURINARY:  No frequency, dysuria, hematuria, or urinary incontinence.",
		"position" : {
			"x" : 0,
			"y" : 74
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PERIPHERAL VASCULAR:  No history of phlebitis or leg pain.  Negative for intermittent claudication.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 22,
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
			"x" : 25,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 22,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0023222",
			"preferredName" : "Leg pain, NOS"
		}],
		"conceptPositions" : [{
			"x" : 49,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 22,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0031542",
			"preferredName" : "Phlebitis"
		}],
		"conceptPositions" : [{
			"x" : 36,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 60,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0021775",
			"preferredName" : "Intermittent Claudication"
		}],
		"conceptPositions" : [{
			"x" : 73,
			"y" : 25
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PERIPHERAL VASCULAR:  No history of phlebitis or leg pain.  ",
		"position" : {
			"x" : 0,
			"y" : 60
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Negative for intermittent claudication.",
		"position" : {
			"x" : 60,
			"y" : 39
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "MUSCULOSKELETAL:  Denies arthralgia, injury, or swelling.  Denies any muscle stiffness, arthritis, gout, backache, or limitation of motion or activity.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 18,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0003862",
			"preferredName" : "Arthralgia"
		}],
		"conceptPositions" : [{
			"x" : 25,
			"y" : 10
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 18,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0175677",
			"preferredName" : "Injury"
		}],
		"conceptPositions" : [{
			"x" : 37,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 18,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0038999",
			"preferredName" : "Swelling"
		}, {
			"conceptId" : "C0013604",
			"preferredName" : "SWELLING"
		}],
		"conceptPositions" : [{
			"x" : 48,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 59,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0003864",
			"preferredName" : "Arthritis"
		}],
		"conceptPositions" : [{
			"x" : 88,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 59,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0004604",
			"preferredName" : "Backache"
		}],
		"conceptPositions" : [{
			"x" : 105,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 59,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0221170",
			"preferredName" : "Muscle stiffness"
		}],
		"conceptPositions" : [{
			"x" : 70,
			"y" : 16
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "MUSCULOSKELETAL:  Denies arthralgia, injury, or swelling.  ",
		"position" : {
			"x" : 0,
			"y" : 59
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Denies any muscle stiffness, arthritis, gout, backache, or limitation of motion or activity.",
		"position" : {
			"x" : 59,
			"y" : 92
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "NEUROLOGICAL:  Positive for paresthesias.  No fainting, seizures, motor, or sensory loss.  Long-term and short-term memory is intact.  Denies frequent headaches, weakness of the extremities, or slurring of the speech.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 43,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0039070",
			"preferredName" : "Fainting"
		}],
		"conceptPositions" : [{
			"x" : 46,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 43,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0036572",
			"preferredName" : "Seizures"
		}],
		"conceptPositions" : [{
			"x" : 56,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 43,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0278134",
			"preferredName" : "Sensory loss"
		}],
		"conceptPositions" : [{
			"x" : 76,
			"y" : 12
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 135,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0948396",
			"preferredName" : "Frequent headaches"
		}],
		"conceptPositions" : [{
			"x" : 142,
			"y" : 18
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 135,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0234518",
			"preferredName" : "Slurring"
		}],
		"conceptPositions" : [{
			"x" : 194,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "denies",
		"triggerPositions" : [{
			"x" : 135,
			"y" : 6
		}],
		"conceptPairs" : [{
			"conceptId" : "C0086525",
			"preferredName" : "weakness"
		}, {
			"conceptId" : "C1883552",
			"preferredName" : "Weakness"
		}, {
			"conceptId" : "C0004093",
			"preferredName" : "Weakness"
		}],
		"conceptPositions" : [{
			"x" : 162,
			"y" : 8
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "NEUROLOGICAL:  Positive for paresthesias.  ",
		"position" : {
			"x" : 0,
			"y" : 43
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "No fainting, seizures, motor, or sensory loss.  ",
		"position" : {
			"x" : 43,
			"y" : 48
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "Long-term and short-term memory is intact.  ",
		"position" : {
			"x" : 91,
			"y" : 44
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "Denies frequent headaches, weakness of the extremities, or slurring of the speech.",
		"position" : {
			"x" : 135,
			"y" : 82
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PSYCHIATRIC:  No history of depression or treatment for psychiatric disorders. ",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 14,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0344315",
			"preferredName" : "Depression"
		}, {
			"conceptId" : "C0011581",
			"preferredName" : "Depression"
		}, {
			"conceptId" : "C0011570",
			"preferredName" : "Depression"
		}],
		"conceptPositions" : [{
			"x" : 28,
			"y" : 10
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 14,
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
			"x" : 17,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 14,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0004936",
			"preferredName" : "PSYCHIATRIC DISORDERS"
		}],
		"conceptPositions" : [{
			"x" : 56,
			"y" : 21
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PSYCHIATRIC:  No history of depression or treatment for psychiatric disorders.",
		"position" : {
			"x" : 0,
			"y" : 78
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PHYSICAL EXAMINATION:  ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PHYSICAL EXAMINATION:",
		"position" : {
			"x" : 0,
			"y" : 21
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Vital signs:  Blood pressure:  118/73 mmHg.  Pulse:  53.  Temperature:  97.6.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Vital signs:  Blood pressure:  118/73 mmHg.  ",
		"position" : {
			"x" : 0,
			"y" : 45
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Pulse:  53.  ",
		"position" : {
			"x" : 45,
			"y" : 13
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "Temperature:  97.6.",
		"position" : {
			"x" : 58,
			"y" : 19
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "General:  The patient is in no acute distress.  Alert, awake, and comfortable.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 28,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0231303",
			"preferredName" : "Distress"
		}],
		"conceptPositions" : [{
			"x" : 37,
			"y" : 8
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "General:  The patient is in no acute distress.  ",
		"position" : {
			"x" : 0,
			"y" : 48
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Alert, awake, and comfortable.",
		"position" : {
			"x" : 48,
			"y" : 30
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "HEENT:  Head:  Normocephalic and atraumatic.  Hair of average textures.  Scalp without lesions.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "without",
		"triggerPositions" : [{
			"x" : 79,
			"y" : 7
		}],
		"conceptPairs" : [{
			"conceptId" : "C0221198",
			"preferredName" : "lesions"
		}],
		"conceptPositions" : [{
			"x" : 87,
			"y" : 7
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "HEENT:  Head:  Normocephalic and atraumatic.  ",
		"position" : {
			"x" : 0,
			"y" : 46
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Hair of average textures.  ",
		"position" : {
			"x" : 46,
			"y" : 27
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "Scalp without lesions.",
		"position" : {
			"x" : 73,
			"y" : 22
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Skin:  No infections, jaundice, rash, or petechiae.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0021311",
			"preferredName" : "Infections"
		}],
		"conceptPositions" : [{
			"x" : 10,
			"y" : 10
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0022346",
			"preferredName" : "Jaundice"
		}],
		"conceptPositions" : [{
			"x" : 22,
			"y" : 8
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0031256",
			"preferredName" : "Petechiae"
		}],
		"conceptPositions" : [{
			"x" : 41,
			"y" : 9
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 7,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0015230",
			"preferredName" : "Rash"
		}],
		"conceptPositions" : [{
			"x" : 32,
			"y" : 4
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Skin:  No infections, jaundice, rash, or petechiae.",
		"position" : {
			"x" : 0,
			"y" : 51
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Eyes:  Conjunctiva moist and pink.  PERRLA.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Eyes:  Conjunctiva moist and pink.  ",
		"position" : {
			"x" : 0,
			"y" : 36
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "PERRLA.",
		"position" : {
			"x" : 36,
			"y" : 7
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Ears:  Auditory, acuity good to whispered voice.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Ears:  Auditory, acuity good to whispered voice.",
		"position" : {
			"x" : 0,
			"y" : 48
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Nose:  Mucosa is pink.  No sinus tenderness.  No nasal discharge.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 24,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0016169",
			"preferredName" : "Sinus"
		}],
		"conceptPositions" : [{
			"x" : 27,
			"y" : 5
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 24,
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
			"x" : 33,
			"y" : 10
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 46,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0264273",
			"preferredName" : "Nasal discharge"
		}],
		"conceptPositions" : [{
			"x" : 49,
			"y" : 15
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Nose:  Mucosa is pink.  ",
		"position" : {
			"x" : 0,
			"y" : 24
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "No sinus tenderness.  ",
		"position" : {
			"x" : 24,
			"y" : 22
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "No nasal discharge.",
		"position" : {
			"x" : 46,
			"y" : 19
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Mouth:  Oral mucosa is moist and pink.  No gingivitis.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 40,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0017574",
			"preferredName" : "Gingivitis"
		}],
		"conceptPositions" : [{
			"x" : 43,
			"y" : 10
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Mouth:  Oral mucosa is moist and pink.  ",
		"position" : {
			"x" : 0,
			"y" : 40
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "No gingivitis.",
		"position" : {
			"x" : 40,
			"y" : 14
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Neck:  Supple.  Trachea is midline.  No thyromegaly.  No lymphadenopathy.  Carotid, no bruits.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 37,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0018021",
			"preferredName" : "Thyromegaly"
		}],
		"conceptPositions" : [{
			"x" : 40,
			"y" : 11
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 54,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0497156",
			"preferredName" : "Lymphadenopathy"
		}, {
			"conceptId" : "C0024228",
			"preferredName" : "Lymphadenopathy"
		}],
		"conceptPositions" : [{
			"x" : 57,
			"y" : 15
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 84,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0006318",
			"preferredName" : "bruits"
		}],
		"conceptPositions" : [{
			"x" : 87,
			"y" : 6
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Neck:  Supple.  ",
		"position" : {
			"x" : 0,
			"y" : 16
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Trachea is midline.  ",
		"position" : {
			"x" : 16,
			"y" : 21
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "No thyromegaly.  ",
		"position" : {
			"x" : 37,
			"y" : 17
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "No lymphadenopathy.  ",
		"position" : {
			"x" : 54,
			"y" : 21
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.5",
		"text" : "Carotid, no bruits.",
		"position" : {
			"x" : 75,
			"y" : 19
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Heart:  S1 and S2 regular.  No S3 or S4.  No murmurs.  No jugular vein distention.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 42,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0018808",
			"preferredName" : "murmurs"
		}],
		"conceptPositions" : [{
			"x" : 45,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 55,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C1167958",
			"preferredName" : "Jugular vein distention"
		}],
		"conceptPositions" : [{
			"x" : 58,
			"y" : 23
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Heart:  S1 and S2 regular.  ",
		"position" : {
			"x" : 0,
			"y" : 28
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "No S3 or S4.  ",
		"position" : {
			"x" : 28,
			"y" : 14
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "No murmurs.  ",
		"position" : {
			"x" : 42,
			"y" : 13
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "No jugular vein distention.",
		"position" : {
			"x" : 55,
			"y" : 27
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Thorax:  Symmetric with good excursion.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Thorax:  Symmetric with good excursion.",
		"position" : {
			"x" : 0,
			"y" : 39
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Lungs:  Clear.  No rales, wheezing, or rhonchi.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 16,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0240859",
			"preferredName" : "Rales"
		}, {
			"conceptId" : "C0034642",
			"preferredName" : "Rales"
		}],
		"conceptPositions" : [{
			"x" : 19,
			"y" : 5
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 16,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0035508",
			"preferredName" : "Rhonchi"
		}],
		"conceptPositions" : [{
			"x" : 39,
			"y" : 7
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 16,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0043144",
			"preferredName" : "Wheezing"
		}],
		"conceptPositions" : [{
			"x" : 26,
			"y" : 8
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Lungs:  Clear.  ",
		"position" : {
			"x" : 0,
			"y" : 16
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "No rales, wheezing, or rhonchi.",
		"position" : {
			"x" : 16,
			"y" : 31
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Abdomen:  Soft, nontender, and non-distended.  No masses.  No costovertebral angle tenderness.  Bowel sounds are active.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 47,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0577559",
			"preferredName" : "Mass"
		}],
		"conceptPositions" : [{
			"x" : 50,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 59,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0235634",
			"preferredName" : "Costovertebral angle tenderness"
		}],
		"conceptPositions" : [{
			"x" : 62,
			"y" : 31
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Abdomen:  Soft, nontender, and non-distended.  ",
		"position" : {
			"x" : 0,
			"y" : 47
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "No masses.  ",
		"position" : {
			"x" : 47,
			"y" : 12
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "No costovertebral angle tenderness.  ",
		"position" : {
			"x" : 59,
			"y" : 37
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "Bowel sounds are active.",
		"position" : {
			"x" : 96,
			"y" : 24
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Peripheral vascular:  Negative for ankle edema.  No stasis, pigmentation, or ulcers.  Radial pulses are 2+.  Dorsalis pedis 2+.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "negative for",
		"triggerPositions" : [{
			"x" : 22,
			"y" : 12
		}],
		"conceptPairs" : [{
			"conceptId" : "C0235439",
			"preferredName" : "Ankle edema"
		}],
		"conceptPositions" : [{
			"x" : 35,
			"y" : 11
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 49,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0031911",
			"preferredName" : "Pigmentation"
		}],
		"conceptPositions" : [{
			"x" : 60,
			"y" : 12
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 49,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0333138",
			"preferredName" : "Stasis"
		}],
		"conceptPositions" : [{
			"x" : 52,
			"y" : 6
		}]
	}, {
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 49,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0041582",
			"preferredName" : "Ulcers"
		}],
		"conceptPositions" : [{
			"x" : 77,
			"y" : 6
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Peripheral vascular:  Negative for ankle edema.  ",
		"position" : {
			"x" : 0,
			"y" : 49
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "No stasis, pigmentation, or ulcers.  ",
		"position" : {
			"x" : 49,
			"y" : 37
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.3",
		"text" : "Radial pulses are 2+.  ",
		"position" : {
			"x" : 86,
			"y" : 23
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.4",
		"text" : "Dorsalis pedis 2+.",
		"position" : {
			"x" : 109,
			"y" : 18
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Musculoskeletal:  No joint deformities.  Good range of motion.",
	"negations" : [{
		"type" : "nega",
		"trigger" : "no",
		"triggerPositions" : [{
			"x" : 18,
			"y" : 2
		}],
		"conceptPairs" : [{
			"conceptId" : "C0427244",
			"preferredName" : "Joint deformity"
		}],
		"conceptPositions" : [{
			"x" : 21,
			"y" : 17
		}]
	}],
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Musculoskeletal:  No joint deformities.  ",
		"position" : {
			"x" : 0,
			"y" : 41
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Good range of motion.",
		"position" : {
			"x" : 41,
			"y" : 21
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "ASSESSMENT:  ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "ASSESSMENT:",
		"position" : {
			"x" : 0,
			"y" : 11
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Chronic gastroesophageal reflux disease with intermittent dysphagia.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Chronic gastroesophageal reflux disease with intermittent dysphagia.",
		"position" : {
			"x" : 0,
			"y" : 68
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Colon cancer screening.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Colon cancer screening.",
		"position" : {
			"x" : 0,
			"y" : 23
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "?\nXXXXXX\t\t\t\t\t\t\t\t\t          PAGE THREE",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "? XXXXXX                   PAGE THREE",
		"position" : {
			"x" : 0,
			"y" : 37
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "XXXXXX",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "XXXXXX",
		"position" : {
			"x" : 0,
			"y" : 6
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "PLAN:  ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "PLAN:",
		"position" : {
			"x" : 0,
			"y" : 5
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "At the present time, the patient is interested in the GERD study and he will be screened for the study and will receive medications as per the study protocol.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "At the present time, the patient is interested in the GERD study and he will be screened for the study and will receive medications as per the study protocol.",
		"position" : {
			"x" : 0,
			"y" : 158
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "The patient was also advised regarding a screening colonoscopy, which will be considered at the patientís convenience.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "The patient was also advised regarding a screening colonoscopy, which will be considered at the patient s convenience.",
		"position" : {
			"x" : 0,
			"y" : 118
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Thank you Dr. Dar for allowing us to participate in the care of this patient. ",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Thank you Dr. ",
		"position" : {
			"x" : 0,
			"y" : 14
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Dar for allowing us to participate in the care of this patient.",
		"position" : {
			"x" : 14,
			"y" : 63
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "______________________",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "______________________",
		"position" : {
			"x" : 0,
			"y" : 22
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Syam Vemulapalli, M.D.",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Syam Vemulapalli, M.D.",
		"position" : {
			"x" : 0,
			"y" : 22
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "Rje/hma",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Rje/hma",
		"position" : {
			"x" : 0,
			"y" : 7
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "cc:\tDr. Dar",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "cc: Dr. ",
		"position" : {
			"x" : 0,
			"y" : 8
		},
		"phraseConceptMappings" : []
	}, {
		"id" : "00000000.tx.2",
		"text" : "Dar",
		"position" : {
			"x" : 8,
			"y" : 3
		},
		"phraseConceptMappings" : []
	}]
}, {
	"inputText" : "\tPhone: 432 333 3433\t\t\t\tFax: 432 333 3450\t\t\t\tEmail : Raviv @ aol.com",
	"utterences" : [{
		"id" : "00000000.tx.1",
		"text" : "Phone: 432 333 3433    Fax: 432 333 3450    Email : Raviv @ aol.com",
		"position" : {
			"x" : 1,
			"y" : 67
		},
		"phraseConceptMappings" : []
	}]
}]