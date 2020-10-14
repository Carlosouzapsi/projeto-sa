package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.sc.senai.projetosa.model.enums.TipoAtendimento;

@Entity
@Table(name="consulta")
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = 8530642283994774442L;
	
	private int idConsulta;
	private TipoAtendimento tipo;
	private Paciente paciente;
	private ProfissionalPsi profissionalPsi;
	private String endereco;
	private String data;
	private String hora;
	
	public Consulta() {
		
	}
	
	@ManyToOne
	@JoinColumn(name="idPac", referencedColumnName = "idPac")
	public Paciente getPaciente() {
		return paciente;
	}
	
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	@ManyToOne
	@JoinColumn(name="idPro", referencedColumnName = "idPro")
	public ProfissionalPsi getProfissionalPsi() {
		return profissionalPsi;
	}

	public void setProfissionalPsi(ProfissionalPsi profissionalPsi) {
		this.profissionalPsi = profissionalPsi;
	}
	
	@Column(name="data", nullable = false)
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Column(name="tipo_atendimento")
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
