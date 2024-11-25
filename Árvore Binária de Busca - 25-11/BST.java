public class BST {
    private No raiz;

    public BST() {
        this.raiz = null;
    }

    public boolean buscar(int valor) {
        return buscar(this.raiz, valor);
    }

    public boolean buscar(No noRaiz, int valor) {
        if (noRaiz == null) {
            return false;
        }

        if (noRaiz.valor == valor) {
            return true;
        }

        if (noRaiz.valor < valor) {
            return buscar(noRaiz.dir, valor);
        } else {
            return buscar(noRaiz.esq, valor);
        }
    }

    public boolean isFolha(No no) {
        return no.esq == null && no.dir == null;
    }

    public void remover(int valor) {
        this.raiz = remover(valor, this.raiz);
    }

    public No remover(int valor, No noRaiz) {
        if (noRaiz == null) {
            return noRaiz;
        }

        if (valor < noRaiz.valor) {
            noRaiz.esq = remover(valor, noRaiz.esq);
        } else if (valor > noRaiz.valor) {
            noRaiz.dir = remover(valor, noRaiz.dir);
        } else {
            if (isFolha(noRaiz)) {
                //Remover o elemento
                return null;
            }
            else if (noRaiz.esq == null) {
                return noRaiz.dir;
            } else if (noRaiz.dir == null) {
                return noRaiz.esq;
            }

            No predecessor = max(noRaiz.esq);
            noRaiz.valor = predecessor.valor;
            noRaiz.esq = remover(predecessor.valor, noRaiz.esq);
        }
        return noRaiz;
    }

    private No max(No raiz) {
        if (raiz == null) {
            return raiz;
        }

        if (raiz.dir != null) {
            return max(raiz.dir);
        }

        return raiz;
    }

    public void imprimirPreOrdem() {
        imprimirPreOrdem(this.raiz);
    }

    public void imprimirPosOrdem() {
        imprimirPosOrdem(this.raiz);
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdem(this.raiz);
    }

    private void imprimirPreOrdem(No noRaiz) {
        if (noRaiz == null) {
            return;
        }

        System.out.println(noRaiz.valor);
        imprimirPreOrdem(noRaiz.esq);
        imprimirPreOrdem(noRaiz.dir);
    }

    private void imprimirPosOrdem(No noRaiz) {
        if (noRaiz == null) {
            return;
        }

        imprimirPosOrdem(noRaiz.esq);
        imprimirPosOrdem(noRaiz.dir);
        System.out.println(noRaiz.valor);
    }

    private void imprimirEmOrdem(No noRaiz) {
        if (noRaiz == null) {
            return;
        }

        imprimirEmOrdem(noRaiz.esq);
        System.out.println(noRaiz.valor);
        imprimirEmOrdem(noRaiz.dir);
    }

    // Atividade 1 - Contar Nós De Forma Recursiva
    public int contarNos() {
        return contarNos(this.raiz);
    }

    private int contarNos(No noRaiz) {
        if (noRaiz == null) {
            return 0;
        }
        return 1 + contarNos(noRaiz.esq) + contarNos(noRaiz.dir);
    }

    public int contarFolhas() {
        return contarFolhas(this.raiz);
    }

    // Atividade 2 - Contar Nós Folhas

    private int contarFolhas(No noRaiz) {
        if (noRaiz == null) {
            return 0;
        }

        if (noRaiz.esq == null && noRaiz.dir == null) {
            return 1;
        }

        return contarFolhas(noRaiz.esq) + contarFolhas(noRaiz.dir);
    }

    // Atividade 3 - Fazer Função Adcionar sem Recursão
    public void adicionar(int novoValor) {
        No novoNo = new No(novoValor);

        if (this.raiz == null) {
            this.raiz = novoNo;
            return;
        }

        No atual = this.raiz;
        No pai = null;

        while (atual != null) {
            pai = atual;
            if (novoValor < atual.valor) {
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
        }

        if (novoValor < pai.valor) {
            pai.esq = novoNo;
        } else {
            pai.dir = novoNo;
        }
    }


    // Atividade 4 - Espelhar Árvore
    public void espelhar() {
        espelhar(this.raiz);
    }

    private void espelhar(No noRaiz) {
        if (noRaiz == null) {
            return;
        }

        No temp = noRaiz.esq;
        noRaiz.esq = noRaiz.dir;
        noRaiz.dir = temp;

        espelhar(noRaiz.esq);
        espelhar(noRaiz.dir);
    }


    // Atividade 5 - Verificar se duas árvores são similares
    public boolean saoSimilares(BST outraArvore) {
        return saoSimilares(this.raiz, outraArvore.raiz);
    }

    private boolean saoSimilares(No no1, No no2) {
        if (no1 == null && no2 == null) {
            return true;
        }

        if (no1 == null || no2 == null) {
            return false;
        }

        return saoSimilares(no1.esq, no2.esq) && saoSimilares(no1.dir, no2.dir);
    }

    // Atividade 6 - Verificar se duas árvores são iguais
    public boolean saoIguais(BST outraArvore) {
        return saoIguais(this.raiz, outraArvore.raiz);
    }

    private boolean saoIguais(No no1, No no2) {
        if (no1 == null && no2 == null) {
            return true;
        }

        if (no1 == null || no2 == null || no1.valor != no2.valor) {
            return false;
        }

        return saoIguais(no1.esq, no2.esq) && saoIguais(no1.dir, no2.dir);
    }


    // Atividade 7 - Verificar se a árvore é estritamente binária

    public boolean ehEstritamenteBinaria() {
        return ehEstritamenteBinaria(this.raiz);
    }

    private boolean ehEstritamenteBinaria(No noRaiz) {
        if (noRaiz == null) {
            return true;
        }

        if (noRaiz.esq == null && noRaiz.dir == null) {
            return true;
        }

        if (noRaiz.esq != null && noRaiz.dir != null) {
            return ehEstritamenteBinaria(noRaiz.esq) && ehEstritamenteBinaria(noRaiz.dir);
        }

        return false;
    }



}
