package com.ecom;

import java.util.Scanner;

public class Men extends Fashion {
	public void category() {
		System.out.println("Enter 1 for formals");
		System.out.println("Enter 2 for casuals");
		System.out.println("Enter 3 to go back");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1:
			formals();
			break;
		case 2:
			casual();
			break;
		case 3:
			gender_category();
			break;
		default:
			System.err.println("Invalid");
			category();
		}
	}

	public void formals() {
		System.out.println("Enter 1 for formal shirt");
		System.out.println("Enter 2 for formal pant");
		System.out.println("Enter 3 to go back");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Enter the color");
			color = sc.next();
			System.out.println("Enter the material");
			material = sc.next();

			System.out.println("Enter 1 for plain shirt price $10");
			System.out.println("Enter 2 for checks shirt price $12");
			option = sc.nextInt();
			if (isRegistered == false) {
				System.out.println("Please Register before proceeding");
				signup();
			}
			switch (option) {
			case 1:
				System.out.println("You have choosen plain shirt");
				System.out.println("Press Y to confirm purchase");
				char confirm = sc.next().charAt(0);
				if (confirm == 'y' || confirm == 'Y') {
					total = total + 10;
					cart.put("plain shirt", 10);
				} else {
					formals();
				}
				break;
			case 2:
				System.out.println("You have choosen checks shirt");
				System.out.println("Press Y to confirm purchase");
				confirm = sc.next().charAt(0);
				if (confirm == 'y' || confirm == 'Y') {
					total = total + 12;
					cart.put("checks shirt", 12);
				} else {
					formals();
				}
				break;
			}

			break;
		case 2: // pant
			break;
		case 3:
			break;
		default:
			System.err.println("Invalid");
			formals();
		}
		
		System.out.println("If you want to shop more press 0");
		System.out.println("If you want to checkout press 1");
		option = sc.nextInt();
		if (option == 0) {
			homepage();
		} else if (option == 1) {
			//payment
			total_bill();
		}
	}

	public void casual() {

	}

	public void traditional() {

	}
}
