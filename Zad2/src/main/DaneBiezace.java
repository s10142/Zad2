package main;

public class DaneBiezace implements Wyswietlanie 
{
		private double temp = 17;
		private double wilg = 90;
		private double cisn = 1;
		private Podmiot danePogodowe;
		
		public DaneBiezace(Podmiot danePogodowe) 
		{
			this.danePogodowe = danePogodowe;
			danePogodowe.dodajWyswietlacz(danePogodowe);
		}
		
		public void aktualizacja(double temperatura, double wilgotnosc, double cisnienie) 
		{
			this.temp = temperatura;
			this.wilg = wilgotnosc;
			this.cisn = cisnienie;
			wyswietlanie();
		}
		
		public void wyswietlanie()
		{
			System.out.println("Dane bie¿¹ce: \n" + temp + " stopni C,\n" + wilg + " % wilgotnosci" + cisn + " atmosfer");
		}
}
