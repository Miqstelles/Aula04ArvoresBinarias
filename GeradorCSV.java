import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorCSV {

    public static void gerarArquivoCSV(String caminhoArquivo, int quantidadeContatos) {
        try {
            // Criar a pasta 'assets' dentro de 'Aula04ArvoresBinarias' se não existir
            File pasta = new File( System.getProperty("user.dir") + "/assets/contatos.csv");

            if (!pasta.exists()) {
                pasta.mkdir();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
                writer.write("Codigo,Nome,Telefone\n");  // Cabeçalho do CSV

                Random random = new Random();

                for (int i = 0; i < quantidadeContatos; i++) {
                    int codigo = random.nextInt(900000) + 100000;  // Código de 6 dígitos
                    String nome = "Contato" + codigo;  // Nome fictício
                    String telefone = "(11) 9" + (random.nextInt(90000000) + 10000000);  // Telefone aleatório

                    writer.write(codigo + "," + nome + "," + telefone + "\n");
                }

                System.out.println("Arquivo CSV gerado com sucesso em: " + caminhoArquivo);
            }
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String arquivoCSV = System.getProperty("user.dir") + "/assets/contatos.csv"; // Caminho do arquivo CSV
        int quantidadeContatos = 50000;  // Total de contatos a serem gerados

        gerarArquivoCSV(arquivoCSV, quantidadeContatos);
    }
}
