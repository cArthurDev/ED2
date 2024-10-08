package AtividadesED2.Atv2;

import java.util.ArrayList;
import java.util.Arrays;

public class BuscaBinariaMultipla {
    public static ArrayList<Integer> buscaBinaria(int[] vetor, int chave) {
        ArrayList<Integer> indices = new ArrayList<>();
        int inicio = 0, fim = vetor.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vetor[meio] == chave) {
                indices.add(meio);

                int esq = meio - 1;
                while (esq >= 0 && vetor[esq] == chave) {
                    indices.add(esq);
                    esq--;
                }

                int dir = meio + 1;
                while (dir < vetor.length && vetor[dir] == chave) {
                    indices.add(dir);
                    dir++;
                }
                break;
            } else if (vetor[meio] < chave) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        int[] vetor = {0, 9, 1, 2, 9, 9, 13};
        Arrays.sort(vetor);
        int chave = 9;
        ArrayList<Integer> resultado = buscaBinaria(vetor, chave);
        System.out.println("Chave encontrada nos índices: " + resultado);
    }
}
