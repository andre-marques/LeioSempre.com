package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pojo.Autor;

public class DAO_Autor {

    public DAO_Autor(){
        ConnectionDB c = new ConnectionDB();
        con = c.getConnection();
    }
    
    private Connection con;
    
    public boolean cadastrarAutor(Autor a){
        
        String sql = "INSERT INTO autor (nome_autor) VALUES (?)";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            
            stmt.setString(1, a.getNome_autor());            
         
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
        }
        return true;
    }

	public List<Autor> getAll(){
		String sql = "SELECT id_autor, nome_autor FROM autor";
        PreparedStatement stmt;
        List<Autor> lista = new LinkedList<Autor>();
        try {
            stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
            	Autor a = new Autor();
                
            	a.setId_autor(rs.getInt("id_autor"));
            	a.setNome_autor(rs.getString("nome_autor"));
            	
                lista.add(a);
            }
        } catch (SQLException ex) {
        	return null;
        }
        return lista;
	}
	
    public List<Autor> getAutor(String nome_autor){
        String sql = "SELECT id_autor, nome_autor FROM autor WHERE nome_autor LIKE ?";
        PreparedStatement stmt;
        List<Autor> lista = new LinkedList<Autor>();
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setString(1, "%"+nome_autor+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
            	Autor a = new Autor();
            	
            	a.setId_autor(rs.getInt("id_autor"));
            	a.setNome_autor(rs.getString("nome_autor"));
                               
                lista.add(a);
            }
        } catch (SQLException ex) {
           return null;
        }
        return lista;
    }
    
    public Autor getAutor(int id_autor){
        String sql = "SELECT nome_autor FROM autor WHERE id_autor = ?";
        PreparedStatement stmt;
        Autor a = null;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id_autor);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            	a = new Autor();
                a.setId_autor(id_autor);
                a.setNome_autor(rs.getString("nome_autor"));
                
            }
        } catch (SQLException ex) {
        	return null;
        }
        return a;
    }
    
    public boolean alterarAutor(Autor a) {

        String sql = "UPDATE autor SET nome_autor = ? WHERE id_autor = ?";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setString(1, a.getNome_autor());        
            stmt.setInt(2, a.getId_autor());
            
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }      
	
	public boolean deletargenero(int id_autor){
	        
        String sql = "DELETE FROM autor WHERE id_autor = ?";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id_autor);

            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
           
        }
        
        return true;
	  }
}
