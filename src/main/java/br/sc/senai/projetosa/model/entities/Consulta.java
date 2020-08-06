package br.sc.senai.projetosa.model.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="consulta")
public class Consulta implements Serializable {
	
	private static final long serialVersionUID = 8530642283994774442L;
	
	private Long id;
	
}
