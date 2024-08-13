
public class pilhaaritmetica {
    Integer topoindex = -1;
    ArrayList<Character> dado = new ArrayList<>();

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

    public void empilha(char desisto) {
        if (desisto == '{' || desisto == '(' || desisto == '[') {

        }
    }

    public void desempilha() {
        if (vazia() == 1) {
            System.out.println("Pilha vazia.");
        } else {
            int item = this.dado.remove(this.topoindex.intValue());
            this.topoindex--;
        }
    }
}
