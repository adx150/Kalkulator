/**
 * 
 * @author Adrian Waluk
 * 
 */
package kalkulator;

import java.lang.*;
import org.apache.commons.lang3.StringUtils;

public class Kalkulator {
	public String dzialanie;
	public Kalkulator(){dzialanie="a";};
	/**
	 * Tworzenie tabeli z wpisanymi liczbami.
	 * 
	 * @param liczby		tabela na liczby z rownania.
	 * @return ilosc liczb w rownaniu.
	 */
	private int tworzenieLiczb(double[] liczby){
		/**
		 * i oraz j		liczniki do poruszania sie po tablicy.
		 * k 			sluzy do potegwania dziesiatki aby zapisac poprawnie liczbe.
		 * pom			tabela pomocnicza do tworzenia liczb z cyfr.
		 * pomoc		zmienna do przechowania oblicznej liczby.
		 * znak			pojedynczy znak z rownania.
		 */
		int i=0, j=0, k=1, ileLiczb=0;
		int[] pom=new int[4];
		double pomoc=0;
		String znak;
		while(i<dzialanie.length()){
			znak=dzialanie.charAt(i)+"";
			if(StringUtils.isNumeric(znak)){
				pom[j]=Integer.valueOf(znak);
				j++;
			}
			if(!StringUtils.isNumeric(znak) && !StringUtils.isAlpha(znak)){
				while(j>0){
					j--;
					pomoc+=pom[j]*k;
					k*=10;
				}
				liczby[ileLiczb]=pomoc;
				ileLiczb++; k=1; pomoc=0;
			}
			i++;
		}
		while(j>0){
			j--;
			pomoc+=pom[j]*k;
			k*=10;
		}
		liczby[ileLiczb]=pomoc;
		ileLiczb++; k=1; pomoc=0;
		return ileLiczb;
	}
	/**
	 * Tworzenie tabeli z wpisanymi znakami.
	 * 
	 * @param znaki		tablica na znaki z rownania.
	 * @return liczba znakow w rownaniu.
	 */
	private int tworzenieZnaki(char[] znaki){
		/**
		 * i to licznik do poruszania sie po tablicy
		 * znak to pojedynczy znak z rownania
		 */
		int i=0, ileZnakow=0;
		String znak;
		while(i<dzialanie.length()){
			znak=dzialanie.charAt(i)+"";
			if(!StringUtils.isNumeric(znak) && !StringUtils.isAlpha(znak)){
				znaki[ileZnakow]=znak.charAt(0);
				ileZnakow++;
			}
			i++;
		}
		return ileZnakow;
	}
	
	/**
	 * Oblicznie rownania.
	 * 
	 * @return wynik rownania
	 */
	public double oblicz(){
		/**
		 * i oraz j		liczniki do poruszania sie po tablicy
		 * pom			zmienna pomocnicza
		 * liczby		tablica liczb z rownania
		 * znaki		tablica znakow z rownania
		 * ileLiczb		ilosc liczb w rownaniu
		 * ileZnakow	ilosc znakow w rownaniu
		 */
		int i=0, j=0, pom;
		double[] liczby=new double[10];
		char[] znaki=new char[10];
		int ileLiczb=this.tworzenieLiczb(liczby);
		int ileZnakow=this.tworzenieZnaki(znaki);
		pom=ileZnakow;
		while(pom!=0){
			if(znaki[i]=='*'){
				liczby[i]=liczby[i]*liczby[i+1];
				j=i+1;
				while(j<ileLiczb){
					liczby[j]=liczby[j+1];
					j++;
				}
				ileLiczb--;
				j=i;
				while(j<ileZnakow){
					znaki[j]=znaki[j+1];
					j++;
				}
				ileZnakow--;
				i--;
				pom++;
			}
			else  if(znaki[i]=='/'){
				liczby[i]=liczby[i]/liczby[i+1];
				j=i+1;
				while(j<ileLiczb){
					liczby[j]=liczby[j+1];
					j++;
				}
				ileLiczb--;
				j=i;
				while(j<ileZnakow){
					znaki[j]=znaki[j+1];
					j++;
				}
				ileZnakow--;
				i--;
				pom++;
			}
			i++;
			pom--;
		}
		i=0;
		pom=ileZnakow;
		while(pom!=0){
			if(znaki[i]=='+'){
				liczby[i]=liczby[i]+liczby[i+1];
				j=i+1;
				while(j<ileLiczb){
					liczby[j]=liczby[j+1];
					j++;
				}
				ileLiczb--;
				j=i;
				while(j<ileZnakow){
					znaki[j]=znaki[j+1];
					j++;
				}
				ileZnakow--;
				i--;
				pom++;
			}
			else  if(znaki[i]=='-'){
				liczby[i]=liczby[i]-liczby[i+1];
				j=i+1;
				while(j<ileLiczb){
					liczby[j]=liczby[j+1];
					j++;
				}
				ileLiczb--;
				j=i;
				while(j<ileZnakow){
					znaki[j]=znaki[j+1];
					j++;
				}
				ileZnakow--;
				i--;
				pom++;
			}
			i++;
			pom--;
		}
		return liczby[0];
	}
}
