package com.bignlp.langy.metamap.result;

import java.util.ArrayList;
import java.util.List;

import com.bignlp.langy.metamap.AcronymsAbbrevs;
import com.bignlp.langy.metamap.Negation;
import com.bignlp.langy.metamap.Result;

public class MetaMapUtils {

	public static MetaMapResult createMetaMapResult(Result argResult) {

		MetaMapResult result = new MetaMapResult();

		result.setInputText(argResult.getInputText());
		List<MetaMapAcronym> mmAcronyms = new ArrayList<MetaMapAcronym>();
		try {
			List<AcronymsAbbrevs> resultAcronyms = argResult
					.getAcronymsAbbrevs();
			for (AcronymsAbbrevs acronymsAbbrevs : resultAcronyms) {
				MetaMapAcronym mmAcronym = new MetaMapAcronym();
				mmAcronym.setAbbreviation(acronymsAbbrevs.getAcronym());
				mmAcronym.setExpansion(acronymsAbbrevs.getExpansion());
				mmAcronym.setCounts(acronymsAbbrevs.getCountList());
				mmAcronym.setCuis(acronymsAbbrevs.getCUIList());
				mmAcronyms.add(mmAcronym);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.setAcronyms(mmAcronyms);

		List<MetaMapNegation> mmNegatation = new ArrayList<MetaMapNegation>();
		try {
//			
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			List<Negation> resultNegations = argResult.getNegationList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
