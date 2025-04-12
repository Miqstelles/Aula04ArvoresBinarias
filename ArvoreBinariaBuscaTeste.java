import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArvoreBinariaBuscaTeste {
    private ArvoreBinariaBusca arvore;

    @Before
    public void configurar() {
        arvore = new ArvoreBinariaBusca();
    }

    @Test
    public void testarEstaVaziaArvoreNova() {
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testarImprimirArvoreTexto() {
        
        arvore.inserir(new Contato(15, "Contato 15", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(16, "Contato 16", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(20, "Contato 20", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(23, "Contato 23", "(11) 9 9999-9996"));
        arvore.inserir(new Contato(18, "Contato 18", "(11) 9 9999-9995"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9994"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9993"));
        arvore.inserir(new Contato(12, "Contato 12", "(11) 9 9999-9992"));
        arvore.inserir(new Contato(13, "Contato 13", "(11) 9 9999-9991"));
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9990"));
        arvore.inserir(new Contato(6, "Contato 6", "(11) 9 9999-9989"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9988"));
        arvore.imprimirArvoreTexto();
    }

    @Test
    public void testarEstaVaziaAposInsercao() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        assertFalse(arvore.estaVazia());
    }

    @Test
    public void testarEstaVaziaAposRemocaoUnicoNo() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        arvore.remover(10);
        assertTrue(arvore.estaVazia());
    }

    @Test
    public void testarInserirEBuscarUnicoNo() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        assertTrue(arvore.existe(5));
        assertFalse(arvore.existe(10));
    }

    @Test
    public void testarInserirEBuscarMultiplosNos() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9997"));
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(7));
        assertFalse(arvore.existe(4));
    }

    @Test
    public void testarInserirDuplicado() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999")); // Não deve alterar a arvore
        assertEquals(1, arvore.contarNos());
        assertTrue(arvore.existe(5));
    }

    @Test
    public void testarBuscarEmArvoreVazia() {
        assertFalse(arvore.existe(1));
    }

    @Test
    public void testarRemoverNoFolha() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.remover(3);
        assertTrue(arvore.existe(5));
        assertFalse(arvore.existe(3));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComUmFilho() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(4, "Contato 4", "(11) 9 9999-9997"));
        arvore.remover(3);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(4));
        assertFalse(arvore.existe(3));
        assertEquals(2, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComDoisFilhos() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(6, "Contato 6", "(11) 9 9999-9996"));
        arvore.inserir(new Contato(8, "Contato 8", "(11) 9 9999-9995"));
        arvore.remover(7);
        assertTrue(arvore.existe(5));
        assertTrue(arvore.existe(3));
        assertTrue(arvore.existe(6));
        assertTrue(arvore.existe(8));
        assertFalse(arvore.existe(7));
        assertEquals(4, arvore.contarNos());
    }

    @Test
    public void testarRemoverNoComDoisFilhosSlide() {
        arvore.inserir(new Contato(15, "Contato 15", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(16, "Contato 16", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(20, "Contato 20", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(23, "Contato 23", "(11) 9 9999-9996"));
        arvore.inserir(new Contato(18, "Contato 18", "(11) 9 9999-9995"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9994"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9993"));
        arvore.inserir(new Contato(12, "Contato 12", "(11) 9 9999-9992"));
        arvore.inserir(new Contato(13, "Contato 13", "(11) 9 9999-9991"));
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9990"));
        arvore.inserir(new Contato(6, "Contato 6", "(11) 9 9999-9989"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9988"));

        arvore.remover(5);
        assertFalse(arvore.existe(5));
        assertTrue(arvore.existe(6));
        assertTrue(arvore.existe(7));
        assertEquals(11, arvore.contarNos());
        assertEquals(6, arvore.raiz.esquerdo.contato.getId());
    }

    @Test
    public void testarRemoverRaizUnica() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.remover(5);
        assertFalse(arvore.existe(5));
        assertEquals(0, arvore.contarNos());
    }

    @Test
    public void testarRemoverNaoExistente() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.remover(10);
        assertTrue(arvore.existe(5));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarContarNosArvoreVazia() {
        assertEquals(0, arvore.contarNos());
    }

    @Test
    public void testarContarNosUmNo() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testarContarNosArvoreGrande() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(6, "Contato 6", "(11) 9 9999-9996"));
        arvore.inserir(new Contato(8, "Contato 8", "(11) 9 9999-9995"));
        assertEquals(5, arvore.contarNos());
    }

    @Test
    public void testarCalcularAlturaArvoreVazia() {
        assertEquals(-1, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreUmNo() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        assertEquals(0, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreBalanceada() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9997"));
        assertEquals(1, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaArvoreDesbalanceada() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(1, "Contato 1", "(11) 9 9999-9996"));
        assertEquals(3, arvore.calcularAlturaArvore());
    }

    @Test
    public void testarCalcularAlturaNoInexistente() {
        assertEquals(-1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularAlturaNoRaiz() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9997"));
        assertEquals(1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularAlturaNoFolha() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        assertEquals(0, arvore.calcularAlturaNo(3));
    }

    @Test
    public void testarCalcularAlturaNoIntermediario() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9996"));
        assertEquals(1, arvore.calcularAlturaNo(5));
    }

    @Test
    public void testarCalcularProfundidadeArvoreVazia() {
        assertEquals(-1, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeArvoreUmNo() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        assertEquals(0, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeArvoreDesbalanceada() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(1, "Contato 1", "(11) 9 9999-9996"));
        assertEquals(3, arvore.calcularProfundidadeArvore());
    }

    @Test
    public void testarCalcularProfundidadeNoInexistente() {
        assertEquals(-1, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarCalcularProfundidadeNoRaiz() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        assertEquals(0, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarCalcularProfundidadeNoFolha() {
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9997"));
        assertEquals(1, arvore.calcularProfundidadeNo(3));
    }

    @Test
    public void testarCalcularProfundidadeNoIntermediario() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9997"));
        assertEquals(1, arvore.calcularProfundidadeNo(5));
    }

    @Test
    public void testarImprimirPreOrdemArvoreVazia() {
        assertEquals("[]", arvore.imprimirPreOrdem());
    }

    @Test
    public void testarImprimirPreOrdemUmNo() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        String esperado = "[ID: 10, " + 
                        "Nome: CONTATO 10, " + 
                        "Telefone: (11) 9 9999-9999]";
        assertEquals(esperado, arvore.imprimirPreOrdem());
    }
    
    @Test
    public void testarImprimirPreOrdem() {
        arvore.inserir(new Contato(10, "Contato 10", "(11) 9 9999-9999"));
        arvore.inserir(new Contato(5, "Contato 5", "(11) 9 9999-9998"));
        arvore.inserir(new Contato(15, "Contato 15", "(11) 9 9999-9997"));
        arvore.inserir(new Contato(3, "Contato 3", "(11) 9 9999-9996"));
        arvore.inserir(new Contato(7, "Contato 7", "(11) 9 9999-9995"));
        String esperado = "[ID: 10, "+
                            "Nome: CONTATO 10, "+
                            "Telefone: (11) 9 9999-9999, "+
                            "ID: 5, "+
                            "Nome: CONTATO 5, "+
                            "Telefone: (11) 9 9999-9998, "+
                            "ID: 3, "+
                            "Nome: CONTATO 3, "+
                            "Telefone: (11) 9 9999-9996, "+
                            "ID: 7, "+
                            "Nome: CONTATO 7, "+
                            "Telefone: (11) 9 9999-9995, "+
                            "ID: 15, "+
                            "Nome: CONTATO 15, "+
                            "Telefone: (11) 9 9999-9997]";



        assertEquals(esperado, arvore.imprimirPreOrdem());
        }


    @Test
    public void testContarNosFolha() {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        arvore.inserir(new Contato(50, "Ana", "1111"));
        arvore.inserir(new Contato(30, "Bruno", "2222"));
        arvore.inserir(new Contato(70, "Carlos", "3333"));
        arvore.inserir(new Contato(20, "Daniela", "4444"));
        arvore.inserir(new Contato(40, "Eduardo", "5555"));
        arvore.inserir(new Contato(60, "Fernanda", "6666"));
        arvore.inserir(new Contato(80, "Gabriel", "7777"));

        int folhas = arvore.contarNosFolha();
        assertEquals(4, folhas);
    }
}