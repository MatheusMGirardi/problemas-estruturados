package Circular;

public class FilaCircular {
    private int[] fila;
    private int capacidade;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaCircular(int capacidade) {
        this.capacidade = capacidade;
        this.fila = new int[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    public boolean cheia() {
        return tamanho == capacidade;
    }

    public boolean vazia() {
        return tamanho == 0;
    }

    public void insere(int elemento) {
        if (!cheia()) {
            fim = (fim + 1) % capacidade;
            fila[fim] = elemento;
            tamanho++;
        } else {
            System.out.println("Fila está cheia");
        }
    }

    public void remove() {
        if (!vazia()) {
            int elemento = fila[inicio];
            System.out.println("Elemento removido: " + elemento);
            inicio = (inicio + 1) % capacidade;
            tamanho--;
        } else {
            System.out.println("Fila está vazia");
        }
    }

    public int primeiro() {
        if (!vazia()) {
            return fila[inicio];
        } else {
            System.out.println("Fila está vazia");
            return -1;
        }
    }

    public int ultimo() {
        if (!vazia()) {
            return fila[fim];
        } else {
            System.out.println("Fila está vazia");
            return -1;
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public void mostrarFila() {
        if (vazia()) {
            System.out.println("Fila está vazia");
            return;
        }

        System.out.print("Elementos da Fila: ");
        int i = inicio;
        for (int count = 0; count < tamanho; count++) {
            System.out.print(fila[i] + " ");
            i = (i + 1) % capacidade;
        }
        System.out.println();
    }
}
