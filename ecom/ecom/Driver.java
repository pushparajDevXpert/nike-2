
import java.util.Scanner;

public class Driver {
	static {
		System.out.println("Welcome to Jspiders Shop");
		System.out.println("Udhar mana hai");
	}

	public static void main(String[] args) {
		System.out.println("Enter 1 to Register");
		System.out.println("Enter 2 to Login");
		System.out.println("Enter 3 to Guest Login");
		System.out.println("Enter 4 to Exit");
		Scanner sc = new Scanner(System.in);
		ShopAbst s = new Shop(); // Upcasting

		int n = sc.nextInt();
		switch (n) {
		case 1:
			s.signup();
		case 2:
			s.login();
		case 3:
			s.homepage();
			break;
		case 4:
			System.out.println("Bye Bye");
			System.exit(0);
			break;
		default:
			System.err.println("Try Again !!");
			main(null);
		}

	}
}
