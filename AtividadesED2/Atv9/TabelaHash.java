package AtividadesED2.Atv9;

public class TabelaHash {
    private No[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new No[tamanho];
    }

    private int hash(int chave) {
        return chave % tamanho;
    }

    public void inserir(int chave) {
        int indice = hash(chave);
        No novoNo = new No(chave);

        if (tabela[indice] == null) {
            tabela[indice] = novoNo;
        } else {
            No atual = tabela[indice];
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }

        imprimirTabela();
    }

    public String buscar(int chave) {
        int indice = hash(chave);
        No atual = tabela[indice];

        while (atual != null) {
            if (atual.chave == chave) {
                return "Elemento " + chave + " encontrado na posição " + indice;
            }
            atual = atual.proximo;
        }
        return "Elemento " + chave + " não encontrado";
    }

    public String remover(int chave) {
        int indice = hash(chave);
        No atual = tabela[indice];
        No anterior = null;

        while (atual != null) {
            if (atual.chave == chave) {
                if (anterior == null) {
                    tabela[indice] = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                imprimirTabela();
                return "Elemento " + chave + " removido";
            }
            anterior = atual;
            atual = atual.proximo;
        }
        return "Elemento " + chave + " não encontrado";
    }

    public void imprimirTabela() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Posição " + i + ": ");
            No atual = tabela[i];
            while (atual != null) {
                System.out.print(atual.chave + " -> ");
                atual = atual.proximo;
            }
            System.out.println("null");
        }
    }
}