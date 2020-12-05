import java.util.Random;

/**
 * Funcionario
 */
public class Funcionario {

    public int matricula;
    public String nome;
    public String mail;
    public Funcionario esquerda;
    public Funcionario direita;

    // Funcionario() {
    //     this.matricula = 0;
    //     this.nome = "";
    //     this.mail = "";
    //     this.esquerda = null;
    //     this.direita = null;
    // }

    Funcionario() {
        Random random = new Random();

        this.matricula = random.nextInt(100);
        this.nome = "Funcionario" + random.nextInt(10000);
        this.mail = random.nextInt(10000) + "@gmail.com";  
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