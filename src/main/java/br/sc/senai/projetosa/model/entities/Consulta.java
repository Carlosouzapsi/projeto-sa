package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="consulta")
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = 8530642283994774442L;
	
	private int idConsulta;
	//definir o enum que é o tipo da consulta;
	private int idProfissional;
	private int idPaciente;
	private String endereco;
	private String modalConsulta;
	//Definir datas;
	
	//gerar o toString;
	
	public Consulta() {
		
	}
	
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public int getIdProfissional() {
		return idProfissional;
	}
	public void setIdProfissional(int idProfissional) {
		this.idProfissional = idProfissional;
	}
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getModalConsulta() {
		return modalConsulta;
	}
	public void setModalConsulta(String modalConsulta) {
		this.modalConsulta = modalConsulta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
