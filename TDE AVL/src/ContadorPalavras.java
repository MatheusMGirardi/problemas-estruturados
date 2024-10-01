import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ContadorPalavras {
    ArvoreAVLPalavras avl = new ArvoreAVLPalavras();

    public void processarArquivos(String diretorio) {
        File folder = new File(diretorio);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null) {
            System.out.println("O diretório está vazio ou não existe.");
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                contarPalavrasNoArquivo(file);
            }
        }

        System.out.println("Palavras processadas e inseridas na árvore AVL.");
    }

    private void contarPalavrasNoArquivo(File arquivo) {
        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNext()) {
                String palavra = scanner.next().toLowerCase();
                avl.raiz = avl.insereElemento(avl.raiz, palavra);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + arquivo.getName());
        }
    }

    public void buscarPalavra(String palavra) {
        PalavraFrequencia resultado = avl.buscaPalavra(avl.raiz, palavra.toLowerCase());
        if (resultado != null) {
            System.out.println("A palavra \"" + palavra + "\" aparece " + resultado.getFrequencia() + " vezes.");
        } else {
            System.out.println("A palavra \"" + palavra + "\" não foi encontrada.");
        }
    }
}
