package br.ifmg.trabalhopratico01.modelo;

import java.sql.Date;

public class Consulta {

   private int codigo;
   private Date date;
   private String tipoConsulta;
   private String horario;
   private int codMedico;
   private int codPaciente;
   
   public Consulta(int codigo, Date date, String tipoConsulta, String horario, int codMedico, int codPaciente) {
		super();
		this.codigo = codigo;
		this.date = date;
		this.tipoConsulta = tipoConsulta;
		this.horario = horario;
		this.codMedico = codMedico;
		this.codPaciente = codPaciente;
   }

public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getTipoConsulta() {
	return tipoConsulta;
}

public void setTipoConsulta(String tipoConsulta) {
	this.tipoConsulta = tipoConsulta;
}

public String getHorario() {
	return horario;
}

public void setHorario(String horario) {
	this.horario = horario;
}

public int getCodMedico() {
	return codMedico;
}

public void setCodMedico(int codMedico) {
	this.codMedico = codMedico;
}

public int getCodPaciente() {
	return codPaciente;
}

public void setCodPaciente(int codPaciente) {
	this.codPaciente = codPaciente;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + codMedico;
	result = prime * result + codPaciente;
	result = prime * result + codigo;
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((horario == null) ? 0 : horario.hashCode());
	result = prime * result + ((tipoConsulta == null) ? 0 : tipoConsulta.hashCode());
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
	Consulta other = (Consulta) obj;
	if (codMedico != other.codMedico)
		return false;
	if (codPaciente != other.codPaciente)
		return false;
	if (codigo != other.codigo)
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (horario == null) {
		if (other.horario != null)
			return false;
	} else if (!horario.equals(other.horario))
		return false;
	if (tipoConsulta == null) {
		if (other.tipoConsulta != null)
			return false;
	} else if (!tipoConsulta.equals(other.tipoConsulta))
		return false;
	return true;
}

@Override
public String toString() {
	return "Consulta [codigo=" + codigo + ", date=" + date + ", tipoConsulta=" + tipoConsulta + ", horario=" + horario
			+ ", codMedico=" + codMedico + ", codPaciente=" + codPaciente + "]";
}

}