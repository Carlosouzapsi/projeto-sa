package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 3624675698464100635L;
	
	private int idPac;
	private String nomePac;
	private String cpfPac;
	private String whatsappPac;
	private String emailPac;
	private String telPac;
	private String idadePac;
	private String generoPac;
	private ProfissionalPsi profissionalpsi;
	
	public Paciente() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdPac() {
		return idPac;
	}

	public void setIdPac(int idPac) {
		this.idPac = idPac;
	}

	public String getNomePac() {
		return nomePac;
	}

	public void setNomePac(String nomePac) {
		this.nomePac = nomePac;
	}
	
	//procurar notação de validação de cpf, maven.
	@Column(name="cpf_paciente", nullable = false)
	public String getCpfPac() {
		return cpfPac;
	}

	public void setCpfPac(String cpfPac) {
		this.cpfPac = cpfPac;
	}

	public String getWhatsappPac() {
		return whatsappPac;
	}

	public void setWhatsappPac(String whatsappPac) {
		this.whatsappPac = whatsappPac;
	}

	public String getEmailPac() {
		return emailPac;
	}

	public void setEmailPac(String emailPac) {
		this.emailPac = emailPac;
	}

	public String getTelPac() {
		return telPac;
	}

	public void setTelPac(String telPac) {
		this.telPac = telPac;
	}

	public String getIdadePac() {
		return idadePac;
	}

	public void setIdadePac(String idadePac) {
		this.idadePac = idadePac;
	}

	public String getGeneroPac() {
		return generoPac;
	}

	public void setGeneroPac(String generoPac) {
		this.generoPac = generoPac;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public ProfissionalPsi getProfissionalpsi() {
		return profissionalpsi;
	}

	public void setProfissionalpsi(ProfissionalPsi profissionalpsi) {
		this.profissionalpsi = profissionalpsi;
	}

	@Override
	public String toString() {
		return "Paciente [idPac=" + idPac + ", nomePac=" + nomePac + ", cpfPac=" + cpfPac + ", whatsappPac="
				+ whatsappPac + ", emailPac=" + emailPac + ", telPac=" + telPac + ", idadePac=" + idadePac
				+ ", generoPac=" + generoPac + ", profissionalpsi=" + profissionalpsi + "]";
	}

	

	
	
}
