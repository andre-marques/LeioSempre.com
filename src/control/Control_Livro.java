package control;

import java.util.List;

import dao.DAO_Livro;
import pojo.Livro;

/**
 *
 * @author André Marques
 */
public class Control_Livro {
	
	private DAO_Livro dao_Livro;
	
	public Control_Livro(){
		dao_Livro = new DAO_Livro();
	}
	
    public boolean cadastrarLivro(int isbn, String titulo, String editora, int qtd_livro){

    	Livro l = new Livro(isbn, titulo, editora, qtd_livro);
		
    	if(dao_Livro.cadastrarLivro(l)){
			System.out.println("Livro cadastrado como sucesso.");
                        return true;
		}else{
			System.out.println("Erro ao salvar Livro.");
                        return false;
		}
		
    }
    
    public List<Livro> getLivros(){
    	
		List<Livro> livros = dao_Livro.getAll();
		
		//this.imprimirLivros(livros);
		
		return livros;

   
    }
    
    public List<Livro> pesquisaLivro(String titulo){

		List<Livro> livros = dao_Livro.getPorNomeLivro(titulo);
		
		//this.imprimirLivros(livros);
		
		return livros;
		
    }
    
    public boolean alterarLivro(int isbn, String titulo, String editora, int qtd_livro){
    	
    	Livro l = new Livro(isbn, titulo, editora, qtd_livro);
    	
    	if(dao_Livro.alterarLivro(l)){
			System.out.println("Livro alterado como sucesso.");
                        return true;
		}else{
			System.out.println("Erro ao alterar Livro.");
                        return false;
		}
    }
    

    private void imprimirLivros(List<Livro> livros){
    	System.out.println("Lista de Livros");
		
		for (Livro livro : livros) {
			System.out.println("Isbn:"+ livro.getIsbn() +" T�tulo:"+ livro.getTitulo() +" Editora:"+ livro.getEditora() +" QTD:"+ livro.getQtd_livro());
		}
    }
    
}
