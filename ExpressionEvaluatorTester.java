// ExpressionEvaluatorTester.java

public class ExpressionEvaluatorTester {
  
   public static void main(String[] args) {
       // Create an array of Test Data
       Expression[] testExpressions = {
               new Expression("1 < 2"),
               new Expression("1 == 2"),
               new Expression("1 != 2"),
               new Expression("1 > 2"),
               new Expression("1 >= 2"),
               new Expression("1 <= 2"),
               new Expression("1 && 0"),
               new Expression("25 || 26"),
               new Expression("25 || 0"),
               new Expression("25 && 26"),
               new Expression("25 || 26 && 0"),
               new Expression("( 25 || 26 ) && 0"),
               new Expression("1 < 2 && 2 < 3"),
               new Expression("1 < 2 && 2 > 3"),
               new Expression("1 < 2 || 2 < 3"),
               new Expression("1 < 2 || 2 > 3"),
               new Expression("1 > 2 || 2 > 3"),
               new Expression("1 < 2 < 3"),
               new Expression("1 < 2 > 3"),
               new Expression("1 < 2 + 5"),
               new Expression("( 1 < 2 ) + 5"),
               new Expression("2 < 3 * 5 + 4"),
               new Expression("( 2 < 3 ) * ( 5 + 4 )"),
               new Expression("( 2 < 3 * 5 ) + 4"),
               new Expression("( 25 + ( 10 > 5 ) * 3 ) % 6"),
               new Expression("( 25 < 8 < 9 ) + ( 8 * 3 > 2 )"),
               new Expression("25 + 45 "),
               new Expression("10 * ( 5 + 3 )"),
               new Expression("20"),
               new Expression("10 * 5 + 3"),
               new Expression("10 * ( 7 + ( 12 - 9 ) ) / 10"),
               new Expression("100 % ( ( 3 + 2 ) + 3 ) / 4"),
               new Expression("102 % ( ( 3 + 2 * 10 ) - 10 - 5 ) / 3"),
               new Expression("( 25 + ( 10 > 5 ) * 3 ) % 6") };
      
       // Expected values of test data
       int[] expectedExpressionValues = { 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0,
               1, 0, 1, 0, 0, 1, 0, 1, 6, 1, 9, 5, 4, 2, 70, 80, 20, 53, 10,
               1, 2, 4 };
       // Instantiate an ExpressionEvaluator
       ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
      
       // All Tests Passed Boolean
       boolean allTestsPassed = true;
           for (int i = 0; i < testExpressions.length; i++) {
           int expressionValue = expressionEvaluator.evaluate(testExpressions[i]);
           boolean passed = expressionValue == expectedExpressionValues[i];
           allTestsPassed = allTestsPassed && passed;
           System.out.println("Infix Expression: " + testExpressions[i]);
           System.out.println("Value of Expression: " + expressionValue);
           System.out.println("Result: " + (passed ? "Passed" : "Failed"));
           System.out.println();
       }
      
       // Print if all tests pass or not
       System.out.println("All Tests Pass?: " + allTestsPassed);
   }
  
}
