package br.ifmg.trabalhopratico01.modelo;


public class TADListaPacientesHoje {
   
	private int codigo;
    private String nome;
    private String horario;
    private String codAgenda;
   
    public TADListaPacientesHoje(int codigo, String nome, String horario, String codAgenda) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.horario = horario;
		this.codAgenda = codAgenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCodAgenda() {
		return codAgenda;
	}

	public void setCodAgenda(String codAgenda) {
		this.codAgenda = codAgenda;
	}
    
}
