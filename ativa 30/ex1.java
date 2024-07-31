public class ex1 {
   public static void main(String[] args) {
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner sc = new Scanner(System.in);

        // Pede ao usuário para digitar o tamanho do vetor
        System.out.println("Digite o tamanho do vetor:");

        // Lê um número inteiro do usuário
        int tamanho = sc.nextInt();

        // Cria um vetor com o tamanho especificado pelo usuário
        int[] vetor = new int[tamanho];

        // Pede ao usuário para digitar os elementos do vetor
        System.out.println("Digite os elementos do vetor:");
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = sc.nextInt();
        }

        // Calcula a soma dos elementos do vetor
        int soma = 0;
        for (int num : vetor) {
            soma += num;
        }

        // Calcula a média
        double media = (double) soma / tamanho;

        // Exibe a média dos elementos do vetor
        System.out.println("A média dos elementos do vetor é: " + media);

        // Fecha o Scanner
        sc.close();
    } 
}
