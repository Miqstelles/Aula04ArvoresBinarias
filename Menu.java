import java.util.Scanner;

public class Menu {

    private int opcao;
    private Scanner scanner;
    private ArvoreBinariaBusca arvore;
    private ArvoreBinariaBusca arvoreOrdenadaPorNome;

    public Menu(ArvoreBinariaBusca arvore, ArvoreBinariaBusca arvoreOrdenadaPorNome) {
        this.arvore = arvore;
        this.arvoreOrdenadaPorNome = arvoreOrdenadaPorNome;
        this.opcao = 0;
        this.scanner = new Scanner(System.in);
    }

    private void exibirMenu() {
        System.out.println("\n1 - Inserir novo contato");
        System.out.println("2 - Remover contato - (ID)");
        System.out.println("3 - Buscar contato - (ID)");
        System.out.println("4 - Listar contatos em ordem (alfabética)");
        System.out.println("5 - Importar CSV");
        System.out.println("6 - Mostrar estatísticas");
        System.out.println("7 - Sair do programa");
    }

    private void lerOpcao() {
        System.out.print("Escolha uma opção: ");
        this.opcao = scanner.nextInt();
    }

    private Contato lerContato() {
        System.out.print("Digite o ID do contato: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome do contato: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o telefone do contato: ");
        String telefone = scanner.nextLine();

        return new Contato(id, nome, telefone);
    }

    private int lerContatoPorID() {
        System.out.print("Digite o ID do contato: ");
        int id = scanner.nextInt();
        return id;
    }

    private void executarOpcao() {
        switch (this.opcao) {
            case 1:
                Contato novoContato = lerContato();
                this.arvore.inserir(novoContato);
                this.arvoreOrdenadaPorNome.inserirPorNome(novoContato);
                System.out.println("Contato inserido com sucesso!");
                break;
            case 2:
                int id = lerContatoPorID();
                boolean existeContato = this.arvore.buscar(id) != null;
                if (existeContato) {
                    this.arvore.remover(id);
                    this.arvoreOrdenadaPorNome.remover(id);
                    System.out.println("Contato removido com sucesso!");
                } else {
                    System.out.println("Contato não encontrado na árvore.");
                }
                break;
            case 3:
                int idBuscar = lerContatoPorID();
                if (this.arvore.buscar(idBuscar) != null) {
                    System.out.println("Contato encontrado na árvore!\n");
                    No noContato = this.arvore.buscar(idBuscar);
                    System.out.println(noContato.contato);
                } else {
                    System.out.println("Contato não encontrado na árvore.");
                }
                break;
            case 4:
                System.out.println("\nÁrvore ordenada por Nome:");
                System.out.println(arvore.imprimirInOrdemPorNome());
                break;
            case 5:
                String caminhoArquivo = System.getProperty("user.dir") + "/assets/contatos.csv";
                int quantidadeContatos = 50000;
                GeradorCSV.gerarArquivoCSV(caminhoArquivo, quantidadeContatos);
                ImportadorCSV.importarCSV(caminhoArquivo, this.arvore, this.arvoreOrdenadaPorNome);
                break;
            case 6:
                System.out.println("Número total de contatos cadastrados: " + arvore.contarNos());
                System.out.println("Altura da árvore: " + arvore.calcularAlturaArvore());
                System.out.println("Número de nós folha: " + arvore.contarNosFolha());
                break;
            case 7:
                System.out.println("Saindo do programa...");
                this.scanner.close();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void iniciar() {
        do {
            exibirMenu();
            lerOpcao();
            executarOpcao();
        } while (this.opcao != 7);
    }
}
