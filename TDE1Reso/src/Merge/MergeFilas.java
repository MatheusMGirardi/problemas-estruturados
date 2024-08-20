package Merge;

public class MergeFilas {
    public static FilaCircular merge(FilaCircular filaA, FilaCircular filaB) {
        int capacidadeTotal = filaA.tamanho() + filaB.tamanho();
        FilaCircular filaC = new FilaCircular(capacidadeTotal);

        while (!filaA.vazia() && !filaB.vazia()) {
            if (filaA.primeiro() <= filaB.primeiro()) {
                filaC.insere(filaA.remove());
            } else {
                filaC.insere(filaB.remove());
            }
        }

        while (!filaA.vazia()) {
            filaC.insere(filaA.remove());
        }

        while (!filaB.vazia()) {
            filaC.insere(filaB.remove());
        }

        return filaC;
    }

}
