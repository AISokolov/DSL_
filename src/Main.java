import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.regex.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws ParseExc, IOException {
        String[] exp = {
                "v = 1;",
                ".main()  a = 5;",
                "IF (a ~ 5): b = 7 * c;",
                "DO a = 7 WHILE (a < 7);",
                "WHILE (a < 10) a = 2;",
                "a = 1;"};
        int len = exp.length;
        TokenType lex = new TokenType();
        LinkedList<Token> tokens = new LinkedList<Token>();
        String str = "";
        int counter = 0;
        for (int j = 0; j < exp.length;j++){
            for (int i = 0; i < exp[j].length(); i++) {
                if (exp[j].toCharArray()[i] == ' ') {
                    continue;
                }
                str += exp[j].toCharArray()[i];
                String str_ = "";
                if (i < exp[j].length() - 1) {
                    str_ = str + exp[j].toCharArray()[i + 1];
                }
                for (String key : lex.regexp.keySet()) {
                    Pattern p = Pattern.compile(lex.regexp.get(key));
                    Matcher m_1 = p.matcher(str);
                    Matcher m_2 = p.matcher(str_);
                    if (m_1.find() && !m_2.find()) {
                        tokens.add(new Token(key, str));
                        str = "";
                    }
                }
            }
        }
        for (Token t : tokens) {
            counter++;
            System.out.println("Token [" + counter + "] "+"Type of Regular Exp.: "+ t.type + "; Token: " + t.token);
        }
        Parser par = new Parser(tokens, len);
        par.lang();
        Interpreter in = new Interpreter(tokens, len);
        in.scan();
    }
}
