package application;

public final class AccountState {
	private static Account CurrAcc;

	public static Account getCurrAcc() {
		return CurrAcc;
	}

	public static void setCurrAcc(Account currAcc) {
		CurrAcc = currAcc;
	}
	
	
	
}
