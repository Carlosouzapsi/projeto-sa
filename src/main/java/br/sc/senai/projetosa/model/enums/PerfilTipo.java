package br.sc.senai.projetosa.model.enums;

public enum PerfilTipo {
	ADMIN(1, "ADMIN"), PSICOLOGO(2, "PROFISSIONAL"), PACIENTE(3, "PACIENTE");
	
	private Long cod;
	private String desc;

	private PerfilTipo(long cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public long getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

}
