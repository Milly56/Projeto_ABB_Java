public class Aluno {
    private String nome;
    private String rgm;
 
    public Aluno(String nome, String rgm) {
        this.nome = nome;
        this.rgm = rgm;
    }
 
    public String getNome() {
        return nome;
        // acessar a variável nome do objeto Aluno de fora da classe Aluno, retorna o valor atual da variável.
    }
 
    public void setNome(String nome) {
        this.nome = nome;
        // alterar o valor da variável Nome de fora da classe Aluno.
    }
 
    public String getRgm() {
        return rgm;
        // acessar a variável rgm do objeto Aluno de fora da classe Aluno, retorna o valor atual da variável.
    }
 
    public void setRgm(String rgm) {
        this.rgm = rgm;
        // alterar o valor da variável Rgm de fora da classe Rgm.
    }
 
    @Override
    public String toString() {
        return "Nome: " + nome + "\nRGM: " + rgm;
        // isso é para imprimir da forma útil informações legíveis dessa variáveis.
    }
}
