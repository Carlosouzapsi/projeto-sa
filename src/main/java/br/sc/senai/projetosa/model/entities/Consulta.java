package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.sc.senai.projetosa.model.enums.TipoAtendimento;

@Entity
@Table(name="consulta")
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = 8530642283994774442L;
	
	private int idConsulta;
	private TipoAtendimento tipo;
	private int idPro;
	private int idPac;
	private String endereco;
	private String modalConsulta;
	private Date data;
	
	public Consulta() {
		
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="tipo_atendimento", nullable = false)
	public TipoAtendimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtendimento tipo) {
		this.tipo = tipo;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	
	public int getIdPro() {
		return idPro;
	}
	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}
	public int getIdPac() {
		return idPac;
	}
	public void setIdPac(int idPac) {
		this.idPac = idPac;
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

	@Override
	public String toString() {
		return "Consulta [idConsulta=" + idConsulta + ", tipo=" + tipo + ", idPro=" + idPro + ", idPac=" + idPac
				+ ", endereco=" + endereco + ", modalConsulta=" + modalConsulta + ", data=" + data + "]";
	}
	
}
