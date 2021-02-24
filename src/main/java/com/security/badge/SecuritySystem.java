package security.badge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SecuritySystem {

	private Set<String> enteredWithoutSwipe = new HashSet<>();
	private Set<String> exitedWithoutSwipe = new HashSet<>();
	
	private Map<String, Boolean> employeeOfficeInsideStatusMap = new HashMap<>(); // true ENTER , false EXIT
	
	private void identify(String[][] badgeAccessEntries) {		
		for(String[] badgeAccessEntry : badgeAccessEntries) {
			String user = badgeAccessEntry[0];
			if (enteredWithoutSwipe.contains(user) || exitedWithoutSwipe.contains(user)) {
				continue;
			}

			String access = badgeAccessEntry[1];
			if (employeeOfficeInsideStatusMap.containsKey(user)) {				
				multipleAccessHelper(user, access);
			} else if (access.equalsIgnoreCase("enter")) {
				employeeOfficeInsideStatusMap.put(user, true);
			} else {
				enteredWithoutSwipe.add(user);
			}
		}
	}

	private void multipleAccessHelper(String user, String access) { 
		boolean isInsideOffcie = employeeOfficeInsideStatusMap.get(user);
		if(access.equalsIgnoreCase("enter") && isInsideOffcie) { // double entry, means not used card in previous exit
			exitedWithoutSwipe.add(user);
		}else if (access.equalsIgnoreCase("exit") && !isInsideOffcie) { // double exit, means not used card in previous enter
			enteredWithoutSwipe.add(user);
		}else {
		    employeeOfficeInsideStatusMap.put(user, !isInsideOffcie);
		}
	}

	public Set<String> getEnteredWithoutSwipe() {
		return enteredWithoutSwipe;
	}

	public Set<String> getExitedWithoutSwipe() {
		return exitedWithoutSwipe;
	}

	public static void main(String[] args) {
		System.out.println("******** Case 1 *********");
		testCase1();
		System.out.println("******** Case 2 *********");
		testCase2();
	}

	private static void testCase2() {
		SecuritySystem securitySystem = new SecuritySystem();
		String[][] badgeAccessEntries = {  
				{ "Martha", "exit" }, 
				{ "Adam", "enter" }, 
				{ "Paul", "enter" }, 
				{ "Paul", "enter" },
		};
		securitySystem.identify(badgeAccessEntries);
		System.out.println("Entered Without Swipe  - " + securitySystem.getEnteredWithoutSwipe());
		System.out.println("Exited Without Swipe - " + securitySystem.getExitedWithoutSwipe());
	}

	private static void testCase1() {
		SecuritySystem securitySystem = new SecuritySystem();
		String[][] badgeAccessEntries = { 
				{ "Adam", "enter" },
				{ "Adam", "exit" }, 
				{ "Kelly", "enter" }, 
				{ "Kelly", "exit" },
				{ "Adam", "enter" }, 
				{ "Martha", "exit" }, 
				{ "Adam", "enter" }, 
				{ "Paul", "enter" }, 
		};
		securitySystem.identify(badgeAccessEntries);
		System.out.println("Entered Without Swipe  - " + securitySystem.getEnteredWithoutSwipe());
		System.out.println("Exited Without Swipe - " + securitySystem.getExitedWithoutSwipe());
	}

}
