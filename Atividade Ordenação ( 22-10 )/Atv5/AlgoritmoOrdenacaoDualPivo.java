package Atv5;

import java.util.Scanner;

public class AlgoritmoOrdenacaoDualPivo {

    public static void AlgoritmoOrdenacaoDualPivo(int[] numeros, int baixo, int alto) {
        if (baixo < alto) {
            int[] pivots = dividir(numeros, baixo, alto);

            AlgoritmoOrdenacaoDualPivo(numeros, baixo, pivots[0] - 1);
            AlgoritmoOrdenacaoDualPivo(numeros, pivots[0] + 1, pivots[1] - 1);
            AlgoritmoOrdenacaoDualPivo(numeros, pivots[1] + 1, alto);
        }
    }

    private static int[] dividir(int[] numeros, int baixo, int alto) {
        if (numeros[baixo] > numeros[alto]) {
            trocar(numeros, baixo, alto);
        }
        int pivo1 = numeros[baixo];
        int pivo2 = numeros[alto];
        int i = baixo + 1, menorQuePivo1 = baixo + 1, maiorQuePivo2 = alto - 1;

        while (i <= maiorQuePivo2) {
            if (numeros[i] < pivo1) {
                trocar(numeros, i++, menorQuePivo1++);
            } else if (numeros[i] > pivo2) {
                trocar(numeros, i, maiorQuePivo2--);
            } else {
                i++;
            }
        }
        trocar(numeros, baixo, --menorQuePivo1);
        trocar(numeros, alto, ++maiorQuePivo2);

        return new int[]{menorQuePivo1, maiorQuePivo2};
    }

    private static void trocar(int[] numeros, int i, int j) {
        int temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números que deseja ordenar: ");
        int tamanho = scanner.nextInt();

        int[] numeros = new int[tamanho];

        System.out.println("Digite os números:");
        for (int i = 0; i < tamanho; i++) {
            numeros[i] = scanner.nextInt();
        }

        long tempoInicial = System.nanoTime();

        AlgoritmoOrdenacaoDualPivo(numeros, 0, numeros.length - 1);

        long tempoFinal = System.nanoTime();
        long tempoExecucao = (tempoFinal - tempoInicial);

        System.out.println("Array ordenado:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        System.out.println("\nTempo de execução: " + tempoExecucao + " nanosegundos");

        scanner.close();
    }
}
