package AtividadesED2.Atv1;

public class BuscaSequencial {
    public static int buscaSequencial(int[] vetor, int chave) {
        int i = 0;
        while (i < vetor.length) {
            if (vetor[i] == chave) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] vetor = {1, 3, 7, 9, 11, 13, 17};
        int chave = 9;
        int resultado = buscaSequencial(vetor, chave);
        System.out.println("Chave encontrada no índice: " + resultado);
    }
}
