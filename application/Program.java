package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Room Number: ");
			int roomNumber = sc.nextInt();
			System.out.println("Check-In Date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out Date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println("\nEnter data to update the reservation:");
			System.out.println("Check-In Date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out Date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid Date Format");
		} catch (DomainException e) {
			System.out.println("Error in Reservation: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected Error");
		}

		sc.close();
	}

}
