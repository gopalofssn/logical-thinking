package com.gs.pattern.sequence;

import java.util.*;

/**
 * Given String , find if sub sequences are present or not
 * 
 * @author Gopal Selvaraj
 *
 *         Given String : hghgghacbdefuaz
 *          acaz? - present 
 *          hfac? - no present
 */
public class PatternSequenceChecker {

  private Map<Character, List<Integer>> charPositionsGrid;

  public PatternSequenceChecker(String str) {
    if (isNullOrEmpty(str)) {
      throw new IllegalArgumentException("Input String can not be empty or null");
    }
    charPositionsGrid = new HashMap<Character, List<Integer>>();
    buildCharPositionsMap(str);
  }


  private void buildCharPositionsMap(String str) {
    for (int index = 0; index < str.length(); index++) {
      char ch = str.charAt(index);
      charPositionsGrid.putIfAbsent(ch, new ArrayList<Integer>());
      charPositionsGrid.get(ch).add(index);
    }
  }

  public boolean isSubSequencePresent(String subSequence) {
    if (isNullOrEmpty(subSequence)) {
      throw new IllegalArgumentException("Input SsubSequence String can not be empty or null");
    }

    int current = -1;
    for (char ch : subSequence.toCharArray()) {

      if (!charPositionsGrid.containsKey(ch)) {
        return false;
      }

      List<Integer> positions = charPositionsGrid.get(ch);
      int next = findNextPostionForGivenChar(positions, current);

      if (next <= current) {
        return false;
      }

      current = next;
    }

    return true;
  }


   //binarySearchToFindNext
  private int findNextPostionForGivenChar(List<Integer> positions, int target) {
    int left = 0;
    int right = positions.size() - 1;
    while(left <= right) {
      int mid = left + ( (right - left) / 2 );
      
      if(hasEligCriteriaMet(positions, target, mid)) {
        return positions.get(mid);
      }
      
      if( target > positions.get(mid) ) {
        left = mid + 1;
      }else {
        right = mid -  1;
      }
      
    }    
    return -1;
  }


  private boolean hasEligCriteriaMet(List<Integer> positions, int target, int mid) {
    if(mid == 0 && target < positions.get(mid) ) {
      return true;
    }
    
    if(mid > 0 && target > positions.get(mid - 1)  &&  target < positions.get(mid) ) {
      return true;
    }
    
    return false;
  }


  private boolean isNullOrEmpty(String str) {
    return str == null || str.isBlank();
  }

  public static void main(String[] args) {
    System.out.println(new PatternSequenceChecker("hghgghacbdefuaz"));
  }
}
