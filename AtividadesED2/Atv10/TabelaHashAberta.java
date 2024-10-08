package AtividadesED2.Atv10;

public class TabelaHashAberta {
    private Integer[] tabela;
    private int tamanho;
    private int elementos;

    public TabelaHashAberta(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new Integer[tamanho];
        this.elementos = 0;
    }

    private int hash(int chave) {
        return chave % tamanho;
    }

    private void redimensionar() {
        int novoTamanho = tamanho * 2;
        Integer[] novaTabela = new Integer[novoTamanho];
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] != null) {
                int novaPos = tabela[i] % novoTamanho;
                while (novaTabela[novaPos] != null) {
                    novaPos = (novaPos + 1) % novoTamanho;
                }
                novaTabela[novaPos] = tabela[i];
            }
        }
        this.tabela = novaTabela;
        this.tamanho = novoTamanho;
    }

    public void inserir(int chave) {
        if (elementos >= tamanho * 0.75) {
            redimensionar();
        }

        int indice = hash(chave);
        while (tabela[indice] != null) {
            indice = (indice + 1) % tamanho;
        }
        tabela[indice] = chave;
        elementos++;
        imprimirTabela();
    }

    public String buscar(int chave) {
        int indice = hash(chave);
        int passos = 0;
        while (tabela[indice] != null && passos < tamanho) {
            if (tabela[indice] == chave) {
                return "Elemento " + chave + " encontrado na posição " + indice;
            }
            indice = (indice + 1) % tamanho;
            passos++;
        }
        return "Elemento " + chave + " não encontrado";
    }

    public String remover(int chave) {
        int indice = hash(chave);
        int passos = 0;

        while (tabela[indice] != null && passos < tamanho) {
            if (tabela[indice] == chave) {
                tabela[indice] = null;
                elementos--;
                reorganizarTabela();
                imprimirTabela();
                return "Elemento " + chave + " removido";
            }
            indice = (indice + 1) % tamanho;
            passos++;
        }
        return "Elemento " + chave + " não encontrado";
    }

    private void reorganizarTabela() {
        Integer[] novaTabela = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] != null) {
                int novaPos = hash(tabela[i]);
                while (novaTabela[novaPos] != null) {
                    novaPos = (novaPos + 1) % tamanho;
                }
                novaTabela[novaPos] = tabela[i];
            }
        }
        tabela = novaTabela;
    }

    public void imprimirTabela() {
        System.out.println("Tabela Hash:");
        for (int i = 0; i < tamanho; i++) {
            if (tabela[i] == null) {
                System.out.println("Posição " + i + ": vazio");
            } else {
                System.out.println("Posição " + i + ": " + tabela[i]);
            }
        }
    }
}