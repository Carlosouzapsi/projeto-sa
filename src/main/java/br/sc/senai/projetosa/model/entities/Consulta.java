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
	//Chave estrangeira
	private Paciente paciente;
	//Chave estrangeira
	private ProfissionalPsi profissionalPsi;
	private String endereco;
	private String modalConsulta;
	private Date data;
	
	public Consulta() {
		
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public ProfissionalPsi getProfissionalPsi() {
		return profissionalPsi;
	}

	public void setProfissionalPsi(ProfissionalPsi profissionalPsi) {
		this.profissionalPsi = profissionalPsi;
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

}
