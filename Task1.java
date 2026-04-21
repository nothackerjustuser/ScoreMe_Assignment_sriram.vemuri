package assignment;

import java.util.List;

public class Task1 {
	public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
		// FIX: Initialized list to prevent NullPointerException when calling .add()
		List<LoanAccount> result = new ArrayList<>();

		if (accounts == null)
			return result;

		for (LoanAccount account : accounts) {
			// FIX: Added null check for dueDate to handle restructured accounts
			if (account != null && account.getDueDate() != null && account.getDueDate().before(new Date())) {
				if (account.getOutstandingBalance() > 0) {
					result.add(account);
				}
			}
		}
		// FIX: Returning initialized list (empty or populated) instead of null
		return result;
	}

}
