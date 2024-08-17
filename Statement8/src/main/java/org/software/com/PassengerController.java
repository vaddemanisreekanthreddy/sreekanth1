package org.software.com;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PassengerController {
	static PassengerDao dao;
	static Scanner s = new Scanner(System.in);
	static {
		System.out.println("Executed");

		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		 dao=(PassengerDao)ctx.getBean("dao");
		System.out.println("Executed");

	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("Press 1 for Insert");
			System.out.println("Press 2 for Update");
			System.out.println("Press 3 for Retrive");
			System.out.println("Press 4 for Delete");
			System.out.println("Press 5 to Quit");
			System.out.println("Make Your Choice");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				insert();
				break;
			}
			case 2: {
				updatePassenger();
				break;

			}
			case 3: {
				findAllthePassengers();
				break;

			}
			case 4: {
				deletePassenger();
				break;

			}
			case 5: {
				System.err.println("Thank you");
				System.exit(0);
				break;
			}
			}
			System.out.println("Do want to continue? press y or n");
			char c = s.next().charAt(0);
			switch (c) {
			case 'y': {
				break;
			}
			case 'n': {
				System.err.println("Thank you");
				System.exit(0);
				break;
			}
			}

		}
	}

	private static void insert() {
		try {
			System.out.println("Enter passengerName ");
			String name = s.next();
			System.out.println("Enter passengerDob yyyy-MM-dd Format");
			String dob = s.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(dob);
			System.out.println("Enter passengerPhone ");
			String phone = s.next();
			System.out.println("Enter passengerEmail ");
			String email = s.next();
			PassengerDetails passenger = new PassengerDetails(name, date, phone, email);
			int effrow = dao.savePassenger(passenger);
			System.out.println(effrow + " Rows are Effected");
		} catch (ParseException e) {
			System.out.println("Invalid date Format");
		}
	}

	private static void updatePassenger() {
		System.out.println("Enter Passenger id");
		int id = s.nextInt();
		PassengerDetails passenger = dao.findById(id);
		try {
			System.out.println("Enter passengerName ");
			String name = s.next();
			System.out.println("Enter passengerDob yyyy-MM-dd Format");
			String dob = s.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = dateFormat.parse(dob);
			System.out.println("Enter passengerPhone ");
			String phone = s.next();
			System.out.println("Enter passengerEmail ");
			String email = s.next();
			passenger.setPassengerName(name);
			passenger.setPassengerDob(date);
			passenger.setPassengerPhone(phone);
			passenger.setPassengerEmail(email);
			int effrow = dao.updatePassenger(passenger);
			System.out.println(effrow + " Rows are Effected");
			System.err.println("Passenger updated successfully at id : " + passenger.getPassengerId());
		} catch (ParseException e) {
			System.out.println("Invalid date Format");
		}
	}

	private static void findAllthePassengers() {
		List<PassengerDetails> passengers = dao.finaAllPassenger();
		if (passengers != null) {
			for (PassengerDetails passenger : passengers) {
				System.out.println(passenger);
			}
		} else {
			System.out.println("Data is Not present");
		}
	}

	private static void deletePassenger() {
		System.out.println("Enter Passenger id");
		int id = s.nextInt();
		PassengerDetails passenger = dao.findById(id);
		if (passenger != null) {
			int effrow = dao.deletePassenger(passenger);
			System.out.println(effrow + " Passenger Deleted Succefully");
		} else {
			System.out.println("You Entered Invalid Id or Passenger is Not Present");
		}
	}

}
