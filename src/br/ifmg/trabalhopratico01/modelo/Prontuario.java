package br.ifmg.trabalhopratico01.modelo;

public class Prontuario {
  
	 private int codigo;
	 private String queixa;
	 private String usoMedicamento;
	 private String pessoais;
	 private String anotecoesFinais;
	 private int agenda_codigo;
	 
	 
	 
	public Prontuario(int codigo, String queixa, String usoMedicamento, String pessoais, String anotecoesFinais,
			int agenda_codigo) {
		
		this.codigo = codigo;
		this.queixa = queixa;
		this.usoMedicamento = usoMedicamento;
		this.pessoais = pessoais;
		this.anotecoesFinais = anotecoesFinais;
		this.agenda_codigo = agenda_codigo;
	}

	public Prontuario(){
		this(-1,"","","","",-1);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getQueixa() {
		return queixa;
	}

	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}

	public String getUsoMedicamento() {
		return usoMedicamento;
	}

	public void setUsoMedicamento(String usoMedicamento) {
		this.usoMedicamento = usoMedicamento;
	}

	public String getPessoais() {
		return pessoais;
	}

	public void setPessoais(String pessoais) {
		this.pessoais = pessoais;
	}

	public String getAnotecoesFinais() {
		return anotecoesFinais;
	}

	public void setAnotecoesFinais(String anotecoesFinais) {
		this.anotecoesFinais = anotecoesFinais;
	}

	public int getAgenda_codigo() {
		return agenda_codigo;
	}

	public void setAgenda_codigo(int agenda_codigo) {
		this.agenda_codigo = agenda_codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agenda_codigo;
		result = prime * result + ((anotecoesFinais == null) ? 0 : anotecoesFinais.hashCode());
		result = prime * result + codigo;
		result = prime * result + ((pessoais == null) ? 0 : pessoais.hashCode());
		result = prime * result + ((queixa == null) ? 0 : queixa.hashCode());
		result = prime * result + ((usoMedicamento == null) ? 0 : usoMedicamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prontuario other = (Prontuario) obj;
		if (agenda_codigo != other.agenda_codigo)
			return false;
		if (anotecoesFinais == null) {
			if (other.anotecoesFinais != null)
				return false;
		} else if (!anotecoesFinais.equals(other.anotecoesFinais))
			return false;
		if (codigo != other.codigo)
			return false;
		if (pessoais == null) {
			if (other.pessoais != null)
				return false;
		} else if (!pessoais.equals(other.pessoais))
			return false;
		if (queixa == null) {
			if (other.queixa != null)
				return false;
		} else if (!queixa.equals(other.queixa))
			return false;
		if (usoMedicamento == null) {
			if (other.usoMedicamento != null)
				return false;
		} else if (!usoMedicamento.equals(other.usoMedicamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prontuario [codigo=" + codigo + ", queixa=" + queixa + ", usoMedicamento=" + usoMedicamento
				+ ", pessoais=" + pessoais + ", anotecoesFinais=" + anotecoesFinais + ", agenda_codigo=" + agenda_codigo
				+ "]";
	}
		
	 
	 
}
