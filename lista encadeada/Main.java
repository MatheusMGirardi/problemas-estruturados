class node {
    int data;
    node next;

    public node(int data) {
        this.data = data;
        this.next = null;
    }
}

class lista {
    private node head;
    private node last;
    private int size;

    public lista() {
        this.head = null;
        this.last = null;
        this.size = 0;
    }

    public void add(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            last = newNode;
            size++;
        }
    }

    public void printLista() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }
        node current = head;
        while (current != null) {
            System.out.println(current.data + ' ');
            current = current.next;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }
}

public class Main {
    public static void main(String[] args) {
        lista list = new lista();
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println("Elementos da lista encadeada:");
        list.printLista();
    }
}
