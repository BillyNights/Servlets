package br.ifmg.trabalhopratico01.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifmg.trabalhopratico01.controle.PacienteControle;
import br.ifmg.trabalhopratico01.modelo.Paciente;



public class AdicionaPacienteServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public boolean validaCpf(String strCpf) {   ///
		// formato XXX.XXX.XXX-XX  
        if (!strCpf.substring(0, 1).equals("")){
            try {
                int d1, d2;
                int digito1, digito2, resto;
                int digitoCPF;
                String nDigResult;
                strCpf = strCpf.replace('.', ' ');
                strCpf = strCpf.replace('-', ' ');
                strCpf = strCpf.replaceAll(" ", "");
                d1 = d2 = 0;
                digito1 = digito2 = resto = 0;

                for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
                    digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();

                    //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
                    d1 = d1 + (11 - nCount) * digitoCPF;

                    //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
                    d2 = d2 + (12 - nCount) * digitoCPF;
                };

                //Primeiro resto da divisão por 11.  
                resto = (d1 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
                if (resto < 2) {
                    digito1 = 0;
                } else {
                    digito1 = 11 - resto;
                }

                d2 += 2 * digito1;

                //Segundo resto da divisão por 11.  
                resto = (d2 % 11);

                //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
                if (resto < 2) {
                    digito2 = 0;
                } else {
                    digito2 = 11 - resto;
                }

                //Digito verificador do CPF que está sendo validado.  
                String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

                //Concatenando o primeiro resto com o segundo.  
                nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

                //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
                return nDigVerific.equals(nDigResult);
            } catch (Exception e) {
                System.err.println("Erro !" + e);
                return false;
            }
        } else {
            return false;
        }
    }
	
	
	
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 PacienteControle pac = new PacienteControle();
	 
	 
	 String cpf = req.getParameter("CPF");
	  
	 if(validaCpf(cpf)){
			 try {
				 
			 Boolean erro = pac.insertPaciente(new Paciente(-1, req.getParameter("nome"), req.getParameter("CPF"), req.getParameter("RG"), req.getParameter("endereco"),req.getParameter("telefone")));
				
			 if(!erro){
				  resp.setContentType("text/html");
			      resp.sendRedirect("listadepacientes.jsp?buscar=todos");
			 }
			 
	          else resp.sendRedirect("erroBanco.jsp");
	 
           	} catch (Exception e) {
		         e.printStackTrace();
        		resp.sendRedirect("erroBanco.jsp");
	         }
	    
	 } else  resp.sendRedirect("formPaciente.jsp?erro=CPF Invalido");
  }

}
