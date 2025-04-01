public class Contato {
    private int id;
    private String nome;
    private String telefone;

    public Contato(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome.toUpperCase();
        this.telefone = formatarTelefone(telefone);
    }

    public int getId() {
        return this.id;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        // Aqui você pode garantir que o telefone seja formatado ao ser setado
        this.telefone = formatarTelefone(telefone);
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\n" + "NOME: " + this.nome.toUpperCase() + "\n" + "TELEFONE: " + this.telefone;
    }

    // Método para formatar o telefone no formato (XX) X XXXX-XXXX
    private String formatarTelefone(String telefone) {
        // Verifica se o telefone tem o tamanho correto (11 dígitos)
        if (telefone.length() == 11) {
            // Formata o telefone com a máscara (XX) X XXXX-XXXX
            return String.format("(%s) %s %s-%s", 
                    telefone.substring(0, 2), // Código de área
                    telefone.substring(2, 3), // Primeiro dígito do número (sem hífen)
                    telefone.substring(3, 7), // Quatro primeiros números do telefone
                    telefone.substring(7));   // Últimos quatro números do telefone
        }
        return telefone; // Se o telefone não tiver 11 dígitos, retorna ele sem formatação
    }
}
