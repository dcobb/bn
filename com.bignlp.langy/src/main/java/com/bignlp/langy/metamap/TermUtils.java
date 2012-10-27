package com.bignlp.langy.metamap;

import java.util.ArrayList;
import java.util.List;

import se.sics.prologbeans.PBTerm;

/**
 * Utility functions for dealing with Terms.
 *
 * <p>
 * Created: Thu May 21 11:59:49 2009
 *
 * @author <a href="mailto:wrogers@nlm.nih.gov">Willie Rogers</a>
 * @version 1.0
 */
public class TermUtils {

  public static PBTerm getListElement(PBTerm aTerm, int elementNum) {
    PBTerm term = aTerm;
    for (int i = 1; i < (aTerm.length() + 1); i++) {
      if (i == elementNum) {
	return term.head();
      }
      term = term.tail();
    }
    return null;
  }

  public static String getAtomArgument(PBTerm parentTerm, int argnum)
    throws Exception 
  { 
    PBTerm term = parentTerm.getArgument(argnum);
    if (term.isAtom()) {
      return term.toString();
    } else {
      throw new Exception("supplied term is not a string .");
    } 
  }

  public static String getStringArgument(PBTerm parentTerm, int argnum)
    throws Exception 
  { 
    PBTerm term = parentTerm.getArgument(argnum);
    if (term.isString()) {
      return term.getString();
    } else {
      throw new Exception("supplied term is not a string .");
    } 
  }

  public static List<String> getAtomStringListArgument(PBTerm parentTerm, int argnum)
  {
    List<String> stringList = new ArrayList<String>();
    PBTerm prologList = (PBTerm)parentTerm.getArgument(argnum);
    for (int i = 1; i <= prologList.length(); i++) {
      stringList.add(getListElement(prologList, i).toString());
    }
    return stringList;
  }

  public static List<String> getStringListArgument(PBTerm parentTerm, int argnum)
  {
    List<String> stringList = new ArrayList<String>();
    PBTerm term = parentTerm.getArgument(argnum);
    PBTerm prologList = (PBTerm)term.getArgument(1);
    for (int i = 1; i <= prologList.length(); i++) {
      stringList.add(getListElement(prologList, i).toString());
    }
    return stringList;
  }

  public static List<Integer> getIntegerListArgument(PBTerm parentTerm, int argnum)
  {
    List<Integer> integerList = new ArrayList<Integer>();
    PBTerm prologList = (PBTerm)parentTerm.getArgument(argnum);
    for (int i = 1; i <= prologList.length(); i++) {
      integerList.add(Integer.parseInt(getListElement(prologList, i).toString()));
    }
    return integerList;
  }

  public static long getIntegerArgument(PBTerm parentTerm, int argnum)
    throws Exception
  { 
    PBTerm term = parentTerm.getArgument(argnum);
    if (term.isInteger()) {
      return term.intValue();
    } else {
      throw new Exception("supplied term is not an integer.");
    }
  }

  public static Position getPositionArgument(PBTerm parentTerm, int argnum) 
    throws Exception 
  {
    PBTerm term = parentTerm.getArgument(argnum);
    if (term.isCompound()) 
      return new PositionImpl(term.getArgument(1).intValue(), term.getArgument(2).intValue());
    else 
      throw new Exception("supplied term is not a compound term.");
  }

  public static List<Position> getPositionListArgument(PBTerm parentTerm, int argnum)
  {
    List<Position> posList = new ArrayList<Position>();
    PBTerm prologList = (PBTerm)parentTerm.getArgument(argnum);
        for (int i = 1; i <= prologList.length(); i++) {
	  posList.add(new PositionImpl(getListElement(prologList, i)));
    }
    return posList;

  }

  public static String getArgumentAsString(PBTerm parentTerm, int argnum)
  {
    PBTerm term = parentTerm.getArgument(argnum);
    return term.toString();
  }

  public static List<Object> getMatchMapTree(PBTerm prologList) throws Exception {
    List<Object> objectList = new ArrayList<Object>();
    for (int i = 1; i <= prologList.length(); i++) {
      if (getListElement(prologList, i).isListCell()) {
	objectList.add(getMatchMapTree(getListElement(prologList, i)));
      } else if (getListElement(prologList, i).isInteger()) {
	objectList.add(new Integer((int)getListElement(prologList,i).intValue()));
      }
    }
    return objectList;
  }

}
