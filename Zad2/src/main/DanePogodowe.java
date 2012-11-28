package main;

import java.util.*;

public class DanePogodowe implements Podmiot {

		private ArrayList wyswietlacz;
		private double temp;
		private double wilg;
		private double cisn;
		
		public DanePogodowe() 
		{
			wyswietlacz = new ArrayList();
		}
		
		public void dodajWyswietlacz(Podmiot p) 
		{
			wyswietlacz.add(p);
		}
		
		public void usunWyswietlacz(Podmiot p) 
		{
			int i = wyswietlacz.indexOf(p);
			if (i >= 0) 
			{
				wyswietlacz.remove(i);
			}
		}
		
		public void wyslijDaneDoWyswietlaczy() 
		{
			for (int i = 0; i < wyswietlacz.size(); i++) 
			{
				Wyswietlanie wyswietlanie = (Wyswietlanie)wyswietlacz.get(i);
				wyswietlanie.aktualizacja(temp, wilg, cisn);
			}
		}
		
		public void zmiana() 
		{
			wyslijDaneDoWyswietlaczy();
		}
		
		public void ustaw(double temperatura, double wilgotnosc, double cisn) 
		{
			this.temp = temperatura;
			this.wilg = wilgotnosc;
			this.cisn = cisn;
			zmiana();
		}
		
		public double pobierzTemperature() { return temp; }
		
		public double pobierzWilgotnosc() { return wilg; }
		
		public double pobierzCisnienie() { return cisn; }
	

}
