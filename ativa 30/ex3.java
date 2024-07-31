public class ex3 {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("João", "Silva", 30, 5000.0);

        System.out.println(pessoa);
    }

public class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    private double salario;

    public Pessoa(String nome, String sobrenome, int idade, double salario) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.salario = salario;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Nome: '" + nome + '\'' +
                ", Sobrenome: '" + sobrenome + '\'' +
                ", Idade: " + idade +
                ", Salario: " + salario +
                '}';
    }

}