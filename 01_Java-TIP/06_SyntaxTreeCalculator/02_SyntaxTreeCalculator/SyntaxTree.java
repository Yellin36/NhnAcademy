package SyntaxTree;
import Tokenizer.*;

import java.util.List;
import java.util.Stack;

public class SyntaxTree {
    //syntaxTree.evaluation(expression);
    //Node root = syntaxTree.makeTree(List<Token> tokens)
    private String expression;
    public SyntaxTree() {}
    public List<Token> evaluation(String expression) {
        Tokenizer tokenizer = new Tokenizer();
        return tokenizer.evaluation(expression);
    }
    public Node makeTree(List<Token> tokens) {
        Stack<Integer> operandStack = new Stack<>();
        Stack<Node> operatorStack = new Stack<>();

        String operator = "";
        for (Token token : tokens) {
            if(token instanceof TokenOperand) {
                operandStack.add(Integer.valueOf(token.toString()));
                //if(operandStack.)
            }
            if(token instanceof TokenOperator) {
                if(token.equals("+")) {
                    operator = "+";
                    //operatorStack.add();
                }
                if(token.equals("-")) {
                    operator = "-";
                }
            }
        }
        return null;
    }

}
