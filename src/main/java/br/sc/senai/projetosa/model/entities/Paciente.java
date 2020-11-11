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
	private String idadePac;
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
	
	
	public String getNomePac() {
		return nomePac;
	}

	public void setNomePac(String nomePac) {
		this.nomePac = nomePac;
	}
	
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
				+ whatsappPac + ", telPac=" + telPac + ", idadePac=" + idadePac + ", generoPac=" + generoPac
				+ ", consultas=" + consultas + ", senha=" + senha + ", email=" + email + ", tipo=" + tipo + "]";
	}
	
	
	
	

}
