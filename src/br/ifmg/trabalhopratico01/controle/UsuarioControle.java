package br.ifmg.trabalhopratico01.controle;

import java.sql.SQLException;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Usuario;
import br.ifmg.trabalhopratico01.negocio.UsuarioDAO;

public class UsuarioControle {
	
	 UsuarioDAO usuarioDAO;
	  
	  public UsuarioControle(){
		  
		  try {
			usuarioDAO = new UsuarioDAO();
		} catch (Exception e) {
		     e.printStackTrace();
		}
	  }
	  
	  public Boolean insertUsuario(Usuario usuario) throws SQLException{
		  return usuarioDAO.insertUsuario(usuario);
	  }
	  
	  public Boolean deleteUsuario(Usuario usuario) throws SQLException{
		  return usuarioDAO.deleteUsuario(usuario);
	  }
	  
	  public Boolean updateUsuario(Usuario usuario) throws SQLException{
		  return usuarioDAO.updateUsuario(usuario);
	  }
	  
	  public Usuario getUsuario(int id)  throws SQLException {
		  return usuarioDAO.getUsuario(id);
	  } 
	  
	  public List<Usuario> getUsuarios() throws SQLException {
		  return usuarioDAO.getUsuarios();
	  } 
	  
	  
	  
	  public Usuario login(String login,String senha)throws SQLException {
		  Usuario user = null;
				  
		  UsuarioDAO usuarioDAO = new UsuarioDAO();
		  user = usuarioDAO.getUsuarioByLogin(login);
		  
		  if(user != null)
			   if (senha.equals(user.getSenha()))
		           return user;
		  return null;
	  }
}

