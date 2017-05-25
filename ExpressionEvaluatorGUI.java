//ExpressionEvaluatorGUI.java
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ExpressionEvaluatorGUI extends JFrame {
       private ExpressionEvaluator expressionEvaluator;
   private JLabel expressionLabel;
   private JLabel expressionValueLabel;
   private JTextField expressionField;
   private JTextField expressionValueField;
   // -----------------------------------------------------------------
   // Declare Buttons
   private JButton calculateButton;
   private JButton quitButton;
   public ExpressionEvaluatorGUI(ExpressionEvaluator expressionEvaluator) {
       // Set expression evaluator
       this.expressionEvaluator = expressionEvaluator;
       instantiateGUIComponents();
       buildGUI();
       addListeners();
       // Set default jframe close operation
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // SetWINDOW  size
       pack();
       setSize(450, 325);
       // Set window visible
       setVisible(true);
   }
   // --------------------------------------------------------------
   /**
   * Instantiates the GUI components
   */
   private void instantiateGUIComponents() {
       // Initialize GUI Copmponents
       // Initialize Labels
       expressionLabel = new JLabel("Enter Infix Expression");
       expressionValueLabel = new JLabel("Value of Expression");
       // Initialize Fields
       expressionField = new JTextField(10);
       expressionValueField = new JTextField(10);
       // Initialize Buttons
       calculateButton = new JButton("Calculate");
       quitButton = new JButton("Exit");
       // Set display fields to be not editable
       expressionValueField.setEditable(false);
   }
   // --------------------------------------------------------------
   /**
   * Builds the GUI by adding the components to the frame.
   */
   private void buildGUI() {
       // Get Pane
       Container contentPane = getContentPane();
       // Set layout
       contentPane.setLayout(new GridLayout(3, 2, 10, 10));
       // Add components
       contentPane.add(expressionLabel);
       contentPane.add(expressionField);
       contentPane.add(expressionValueLabel);
       contentPane.add(expressionValueField);
       contentPane.add(calculateButton);
       contentPane.add(quitButton);
   }
   // --------------------------------------------------------------
   /**
   * Adds listeners to the GUI buttons
   */
   private void addListeners() {
       // Add listener to search button
       calculateButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               // Set Error message
               String expressionValueStr = "Error, try again";
               // Get expression
               Expression infixExpression = new Expression(expressionField
                       .getText());
               // Evaluate Expression
               int expressionValue = expressionEvaluator
                       .evaluate(infixExpression);
               // Check if something went wrong
               if (expressionValue != Integer.MIN_VALUE) {
                   expressionValueStr = Integer.toString(expressionValue);
               }
               // Set expression value field
               expressionValueField.setText(expressionValueStr);
           }
       });
       // Add listener to quit button
       quitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });
   }
       public static void main(String[] args) {
       // Instantiate an ExpressionEvaluator
       ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
       // Create instance of expression evaluator gui
       new ExpressionEvaluatorGUI(expressionEvaluator);
   }
}
