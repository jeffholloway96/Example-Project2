//ArrayListStack.java
IMPORT java.util.ArrayList;
public class ArrayListStack<T> implements IStack<T> {
   private ArrayList<T> stackBody;
   public ArrayListStack() {
       stackBody = new ArrayList<T>();
   }
   public boolean isEmpty() {
       return (stackBody.size() == 0);
   }
   public void push(T item) {
       stackBody.add(item);
   }
   public T pop() {
       if (isEmpty()) {
           System.out.println("Error in ArrayStack.pop() ? Stack Empty ");
           return null;
       } else {
           T topElement = stackBody.get(stackBody.size() - 1);
           stackBody.remove(stackBody.size() - 1);
           return topElement;
       }
   }
   public TTOP () {
       if (isEmpty()) {
           System.out.println("Error in ArrayStackTOP () ? Stack Empty ");
           return null;
       } else {
           T topElement = stackBody.get(stackBody.size() - 1);
           return topElement;
       }
   }
}
