package com.ecom;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Shop implements ShopAbst // Superclass
{
	private String name;
	private long contact = 123;
	private String email;
	private String address;
	private String gender;
	private String password = "123";
	private String cpassword;
	static boolean isRegistered = false;
	static Map<String, Integer> cart = new LinkedHashMap<>();
	boolean b = false;

	static int total;

	@Override
	public void login() {
		if (isRegistered == false) {
			System.out.println("No account existed please register");
			signup();
		}
		System.out.println("Please proceed for Login");
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to login with contact number");
		System.out.println("Press 2 to login with email id");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			System.out.println("Enter contact number");
			long contact = sc.nextLong();
			sc.nextLine();
			if (contact == this.contact) {
				System.out.println("Valid");
				passwordchecking();
			} else {
				System.err.println("Try again!!!");
				login();
			}
			break;
		case 2:
			System.out.println("Enter your mail id");
			sc.nextLine();
			String email = sc.nextLine();
			if (email.equals(this.email)) {
				System.out.println("Valid email");
				passwordchecking();
			} else

			{
				System.err.println("Try again!!!");
				login();
			}
			break;

		default:
			System.err.println("Try Again!!!");
			login();
		}

	}

	@Override
	public void passwordchecking() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the password to login");
		String password = sc.nextLine();
		if (password.equals(this.password)) {
			System.out.println("Login Successful");
			b = true;
		} else {
			System.err.println("Enter valid password");
			login();
		}
	}

	@Override
	public void signup() {
		System.out.println("Enter the details to register");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name");
		name = sc.nextLine();
		contactValidation();
		emailValidation();
		System.out.println("Enter your address");
		address = sc.nextLine();
		System.out.println("Enter your gender");
		gender = sc.nextLine();
		passwordValidation();
		captcha();
		isRegistered = true;
	}

	@Override
	public void captcha() {
		String captcha = "";
		Random r = new Random();
		while (captcha.length() < 6) {
			int n = r.nextInt(123);// ---> 0 to 122
			if ((n >= 65 && n <= 90) || (n >= 97 && n <= 122) || (n >= 48 && n <= 57)) {
				captcha = captcha + (char) n;
			}
		}
		System.out.println(captcha);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the above captcha");
		String userCaptcha = sc.nextLine();
		if (captcha.equals(userCaptcha)) {
			System.out.println("Successful");
		} else {
			System.err.println("Try Again!!!");
			captcha();
		}
	}

	public void passwordValidation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your password");
		password = sc.nextLine();
		System.out.println("Enter password to confirm");
		cpassword = sc.nextLine();
		if (password.equals(cpassword)) {
			System.out.println("Password Match");
		} else {
			System.err.println("Those passwords didn't match. Try Again!!");
			passwordValidation();
		}
	}
	public void emailValidation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your email id");
		email = sc.nextLine();
		if (email.endsWith("@gmail.com") || email.endsWith("@yahoo.com")) {
			System.out.println("Valid Mail");
		} else
		{
			System.err.println("Invalid Try Again");
			emailValidation();
		}
	}

	public void contactValidation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your contact details");
		try {
			contact = sc.nextLong();
			if (contact > 999999999L && contact < 10000000000L) {
				System.out.println("Contact Valid");
			} else {
				System.err.println("Enter 10 digits number");
				contactValidation(); // method recursion
			}
		} catch (InputMismatchException ime) {
			System.err.println("Enter numbers only");
			contactValidation();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void total_bill() {
		for (Map.Entry<String, Integer> e : cart.entrySet()) {
			System.out.println(e.getKey() + "  " + e.getValue());
		}
		System.out.println("Enter 1 for UPI");
		System.out.println("Enter 2 for Cash on Delivery");
	}

	@Override
	public void homepage() {
		System.out.println("Enter 1 to choose Fashion");
		System.out.println("Enter 2 to choose Jewellery");
		System.out.println("Enter 3 to choose Electronics");
		System.out.println("Enter 4 to choose Vehicle Acc.");
		System.out.println("Enter 5 to Exit");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Enter your size");
			char size = sc.next().charAt(0);
			System.out.println("Enter your waist size");
			int waist_size = sc.nextInt();
			Fashion f = new Fashion(size, waist_size);
			f.gender_category();
			break;
		case 2: // jewel
			break;
		case 3: // electronics
			break;
		case 4: // acc.
			break;
		case 5:
			System.out.println("Thank you and have a nice day");
			System.exit(0);
		default:
			System.err.println("Choose correct option from above");
			homepage();
		}
		System.out.println("total bill " + total);
	}
}
