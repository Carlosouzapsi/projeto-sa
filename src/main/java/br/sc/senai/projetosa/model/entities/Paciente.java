package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "paciente")
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
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "id_usuario")
	public Usuario getUsuario() {
		return usuario;
	}
	
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	
}
