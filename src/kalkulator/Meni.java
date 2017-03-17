/**
 * 
 * @author Adrian Waluk
 *
 */
package kalkulator;

import java.util.Scanner;

public class Meni {
	/**
	 * Wyswietla meni.
	 * 
	 * @return wpisany tekst z klawiatury
	 */
	public String wyswietlMeni(){
		Scanner keyboard = new Scanner(System.in);
		String tekst;
		System.out.println("Kalkulator.");
		System.out.println("Sposob wprowadzania danych:");
		System.out.println("1. Klawiatura;");
		System.out.println("2. Plik;");
		tekst = keyboard.nextLine();
		return tekst;
	}
}
