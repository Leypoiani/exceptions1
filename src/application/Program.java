package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("CheckIn Date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("CheckOut Date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update yhe reservation: ");
			System.out.print("CheckIn Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation. RESERVATION DATES FOR UPDATE MUST BE FUTURE DATES.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: CHECK-OUT DATE MUST BE AFTER CHECK-IN DATE.");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
	}

}
