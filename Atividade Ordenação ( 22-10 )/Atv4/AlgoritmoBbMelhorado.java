package Atv4;

import java.util.Scanner;

public class AlgoritmoBbMelhorado {

    public static void bubbleSort(int[] numeros) {
        boolean trocar;
        int n = numeros.length;

        do {
            trocar = false;
            for (int i = 0; i < n - 1; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    int temp = numeros[i];
                    numeros[i] = numeros[i + 1];
                    numeros[i + 1] = temp;
                    trocar = true;
                }
            }
            n--;
        } while (trocar);
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

        long startTime = System.nanoTime();

        bubbleSort(numeros);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Array ordenado:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        System.out.println("\nTempo de execução: " + duration + " nanosegundos");

        scanner.close();
    }
}
