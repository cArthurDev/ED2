package AtividadesED2.Atv2;

import java.util.ArrayList;

public class BuscaSequencialMultipla {
    public static ArrayList<Integer> buscaSequencial(int[] vetor, int chave) {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == chave) {
                indices.add(i);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] vetor = {1, 3, 7, 9, 9, 11, 9};
        int chave = 9;
        ArrayList<Integer> resultado = buscaSequencial(vetor, chave);
        System.out.println("Chave encontrada nos índices: " + resultado);
    }
}
