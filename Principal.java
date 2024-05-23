import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        
    	// criar uma variável e atrbui o nome do arquivo que sera lido;
    	
    	 String fileName = "dado.txt";
         
    	 // bloco de exeções podem ocorrer
  
         try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
             String line;
             
             // lendo cada linha do arquivo até encontrar uma linha nula;
             
             while ((line = br.readLine()) != null) {
            	 
            	 // imprimi a linha atual no console
            	 
                 System.out.println(line);
             }
             
             // captura qualquer exceção que possa ocorrer durante a leitura no arquivo;
             
         } catch (IOException e) {
        	 
        	 // se ocorrer uma exceção,imprime uma mensagem de erro no console;
        	 
             System.err.println("Erro ao ler o arquivo: " + e.getMessage());
         }
  
    	Scanner leitorNumero = new Scanner(System.in);
        Noarvore raiz = new Noarvore(new Aluno("João da Costa -RAIZ","96853402"));
        raiz.inserirAluno("Maria da Penha","65432123");
        raiz.inserirAluno("Carlos Luiz do Nascimento ", "98765445");
 
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
                	
                	//responsavel por inserir novos alunos
                	
                	System.out.println("Digite o nome do aluno:");
                    String nome = leitorNumero.next();
                    
                    boolean verificaRgm;
                    
                  //verifica sem o rgm foi valido pela quantidade de caracteres
                    
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
                	
                	//responsavel por remover um no
                	
                	System.out.print("Digite o RG do aluno que deseja remover: ");
                    String rgm = leitorNumero.next(); 
                    raiz.remover(rgm);
                    System.out.println("Aluno removido com sucesso!");
            
                	
                	
                    break;
                }
                case 3: {
                  
                	//responsavel por buscar alunos por rgm
                	
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
                	//responsavel por esvaziar a arvore
                	
                	Noarvore.esvaziar(raiz);
             
                    break;
                }
              
                case 5: {
                    // Exibir a árvore em ordem
                    System.out.println("Elementos da árvore em ordem:");
                    raiz.imprimiEmOrdem();
                    
                    // Exibir a árvore em pré-ordem
                    System.out.println("\nElementos da árvore em pré-ordem:");
                    raiz.imprimiPreOrdem();
                    
                    // Exibir a árvore em pós-ordem
                    System.out.println("\nElementos da árvore em pós-ordem:");
                    raiz.imprimiPosOrdem();
                    
                    // Exibir graficamente a árvore
                    System.out.println("\nExibição gráfica da árvore:");
                    Noarvore.exibirGraficamente(raiz);
                    
                    break;
                }
                
                case 6: {
                	//responsavel por sair do loop

                    verificaLoop = false;
                    break;
                }
                default: {
                	
                	//mensagem padrao caso nenhum dos casos sejam validos
                	
                    System.out.println("Essa não é uma opção válida");
                    System.out.println("Tente novamente");
                    break;
                }
            }
 
            //caso a opcao digitada seja 6 quebra o loop sem passar pela mensagem de retorno
            
            if(opcoes == 6)
            	break;
            
            //mensagem de retorna ao loop
            
            System.out.println("\nDeseja retornar para o menu principal?");
            System.out.println("1 - para sim || 2 - para não");
            int retornar = leitorNumero.nextInt();
 
            verificaLoop = retornar == 1;
 
            System.out.println();
        }
 
        System.out.println("\nAplicação encerrada");
        
        //fecha o scanner e depois acaba o programa
        leitorNumero.close();
        System.exit(0);
    }
}
