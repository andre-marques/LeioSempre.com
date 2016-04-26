package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import pojo.Livro;

public class DAO_Livro {

    public DAO_Livro(){
        ConnectionDB c = new ConnectionDB();
        con = c.getConnection();
    }
    
    private Connection con;
    
    public boolean cadastrarLivro(Livro l){
        
        String sql = "INSERT INTO livro (isbn, titulo, editora, qtd_livro) VALUES (?,?,?,?)";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, l.getIsbn());
            stmt.setString(2, l.getTitulo());
            stmt.setString(3, l.getEditora());
            stmt.setInt(4, l.getQtd_livro());
         
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
           return false;
        }
        return true;
    }

	public List<Livro> getAll(){
		String sql = "SELECT isbn, titulo, editora, qtd_livro FROM livro";
        PreparedStatement stmt;
        List<Livro> lista = new LinkedList<Livro>();
        try {
            stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
            	Livro l = new Livro();
                
            	l.setIsbn(rs.getInt("isbn"));
            	l.setTitulo(rs.getString("titulo"));
            	l.setEditora(rs.getString("editora"));
            	l.setQtd_livro(rs.getInt("qtd_livro"));
                
                
                lista.add(l);
            }
        } catch (SQLException ex) {
        	return null;
        }
        return lista;
	}
	
    public List<Livro> getPorNomeLivro(String titulo){
        String sql = "SELECT isbn, titulo, editora, qtd_livro FROM livro WHERE titulo LIKE ?";
        PreparedStatement stmt;
        List<Livro> lista = new LinkedList<Livro>();
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setString(1, "%"+titulo+"%");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
            	Livro l = new Livro();
            	
            	l.setIsbn(rs.getInt("isbn"));
            	l.setTitulo(rs.getString("titulo"));
            	l.setEditora(rs.getString("editora"));
            	l.setQtd_livro(rs.getInt("qtd_livro"));
                           
                lista.add(l);
            }
        } catch (SQLException ex) {
           return null;
        }
        return lista;
    }
    
    public boolean alterarLivro(Livro l) {

        String sql = "UPDATE livro SET  titulo = ?, editora = ?, qtd_livro = ? WHERE isbn = ?";

        PreparedStatement stmt;
        try {
            stmt = this.con.prepareStatement(sql);
            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getEditora());
            stmt.setInt(3, l.getQtd_livro());
            stmt.setInt(4, l.getIsbn());
            
            int i = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
        
	
}
