// Token.java

public class Token {
   // -------------------------------------------------------------
  
   // It classifies the following as "OPERATORS".
   private final static String[] validOperators = { "<", "<=", ">", ">=",
           "==", "!=", "||", "&&", "+", "-", "*", "/", "%" };
   // -------------------------------------------------------------
  
   private final static char OPENPAREN = '(';
   private final static char CLOSEDPAREN = ')';
   // -------------------------------------------------------------
  
   // Holds contents of token
   private String body;
       public Token(String body) {
       this.body = body;
   }
   public String getBody() {
       return body;
   }
       public boolean isOperator() {
       for (int i = 0; i < validOperators.length; i++) {
           if (validOperators[i].equals(body)) {
               return true;
           }
       }
       return false;
   }
       public boolean isOpenParen() {
       char ch = body.charAt(0);
       return (ch == OPENPAREN);
   }
       public boolean isClosedParen() {
       char ch = body.charAt(0);
       return (ch == CLOSEDPAREN);
   }
  
   public boolean isOperand() {
       return (!((isOperator() || isOpenParen() || isClosedParen())));
   }
   public int getPrecedence() {
       if (body.equals("<") || body.equals("<=") || body.equals(">")
               || body.equals(">="))
           return 1;
       else if (body.equals("==") || body.equals("!="))
           return 2;
       else if (body.equals("||"))
           return 3;
       else if (body.equals("&&"))
           return 4;
       else if (body.equals("+") || body.equals("-"))
           return 5;
       else if (body.equals("*") || body.equals("/") || body.equals("%"))
           return 6;
       return -1;
   }
   public String toString() {
       return body;
   }
}
