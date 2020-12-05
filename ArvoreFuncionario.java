import java.util.Scanner;

/**
 * ArvoreFuncionario
 */
public class ArvoreFuncionario {

    public Funcionario novo;
    public Funcionario raiz;
    public Funcionario aux;

    ArvoreFuncionario() {
        novo = null;
        raiz = null;
        aux = null;
    }

    public boolean inserirNo(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);
        int achou;

        this.novo = funcionario;

        if (raiz == null) {
            raiz = novo;
        } else {
            aux = raiz;
            achou = 0;

            while (achou == 0) {
                if (novo.matricula < aux.matricula) {
                    if (aux.esquerda == null) {
                        aux.esquerda = novo;
                        achou = 1;
                    } else {
                        aux = aux.esquerda;
                    }
                } else if (novo.matricula > aux.matricula) {
                    if (aux.direita == null) {
                        aux.direita = novo;
                        achou = 1;
                    } else {
                        aux = aux.direita;
                    }
                } else if (novo.matricula == aux.matricula) {
                    return false;
                }
            }
        }
        return true;
    }

    public String pesquisarNo(int a) {
        int altura = 0;
        aux = raiz;

        while (aux != null) {
            if (a == aux.matricula) {
                return "\nAltura encontrada do nó foi: " + altura + "\n--- Informação do nó achado ---"
                        + aux.toString();
            } else if (a < aux.matricula) {
                aux = aux.esquerda;
                altura++;
            } else if (a > aux.matricula) {
                aux = aux.direita;
                altura++;
            }
        }
        return "Não foi achado esse nó, tente novamente!";
    }

    public void excluirNo(int a) {
        if (a == raiz.matricula) {
            aux = raiz.esquerda;

            if (raiz.direita != null) {
                raiz = raiz.direita.esquerda;
                raiz.esquerda = aux;
            }
        } 
    }

    public void esvaziarArvore() {
        raiz = null;
        raiz.esquerda = null;
        raiz.direita = null;
    }

    public void mostrarArvoreOrdem(Funcionario funcionario) {
        if (funcionario != null) {
            mostrarArvoreOrdem(funcionario.esquerda);
            System.out.printf(funcionario.toString());
            mostrarArvoreOrdem(funcionario.direita);
        }
    }

    public void mostrarArvorePreOrdem(Funcionario funcionario) {
        if (funcionario != null) {
            System.out.printf(funcionario.toString());
            mostrarArvoreOrdem(funcionario.esquerda);
            mostrarArvoreOrdem(funcionario.direita);
        }
    }

    public void mostrarArvorePosOrdem(Funcionario funcionario) {
        if (funcionario != null) {
            mostrarArvoreOrdem(funcionario.esquerda);
            mostrarArvoreOrdem(funcionario.direita);
            System.out.printf(funcionario.toString());
        }
    }
}