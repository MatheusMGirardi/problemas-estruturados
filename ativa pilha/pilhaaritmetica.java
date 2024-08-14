
import java.util.ArrayList;


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
            this.dado.add(desisto);
            this.topoindex++;
        }else{
            switch(desisto){
                case '}':
                    if (topo() == '{'){this.desempilha();}
                        this.dado.add(desisto);
                        break;
                case ')':
                    if (topo() == '('){this.desempilha();}
                        this.dado.add(desisto);
                        break;
                case ']':
                    if (topo() == '['){this.desempilha();}
                        this.dado.add(desisto);
                        break;
                default:
                    break;
            }
        }
    }

    public void desempilha() {
        if (vazia() == 1) {
            System.out.println("Pilha vazia.");
        } else {
            this.dado.remove(this.topoindex.intValue());
            this.topoindex--;
        }
    }
        public void flush() {
        while (topoindex != -1) {
            desempilha();
            }
        }
        
        public void check(){
        if(this.vazia() == 1){
            System.out.println("Expressão boa.");
        } else{
            System.out.println("Expressão ruim.");
        }
        }
    
    
    public static void main(String[] args){
        pilhaaritmetica stack = new pilhaaritmetica();
        String expressaoBoa = "(A + B) + C + { B * [C + B]}";
        String expressaoRuim = "(A + B { D  + C}])";
    
        for(int i = 0; i < expressaoBoa.length(); i++){
            char c = expressaoBoa.charAt(i);
            stack.empilha(c);
        }
        stack.check();   
        stack.flush();
        for(int i = 0; i < expressaoRuim.length(); i++){
            char c = expressaoRuim.charAt(i);
            stack.empilha(c);
        }
        stack.check();
    }
}
