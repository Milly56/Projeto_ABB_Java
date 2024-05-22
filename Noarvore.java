public class Noarvore {
    private Aluno aluno;
    private Noarvore direita;
    private Noarvore esquerda;
 
    Noarvore(Aluno aluno) {
        this.aluno = aluno;
        this.direita = null;
        this.esquerda = null;
       
    }
 
    // Method to print the elements in in-order traversal
    public void imprimiEmOrdem() {
        imprimiEmOrdem(this);
    }
 
    private void imprimiEmOrdem(Noarvore n) {    	
    	if (n != null) {
            imprimiEmOrdem(n.esquerda);
            System.out.println(n.aluno);
            imprimiEmOrdem(n.direita);
    	}
    }
    public static void exibirGraficamente(Noarvore tree) {
        exibirGraficamenteRecursivo(tree, "", true);
    }
    
    public static void exibirGraficamenteRecursivo(Noarvore tree, String prefix, boolean isLeft) {
        if (tree != null) {
            System.out.println(prefix + (isLeft ? "\n├── " : "└── ") + tree.aluno);
            exibirGraficamenteRecursivo(tree.esquerda, prefix + (isLeft ? "│   " : "    "), true);
            exibirGraficamenteRecursivo(tree.direita, prefix + (isLeft ? "│   " : "    "), false);
        }
    }
 
    public void inserirAluno(String nome, String rgm) {
        Aluno novoAluno = new Aluno(nome, rgm);
        inserir(this, novoAluno);
    }
 
    private void inserir(Noarvore noarvore, Aluno novoAluno) {
    	try {
	        if (novoAluno.getRgm().compareTo(noarvore.aluno.getRgm()) < 0) {
	            if (noarvore.esquerda == null) {
	                noarvore.esquerda = new Noarvore(novoAluno);
	            } else {
	                inserir(noarvore.esquerda, novoAluno);
	            }
	        } else if (novoAluno.getRgm().compareTo(noarvore.aluno.getRgm()) > 0) {
	            if (noarvore.direita == null) {
	                noarvore.direita = new Noarvore(novoAluno);
	            } else {
	                inserir(noarvore.direita, novoAluno);
	            }
	        }
    	} catch(NullPointerException ponteiroNulo) {
    		System.out.println("\nErro na tentativa em inserir um objeto vazio");
    	}
    }
    
    public void remover(String rgm) {
        remover(this, rgm);
    }
    
    private Noarvore remover(Noarvore raiz, String rgm) {
        if (raiz == null) {
            return null;
        }

        // Verifica se o RG do aluno na raiz é igual ao RG buscado
        if (raiz.aluno.getRgm().equals(rgm)) {
            // Caso o nó tenha apenas um filho ou nenhum filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }
         // Caso o nó tenha dois filhos, encontra o menor nó na subárvore direita
            Noarvore menorNoDireita = encontrarMenorNoarvore(raiz.direita);
            raiz.aluno = menorNoDireita.aluno;
            raiz.direita = remover(raiz.direita, menorNoDireita.aluno.getRgm());
            return raiz;
        }

        // Se o RG buscado for menor que o RG do nó atual, remove da subárvore esquerda
        if (rgm.compareTo(raiz.aluno.getRgm()) < 0) {
            raiz.esquerda = remover(raiz.esquerda, rgm);
        } else { // Senão, remove da subárvore direita
            raiz.direita = remover(raiz.direita, rgm);
        }
        return raiz;
    }
    
    private Noarvore encontrarMenorNoarvore(Noarvore no) {
        Noarvore atual = no;
        while (atual.esquerda != null) {
            atual = atual.esquerda;
        }
        return atual;
    }

    //metodo que recebe qual aluno deseja buscar pelo rgm
    public Noarvore buscar(String rgm) {
        return buscar(this, rgm);
    }

    private Noarvore buscar(Noarvore noarvore, String rgm) {
    	//se for vazio ou nao for encontrado
        if (noarvore == null) {
            return null;
        }
        //se o rgm digitado for igual ao rgm buscado retorna o conteudo
        if (rgm.equals(noarvore.aluno.getRgm())) {
            return noarvore;
        }
        //se o rgm digitado e menor que o rgm que ta sendo buscado ou o contrario
        if (rgm.compareTo(noarvore.aluno.getRgm()) < 0) {
            return buscar(noarvore.esquerda, rgm);
        } else {
            return buscar(noarvore.direita, rgm);
        }
    }
    
    public static void esvaziar(Noarvore raiz) {
    	if (raiz == null) {
    	} else {
    		esvaziar(raiz.esquerda);
        	esvaziar(raiz.direita);
        	
        	raiz.aluno = null;
        	raiz.esquerda = null;
        	raiz.direita = null;
    	}
   }
  
  	public void arvoreEsvaziada(Noarvore raiz) {
	  if(raiz.aluno == null) {
		  System.out.println("Árvore esvaziada");
	  } else {
		  System.out.println("Árvore não esvaziada");
	  }
  }

    @Override
    public String toString() {
    	return aluno.toString();
    }
}