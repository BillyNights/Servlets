package br.ifmg.trabalhopratico01.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifmg.trabalhopratico01.modelo.Produto;

public class ProdutoDAO extends DBConnection {

	private Connection conn;

	public  ProdutoDAO() throws SQLException {
		this.conn = getConnection();
	}

	public ProdutoDAO(Connection conn) throws SQLException {
		this.conn = conn;
	}

	public Boolean insertProduto(Produto produto) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("INSERT INTO produtos (Nome,Status) VALUES (?,?);");
			ps.setString(1, produto.getnome());
			ps.setString(2, produto.getStatus());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean deleteProduto(Produto produto) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;

		try {
			ps = this.conn.prepareStatement("DELETE FROM produtos WHERE codigo = ?");
			ps.setInt(1, produto.getCodigo());
			affectedRows = ps.execute();
		} finally {
			ps.close();
			conn.close();
		}

		return affectedRows;
	}

	public Boolean updateProduto(Produto produto) throws SQLException {

		PreparedStatement ps = null;
		Boolean affectedRows = false;
	    Connection connNEw = getConnection();
		
		try {
			ps = connNEw.prepareStatement("UPDATE produtos SET Status = ? WHERE Codigo = ?;");
			ps.setString(1, produto.getStatus());
		    ps.setInt(2, produto.getCodigo());
		    
			affectedRows = ps.execute();

		} finally {
			ps.close();
			connNEw.close();
		}

		return affectedRows;
	}
	
	public Produto getProduto(int id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT * FROM produtos WHERE codigo = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				return new Produto(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Status"));
			}
			
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}

		return null;
	}
	
	public String getStatus(int id) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = this.conn.prepareStatement("SELECT produtos.status FROM produtos WHERE codigo = ?;");
			ps.setInt(1, id);
			rs = ps.executeQuery();
             
			
			String result = "";
			 
			while(rs.next()){
				result = rs.getString("status");
			} 
			
			return result;
			
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		

	}
		
	public List<Produto> getProdutos() throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Produto> produtos = new ArrayList<Produto>();

		try {
			ps = this.conn.prepareStatement("SELECT * FROM produtos ORDER BY Nome;");
			rs = ps.executeQuery();

			while (rs.next()) {
				produtos.add(new Produto(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Status")));
			}

			return produtos;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}

	public List<Produto> getNomeProdutos(String nome) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Produto> produtos = new ArrayList<Produto>();

		try {
			ps = this.conn.prepareStatement("Select * From produtos WHERE Nome like ? ORDER BY Nome;");
			ps.setString(1, "%" + nome + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				produtos.add(new Produto(rs.getInt("Codigo"), rs.getString("Nome"), rs.getString("Status")));
			}

			return produtos;

		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
	}
	


}
