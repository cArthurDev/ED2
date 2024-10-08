package AtividadesED2.Atv3;

import java.util.Random;

public class BuscaSequencialTempo {
    public static int buscaSequencial(int[] vetor, int chave) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] vetor = new int[100000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(10001);
        }

        int chave = 5000;
        long inicio = System.currentTimeMillis();
        int resultado = buscaSequencial(vetor, chave);
        long fim = System.currentTimeMillis();

        System.out.println("Chave encontrada no índice: " + resultado);
        System.out.println("Tempo de execução: " + (fim - inicio) + " ms");
    }
}
