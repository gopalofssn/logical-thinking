package com.gs.security.badge.access;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecuritySystem {
  
	public String[][] identify(String[][] badgeAccessEntries) {	
	  
	    if(badgeAccessEntries == null || badgeAccessEntries.length == 0) {
	      return new String[0][];
	    }
	    
	    Set<String> enteredWithoutSwipe = new HashSet<>();
	    Set<String> exitedWithoutSwipe = new HashSet<>();
	    Map<String, Boolean> employeeOfficeInOutStatusMap = new HashMap<>(); // true ENTER , false EXIT
	    
		for(String[] badgeAccessEntry : badgeAccessEntries) {
			String user = badgeAccessEntry[0]; 
			String accessType = badgeAccessEntry[1];
			// case 1 : first time entering
			if(!employeeOfficeInOutStatusMap.containsKey(user) && accessType.equalsIgnoreCase("enter")) {
			  employeeOfficeInOutStatusMap.put(user, true);
			  continue;
            }
			
			// case 2 : not used but try to exit
			if(!employeeOfficeInOutStatusMap.containsKey(user) && accessType.equalsIgnoreCase("exit")) {
			  enteredWithoutSwipe.add(user);
			  continue;
			}

			// case 3 : exited without swipe
			if( accessType.equalsIgnoreCase("enter") && employeeOfficeInOutStatusMap.get(user)) {
			  exitedWithoutSwipe.add(user);
			  continue;
			}
			
			// case 4 : entered without swipe
			if( accessType.equalsIgnoreCase("exit") && !employeeOfficeInOutStatusMap.get(user)) {
			  enteredWithoutSwipe.add(user);
            }
			
		}
		
		String[][] result = new String[2][];
		result[0] = enteredWithoutSwipe.toArray(new String[0]);
		result[1] = exitedWithoutSwipe.toArray(new String[0]);
		return result;
		 
	}
	
}
