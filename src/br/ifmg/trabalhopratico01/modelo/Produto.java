package br.ifmg.trabalhopratico01.modelo;

public class Produto {
  

	private int codigo;
	private String nome;
	private String status;
	
	
	public Produto(int codigo, String nome, String status) {
		this.codigo = codigo;
		this.nome = nome;
		this.status = status;
	}

    public Produto(){
      this(-1,"","");
    }
	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getnome() {
		return nome;
	}


	public void setnome(String nome) {
		this.nome = nome;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", status=" + status + "]";
	}



}
