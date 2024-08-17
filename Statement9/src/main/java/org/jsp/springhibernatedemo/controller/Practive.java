package org.jsp.springhibernatedemo.controller;

import java.util.Scanner;

public class Practive {

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Do want to continue? press y or n");
		char c = s.next().charAt(0);
		switch (c) {
		case 'y': {
			System.out.println("y");

			break;
		}
		case 'n': {
			System.out.println("n");
			break;

		}
		}
	}
}
