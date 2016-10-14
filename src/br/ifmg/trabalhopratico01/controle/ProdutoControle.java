package br.ifmg.trabalhopratico01.controle;

import java.sql.SQLException;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Produto;
import br.ifmg.trabalhopratico01.negocio.ProdutoDAO;


public class ProdutoControle {

	
	 ProdutoDAO produtoDAO;
	  
	  public ProdutoControle(){
		  
		  try {
			produtoDAO = new ProdutoDAO();
		} catch (Exception e) {
		     e.printStackTrace();
		}
	  }
	  
	  public Boolean insertProduto(Produto produto) throws SQLException{
		  return produtoDAO.insertProduto(produto);
	  }
	  
	  public Boolean deleteProduto(Produto produto) throws SQLException{
		  return produtoDAO.deleteProduto(produto);
	  }
	  
	  public Boolean updateProduto(Produto produto) throws SQLException{
		  return produtoDAO.updateProduto(produto);
	  }
	  
	  
	  public Produto getProduto(int id)  throws SQLException {
		  return produtoDAO.getProduto(id);
	  } 
	  
	  
	  public String getStatus(int id)  throws SQLException {
		  return produtoDAO.getStatus(id);
	  } 

	  
	  public List<Produto> getProdutos() throws SQLException {
		  return produtoDAO.getProdutos();
	  } 
	  
	  public List<Produto> getNomeProdutos(String nome) throws SQLException {
		  return produtoDAO.getNomeProdutos(nome);
	  } 
}
