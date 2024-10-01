import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();
        NoAVL raiz = null;

        // Inserindo elementos na árvore
        raiz = avl.insereElemento(raiz, 10);
        raiz = avl.insereElemento(raiz, 20);
        raiz = avl.insereElemento(raiz, 30);
        raiz = avl.insereElemento(raiz, 40);
        raiz = avl.insereElemento(raiz, 50);
        raiz = avl.insereElemento(raiz, 25);

        // Imprimindo em diferentes ordens
        System.out.println("Árvore AVL em Pré-Ordem:");
        avl.imprimePreOrdem(raiz);
        System.out.println();

        System.out.println("Árvore AVL em In-Ordem:");
        avl.imprimeInOrdem(raiz);
        System.out.println();

        System.out.println("Árvore AVL em Pós-Ordem:");
        avl.imprimePosOrdem(raiz);
        System.out.println();

        // Verificando se um elemento existe
        int elementoBusca = 30;
        if (avl.existeElemento(raiz, elementoBusca)) {
            System.out.println("O elemento " + elementoBusca + " existe na árvore.");
        } else {
            System.out.println("O elemento " + elementoBusca + " não existe na árvore.");
        }

        // Removendo um elemento
        raiz = avl.removeElemento(raiz, 20);
        System.out.println("Árvore após remover o elemento 20:");
        avl.imprimeInOrdem(raiz);
        System.out.println();

        // Verificando a altura da árvore
        System.out.println("Altura da árvore: " + avl.altura(raiz));



        //AVL de palavras
        ContadorPalavras contador = new ContadorPalavras();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o termo a ser pesquisado: ");
        String termo = scanner.nextLine();

        System.out.print("Entre com o diretório dos arquivos .txt: ");
        String diretorio = scanner.nextLine();

        contador.processarArquivos(diretorio, termo);

    }
}
