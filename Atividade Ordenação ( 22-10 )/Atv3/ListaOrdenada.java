package Atv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaOrdenada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listaOrdenada = new ArrayList<>();

        System.out.println("Digite valores inteiros (ou um valor não inteiro para encerrar): ");

        while (scanner.hasNextInt()) {
            int valor = scanner.nextInt();
            int indice = 0;

            while (indice < listaOrdenada.size() && valor > listaOrdenada.get(indice)) {
                indice++;
            }

            listaOrdenada.add(indice, valor);

            System.out.println("Lista ordenada: " + listaOrdenada);
        }

        scanner.close();
    }
}
