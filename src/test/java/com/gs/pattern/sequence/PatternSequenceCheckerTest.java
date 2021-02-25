package com.gs.pattern.sequence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatternSequenceCheckerTest {

  private final String GIVEN_STRING = "hghgghacbdefuaz";
  private PatternSequenceChecker patternSequenceChecker = new PatternSequenceChecker(GIVEN_STRING);
  
  @Test
  public void testIfPresent() {
    assertTrue(patternSequenceChecker.isSubSequencePresent("acaz"));
  }
  
  @Test
  public void testIfNotPresent() {
    assertFalse(patternSequenceChecker.isSubSequencePresent("aacaz"));
  }
  
}
