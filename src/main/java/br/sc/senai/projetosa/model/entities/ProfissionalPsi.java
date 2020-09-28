package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="profissional_psi")
public class ProfissionalPsi implements Serializable {
	
	private static final long serialVersionUID = -3184136840428770810L;
	
	private int idPro;
	private String nomePro;
	private String crp;
	private String cpfPro;
	private String whatsappPro;
	private String emailPro;
	private String telPro;
	private String generoPro;
	private String senhaPro;
	private List<Consulta> consultas;
	private List<Paciente> pacientes;
	
	public ProfissionalPsi() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPro() {
		return idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	
	public String getNomePro() {
		return nomePro;
	}

	public void setNomePro(String nomePro) {
		this.nomePro = nomePro;
	}
	
	@Column(name="crp", nullable = false)
	public String getCrp() {
		return crp;
	}
	
	public void setCrp(String crp) {
		this.crp = crp;
	}
	
	@Column(name="cpf_profissional", nullable = false)
	public String getCpfPro() {
		return cpfPro;
	}
	public void setCpfPro(String cpfPro) {
		this.cpfPro = cpfPro;
	}
	public String getWhatsappPro() {
		return whatsappPro;
	}
	public void setWhatsappPro(String whatsappPro) {
		this.whatsappPro = whatsappPro;
	}
	
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public String getTelPro() {
		return telPro;
	}
	public void setTelPro(String telPro) {
		this.telPro = telPro;
	}
	public String getGeneroPro() {
		return generoPro;
	}
	public void setGeneroPro(String generoPro) {
		this.generoPro = generoPro;
	}
	
	public String getSenhaPro() {
		return senhaPro;
	}

	public void setSenhaPro(String senhaPro) {
		this.senhaPro = senhaPro;
	}

	@OneToMany
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	@OneToMany
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
