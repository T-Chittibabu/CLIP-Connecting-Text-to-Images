
/* Main Class
@Author ChittiBabu - ATM Project */

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MenuOption extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	/* Validate Login information customer number and pin number */

	public void getLogin() throws IOException {
		int x = 1;

		do {
			try {
				/*
				 * Accounts in HashMap, key = customer number, value = pin number
				 */
				data.put(3456789, 2323);
				data.put(3456780, 3232);

				System.out.println("Welcome to the ATM Project!");

				System.out.print("Enter Your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());

				System.out.print("Enter Your Pin Number: ");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s). Only numbers." + "\n");
				x = 2;
			}
			for (Entry<Integer, Integer> entry : data.entrySet()) {
				if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("\n" + "Wrong Customer Number or Pin Number." + "\n");
		} while (x == 1);
	}

	/* Display Account Type Menu with selection */

	public void getAccountType() {
		System.out.println("Select the Account you want to access: ");
		System.out.println("Type 1 - Current Account");
		System.out.println("Type 2 - Saving Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Choice: ");

		selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			getCurrent();
			break;

		case 2:
			getSaving();
			break;

		case 3:
			System.out.println("Thank You for using this ATM.");
			break;

		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getAccountType();
		}
	}

	/* Display Current Account Menu with selections */

	public void getCurrent() {
		System.out.println("Current Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");

		selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Current Account Balance: " + moneyFormat.format(getCurrentBalance()) + "\n");
			getAccountType();
			break;

		case 2:
			getCurrentWithdrawInput();
			getAccountType();
			break;

		case 3:
			getCurrentDepositInput();
			getAccountType();
			break;

		case 4:
			System.out.println("Thank You for using this ATM.");
			break;

		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getCurrent();
		}
	}

	/* Display Saving Account Menu with selections */

	public void getSaving() {
		System.out.println("Saving Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Transfer Funds");
		System.out.println("Type 5 - Exit");
		System.out.print("Choice: ");

		selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()) + "\n");
			getAccountType();
			break;

		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;

		case 3:
			getSavingDepositInput();
			getAccountType();
			break;

		case 4:
			getSavingTransferInput();
			getAccountType();
			break;

		case 5:
			System.out.println("Thank You for using this ATM.");
			break;

		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getSaving();
		}
	}

	int selection;
}
