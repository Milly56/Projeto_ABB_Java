import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class Main {
 
    public static void main(String[] args) {

    	String fileName = "dado.txt";
         
         try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
             String line;
             while ((line = br.readLine()) != null) {
                 System.out.println(line);
             }
         } catch (IOException e) {
             System.err.println("Erro ao ler o arquivo: " + e.getMessage());
         }
     
        Scanner leitorNumero = new Scanner(System.in);
 
        Noarvore raiz = new Noarvore(new Aluno("João-RAIZ","123456"));
        raiz.inserirAluno("Maria","654321");
        raiz.inserirAluno("Carlos", "987654");
 
        System.out.println("\n");
 
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
                

	                	System.out.println("Digite o nome do aluno:");
	                    String nome = leitorNumero.next();
	                    
	                    boolean verificaRgm;
	                    
	                    do {                 	
	                    	System.out.println("Digite o RGM do aluno:");
	                        String rgm = leitorNumero.next();
	                        if (rgm.length() == 8) {
	                        	raiz.inserirAluno(nome, rgm);
	                        	verificaRgm = false;
	                        }else if (rgm.length() < 8) {
	                        	System.out.println("RGM INVÁLIDO, É NECESSARIO MAIS CARACTERES\n");
	                        	verificaRgm = true;
	                        }else{
	                        	System.out.println("RGM INVÁLIDO, É NECESSARIO MENOS CARACTERES\n");
	                        	verificaRgm = true;
	                        }
	                        
	                    }while(verificaRgm);
                    
                    
                    break;
                }
                case 2: {
                    // Implement removal logic
                    break;
                }
                case 3: {

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
                	Noarvore.esvaziar(raiz);
                    // Implement emptying logic
                    break;
                }
                case 5: {
                    System.out.println("Elementos da árvore em ordem:");
                    raiz.imprimiEmOrdem();
                    break;
                }
                case 6: {
                    verificaLoop = false;
                    break;
                }
                default: {
                    System.out.println("Essa não é uma opção válida");
                    System.out.println("Tente novamente");
                    break;
                }
            }
 
            System.out.println("\nDeseja retornar para o menu principal?");
            System.out.println("1 - para sim || 2 - para não");
            int retornar = leitorNumero.nextInt();
 
            verificaLoop = retornar == 1;
 
            System.out.println();
        }
 
        System.out.println("\nAplicação encerrada");
 
        leitorNumero.close();
        System.exit(0);
    }
}