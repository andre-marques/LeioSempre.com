package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pojo.Genero;

public class DAO_Generos {

    public DAO_Generos(){
        ConnectionDB c = new ConnectionDB();
        con = c.getConnection();
    }
    
    private Connection con;
	
	public List<Genero> getGenerosLivro(int isbn){
		String sql = "SELECT id_genero, nome_genero FROM generos INNER JOIN genero ON genero.id_genero = generos.genero_id_genero WHERE livro_isbn = ?";
        PreparedStatement stmt;
        List<Genero> lista = new LinkedList<Genero>();
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, isbn);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
            	Genero g = new Genero();
                
            	g.setId_genero(rs.getInt("id_genero"));
            	g.setNome_genero(rs.getString("nome_genero"));
            	
                lista.add(g);
            }
        } catch (SQLException ex) {
        	return null;
        }
        return lista;
	}
	
    public boolean cadastrarGeneros(int isbn, Genero g){
        
        String sql = "INSERT INTO generos (livro_isbn, genero_id_genero) VALUES (?,?)";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            
            stmt.setInt(1, isbn);
            stmt.setInt(2, g.getId_genero());
                   
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
        }
        return true;
    }
    
	public boolean deletarGeneros(int isbn){
        
        String sql = "DELETE FROM generos WHERE livro_isbn = ?";

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
