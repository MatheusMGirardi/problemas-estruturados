class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class lista_encadeada {
    public Node head;
    public Node last;
    private int size;

    public lista_encadeada() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }



    public void insere_ultimo(int info) {
        Node newNode = new Node(info);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public void mostra_lista(lista_encadeada L) {
        if (L.vazia()) {
            System.out.println("Lista vazia.");
            return;
        }
        Node current = L.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean vazia() { // Verifica se a lista está vazia
        return head == null;
    }

    public void insere_primeiro(int info) {
        Node newNode = new Node(info);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public int retira_primeiro() {  // Retira o primeiro elemento da Lista e retorna o valor da info do Nó
        if (vazia()) {
            System.out.println("Lista vazia, não há elementos para remover.");
            return -1;
        }
        int valor = head.data;
        head = head.next;
        if (head == null) { // Se a lista ficou vazia, ajusta o last
            last = null;
        }
        size--;
        return valor;
    }

    public int retira_ultimo() { // Retira o último elemento da Lista e retorna a informação do Nó
        if (vazia()) {
            System.out.println("Lista vazia, não há elementos para remover.");
            return -1; // Indicativo de lista vazia
        }

        int valor;
        if (head == last) { // Apenas um elemento na lista
            valor = head.data;
            head = last = null;
        } else {
            Node current = head;
            while (current.next != last) {
                current = current.next;
            }
            valor = last.data;
            last = current;
            last.next = null;
        }
        size--;
        return valor;
    }

    public void insere_depois(Node no, int info) {
        if (no == null) {
            System.out.println("Nó inválido.");
            return;
        }

        Node newNode = new Node(info);
        newNode.next = no.next;
        no.next = newNode;

        if (no == last) {
            last = newNode;
        }

        size++;
    }

    public void insere_ordenado(int info) { // Insere o elemento info de maneira ordenada na lista
        Node newNode = new Node(info);

        if (vazia() || head.data >= info) {
            insere_primeiro(info);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data < info) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;

        if (current == last) {
            last = newNode;
        }

        size++;
    }

    public int retira_depois(Node no) { // Retira o elemento posterior ao nó No e retorna a sua informação
        if (no == null || no.next == null) {
            System.out.println("Não há elemento após o nó informado.");
            return -1;
        }

        Node temp = no.next;
        int valor = temp.data;
        no.next = temp.next;

        if (temp == last) {
            last = no;
        }

        size--;
        return valor;
    }

    public int ultimo_elemento() {  // Retorna a informação do último elemento da Lista
        if (vazia()) {
            System.out.println("Lista vazia.");
            return -1;
        }
        return last.data;
    }
}
