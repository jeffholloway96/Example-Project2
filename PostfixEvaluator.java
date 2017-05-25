//PostfixEvaluator.java
import java.util.ArrayList;
public class PostfixEvaluator {
   // -----------------------------------------------------------------
   // Input postfix expression
   private Expression postfixExpression;
   // -----------------------------------------------------------------
   // Value of expression
   private int valueOfExpression;
   // -----------------------------------------------------------------
   /**
   * Constructs evaluator from postfix expression
   */
   public PostfixEvaluator(Expression postfix) {
       postfixExpression = postfix;
   }
   // -----------------------------------------------------------------
   /**
   * Evaluates the postfixExpression
   *
   * @return value
   */
   public int eval() {
       // Starts with an empty operand stack
       ArrayListStack<Token> operandStack = new ArrayListStack<Token>();
       // Temp variable
       Token nextToken;
       ArrayList<Token> postfix = postfixExpression.getExpression();
       // Main Loop: Parse the postfix expression
       for (int k = 0; k < postfix.size(); k++) {
           // Get the next token from postfix
           nextToken = postfix.get(k);
           // If it is an operand, push it into stack
           if (nextToken.isOperand()) {
               operandStack.push(nextToken);
               // System.out.println(operandStack);
           }
           // If it is an operator,
           else if (nextToken.isOperator()) {
               // Get two operands out of the stack
               if (operandStack.isEmpty()) {
                   System.out.println("Error in PostfixEvaluator.eval() "
                           + "-- Input expression was probably wrong");
                   return Integer.MIN_VALUE;
               }
               Token operand2 = operandStack.pop();
               if (operandStack.isEmpty()) {
                   System.out.println("Error in PostfixEvaluator.eval() "
                           + "-- Input expression was probably wrong");
                   return Integer.MIN_VALUE;
               }
               Token operand1 = operandStack.pop();
               // Perform the operation
               Token result = calculate(nextToken, operand1, operand2);
               // Push the result back into the stack
               operandStack.push(result);
               // System.out.println(operandStack);
           }
       }
       // At the end, if only one element is left in the stack
       if (operandStack.isEmpty()) {
           System.out.println("Error in PostfixEvaluator.eval() "
                   + "-- Input expression was probably wrong");
           return Integer.MIN_VALUE;
       }
       // Get the operand out of the stack, and convert it into
       // an integer
       Token topToken = operandStack.pop();
       valueOfExpression = Integer.parseInt(topToken.getBody());
       if (operandStack.isEmpty())
           return valueOfExpression;
       else {
           System.out.println("Error in PostfixEvaluator.eval() "
                   + "-- Input expression was probably wrong");
           return Integer.MIN_VALUE;
       }
   }
   // -----------------------------------------------------------------
   /**
   * Performs an arithmetic operation
   *
   * @param operator
   * @param operand1
   * @param operand2
   * @return
   */
   private Token calculate(Token operatorToken, Token operand1Token,
           Token operand2Token) {
       // Get the operator from the token
       String operator = operatorToken.getBody();
       // Get the two operands by converting from String to int
       int operand1 = Integer.parseInt(operand1Token.getBody());
       int operand2 = Integer.parseInt(operand2Token.getBody());
       // Default return value, in case an error occurs
       int result = Integer.MAX_VALUE;
       // Perform the operation, and set a value for result
       if (operator.equals("<")) {
           if (operand1 < operand2)
               result = 1;
           else
               result = 0;
       } else if (operator.equals("<=")) {
           if (operand1 <= operand2)
               result = 1;
           else
               result = 0;
       } else if (operator.equals(">")) {
           if (operand1 > operand2)
               result = 1;
           else
               result = 0;
       } else if (operator.equals(">=")) {
           if (operand1 >= operand2)
               result = 1;
           else
               result = 0;
       } else if (operator.equals("==")) {
           if (operand1 == operand2)
               result = 1;
           else
               result = 0;
       } else if (operator.equals("!=")) {
           if (operand1 != operand2)
               result = 1;
           else
               result = 0;
       } else if (operator.equals("||")) {
           if (operand1 != 0 || operand2 != 0)
               result = 1;
           else
               result = 0;
       } else if (operator.equals("&&")) {
           if (operand1 != 0 && operand2 != 0)
               result = 1;
           else
               result = 0;
       } else if (operator.equals("+")) {
           result = operand1 + operand2;
       } else if (operator.equals("-")) {
           result = operand1 - operand2;
       } else if (operator.equals("*")) {
           result = operand1 * operand2;
       } else if (operator.equals("/")) {
           if (operand2 != 0)
               result = operand1 / operand2;
           else
               System.out.println("Division by zero error in"
                       + " PostfixEvaluator.calculate().");
       } else if (operator.equals("%")) {
           if (operand2 != 0)
               result = operand1 % operand2;
           else
               System.out.println("Division by zero error in"
                       + " PostfixEvaluator.calculate().");
       } else {
           System.out.println("Illegal Operator in "
                   + "PostfixEvaluator.calculate()");
       }
       // Convert res into a Token and return it.
       return new Token("" + result);
   }
}
