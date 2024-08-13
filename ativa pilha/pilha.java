
import java.util.ArrayList;

public class pilha {
    Integer topoindex = -1;
    ArrayList<Integer> dado = new ArrayList<>();
    Integer max;

    public pilha(int max) {
        this.max = max;
    }

    public int topo() {
        return this.dado.get(this.topoindex);
    }

    public int vazia() {
        if (this.topoindex == -1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int cheia() {
        if (this.topoindex == this.max) {
            return 1;
        } else {
            return 0;
        }
    }

    public void empilha(int desisto) {
        if (this.cheia() == 1) {
            System.out.println("Pilha cheia.");
        } else {
            this.dado.add(desisto);
            this.topoindex++;
        }
    }

    public int desempilha() {
        if (vazia() == 1) {
            System.out.println("Pilha vazia.");
            return -1;
        } else {
            int item = this.dado.remove(this.topoindex.intValue());
            this.topoindex--;
            return item;
        }

    }
}