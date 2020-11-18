package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.sc.senai.projetosa.model.enums.PerfilTipo;

@Entity
@Table(name = "paciente", indexes = {@Index(name = "idx_paciente_email", columnList = "email")})
public class Paciente implements Serializable {
	
	private static final long serialVersionUID = 3624675698464100635L;
	
	private int idPac;
	private String nomePac;
	private String cpfPac;
	private String whatsappPac;
	private String telPac;
	private String dataNasc;
	private String generoPac;
	private List<Consulta> consultas;
	private String senha;
	private String email;
	private PerfilTipo tipo;
	
	public Paciente(String email) {
		this.email = email;
	}
	
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
	
	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Paciente() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPac() {
		return idPac;
	}

	public void setIdPac(int idPac) {
		this.idPac = idPac;
	}
	
	@NotBlank(message = "informe um nome.")
	@Column(nullable = false, length = 60)
	public String getNomePac() {
		return nomePac;
	}

	public void setNomePac(String nomePac) {
		this.nomePac = nomePac;
	}
	
	@NotBlank(message = "O número de CPF é obrigatório.")
	@Column(name="cpf_paciente", nullable = false, unique = true)
	public String getCpfPac() {
		return cpfPac;
	}

	public void setCpfPac(String cpfPac) {
		this.cpfPac = cpfPac;
	}
	
	@NotBlank(message = "O número de whatsapp é obrigatório.")
	@Column(name="whatsapp_paciente", nullable = false)
	public String getWhatsappPac() {
		return whatsappPac;
	}

	public void setWhatsappPac(String whatsappPac) {
		this.whatsappPac = whatsappPac;
	}

	public String getTelPac() {
		return telPac;
	}

	public void setTelPac(String telPac) {
		this.telPac = telPac;
	}
	
	@NotBlank(message = "Insira uma data de nascimento.")
	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getGeneroPac() {
		return generoPac;
	}

	public void setGeneroPac(String generoPac) {
		this.generoPac = generoPac;
	}

	@OneToMany(mappedBy="paciente")
	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Paciente [idPac=" + idPac + ", nomePac=" + nomePac + ", cpfPac=" + cpfPac + ", whatsappPac="
				+ whatsappPac + ", telPac=" + telPac + ", dataNasc=" + dataNasc + ", generoPac=" + generoPac
				+ ", consultas=" + consultas + ", senha=" + senha + ", email=" + email + ", tipo=" + tipo + "]";
	}
	
}
