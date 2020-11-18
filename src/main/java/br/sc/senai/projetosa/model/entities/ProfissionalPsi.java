package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.sc.senai.projetosa.model.enums.PerfilTipo;

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
	private String senha;
	private String email;
	private PerfilTipo tipo;
	
	
	public PerfilTipo getTipo() {
		return tipo;
	}

	public void setTipo(PerfilTipo tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	@NotBlank(message="Informe o nome.")
	@Column(name = "nome_pro", nullable = false, unique = true)
	public String getNomePro() {
		return nomePro;
	}

	public void setNomePro(String nomePro) {
		this.nomePro = nomePro;
	}
	
	@NotBlank(message="O número de CRP é obrigatório.")
	@Column(name="crp", nullable = false)
	public String getCrp() {
		return crp;
	}
	
	public void setCrp(String crp) {
		this.crp = crp;
	}
	
	@NotBlank(message="O número de CPF é obrigatório.")
	@Column(name="cpf_profissional", nullable = false)
	public String getCpfPro() {
		return cpfPro;
	}
	public void setCpfPro(String cpfPro) {
		this.cpfPro = cpfPro;
	}
	
	@NotBlank(message="O número de whatsapp")
	@Column(name="whatsapp", nullable = false)
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
