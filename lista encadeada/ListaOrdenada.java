class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class ListaOrdenada {
    private Node head;
    private Node last;
    private int size;

    public ListaOrdenada() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    // Método para adicionar um elemento de forma ordenada
    public void add(int data) {
        Node newNode = new Node(data);

        // a) Se a lista estiver vazia
        if (head == null) {
            head = newNode;
            last = newNode;
        }
        // b) Se o elemento for menor que o primeiro
        else if (data < head.data) {
            newNode.next = head;
            head = newNode;
        }
        // c) Se o elemento for maior que o último
        else if (data > last.data) {
            last.next = newNode;
            last = newNode;
        }
        // d) Se o elemento for intermediário
        else {
            Node current = head;
            Node previous = null;

            // Encontrar a posição correta para inserção
            while (current != null && current.data < data) {
                previous = current;
                current = current.next;
            }

            // Inserir o novo nó na posição correta
            newNode.next = current;
            previous.next = newNode;
        }

        size++;
    }

    public void printLista() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}

class Main {
    public static void main(String[] args)
        ListaOrdenada list = new ListaOrdenada();
        list.add(20);
        list.add(10);
        list.add(30);
        list.add(15);

        System.out.println("Elementos da lista encadeada ordenada:");
        list.printLista();
    }

