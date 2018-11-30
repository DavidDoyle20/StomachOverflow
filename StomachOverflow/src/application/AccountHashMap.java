package application;

import java.util.HashMap;

public final class AccountHashMap extends Object{
	
	private static HashMap<String, Account> accounts = new HashMap<String, Account>();
	
	public AccountHashMap() {
		
	}
	
	public static void put(String key, Account a) {
		accounts.put(key, a);
	}
	
	public static Account get(String key) {
		return accounts.get(key);
	}

}
