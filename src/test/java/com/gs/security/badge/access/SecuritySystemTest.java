package com.gs.security.badge.access;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SecuritySystemTest {

  private SecuritySystem securitySystem;

  @BeforeEach
  public void initEach() {
    securitySystem = new SecuritySystem();
  }

  @Test
  public void testScnerio1() {
    String[][] badgeAccessEntries =
        {{"Martha", "exit"}, 
         {"Adam", "enter"}, 
         {"Paul", "enter"}, 
         {"Paul", "enter"},
        };
    String[][] actualResult = securitySystem.identify(badgeAccessEntries);
    String[][] expectedValue = {
                              {"Martha"},
                              {"Paul"}
                            };
    assertArrayEquals(actualResult, expectedValue);  
  }

  
  @Test
  public void testScnerio2() {
    String[][] badgeAccessEntries =
        {  
            { "Adam", "enter" },
            { "Adam", "exit" }, 
            { "Kelly", "enter" }, 
            { "Kelly", "exit" },
            { "Adam", "enter" }, 
            { "Martha", "exit" }, 
            { "Adam", "enter" }, 
            { "Paul", "enter" }
        };
    String[][] actualResult = securitySystem.identify(badgeAccessEntries);
    String[][] expectedValue = {
                              {"Martha"},
                              {"Adam"}
                            };
    assertArrayEquals(actualResult, expectedValue);  
  }
  
}
