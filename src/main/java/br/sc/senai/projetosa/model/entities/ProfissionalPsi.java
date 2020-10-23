package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	private String telPro;
	private String generoPro;
	private List<Paciente> Pacientes;
	private Usuario usuario;
	
	
	@OneToOne
	@JoinColumn(name="id_usuario")
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToMany
	public List<Paciente> getPacientes() {
		return Pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		Pacientes = pacientes;
	}

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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
