import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BST arvore = new BST();
        BST arvore1 = new BST();
        BST arvore2 = new BST();

        // Pré-carregamento de dados para as árvores
        arvore.adicionar(50);
        arvore.adicionar(30);
        arvore.adicionar(70);
        arvore.adicionar(20);
        arvore.adicionar(40);
        arvore.adicionar(60);
        arvore.adicionar(80);
        arvore.adicionar(10);
        arvore.adicionar(25);
        arvore.adicionar(35);
        arvore.adicionar(77);

        arvore1.adicionar(50);
        arvore1.adicionar(30);
        arvore1.adicionar(70);
        arvore1.adicionar(20);
        arvore1.adicionar(40);
        arvore1.adicionar(60);
        arvore1.adicionar(80);

        arvore2.adicionar(45);
        arvore2.adicionar(25);
        arvore2.adicionar(50);
        arvore2.adicionar(10);
        arvore2.adicionar(40);
        arvore2.adicionar(47);
        arvore2.adicionar(55);

        while (true) {
            System.out.println("\nEscolha uma atividade para executar:");
            System.out.println("1 - Contar Nós De Forma Recursiva");
            System.out.println("2 - Contar Nós Folhas");
            System.out.println("3 - Imprimir Árvore Original e Espelhada");
            System.out.println("4 - Verificar se duas árvores são similares");
            System.out.println("5 - Verificar se duas árvores são iguais");
            System.out.println("6 - Verificar se a árvore é estritamente binária");
            System.out.println("7 - Sair");
            System.out.print("Digite sua escolha: ");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Quantidade de nós: " + arvore.contarNos());
                    break;
                case 2:
                    System.out.println("Quantidade de folhas: " + arvore.contarFolhas());
                    break;
                case 3:
                    System.out.println("Árvore original (Em ordem):");
                    arvore.imprimirEmOrdem();
                    arvore.espelhar();
                    System.out.println("Árvore espelhada (Em ordem):");
                    arvore.imprimirEmOrdem();
                    break;
                case 4:
                    System.out.println("As árvores são similares? " + arvore1.saoSimilares(arvore2));
                    break;
                case 5:
                    System.out.println("As árvores são iguais? " + arvore1.saoIguais(arvore2));
                    break;
                case 6:
                    System.out.println("A árvore é estritamente binária? " + arvore.ehEstritamenteBinaria());
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
