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
 
    public void inserirAluno(String nome, String rgm) {
        Aluno novoAluno = new Aluno(nome, rgm);
        inserir(this, novoAluno);
    }
 
    private void inserir(Noarvore noarvore, Aluno novoAluno) {
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
    		return;
    	}
    	esvaziar(raiz.esquerda);
    	esvaziar(raiz.direita);
    	
    	raiz.esquerda = null;
    	raiz.direita = null;
    }

    @Override
    	    public String toString() {
    	        return aluno.toString();
    	    }
}
