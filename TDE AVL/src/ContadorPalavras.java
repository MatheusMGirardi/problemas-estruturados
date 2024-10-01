import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContadorPalavras {
    ArvoreAVLPalavras avl = new ArvoreAVLPalavras();

    public void processarArquivos(String diretorio, String palavraChave) {
        File folder = new File(diretorio);
        File[] listOfFiles = folder.listFiles();

        int totalOcorrencias = 0;

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                int ocorrenciasArquivo = contarPalavraNoArquivo(file, palavraChave);
                totalOcorrencias += ocorrenciasArquivo;

                System.out.println("Arquivo \"" + file.getName() + "\": " + ocorrenciasArquivo);
            }
        }

        System.out.println("Total de ocorrências de \"" + palavraChave + "\": " + totalOcorrencias);
    }

    private int contarPalavraNoArquivo(File arquivo, String palavraChave) {
        int ocorrencias = 0;

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNext()) {
                String palavra = scanner.next().replaceAll("[^a-zA-Z]", "").toLowerCase();
                avl.raiz = avl.insereElemento(avl.raiz, palavra);

                if (palavra.equals(palavraChave.toLowerCase())) {
                    ocorrencias++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + arquivo.getName());
        }

        return ocorrencias;
    }
}
