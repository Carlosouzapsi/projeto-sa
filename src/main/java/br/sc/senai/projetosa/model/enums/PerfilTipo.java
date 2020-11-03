package br.sc.senai.projetosa.model.enums;

public enum PerfilTipo {
	ADMIN(0, "ADMIN"), PSICOLOGO(1, "PROFISSIONAL"), PACIENTE(2, "PACIENTE");
	
	private int cod;
	private String desc;

	private PerfilTipo(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

}
