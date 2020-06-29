package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

		System.out.print("Rooms numbers: ");
		int numbers = sc.nextInt();
		System.out.print("Check-in date: ");

		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-out date: ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Checkout can be before checkin! ");
		} else {
			Reservation reserve = new Reservation(numbers, checkin, checkout);
			System.out.println("Reservation: " + reserve);

			System.out.println();

			System.out.println("Enter the update reservation: ");
			System.out.print("Check-in date: ");
			Date check_in = sdf.parse(sc.next());
			System.out.print("Check-out date: ");
			Date check_out = sdf.parse(sc.next());

			System.out.println("Reservation: " + reserve);

			Date now = new Date();
			if (check_in.before(now) || check_out.before(now)) {
				System.out.println("Error in reservation - Reservation datas for updates must");
			} else if (check_out.after(check_in)) {
				System.out.println("Checkout cant be after check in");
			} else {
				reserve.updateDate(check_in, check_out);
				System.out.println();
			}

		}

	}

}
