package AtividadesED2.Atv9;

public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(8);

        int[] elementos = {52, 45, 64, 34, 69, 11, 10, 3, 6, 2};
        for (int elem : elementos) {
            tabela.inserir(elem);
        }

        System.out.println(tabela.buscar(45));
        System.out.println(tabela.buscar(75));
        System.out.println(tabela.remover(11));
        tabela.imprimirTabela();
    }
}
