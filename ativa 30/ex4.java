import java.util.Scanner;

public class ex4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de pessoas a serem cadastradas: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        Pessoa[] pessoas = new Pessoa[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Pessoa " + (i + 1) + ":");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Sobrenome: ");
            String sobrenome = scanner.nextLine();

            System.out.print("Idade: ");
            int idade = scanner.nextInt();

            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();

            pessoas[i] = new Pessoa(nome, sobrenome, idade, salario);
        }

        System.out.println("\nInformações das pessoas cadastradas:");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }

        scanner.close();
    }
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
   

