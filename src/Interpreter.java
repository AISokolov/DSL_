import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class Interpreter {
    int iterator = 0;
    public LinkedList<Token> tokens = new LinkedList<Token>();
    public int len;
    public LinkedList<String> exp = new LinkedList<String>();
    public LinkedList<String> exp1 = new LinkedList<String>();
    public LinkedList<String> variables = new LinkedList<String>();
    public ArrayList<String> operator = new ArrayList<String>();
    Interpreter(LinkedList<Token> tokens, int len) {
        this.tokens = tokens;
        this.len = len;
    }
    public void scan() throws ParseExc, IOException {
        for (int i = 0;i < len; i++ ){
            inter();
        }
    }
    public void inter() {
        Token currentToken = tokens.get(iterator);
        if (currentToken.type == "VAR") {
            var(currentToken);
            currentToken = tokens.get(iterator);
        }
        if (currentToken.type == "ASSIGNMENT OPERATOR") {
            as(currentToken);
            currentToken = tokens.get(iterator);
        }
        if (currentToken.type == "DIGIT") {
            dig(currentToken);
            currentToken = tokens.get(iterator);
        }
        if (currentToken.type == "OPERATOR") {
            op(currentToken);
            currentToken = tokens.get(iterator);
        }
        if (currentToken.type == "DIGIT") {
            dig(currentToken);
            currentToken = tokens.get(iterator);
        }
        if (currentToken.type == "ENDLINE") {
            end(currentToken);
            currentToken = tokens.get(iterator);
        }

//        if (currentToken.type == "IF OPERATION"){
//            iterator++;
//            if_(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "L_BRACKET"){
//            iterator++;
//            LB(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "VAR") {
//            iterator++;
//            var(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "OPERATOR") {
//            iterator++;
//            op(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "DIGIT") {
//            iterator++;
//            dig(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "R_BRACKET"){
//            iterator++;
//            RB(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "COLON"){
//            iterator++;
//            colon(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "VAR") {
//            iterator++;
//            var(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "ASSIGNMENT OPERATOR") {
//            iterator++;
//            as(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "DIGIT") {
//            iterator++;
//            dig(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "OPERATOR") {
//            iterator++;
//            op(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "DIGIT") {
//            iterator++;
//            dig(currentToken);
//            currentToken = tokens.get(iterator);
//        }
//        if (currentToken.type == "ENDLINE") {
//            end(currentToken);
//            currentToken = tokens.get(iterator);
//        }
        ex(currentToken);
        if__(currentToken);
    }
    public void var(Token currentToken){
        String var = String.valueOf(currentToken.token);
        variables.add(var);
        iterator++;
    }
    public void as(Token currentToken){
        String as = String.valueOf(currentToken.token);
        exp.add(as);
        iterator++;
    }
    public void dig(Token currentToken){
        String dig = String.valueOf(currentToken.token);
        exp1.add(dig);
        iterator++;
    }
    public void op(Token currentToken){
        String op = String.valueOf(currentToken.token);
        exp.add(op);
        operator.add(op);
        iterator++;
    }
    public void end(Token currentToken){
        String end = String.valueOf(currentToken.token);
        exp.add(end);
    }
    public void if_(Token currentToken){
        String if_ = String.valueOf(currentToken.token);
        exp.add(if_);
    }
    public void LB(Token currentToken){
        String LB = String.valueOf(currentToken.token);
        exp.add(LB);
    }
    public void RB(Token currentToken){
        String RB = String.valueOf(currentToken.token);
        exp.add(RB);
    }
    public void colon(Token currentToken){
        String colon = String.valueOf(currentToken.token);
        exp.add(colon);
    }
    public void ex(Token currentToken){
        String op = String.valueOf(operator);
        if(op.equals("[-]")){
            int a = Integer.parseInt(exp.pop());
            int b = Integer.parseInt(exp1.getLast());
            int res = a - b;
            System.out.println(variables + " = " + res);
        }
        if(op.equals("[+]")){
            int a = exp1.push(currentToken.token);
            int b = Integer.parseInt(exp1.getLast());
            int res = a + b;
            System.out.println(variables + " = " + res);
        }
        if(op.equals("[*]")){
            int a = Integer.parseInt(exp1.getFirst());
            int b = Integer.parseInt(exp1.getLast());
            int res = a * b;
            System.out.println(variables + " = " + res);
        }
        if(op.equals("[/]")){
            int a = Integer.parseInt(exp1.getFirst());
            int b = Integer.parseInt(exp1.getLast());
            int res = a / b;
            System.out.println(variables + " = " + res);
        }
    }
    public void if__(Token currentToken){

    }
}
