//Expression.java
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Expression {
   private ArrayList<Token> expression;
public Expression(String exp) {
       // Create the array
       expression = new ArrayList<Token>();
           StringTokenizer strTok = new StringTokenizer(exp, " ");
       // Scan the input
       while (strTok.hasMoreElements()) {
           Token tok = new Token((String) strTok.nextElement());
           expression.add(tok);
       }
   }
public Expression() {
       // Create the array that represents the body of the Expression
       expression = new ArrayList<Token>();
   }
   public int size() {
       return expression.size();
   }
       public void add(Token newElement) {
       expression.add(newElement);
   }
   public String toString() {
       String ret = "";
       for (int i = 0; i < expression.size(); i++)
           ret = ret + expression.get(i).getBody() + " ";
       return ret;
   }
       public ArrayList<Token> getExpression() {
       return expression;
   }
}
