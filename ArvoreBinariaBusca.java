public class ArvoreBinariaBusca {

    private static final int ESPACO_IMPRESSAO = 4;
    No raiz;

    ArvoreBinariaBusca arvorePorNome = new ArvoreBinariaBusca();

    public ArvoreBinariaBusca() {
        this.raiz = null;
    }

    public void inserir(Contato novoContato) {
        if (estaVazia()) {
            raiz = new No(novoContato);
            return;
        }

        No atual = raiz;
        No pai = null;

        No atualPorNome = arvorePorNome.raiz;
        No paiPorNome = null;

        while (atual != null) {
            pai = atual;
            if (novoContato.getId() < atual.contato.getId()) {
                atual = atual.esquerdo;
            } else if (novoContato.getId() > atual.contato.getId()) {
                atual = atual.direito;
            } else {
                return; // Valor já existe, ignora
            }
        }

        
        while (atualPorNome != null) {
            paiPorNome = atualPorNome;
            if (novoContato.getNome().compareTo(atual.contato.getNome()) < 0) {
                atualPorNome = atual.esquerdo;
            } else if (novoContato.getNome().compareTo(atual.contato.getNome()) > 0) {
                atualPorNome = atual.direito;
            }
        }

        // Após encontrar a posição (atual == null), insere o novo nó
        No novoNo = new No(novoContato);
        if (novoContato.getId() < pai.contato.getId()) {
            pai.esquerdo = novoNo;
        } else {
            pai.direito = novoNo;
        }

        No novoNoPorNome = new No(novoContato);
        if (novoContato.getNome().compareTo(paiPorNome.contato.getNome()) < 0) {
            paiPorNome.esquerdo = novoNoPorNome;
        } else {
            paiPorNome.direito = novoNoPorNome;
        }
    }

    public No buscar(int idContato) {
        No atual = raiz;
        while (atual != null) {
            if (idContato == atual.contato.getId())
                return atual;
            else if (idContato < atual.contato.getId())
                atual = atual.esquerdo;
            else
                atual = atual.direito;
        }
        return null;
    }

    public boolean existe(int valor) {
        return (buscar(valor) != null);
    }

    public void remover(int valorRemover) {

        if (estaVazia()) {
            return;
        }

        No atual = raiz;
        No pai = null;

        // Encontrar o nó a ser removido e seu pai
        while (atual != null && atual.contato.getId() != valorRemover) {
            pai = atual;
            if (valorRemover < atual.contato.getId()) {
                atual = atual.esquerdo;
            } else {
                atual = atual.direito;
            }
        }

        // Se o nó não foi encontrado, retorna
        if (atual == null) {
            return;
        }

        // Caso 1 e 2: Nó sem filhos ou com apenas um filho
        if (atual.esquerdo == null || atual.direito == null) {
            No filho;
            if (atual.esquerdo != null) {
                filho = atual.esquerdo;
            } else {
                filho = atual.direito;
            }
            // Se o nó a ser removido é a raiz
            if (pai == null) {
                raiz = filho;
            } else {
                // Conecta o pai ao filho do nó removido
                if (atual == pai.esquerdo) {
                    pai.esquerdo = filho;
                } else {
                    pai.direito = filho;
                }
            }
        }
        // Caso 3: Nó com dois filhos
        else {
            // Encontrar o sucessor (menor valor da subárvore direita)
            No paiSucessor = atual;
            No sucessor = atual.direito;
            
            while (sucessor.esquerdo != null) {
                paiSucessor = sucessor;
                sucessor = sucessor.esquerdo;
            }

            // Copiar o valor do sucessor para o nó atual
            atual.contato = sucessor.contato;

            // Remover o sucessor (que tem no máximo um filho direito)
            if (paiSucessor == atual) {
                paiSucessor.direito = sucessor.direito;
            } else {
                paiSucessor.esquerdo = sucessor.direito;
            }
        }
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public int contarNos() {
        return contarNosRecursivo(raiz);
    }

    private int contarNosRecursivo(No atual) {
        if (atual == null) {
            return 0;
        }
        return 1 + contarNosRecursivo(atual.esquerdo) + contarNosRecursivo(atual.direito);
    }

    public int calcularAlturaArvore() {
        return calcularAlturaRecursivo(raiz);
    }

    private int calcularAlturaRecursivo(No atual) {
        if (atual == null) {
            return -1;
        }
        int alturaEsquerda = calcularAlturaRecursivo(atual.esquerdo);
        int alturaDireita = calcularAlturaRecursivo(atual.direito);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int calcularAlturaNo(int idContato) {
        No no = buscar(idContato);
        if (no == null) {
            return -1;
        }
        return calcularAlturaRecursivo(no);
    }

    public int calcularProfundidadeArvore() {
        return calcularAlturaArvore();
    }

    public int calcularProfundidadeNo(int idContato) {
        return calcularProfundidadeRecursivo(raiz, idContato, 0);
    }

    private int calcularProfundidadeRecursivo(No atual, int idContato, int profundidade) {
        if (atual == null) {
            return -1;
        }
        if (atual.contato.getId() == idContato) {
            return profundidade;
        }
        if (idContato < atual.contato.getId()) {
            return calcularProfundidadeRecursivo(atual.esquerdo, idContato, profundidade + 1);
        }
        return calcularProfundidadeRecursivo(atual.direito, idContato, profundidade + 1);
    }

    public String imprimirPreOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirPreOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length()); // Remove a última vírgula e espaço
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirPreOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            sb.append("ID: "+ atual.contato.getId()).append(", \n");
            sb.append("Nome: "+ atual.contato.getNome()).append(", \n");
            sb.append("Telefone: "+ atual.contato.getTelefone()).append(", \n");            
            imprimirPreOrdemRecursivo(atual.esquerdo, sb);
            imprimirPreOrdemRecursivo(atual.direito, sb);
        }
    }

    public String imprimirPosOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirPosOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirPosOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            imprimirPosOrdemRecursivo(atual.esquerdo, sb);
            imprimirPosOrdemRecursivo(atual.direito, sb);
            sb.append("ID: "+ atual.contato.getId()).append(", \n");
            sb.append("Nome: "+ atual.contato.getNome()).append(", \n");
            sb.append("Telefone: "+ atual.contato.getTelefone()).append(", \n");
        }
    }

    public String imprimirInOrdem() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        imprimirInOrdemRecursivo(raiz, sb);
        
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]");
        return sb.toString();
    }

    private void imprimirInOrdemRecursivo(No atual, StringBuilder sb) {
        if (atual != null) {
            imprimirInOrdemRecursivo(atual.esquerdo, sb);
            sb.append("ID: "+ atual.contato.getId()).append(", \n");
            sb.append("Nome: "+ atual.contato.getNome()).append(", \n");
            sb.append("Telefone: "+ atual.contato.getTelefone()).append(", \n");            
            imprimirInOrdemRecursivo(atual.direito, sb);
        }
    }

    public void imprimirArvoreTexto() {
        if (estaVazia()) {
            System.out.println("Árvore vazia");
        } else {
            imprimirArvoreTextoRecursivo(raiz, 0);
        }
    }

    private void imprimirArvoreTextoRecursivo(No atual, int espaco) {
        if (atual == null) {
            return;
        }
        espaco += ESPACO_IMPRESSAO;
        imprimirArvoreTextoRecursivo(atual.direito, espaco);

        System.out.print("\n");
        for (int i = 4; i < espaco; i++) {
            System.out.print(" ");
        }
        System.out.print(atual.contato + "\n");

        imprimirArvoreTextoRecursivo(atual.esquerdo, espaco);

    }
}