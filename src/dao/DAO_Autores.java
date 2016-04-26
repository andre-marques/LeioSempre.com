package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pojo.Autor;

public class DAO_Autores {
	
    public DAO_Autores(){
        ConnectionDB c = new ConnectionDB();
        con = c.getConnection();
    }
    
    private Connection con;
	
	public List<Autor> getAutoresLivro(int isbn){
		String sql = "SELECT id_autor, nome_autor FROM autores INNER JOIN autor ON autor.id_autor = autores.autor_id_autor WHERE livro_isbn = ?";
        PreparedStatement stmt;
        List<Autor> lista = new LinkedList<Autor>();
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, isbn);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
            	Autor a = new Autor();
                
            	a.setId_autor(rs.getInt("id_autor"));
            	a.setNome_autor(rs.getString("nome_genero"));
            	
                lista.add(a);
            }
        } catch (SQLException ex) {
        	return null;
        }
        return lista;
	}
	
    public boolean cadastrarAutores(int isbn, Autor a){
        
        String sql = "INSERT INTO autores (livro_isbn, autor_id_autor) VALUES (?,?)";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            
            stmt.setInt(1, isbn);
            stmt.setInt(2, a.getId_autor());
                   
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
        }
        return true;
    }
    
    public boolean deletarAutores(int isbn){
        
        String sql = "DELETE FROM autores WHERE livro_isbn = ?";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, isbn);

            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
           
        }
        
        return true;
	}

}
