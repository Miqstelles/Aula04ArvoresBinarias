public class Main {
    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        ArvoreBinariaBusca arvoreOrdenadaPorNome = new ArvoreBinariaBusca();

        Contato contato1 = new Contato(3, "Maria", "9999-1111");
        Contato contato2 = new Contato(3, "Carlos", "9999-2222");
        Contato contato3 = new Contato(5, "Ana", "9999-3333");
        Contato contato4 = new Contato(4, "Pedro", "9999-4444");
        Contato contato5 = new Contato(2, "Bruno", "9999-5555");
        Contato contato7 = new Contato(523, "Erlan", "9999-4444");
        Contato contato8 = new Contato(23, "Felipe", "9999-4444");

        arvore.inserir(contato1);
        arvore.inserir(contato2);
        arvore.inserir(contato3);
        arvore.inserir(contato4);
        arvore.inserir(contato5);
        arvore.inserir(contato7);
        arvore.inserir(contato8);

        arvoreOrdenadaPorNome.inserirPorNome(contato1);
        arvoreOrdenadaPorNome.inserirPorNome(contato2);
        arvoreOrdenadaPorNome.inserirPorNome(contato3);
        arvoreOrdenadaPorNome.inserirPorNome(contato4);
        arvoreOrdenadaPorNome.inserirPorNome(contato5);
        arvoreOrdenadaPorNome.inserirPorNome(contato7);
        arvoreOrdenadaPorNome.inserirPorNome(contato8);


        System.out.println("\nÁrvore ordenada por Nome:");
        System.out.println(arvore.imprimirInOrdemPorNome());

        arvore.remover(23);

        System.out.println("\nÁrvore ordenada por Nome:");
        System.out.println(arvore.imprimirInOrdemPorNome());
    }
}
