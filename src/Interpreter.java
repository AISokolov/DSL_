import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Interpreter {
    int iterator = 0;
    public LinkedList<Token> tokens = new LinkedList<Token>();
    public int len;
    public Map<String,String > exp = new HashMap<>();
    public Map<String,String > exp1 = new HashMap<>();
    Interpreter(LinkedList<Token> tokens, int len) {
        this.tokens = tokens;
        this.len = len;
    }
    public void scan() {
        for (int i = 0;i < len; i++ ){
            inter();
        }
    }
    public void inter() {
        Token currentToken = tokens.get(iterator);
            if (currentToken.type == "VAR") {
                exp.put(currentToken.type, String.valueOf(currentToken.token));
                currentToken = tokens.get(iterator);
                iterator++;
            }
            if (currentToken.type == "ASSIGNMENT OPERATOR") {
                currentToken = tokens.get(iterator);
                System.out.println("gdf");
            }
            if (currentToken.type == "DIGIT") {
                exp.put(currentToken.type, String.valueOf(currentToken.token));
                currentToken = tokens.get(iterator);
            }
            if (currentToken.type == "OPERATOR") {
                exp.put(currentToken.type, String.valueOf(currentToken.token));
                String op = String.valueOf(currentToken.token);
                if (op.equals("+")){
                   plus();
                }
                currentToken = tokens.get(iterator);
            }
                iterator++;
            if (currentToken.type == "DIGIT") {
                exp.put(currentToken.type, String.valueOf(currentToken.token));
                currentToken = tokens.get(iterator);
            }
    }
    public void plus(){
        System.out.println(exp);
        System.out.println("gdf");
    }
}
