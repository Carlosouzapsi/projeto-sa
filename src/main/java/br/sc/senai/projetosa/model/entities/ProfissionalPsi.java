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
	private String crp;
	private String cpfPro;
	private String whatsappPro;
	private String emailPro;
	private String telPro;
	private String generoPro;
	private List<Paciente> pacientes;
	private List<Consulta> consulta;
	
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
	
	@Column(name="crp", nullable = false)
	public String getCrp() {
		return crp;
	}
	
	//verificar as padronizações existentes de crp...
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
	
	//verificar anotações de validação de email..
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
	
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	
	@OneToMany(mappedBy = "paciente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	@OneToMany(mappedBy = "consulta", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProfissionalPsi [idPro=" + idPro + ", crp=" + crp + ", cpfPro=" + cpfPro + ", whatsappPro="
				+ whatsappPro + ", emailPro=" + emailPro + ", telPro=" + telPro + ", generoPro=" + generoPro
				+ ", pacientes=" + pacientes + ", consulta=" + consulta + "]";
	}

}
