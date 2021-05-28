package Desafio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;



public class Cadastro {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		LocalDate l = LocalDate.parse("23/11/2020",formatter);
		
		ArrayList <Anuncio> lista = new ArrayList<Anuncio>();
		Cadastro c = new Cadastro();
		int op = 0;
		final int optotal = 4;
		Scanner num = new Scanner(System.in);
		Calculadora calculadora = new Calculadora();
		
		do {
			System.out.print("Escolha uma opção:\n[1] Adicionar um anuncio\n[2] Procurar um anuncio\n[3] Exibir todos os anuncios\n[4] Calcular alncance por data\n[0] Sair\n\nOpção: ");
			op = num.nextInt();
			
			if (op < 0 || op > optotal)
				System.out.println("\n\nParametro inválido!\n\n");
			else {
				switch(op) {
				case 1:
					lista.add(c.capturaDados(lista));
					System.out.println("\n\nAnuncio adicionado com sucesso!\n\n");
					break;
					
				case 2:
					ArrayList <Anuncio> resultado = c.pesquisa(lista,0);
					if (resultado.isEmpty()) {
						System.out.println("\n\nNão foram encontrados resultados para essa pesquisa.\n\n");
					}else {
						System.out.println("\n\nA pesquisa retornou o seguinte resultado:\n");
						for(Anuncio find: resultado) {
						System.out.println("Anuncio: "+find.getAnuncio()+"\nCliente: "+find.getCliente()+"\nInvestimento: "+find.getInvestimento()+" por dia\nData de início: "+formatter.format(find.getIncio())+"\tData de termino: "+formatter.format(find.getFim()));
						System.out.println("\nProjeção:");
						String data1 = formatter.format(find.getIncio());
						String data2 = formatter.format(find.getFim());
						
						int valor = (int)find.getInvestimento() * c.calculaDias(data1,data2);
						calculadora.calcular(valor);
						System.out.println("\n\n");
						}
						
				
					}
					break;
					
				case 3:
					System.out.println("\n");
					for (Anuncio a: lista) {
						System.out.print("Anuncio: "+a.getAnuncio()+"\nCliente: "+a.getCliente()+"\n\n");
					}
					System.out.println();
					break;
					
					
				case 4:
					resultado = c.pesquisa(lista, 1);
					if (resultado.isEmpty()) {
						System.out.println("Não foram encontrados resultados para essa pesquisa.");
					}else {
						for(Anuncio find: resultado) {
						double valor = find.getInvestimento() * c.anuncioEncontrado(find);
						System.out.println("\nAs projeções para o anuncio na data filtrada são:");
						calculadora.calcular((int)valor);
						System.out.println("\n\n");
						}
					}
					System.out.println("\n");
					break;
					
				default:
					break;
				}
			}
		} while (op > 0 || op < optotal);
		
		
		
		
		
		
			
	}

	
	public Anuncio  capturaDados (ArrayList <Anuncio> lista) {
		Scanner letra = new Scanner(System.in);
		Scanner num = new Scanner(System.in);
		Cadastro d = new Cadastro();
		String anuncio = null, cliente = null;
		double investimento = 0;
		boolean prox = true;
		
	
		do {
		System.out.print("\n\nDigite o nome do anuncio: ");
		anuncio = letra.nextLine();
		for(Anuncio a: lista) {
			if (a.getAnuncio().equals(anuncio)) {
				prox = false;
				System.out.println("\nO nome para o anuncio digitado já está em uso, digite outro.\n");
				break;
			}else {
				prox = true;
			}
		}if (prox) {
		System.out.print("\nDigite o nome do cliente: ");
		cliente = letra.nextLine();
		System.out.print("\nDigite o valor de investimento diário: ");
		investimento = num.nextDouble();
		}
	
		}while (!prox);
		String dataInicial = d.dataInicial();
		String dataFinal = d.dataFinal(dataInicial);
		Anuncio a = new Anuncio(anuncio, cliente, dataInicial, dataFinal, investimento);
		System.out.println("\n\n");
		
		return a;
	}
		
	
	public String dataInicial () {
		Scanner num = new Scanner(System.in);
		int diaI, mesI, anoI;
		boolean prox = false;
		Cadastro c = new Cadastro();
		String diaFormat = null, mesFormat = null, anoFormat = null;
		do {
		System.out.println("\n\nInformações sobre a data inicial:");
		System.out.print("\nDia: ");
		diaI = num.nextInt();
		System.out.print("\nMes: ");
		mesI = num.nextInt();
		System.out.print("\nAno: ");
		anoI = num.nextInt();
		
		diaFormat = String.valueOf(diaI);
		mesFormat = String.valueOf(mesI);
		anoFormat = String.valueOf(anoI);
		
		if (String.valueOf(anoI).length() == 2 || String.valueOf(mesI).length() < 2 || String.valueOf(diaI).length() < 2) {
			
			
			if (String.valueOf(anoI).length() == 2)
				anoFormat = "20"+anoFormat;
			
			if (String.valueOf(mesI).length() < 2)
				mesFormat = "0"+mesFormat;
			
			if (String.valueOf(diaI).length() < 2)
				diaFormat = "0"+diaFormat;
			
			
			}
		
		
		prox = c.dataValida(diaFormat+"/"+mesFormat+"/"+anoFormat);

			if (!prox)
				System.out.println("A data digitada não é válida!\n");
			} while (!prox);
		
		
		return diaFormat+"/"+mesFormat+"/"+anoFormat;
	}
	
	public String dataFinal (String dataInicial) {
		
		int diaF, mesF, anoF;
		Scanner num = new Scanner(System.in);
		boolean prox = false;
		Cadastro c = new Cadastro();
		String diaFormat = null, mesFormat = null, anoFormat = null;
		do {
		do {
		System.out.println("\n\nInformações sobre a data final:");
		System.out.print("\nDia: ");
		diaF = num.nextInt();
		System.out.print("\nMês: ");
		mesF = num.nextInt();
		System.out.print("\nAno: ");
		anoF = num.nextInt();
		
		 diaFormat = String.valueOf(diaF);
		 mesFormat = String.valueOf(mesF);
		 anoFormat = String.valueOf(anoF);
		if (String.valueOf(anoF).length() == 2 || String.valueOf(mesF).length() < 2 || String.valueOf(diaF).length() < 2) {
			
			
			if (String.valueOf(anoF).length() == 2)
				anoFormat = "20"+anoFormat;
			
			if (String.valueOf(mesF).length() < 2)
				mesFormat = "0"+mesFormat;
			
			if (String.valueOf(diaF).length() < 2)
				diaFormat = "0"+diaFormat;
			
			
			}
		
		
		prox = c.dataValida(diaFormat+"/"+mesFormat+"/"+anoFormat);
			if (!prox)
				System.out.println("A data digitada não é válida!\n");
			} while (!prox);
		
		prox = false;
		
		LocalDate dataI = LocalDate.parse(dataInicial, formatter);
		LocalDate dataF = LocalDate.parse(diaFormat+"/"+mesFormat+"/"+anoFormat, formatter);
		
		if (dataI.isBefore(dataF) || dataI.isEqual(dataF)) {
			prox =true;
		}
		
		if (!prox) {
			System.out.println("A data final não pode ser menor que a data de início.\n");
		}
		
		} while (!prox);
		
	
		return diaFormat + "/" + mesFormat +"/" + anoFormat;
	}
	
	public ArrayList <Anuncio> pesquisa(ArrayList <Anuncio> lista, int aux) {
		int op=1;
		String pesquisa = null;
		Scanner palavra = new Scanner(System.in);
		ArrayList <Anuncio> resultado = new ArrayList<Anuncio>();
		Cadastro c = new Cadastro();

		do {
			if (aux == 0) {
		System.out.print("\n\nDeseja pesquisar por:\n[1] Nome do anuncio\n[2] Nome do cliente\n[3] Data\n[0] Sair\n\nOpção: ");
		Scanner num = new Scanner(System.in);
		 op = num.nextInt();
		 
		 if (op<0 || op > 3) {
			 System.out.println("\nOps... essa opção não é válida, tente novamente.\n\n");
			 
		}
			}else {
				System.out.print("\n\nDigite o nome do anuncio: ");
				pesquisa = palavra.nextLine();
				op = 1;
			}
		} while ((op<0 || op > 3));
		switch (op) {
		case 1:
				if (aux == 0) {
					System.out.print("\nDigite o nome: ");
					 pesquisa = palavra.nextLine();
				}
				for (Anuncio an: lista) {
				if (an.getAnuncio().equalsIgnoreCase(pesquisa)) {
					resultado.add(an);
					break;
				}
			}
				
			break;
			
			case 2:
				if (aux == 0) {
					System.out.print("\nDigite o nome: ");
					 pesquisa = palavra.nextLine();
				}
					for (Anuncio an: lista) {
					if (an.getCliente().equalsIgnoreCase(pesquisa)) {
						resultado.add(an);
						
					}
				}
				break;
				
			case 3:
				String data1 = c.dataInicial();
				String data2 = c.dataFinal(data1);
				LocalDate d = LocalDate.parse(data1, formatter);
				LocalDate d2 = LocalDate.parse(data2, formatter);
				for (Anuncio an: lista) {
					if ((an.getIncio().isAfter(d) || an.getIncio().isEqual(d))  && (an.getIncio().isBefore(d2) || an.getIncio().isEqual(d2))) {
						resultado.add(an);
					}
				}
		
		
		
	}
		
		return resultado;
	}
	
	public int calculaDias(String dataInicial, String dataFinal) {
		int  contMes = 0, contDia = 0, contAno = 0, cont;
		
		int diaI = LocalDate.parse(dataInicial, formatter).getDayOfMonth();
		int diaF = LocalDate.parse(dataFinal, formatter).getDayOfMonth();
		int mesI = LocalDate.parse(dataInicial, formatter).getMonthValue();
		int mesF = LocalDate.parse(dataFinal, formatter).getMonthValue();
		int anoI = LocalDate.parse(dataInicial, formatter).getYear();
		int anoF = LocalDate.parse(dataFinal, formatter).getYear();
		
		
		// somando os meses
		if (mesI > mesF) {
			int aux = 12;
			for (int a = mesI; a <= aux;a++) {
				switch (a) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				contMes = contMes + 31;	
				break;
				
				case 4: case 6: case 9: case 11:
					contMes = contMes + 30;
					break;
					
				case 2:
					if (anoI%400 == 0 || (anoI%100 == 0 && anoI%4 == 0)) {
						contMes = contMes + 29;
					}else
						contMes = contMes + 28;
					break;
				}
				if (a == 12) {
					aux = mesF;
					a = 1;
				}
			}
		}else {
			
			for (int a = mesI; a < mesF;a++) {
				switch (a) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				contMes = contMes + 31;	
				break;
				
				case 4: case 6: case 9: case 11:
					contMes = contMes + 30;
					break;
					
				case 2:
					if (anoI%400 == 0 || (anoI%100 == 0 && anoI%4 == 0)) {
						contMes = contMes + 29;
					}else
						contMes = contMes + 28;
					break;
				}
			}
		}
		
		
		//somando os dias
		if (diaI > diaF) {
			contDia = diaI - diaF;
		}else {
			contDia = diaF - diaI;
			
		}
		
		//somando os anos
		
		if (anoI != anoF) {
			if (anoI%400==0 || (anoI%100==0 && anoI%4==0)) {
				contAno = contAno + 366;
			}
			else
				contAno = contAno + 365;
		}
		for (int b = anoI + 1; b < anoF; b++) {
			if (b%400==0 || (b%100==0 && b%4==0)) {
				contAno = contAno + 366;
			}
			else
				contAno = contAno + 365;
		}
		
		
		//somando ano + meses + dias
		if (diaI > diaF && mesI < mesF) {
			cont = contAno + contMes - contDia;
		}
		else {
			if (mesI > mesF && diaI < diaF) {
				cont = contAno - contMes - contDia;
			}
			else {
				cont = contDia + contMes + contAno;
			}
		}
		
		return cont;
	}
	
	public int anuncioEncontrado (Anuncio find) {
		Cadastro d = new Cadastro();
		String data1, data2;
		boolean prox = false;
		do {
			data1 = d.dataInicial();
			LocalDate dt = LocalDate.parse(data1, formatter);
			if (dt.isBefore(find.getIncio())) {
				System.out.println("\nA data informada compreende um período anterior a data de inicio do anuncio.\n\n");
			}else {
				prox = true;
			}
			
			if (prox) {
				prox = false;
			if (dt.isAfter(find.getFim())) {
				System.out.println("\nA data informada compreende um período posterior a data de término do anuncio.\n\n");
			}else {
				prox = true;
			}
		}
		
		}while (!prox);
		prox = false;
		do {
		data2 = d.dataFinal(data1);
		LocalDate dt = LocalDate.parse(data2, formatter);
		if (dt.isAfter(find.getFim())) {
			System.out.println("\nA data informada compreende um período posterior a data de término do anuncio.\n\n");
		}else {
			prox = true;
		}
	
		
	
	}while (!prox);
		
		int dias = d.calculaDias(data1, data2);
		
		return dias;
	}
	
	public boolean dataValida (String data) {
		
		try {
			LocalDate d = LocalDate.parse(data, formatter);
			return true;
		}catch (Exception e){
			
			return false;
		}
	}

}
