package AtividadesED2.Atv4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BuscaBinariaTempo {
    public static int buscaBinaria(int[] vetor, int chave) {
        int inicio = 0, fim = vetor.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == chave) {
                return meio;
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int[] vetor = new int[100000];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = rand.nextInt(10000);
        }

        System.out.print("Informe o valor a ser buscado (entre 0 e 10.000): ");
        int chave = scanner.nextInt();

        long inicioSemOrd = System.currentTimeMillis();
        int resultadoSemOrd = buscaBinaria(vetor, chave);
        long fimSemOrd = System.currentTimeMillis();
        System.out.println("Chave encontrada no índice (sem ordenação): " + resultadoSemOrd);
        System.out.println("Tempo de execução sem ordenação: " + (fimSemOrd - inicioSemOrd) + " ms");

        Arrays.sort(vetor);

        long inicioComOrd = System.currentTimeMillis();
        int resultadoComOrd = buscaBinaria(vetor, chave);
        long fimComOrd = System.currentTimeMillis();
        System.out.println("Chave encontrada no índice (com ordenação): " + resultadoComOrd);
        System.out.println("Tempo de execução com ordenação: " + (fimComOrd - inicioComOrd) + " ms");
    }
}
