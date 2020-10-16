package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "paciente")
public class Paciente implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 3624675698464100635L;
	
	private int idPac;
	private String nomePac;
	private String cpfPac;
	private String whatsappPac;
	private String emailPac;
	private String telPac;
	private String idadePac;
	private String generoPac;
	private String senhaPac;
	private List<Consulta> consultas;
	
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
	
	public String getSenhaPac() {
		return senhaPac;
	}

	public void setSenhaPac(String senhaPac) {
		this.senhaPac = senhaPac;
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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senhaPac;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.emailPac;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	

		
}
