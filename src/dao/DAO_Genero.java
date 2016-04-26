package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pojo.Genero;

public class DAO_Genero {

    public DAO_Genero(){
        ConnectionDB c = new ConnectionDB();
        con = c.getConnection();
    }
    
    private Connection con;
    
    public boolean cadastrarGenero(Genero g){
        
        String sql = "INSERT INTO genero (nome_genero) VALUES (?)";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            
            stmt.setString(1, g.getNome_genero());            
         
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
        }
        return true;
    }

	public List<Genero> getAll(){
		String sql = "SELECT id_genero, nome_genero FROM genero";
        PreparedStatement stmt;
        List<Genero> lista = new LinkedList<Genero>();
        try {
            stmt = this.con.prepareStatement(sql);
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
	
    public List<Genero> getGenero(String nome_genero){
        String sql = "SELECT id_genero, nome_genero FROM genero WHERE nome_genero LIKE ?";
        PreparedStatement stmt;
        List<Genero> lista = new LinkedList<Genero>();
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setString(1, "%"+nome_genero+"%");
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
    
    public Genero getGenero(int id_genero){
        String sql = "SELECT nome_genero FROM genero WHERE id_genero = ?";
        PreparedStatement stmt;
        Genero g = null;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id_genero);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
            	g = new Genero();
            	g.setId_genero(id_genero);
            	g.setNome_genero(rs.getString("nome_genero"));                
            }
        } catch (SQLException ex) {
        	return null;
        }
        return g;
    }
    
    public boolean alterarGenero(Genero g) {

        String sql = "UPDATE genero SET nome_genero = ? WHERE id_genero = ?";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setString(1, g.getNome_genero());        
            stmt.setInt(2, g.getId_genero());
            
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }      
	
	public boolean deletargenero(int id_genero){
	        
        String sql = "DELETE FROM genero WHERE id_genero = ?";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id_genero);

            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
           
        }
        
        return true;
	}
}
