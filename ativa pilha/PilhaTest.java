
public class PilhaTest {
    public static void main(String[] args) {
        pilha stack = new pilha(2);

        // Test empilha method
        stack.empilha(9);
        stack.empilha(19);
        stack.empilha(29);

        // Test empilha when stack is full
        stack.empilha(39); // Should print "Pilha cheia."

        // Test desempilha method
        System.out.println(stack.desempilha()); // Should print 29
        System.out.println(stack.desempilha()); // Should print 19
        System.out.println(stack.desempilha()); // Should print 9

        // Test desempilha when stack is empty
        System.out.println(stack.desempilha()); // Should print "Pilha vazia." and return -1 or throw an exception
    }
}