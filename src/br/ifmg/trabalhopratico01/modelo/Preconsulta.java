package br.ifmg.trabalhopratico01.modelo;

public class Preconsulta {


	private int codigo;
	private String idade;
	private String peso;
	private String altura;
	private String temperatura;
	private String sexo;
	private String pressao;
	private int agenda_codigo;
	
	

	
	public Preconsulta(int codigo, String idade, String peso, String altura, String temperatura, String sexo,
			String pressao, int agenda_codigo) {
		super();
		this.codigo = codigo;
		this.idade = idade;
		this.peso = peso;
		this.altura = altura;
		this.temperatura = temperatura;
		this.sexo = sexo;
		this.pressao = pressao;
		this.agenda_codigo = agenda_codigo;
	}

	public Preconsulta(){
		
		this(-1,"","","","","","",-1);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPressao() {
		return pressao;
	}
	public void setPressao(String pressao) {
		this.pressao = pressao;
	}
	public int getAgenda_codigo() {
		return agenda_codigo;
	}
	public void setAgenda_codigo(int agenda_codigo) {
		this.agenda_codigo = agenda_codigo;
	}
	
	
	
}
