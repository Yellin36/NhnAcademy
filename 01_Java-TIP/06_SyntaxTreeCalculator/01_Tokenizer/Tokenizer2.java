package parser;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer2 {
    public static List<String> function(String line) {
        List<String> list = new ArrayList<>();
        int i=0;
        while(i < line.length()) {
            System.out.println(line.charAt(i) + ": "  +list + ", " + list.size());
            switch(line.charAt(i)) {
                case '0' :
                case '1':
                case '2':
                case '3' :
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9': {
                    StringBuilder number = new StringBuilder();
                    while (i < line.length() && Character.isDigit(line.charAt(i))) {
                        number.append(line.charAt(i));
                        i++;
                    }
                    list.add(number.toString());
                }
                break;
                case '-': {
                    if((list.size() == 0)
                            || list.get(list.size() - 1).equals("(")
                            || list.get(list.size() - 1).equals("+")
                            || list.get(list.size() - 1).equals("-")
                            || list.get(list.size() - 1).equals("/")
                            || list.get(list.size() - 1).equals("*")) {
                        StringBuilder number = new StringBuilder();
                        number.append('-');
                        i++;
                        if(!Character.isDigit(line.charAt(i))) {
                            throw new InvalidParameterException("Invalid expression");
                        }

                        while(i < line.length() && Character.isDigit(line.charAt(i))) {
                            number.append(line.charAt(i));
                            i++;
                        }
                        list.add(number.toString());
                        break;
                    }
                }
                case '+':
                case '*':
                case '/':
                case '(':
                case ')': {
                    list.add(String.valueOf(line.charAt(i)));
                    i++;
                }
                break;

                case ' ':
                case '\t': {
                    i++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        //System.out.println(parseMorpheme("10+2"));
        //System.out.println(parseMorpheme("10+2/34 - 31"));
        //System.out.println("10+100/34 - 31 --> " + function("10+100/34 - 31"));
        System.out.println(function("-10- -2/(-34 - 31)"));
    }
}
