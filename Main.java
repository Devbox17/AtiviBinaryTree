import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        String noAchado;
        ArvoreFuncionario arvoreFuncionario = new ArvoreFuncionario();
        int i = 0;

        while (i < 3) {
            arvoreFuncionario.inserirNo(funcionario);
            funcionario = new Funcionario();
            i++;
        }
        arvoreFuncionario.mostrarArvorePreOrdem(arvoreFuncionario.raiz);

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        // noAchado = arvoreFuncionario.pesquisarNo(x);
        // System.out.printf(noAchado);
        // arvoreFuncionario.mostrarArvorePreOrdem(arvoreFuncionario.raiz);
        // arvoreFuncionario.mostrarArvorePosOrdem(arvoreFuncionario.raiz);
    }
}