import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        ArvoreBinariaBusca arvoreOrdenadaPorNome = new ArvoreBinariaBusca();

        // Iniciar o menu
        Menu menu = new Menu(arvore, arvoreOrdenadaPorNome);
        menu.iniciar();  // Exibir o menu e permitir o uso das opções
    }
}