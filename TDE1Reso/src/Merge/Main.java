package Merge;

public class Main {
    public static void main(String[] args) {
        FilaCircular filaA = new FilaCircular(4);
        filaA.insere(12);
        filaA.insere(35);
        filaA.insere(52);
        filaA.insere(64);

        FilaCircular filaB = new FilaCircular(5);
        filaB.insere(5);
        filaB.insere(15);
        filaB.insere(23);
        filaB.insere(55);
        filaB.insere(75);

        FilaCircular filaC = MergeFilas.merge(filaA, filaB);

        System.out.println("Tamanho da Fila C: " + filaC.tamanho());

        System.out.print("Fila C: ");
        while (!filaC.vazia()) {
            System.out.print(filaC.remove() + " ");
        }
        System.out.println();
    }
}
