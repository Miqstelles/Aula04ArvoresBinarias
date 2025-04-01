import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ImportadorCSV {

    // Método para importar os contatos da árvore
    public static void importarCSV(String caminhoArquivo, ArvoreBinariaBusca arvore, ArvoreBinariaBusca arvoreOrdenadaPorNome) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            br.readLine();  // Pular o cabeçalho do CSV

            // Ler linha por linha do CSV
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int codigo = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String telefone = dados[2];

                Contato contato = new Contato(codigo, nome, telefone);

                // Inserir o contato nas duas árvores
                arvore.inserir(contato);  // Inserir na árvore principal (baseado no código)
                arvoreOrdenadaPorNome.inserirPorNome(contato);  // Inserir na árvore ordenada (baseado no nome)
            }

            System.out.println("Contatos importados com sucesso do CSV!");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}
