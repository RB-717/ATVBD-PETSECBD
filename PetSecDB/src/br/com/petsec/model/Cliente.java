package br.com.petsec.model;

import java.sql.Date;

public class Cliente {
	
	private int IDCliente;
	private String nomeCliente;
	private String sexoCliente;
	private Date dataNascimento;
	public int getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getSexoCliente() {
		return sexoCliente;
	}
	public void setSexoCliente(String sexoCliente) {
		this.sexoCliente = sexoCliente;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(java.util.Date date) {
		this.dataNascimento = (Date) date;
	}
	
	

}
