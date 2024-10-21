package Atv2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ComparacaoOrdenacao {

    public static void main(String[] args) {
        long tempoInicioPrograma = System.currentTimeMillis();

        int tamanho = 100000;
        int intervalo = 100000;
        int repeticoes = 10;

        Random random = new Random();
        long[][] tempos = new long[repeticoes][6];

        for (int i = 0; i < repeticoes; i++) {
            int[] vetorOriginal = random.ints(tamanho, 0, intervalo).toArray();

            int[] vetorBubble = Arrays.copyOf(vetorOriginal, tamanho);
            long inicio = System.currentTimeMillis();
            bubbleSort(vetorBubble);
            tempos[i][0] = System.currentTimeMillis() - inicio;

            int[] vetorInsercao = Arrays.copyOf(vetorOriginal, tamanho);
            inicio = System.currentTimeMillis();
            insertionSort(vetorInsercao);
            tempos[i][1] = System.currentTimeMillis() - inicio;

            int[] vetorSelecao = Arrays.copyOf(vetorOriginal, tamanho);
            inicio = System.currentTimeMillis();
            selectionSort(vetorSelecao);
            tempos[i][2] = System.currentTimeMillis() - inicio;

            int[] vetorShell = Arrays.copyOf(vetorOriginal, tamanho);
            inicio = System.currentTimeMillis();
            shellSort(vetorShell);
            tempos[i][3] = System.currentTimeMillis() - inicio;

            int[] vetorMerge = Arrays.copyOf(vetorOriginal, tamanho);
            inicio = System.currentTimeMillis();
            mergeSort(vetorMerge, 0, tamanho - 1);
            tempos[i][4] = System.currentTimeMillis() - inicio;

            int[] vetorQuick = Arrays.copyOf(vetorOriginal, tamanho);
            inicio = System.currentTimeMillis();
            quickSort(vetorQuick, 0, tamanho - 1);
            tempos[i][5] = System.currentTimeMillis() - inicio;
        }

        System.out.println("Tempos de Execução (em milissegundos):");
        String[] algoritmos = {"BubbleSort", "InsertionSort", "SelectionSort", "ShellSort", "MergeSort", "QuickSort"};

        System.out.print("Rep | ");
        for (String algoritmo : algoritmos) {
            System.out.print(algoritmo + " | ");
        }
        System.out.println();

        for (int i = 0; i < repeticoes; i++) {
            System.out.printf("%d   | ", (i + 1));
            for (int j = 0; j < algoritmos.length; j++) {
                System.out.printf("%d       | ", tempos[i][j]);
            }
            System.out.println();
        }

        long tempoFimPrograma = System.currentTimeMillis();
        long duracao = tempoFimPrograma - tempoInicioPrograma;

        long horas = TimeUnit.MILLISECONDS.toHours(duracao);
        long minutos = TimeUnit.MILLISECONDS.toMinutes(duracao) % 60;
        long segundos = TimeUnit.MILLISECONDS.toSeconds(duracao) % 60;
        long milissegundos = duracao % 1000;

        System.out.printf("Tempo total de execução do programa: %02d:%02d:%02d:%03d\n", horas, minutos, segundos, milissegundos);
    }

    public static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] vetor) {
        for (int i = 1; i < vetor.length; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = chave;
        }
    }

    public static void selectionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            int temp = vetor[indiceMinimo];
            vetor[indiceMinimo] = vetor[i];
            vetor[i] = temp;
        }
    }

    public static void shellSort(int[] vetor) {
        int n = vetor.length;
        for (int intervalo = n / 2; intervalo > 0; intervalo /= 2) {
            for (int i = intervalo; i < n; i++) {
                int temp = vetor[i];
                int j;
                for (j = i; j >= intervalo && vetor[j - intervalo] > temp; j -= intervalo) {
                    vetor[j] = vetor[j - intervalo];
                }
                vetor[j] = temp;
            }
        }
    }

    public static void mergeSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            mergeSort(vetor, esquerda, meio);
            mergeSort(vetor, meio + 1, direita);
            merge(vetor, esquerda, meio, direita);
        }
    }

    public static void merge(int[] vetor, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;
        int[] vetorEsquerda = new int[n1];
        int[] vetorDireita = new int[n2];

        System.arraycopy(vetor, esquerda, vetorEsquerda, 0, n1);
        System.arraycopy(vetor, meio + 1, vetorDireita, 0, n2);

        int i = 0, j = 0;
        int k = esquerda;
        while (i < n1 && j < n2) {
            if (vetorEsquerda[i] <= vetorDireita[j]) {
                vetor[k] = vetorEsquerda[i];
                i++;
            } else {
                vetor[k] = vetorDireita[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            vetor[k] = vetorEsquerda[i];
            i++;
            k++;
        }

        while (j < n2) {
            vetor[k] = vetorDireita[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] vetor, int baixo, int alto) {
        if (baixo < alto) {
            int pi = particao(vetor, baixo, alto);
            quickSort(vetor, baixo, pi - 1);
            quickSort(vetor, pi + 1, alto);
        }
    }

    public static int particao(int[] vetor, int baixo, int alto) {
        int pivo = vetor[alto];
        int i = (baixo - 1);
        for (int j = baixo; j < alto; j++) {
            if (vetor[j] <= pivo) {
                i++;
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }
        int temp = vetor[i + 1];
        vetor[i + 1] = vetor[alto];
        vetor[alto] = temp;
        return i + 1;
    }
}
