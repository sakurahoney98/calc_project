package Desafio;

import java.util.Scanner;

public class Calculadora {
	int valorInv;
	
	

	
	
	public void calcular(int valorInv) {
		int views;
		int click;
		int share;
		int views2;
		
		
		
		views = valorInv * 30;
		
		
		click = (views/100)*12;
		
		
		
		share = (click/20)*3;
		
		
		views2 = share * 40;
		
		int restoC = views%100;
		int restoS = click%20;
		while (views2 >= 100) {
			
			
			int auxViews = views2 + restoC;
			
			int auxClick = (auxViews/100)*12;
			
			int somaAux = auxClick + restoS;
			
			int auxShare = (somaAux/20)*3;
			
			views = views + views2;
			
			views2 = auxShare * 40;
			
			restoC = auxViews%100;
			
			restoS = somaAux%20;
			
			
			
			click = click + auxClick;
			
			share = share + auxShare;
			
		}
		System.out.println("Valor total investido: R$"+valorInv+"\nVisualizações: "+views+"\nCliques: "+click+"\nCompartilhamentos: "+share);
		
	}
	
	

}
