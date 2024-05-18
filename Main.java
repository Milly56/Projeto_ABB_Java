import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitorNumero = new Scanner(System.in);
        Noarvore raiz = new Noarvore(new Aluno("João-RAIZ", "12345678"));

        raiz.inserirAluno("Maria", "65432361");
        raiz.inserirAluno("Carlos", "98762154");

        System.out.println();

        boolean verificaLoop = true;

        while (verificaLoop) {
            System.out.println("+--------------------------+");
            System.out.println("|      MENU DA ÁRVORE      |");
            System.out.println("+--------------------------+");
            System.out.println("|     1 - Inserir          |");
            System.out.println("|     2 - Remover          |");
            System.out.println("|     3 - Buscar           |");
            System.out.println("|     4 - Esvaziar         |");
            System.out.println("|     5 - Exibir           |");
            System.out.println("|     6 - Sair             |");
            System.out.println("+--------------------------+");

            int opcoes = leitorNumero.nextInt();

            switch (opcoes) {
                case 1: {
                	//opcao inserir
                    System.out.println("\nDigite o nome do aluno:");
                    String nome = leitorNumero.next();

                    boolean verificaRgm;
                    
                    //restringe a quantidade de caracteres no rgm
                    do {
                        System.out.println("Digite o RGM do aluno:");
                        String rgm = leitorNumero.next();
                        if (rgm.length() == 8) {
                            raiz.inserirAluno(nome, rgm);
                            verificaRgm = false;
                        } else if (rgm.length() < 8) {
                            System.out.println("RGM INVÁLIDO, É NECESSÁRIO MAIS CARACTERES\n");
                            verificaRgm = true;
                        } else {
                            System.out.println("RGM INVÁLIDO, É NECESSÁRIO MENOS CARACTERES\n");
                            verificaRgm = true;
                        }

                    } while (verificaRgm);

                    break;
                }
                case 2: {
                   //opcao remover
                    break;
                }
                case 3: {
                	//opcao buscar
                	
                    System.out.println("\nDigite qual o RGM deseja buscar: ");
                    String buscaRgm = leitorNumero.next();
                    Noarvore alunoBuscado = raiz.buscar(buscaRgm);
                    
                    //verifica se o aluno existe
                    if (alunoBuscado == null) {
                        System.out.println("\nAluno não encontrado");
                    } else {
                    	System.out.println("\nAluno encontrado");
                        System.out.println(alunoBuscado);
                    }

                    break;
                }
                case 4: {
                	//opcao esvaziar
    
                    Noarvore.esvaziar(raiz);
                    raiz.arvoreEsvaziada(raiz);
                    
                    break;
                }
                case 5: {
                	//opcao imprimir
                	
                    System.out.println("\nElementos da árvore em ordem: \n");
                    raiz.imprimiEmOrdem();
                    break;
                }
                case 6: {
                	//opcao sair
                	
                    verificaLoop = false;
                    break;
                }
                default: {
                	//caso nenhuma opcao seja valida
                	
                    System.out.println("\nEssa não é uma opção válida");
                    System.out.println("Tente novamente");
                    break;
                }
            }
            
            //se digita 6 quebra o loop sem precisar passar pela verificacao
            if(opcoes == 6)
            	break;

            System.out.println("\nDeseja retornar para o menu principal?");
            System.out.println("1 - para sim || 2 - para não");
            int retornar = leitorNumero.nextInt();

            verificaLoop = retornar == 1;

            System.out.println();
        }

        System.out.println("\nVocê saiu do loop");
        
        //fecha o scanner e termina o programa
        leitorNumero.close();
        System.exit(0);
    }
}