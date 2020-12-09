// André Barbosa Coura Valverde

import java.util.Scanner;

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

        // A variavel do tipo da classe recebe um objeto por referência e recebe tudo dele
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

    public String pesquisarNo(int valorPesquisa) {
        int altura = 0;
        aux = raiz;

        while (aux != null) {
            // Se o valor pesquisado for achado, vai ser retornado a sua altura e sua
            // informações relevantes
            if (valorPesquisa == aux.matricula) {
                return "\nAltura encontrada do nó foi: " + altura + "\n\n--- Informação do nó achado ---\n"
                        + aux.toString();
            } else if (valorPesquisa < aux.matricula) {
                aux = aux.esquerda;
                altura++;
            } else if (valorPesquisa > aux.matricula) {
                aux = aux.direita;
                altura++;
            }
        }
        return "\nNão foi achado esse nó, tente novamente!";
    }

    public Funcionario excluirNo(Funcionario funcSelecionado, int valorExcluir) {
        Funcionario aux1, aux2;

        if (valorExcluir == funcSelecionado.matricula) {
            if (funcSelecionado.esquerda == funcSelecionado.direita) {
                return null;
            } else if (funcSelecionado.esquerda == null) {
                return raiz.direita;
            } else if (funcSelecionado.direita == null) {
                return raiz.esquerda;
            } else {
                aux1 = funcSelecionado.direita;
                aux2 = funcSelecionado.direita;

                while (aux1.esquerda != null) {
                    aux1 = aux1.esquerda;
                }

                aux1.esquerda = funcSelecionado.esquerda;

                return aux2;
            }
        } else if (valorExcluir > funcSelecionado.matricula) {
            funcSelecionado.direita = excluirNo(funcSelecionado.direita, valorExcluir);
        } else {
            funcSelecionado.esquerda = excluirNo(funcSelecionado.esquerda, valorExcluir);
        }
        return funcSelecionado;
    }

    // Tira da jogada todas as referências da árvore
    public Funcionario esvaziarArvore() {
        Scanner scanner = new Scanner(System.in);

        if (raiz == null) {
            System.out.printf("\nÁrvore já está vazia, não tem o que fazer aqui, volte o menu!");
            scanner.nextLine();
        } else {
            raiz = null;
            System.out.println("\nÁrvore esvaziada, está completamente limpa!");
            scanner.nextLine();
        }

        return raiz;
    }

    public void mostrarArvoreOrdem(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);

        if (raiz == null) {
            System.out.printf("\nÁrvore está vazia, não tem o que fazer aqui, volte o menu!");
            scanner.nextLine();
        } else if (funcionario != null) {
            mostrarArvoreOrdem(funcionario.esquerda);
            System.out.printf(funcionario.toString());
            mostrarArvoreOrdem(funcionario.direita);
        }
    }

    public void mostrarArvorePreOrdem(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);

        if (raiz == null) {
            System.out.printf("\nÁrvore está vazia, não tem o que fazer aqui, volte o menu!");
            scanner.nextLine();
        } else if (funcionario != null) {
            System.out.printf(funcionario.toString());
            mostrarArvorePreOrdem(funcionario.esquerda);
            mostrarArvorePreOrdem(funcionario.direita);
        }
    }

    public void mostrarArvorePosOrdem(Funcionario funcionario) {
        Scanner scanner = new Scanner(System.in);

        if (raiz == null) {
            System.out.printf("\nÁrvore está vazia, não tem o que fazer aqui, volte o menu!");
            scanner.nextLine();
        } else if (funcionario != null) {
            mostrarArvorePosOrdem(funcionario.esquerda);
            mostrarArvorePosOrdem(funcionario.direita);
            System.out.printf(funcionario.toString());
        }
    }
}