/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import pojo.Livro;

/**
 *
 * @author André Marques
 */
public class Control_LivroTest {
    
    public Control_LivroTest() {
    }

    /**
     * Test of cadastrarLivro method, of class Control_Livro.
     */
    @Test
    public void testCadastrarLivro() {
        System.out.println("cadastrarLivro");
        int isbn = 24;
        String titulo = "JAVAX-C";
        String editora = "3d";
        int qtd_livro = 5;
        Control_Livro instance = new Control_Livro();
        assertEquals(true, instance.cadastrarLivro(isbn, titulo, editora, qtd_livro));
        
    }    
    
    /**
     * Test of alterarLivro method, of class Control_Livro.
     */
    @Test
    public void testAlterarLivro() {
        System.out.println("alterarLivro");
        int isbn = 24;
        String titulo = "JAVAX-BCC";
        String editora = "3ed";
        int qtd_livro = 7;
        Control_Livro instance = new Control_Livro();
        assertEquals(true, instance.alterarLivro(isbn, titulo, editora, qtd_livro));
    }
    
    /**
     * Test of getLivros method, of class Control_Livro.
     */
    @Test
    public void testGetLivros() {
        System.out.println("getLivros");
        Control_Livro instance = new Control_Livro();
        List<Livro> expResult = new LinkedList<Livro>();
        Livro l = new Livro(23,"JAVAX-B", "3d", 5);
        expResult.add(l);
        
        List<Livro> result = instance.getLivros();
        assertNotNull(result);
        
        
        
    }    
    

    /**
     * Test of pesquisaLivro method, of class Control_Livro.
     */
    @Test
    public void testPesquisaLivro() {
        System.out.println("pesquisaLivro");
        String titulo = "JAVAX";
        Control_Livro instance = new Control_Livro();
        Livro l = new Livro(23,"JAVAX", "3d", 5);
        List<Livro> expResult = new LinkedList<Livro>();
        expResult.add(l);
        List<Livro> result = instance.pesquisaLivro(titulo);
        assertNotNull(result);
             
    }


    
}
