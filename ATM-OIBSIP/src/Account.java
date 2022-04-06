
/* Account, Withdraw, Deposit and Transfer
@Author ChittiBabu - ATM Project */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	/* Set the customer number */

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	/* Get the customer number */

	public int getCustomerNumber() {
		return customerNumber;
	}

	/* Set the pin number */

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	/* Get the pin number */

	public int getPinNumber() {
		return pinNumber;
	}

	/* Get Current Account Balance */

	public double getCurrentBalance() {
		return currentBalance;
	}

	/* Get Saving Account Balance */

	public double getSavingBalance() {
		return savingBalance;
	}

	/* Calculate Current Account withdrawal */

	public double calCurrentWithdraw(double amount) {
		currentBalance = (currentBalance - amount);
		return currentBalance;
	}

	/* Calculate Saving Account withdrawal */

	public double calSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	/* Calculate Current Account deposit */

	public double calCurrentDeposit(double amount) {
		currentBalance = (currentBalance + amount);
		return currentBalance;
	}

	/* Calculate Saving Account deposit */

	public double calSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
	
	/* Customer Transfer Amount from Saving Account */

	public double calSavingTransfer(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	/* Customer Deposit Transfer Amount from Saving to Current Account */

	public double calCurrentTransfer(double amount) {
		currentBalance = (currentBalance + amount);
		return currentBalance;
	}


	/* Customer Current Account Withdraw input */

	public void getCurrentWithdrawInput() {
		System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
		System.out.print("Amount you want to withdraw from Current Account: ");
		double amount = input.nextDouble();

		if ((currentBalance - amount) >= 0) {
			calCurrentWithdraw(amount);
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

	/* Customer Saving Account Withdraw input */

	public void getSavingWithdrawInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to withdraw from Saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance - amount) >= 0) {
			calSavingWithdraw(amount);
			System.out.println("New Saving Account balance: " + savingBalance + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

	/* Customer Current Account Deposit input */

	public void getCurrentDepositInput() {
		System.out.println("Current Account Balance: " + moneyFormat.format(currentBalance));
		System.out.print("Amount you want to deposit from Current Account: ");
		double amount = input.nextDouble();

		if ((currentBalance + amount) >= 0) {
			calCurrentDeposit(amount);
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}

	/* Customer Saving Account Deposit input */

	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to deposit from Saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance + amount) >= 0) {
			calSavingDeposit(amount);
			System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	
	/* Customer Transfer Amount input */

	public void getSavingTransferInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to transfer from Saving Account: ");
		double amount = input.nextDouble();
		if (savingBalance >= 0) {
			calSavingTransfer(amount);
			System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance) + "\n");
			calCurrentTransfer(amount);
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}

	}


	private int customerNumber;
	private int pinNumber;
	private double currentBalance = 0;
	private double savingBalance = 0;
}
