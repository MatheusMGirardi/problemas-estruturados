package Circular;

public class Main {
    public static void main(String[] args) {
        FilaCircular fila = new FilaCircular(5);

        fila.insere(10);
        fila.insere(20);
        fila.insere(30);

        System.out.println("Primeiro elemento: " + fila.primeiro());
        System.out.println("Último elemento: " + fila.ultimo());

        fila.remove();
        System.out.println("Primeiro elemento após remoção: " + fila.primeiro());

        fila.insere(40);
        fila.insere(50);
        fila.insere(60);

        System.out.println("Último elemento após inserções: " + fila.ultimo());

        if (fila.cheia()) {
            System.out.println("A fila está cheia.");
        } else {
            System.out.println("A fila não está cheia.");
        }

        if (fila.vazia()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("A fila não está vazia.");
        }

        fila.mostrarFila();

        System.out.println("Tamanho da Fila: " + fila.tamanho());
    }
}
