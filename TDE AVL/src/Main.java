import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ContadorPalavras contador = new ContadorPalavras();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o diretório dos arquivos .txt: ");
        String diretorio = scanner.nextLine();
        contador.processarArquivos(diretorio);

        while (true) {
            System.out.print("Entre com a palavra para buscar (ou digite 'sair' para encerrar): ");
            String termo = scanner.nextLine();

            if (termo.equalsIgnoreCase("sair")) {
                break;
            }

            contador.buscarPalavra(termo);
        }
        scanner.close();
    }
}
