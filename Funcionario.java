// André Barbosa Coura Valverde

import java.util.Random;
import java.util.Scanner;

public class Funcionario {

    public int matricula;
    public String nome;
    public String mail;
    public Funcionario esquerda;
    public Funcionario direita;

    Funcionario() {
        this.matricula = 0;
        this.nome = "";
        this.mail = "";
        this.esquerda = null;
        this.direita = null;
    }

    public void inserirFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("\nDigite a matrícula do funcionário: ");
        this.matricula = scanner.nextInt();

        System.out.printf("Digite o nome do funcionário: ");
        this.nome = scanner.next();

        System.out.printf("Digite o email do funcionário: ");
        this.mail = scanner.next();

        this.esquerda = null;
        this.direita = null;
    }

    @Override
    public String toString() {
        return  "\nMatrícula: " + matricula +
                "\nNome: " + nome +
                "\nMail: " + mail + "\n";
    }
}