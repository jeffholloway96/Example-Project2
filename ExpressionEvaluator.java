//ExpressionEvaluator.java
public class ExpressionEvaluator {
   public int evaluate(Expression infix) {
      
       // InfixToPostfixConverter
       InfixToPostfixConverter itop = new InfixToPostfixConverter(infix);
       // Convert infix to postfix
       itop.convertToPostfix();
       Expression postfix = itop.getPostfix();
       // Print the postfix
       System.out.println("Postfix Expression: " + postfix.toString());
       // Instantiate a PostfixEvaluator
       PostfixEvaluator peval = new PostfixEvaluator(postfix);
       // Evaluate the postfix expression
       int value = peval.eval();
       // calculated value
       return value;
   }
}
