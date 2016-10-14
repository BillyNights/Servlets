package br.ifmg.trabalhopratico01.modelo;

public class TADListaConsulta {

   int codigo;
   String Medico;
   String Paciente;
 
   public TADListaConsulta(int codigo, String medico, String paciente) {
		super();
		this.codigo = codigo;
		Medico = medico;
		Paciente = paciente;
   }

   public TADListaConsulta(){
	   
   }
   
   public int getCodigo() {
	   return codigo;
   }

   public void setCodigo(int codigo) {
	   this.codigo = codigo;
   }

   public String getMedico() {
	   return Medico;
   }

   public void setMedico(String medico) {
	   Medico = medico;
   }

   public String getPaciente() {
	   return Paciente;
   }

   public void setPaciente(String paciente) {
   	   Paciente = paciente;
   }   
     
}
