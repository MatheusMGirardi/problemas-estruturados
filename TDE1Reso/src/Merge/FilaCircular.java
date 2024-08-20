package Merge;

public class FilaCircular {
    private final int[] fila;
    private final int capacidade;
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
        if (cheia()) {
            System.out.println("Fila está cheia");
            return;
        }
        fim = (fim + 1) % capacidade;
        fila[fim] = elemento;
        tamanho++;
    }

    public int remove() {
        if (vazia()) {
            System.out.println("Fila está vazia");
            return -1;
        }
        int elemento = fila[inicio];
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        return elemento;
    }

    public int primeiro() {
        if (vazia()) {
            System.out.println("Fila está vazia");
            return -1;
        }
        return fila[inicio];
    }

    public int tamanho() {
        return tamanho;
    }
}
