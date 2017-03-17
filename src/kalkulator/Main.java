/**
 * 
 * @author Adrian Waluk
 *
 */
package kalkulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		/**
		 * menu		zmiena do tworzenia meni
		 * kal		zmiena bedaca kalkulatorem
		 * tekst	zmiena na wprowadzenie tekstu z klawiatury
		 */
		Meni menu= new Meni();
		Kalkulator kal= new Kalkulator();
		Scanner klawiatura = new Scanner(System.in);
		String tekst = menu.wyswietlMeni();
		while(!tekst.endsWith("koniec")){
			if(tekst.charAt(0)=='1'){
				System.out.print("Podaj dzialanie i zatwierdz enterem (wpisz 'koniec' aby zakonczyc): ");
				kal.dzialanie= klawiatura.nextLine();
				while(!kal.dzialanie.endsWith("koniec")){
					System.out.println(kal.dzialanie+"="+kal.oblicz());
					System.out.print("Podaj dzialanie i zatwierdz enterem (wpisz 'koniec' aby zakonczyc): ");
					kal.dzialanie= klawiatura.nextLine();
				}
				tekst = menu.wyswietlMeni();
			}
			else{
				Scanner odczyt = new Scanner(new File("Dane.txt"));
			    kal.dzialanie = odczyt.nextLine();
				while(!kal.dzialanie.equals("koniec")){
				    System.out.println(kal.dzialanie+"="+kal.oblicz());
				    kal.dzialanie = odczyt.nextLine();
				}
				tekst = menu.wyswietlMeni();
			}
		}
	}
}

