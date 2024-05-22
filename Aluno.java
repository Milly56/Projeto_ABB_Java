public class Aluno {
	
	//variaveis de instancia 
    private String nome;
    private String rgm;
    
    //metodo construtor
    public Aluno(String nome, String rgm) {
        this.nome = nome;
        this.rgm = rgm;
    }
    
    // acessar a variável nome do objeto Aluno de fora da classe Aluno, retorna o valor atual da variável.
    public String getNome() {
        return nome;
    }
    
    // alterar o valor da variável Nome de fora da classe Aluno.
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // acessar a variável rgm do objeto Aluno de fora da classe Aluno, retorna o valor atual da variável.
    public String getRgm() {
        return rgm;
    }
    
    // alterar o valor da variável Rgm de fora da classe Rgm.
    public void setRgm(String rgm) {
        this.rgm = rgm;
    }
    
    // isso é para imprimir da forma útil informações legíveis dessa variáveis.
    @Override
    public String toString() {
        return "Nome: " + nome + "   RGM: " + rgm;
    }
}