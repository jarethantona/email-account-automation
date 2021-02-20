package main;

import java.util.Scanner;

public class Email {

	private String firstName;
	private String lastName;
	private String password;
	private String shift;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 18;
	private String alternateEmail;
	private String companySuffix = "JBCS.com";

	public Email() {
		System.out.println("Thank you for joining JavaBean Computing Services!");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your first name: ");
		String firstName = scanner.next();
		System.out.println("Please enter your last name: ");
		String lastName = scanner.next();
		System.out.println("**************************************************");
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("An email has been created for you, " + this.firstName + " " + this.lastName + "!");

		//Ask for shift preference
		this.shift = setShift();
		System.out.println("Your shift is: " + this.shift);

		//Randomized password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		System.out.println("**************************************************");
		//Generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + companySuffix;
		scanner.close();
	}

	private String setShift() {
		System.out.println("CURRENT SHIFT AVAILABILITIES\n1 | DAY SHIFT | 0630 - 1700 " +
				"\n2 | SWING SHIFT | 1200-2130\n3 | NIGHT SHIFT | 1800-0430\n0 "
				+ "to no longer continue\nPlease select shift code: ");

		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "Monday - Friday | 0630-1700";
			} else if (depChoice == 2) {
			return "Monday - Friday | 1200-2130";
			} else if (depChoice == 3) {
			return "Monday - Friday | 1800-0430";
			}
		System.out.println("We wish you the best of luck in your future endeavors");
		System.exit(depChoice);

		return "";
	}

	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%&";
		char[] password = new char[length];

		for (int i = 0; i < length; i++) {
			int randomValue = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(randomValue);
		}

		return new String(password);
	}

	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	public void changePassword(String password) {
		this.password = password;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}

}

