// André Barbosa Coura Valverde

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario = new Funcionario(), funcionario2;
        ArvoreFuncionario arvoreFuncionario = new ArvoreFuncionario();
        int opcao = 0, valorPesquisa = 0;
        String noAchado;

        do {
            System.out.println("\n\n__________Atividade Árbore Binária__________");
            System.out.println("|                                          |");
            System.out.println("|       1° - Registrar Funcionário         |");
            System.out.println("|       2° - Pesquisar Funcionário         |");
            System.out.println("|       3° - Excluir Funcionário           |");
            System.out.println("|       4° - Esvaziar Árvore               |");
            System.out.println("|       5° - Listar em Ordem               |");
            System.out.println("|       6° - Listar em Pré Ordem           |");
            System.out.println("|       7° - Listar em Pós Ordem           |");
            System.out.println("|       8° - Sair do Programa              |");
            System.out.println("|__________________________________________|");
            System.out.printf("Digite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    funcionario = new Funcionario();
                    funcionario.inserirFuncionario();
                    arvoreFuncionario.inserirNo(funcionario);
                    break;

                case 2:
                    if (arvoreFuncionario.raiz == null) {
                        System.out.printf("\nA árvore está vazia, não tem o que pesquisar, volte ao menu!");
                        scanner.nextLine();
                        scanner.nextLine();
                    } else {
                        System.out.printf("\nDigite o valor a pesquisar: ");
                        valorPesquisa = scanner.nextInt();
                        noAchado = arvoreFuncionario.pesquisarNo(valorPesquisa);
                        System.out.println(noAchado);
                        scanner.nextLine();
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    if (arvoreFuncionario.raiz == null) {
                        System.out.printf("\nA árvore está vazia, não tem o que excluir, volte ao menu!");
                        scanner.nextLine();
                        scanner.nextLine();
                    } else {
                        System.out.printf("\nDigite o valor a pesquisar e excluir: ");
                        valorPesquisa = scanner.nextInt();
                        arvoreFuncionario.raiz = arvoreFuncionario.excluirNo(arvoreFuncionario.raiz, valorPesquisa);
                        System.out.println("\nFuncionário excluído da árvore!!!");
                        scanner.nextLine();
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    arvoreFuncionario.raiz = arvoreFuncionario.esvaziarArvore();
                    break;

                case 5:
                    arvoreFuncionario.mostrarArvoreOrdem(arvoreFuncionario.raiz);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case 6:
                    arvoreFuncionario.mostrarArvorePreOrdem(arvoreFuncionario.raiz);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;

                case 7:
                    arvoreFuncionario.mostrarArvorePosOrdem(arvoreFuncionario.raiz);
                    scanner.nextLine();
                    scanner.nextLine();
                    break;
            }
        } while (opcao < 8);
    }
}