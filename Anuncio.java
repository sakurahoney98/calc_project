package Desafio;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Anuncio {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

private String anuncio;
private String cliente;
private LocalDate inicio;
private LocalDate fim;
public String getAnuncio() {
	return anuncio;
}

public void setAnuncio(String anuncio) {
	this.anuncio = anuncio;
}

public String getCliente() {
	return cliente;
}

public void setCliente(String cliente) {
	this.cliente = cliente;
}

public LocalDate getIncio() {
	
	return this.inicio;
}

public void setIncio(LocalDate incio) {
	this.inicio = incio;
}

public LocalDate getFim() {
	return fim;
}

public void setFim(LocalDate fim) {
	this.fim = fim;
}

public double getInvestimento() {
	return investimento;
}

public void setInvestimento(double investimento) {
	this.investimento = investimento;
}

private double investimento;


/**
 * @param anuncio
 * @param cliente
 * @param incio
 * @param fim
 */



public Anuncio(String anuncio, String cliente, String incio, String fim, double investimento) {
	this.anuncio = anuncio;
	this.cliente = cliente;
	this.inicio = LocalDate.parse(incio, formatter);
	this.fim = LocalDate.parse(fim, formatter);
	this.investimento = investimento;
	
} 
public int getAnoInicio() {
	String aux = String.valueOf(formatter.format(inicio));
	int ano = Integer.parseInt(aux.substring(6, 10));
	
	return ano;
}

public int getAnoFim() {
	String aux = String.valueOf(formatter.format(fim));
	int ano = Integer.parseInt(aux.substring(6, 10));
	
	return ano;
}

public int getMesInicio() {
	String aux = String.valueOf(formatter.format(inicio));
	int mes = Integer.parseInt(aux.substring(3, 5));
	
	return mes;
}

public int getMesFim() {
	String aux = String.valueOf(formatter.format(fim));
	int mes = Integer.parseInt(aux.substring(3, 5));
	
	return mes;
}

public int getDiaInicio() {
	String aux = String.valueOf(formatter.format(inicio));
	int dia = Integer.parseInt(aux.substring(0, 2));
	
	return dia;
}


}
