package com.ecom;

import java.util.Scanner;

public class Fashion extends Shop {
	char size;
	int waist_size;
	String color;
	String material;
	Fashion()
	{
		
	}
	public Fashion(char size, int waist_size) {
		this.size = size;
		this.waist_size = waist_size;
	}

	public void gender_category() {
		System.out.println("Enter 1 to choose Men");
		System.out.println("Enter 2 to choose Women");
		System.out.println("Enter 3 to choose for Kids");
		System.out.println("Enter 4 to go back");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1: 
			Men m = new Men();
			m.category();
			break;
		case 2: // Women
			break;
		case 3: // Kids
			break;
		case 4:
			   homepage();
			break;
		default:
			System.err.println("Enter correct option from above");
			gender_category();
		}
	}
}
