import SyntaxTree.*;

public class SyntaxNodeTest {
    public static void main(String[] args) {

        System.out.println(new NodeMultiply(new NodeConstant(5)
                , new NodeAdd(new NodeConstant(3), new NodeConstant(1))));

        String[] expression = {"2", "-", "1", "+" , "6"};
        Node leftOperand=null, rightOperand= null, root = null;
        String operator = "";
        for(String token : expression) {
            switch(token) {
                case "+":
                case "-":
                    operator = token;
                    break;
                default :
                    if(leftOperand ==null) {
                        leftOperand = new NodeConstant(Integer.parseInt(token));
                    }
                    else {
                        rightOperand = new NodeConstant(Integer.parseInt(token));
                        if(operator.equals("+")) {
                            leftOperand = new NodeAdd(leftOperand, rightOperand);
                        }
                        else {
                            leftOperand = new NodeSubtract(leftOperand, rightOperand);
                        }
                    }
            }
        }
        System.out.println(leftOperand + " = " + leftOperand.getValue());
    }
}
