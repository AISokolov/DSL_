public class ParseExc extends Exception{
    String expected;
    Token token;
    int iterator;
    public void getMsg(Token currentToken, String expected){
        System.out.println("Token [" + iterator + "] " + currentToken.type + " but expected: " + expected);
    }
    public ParseExc(Token currentToken, String expected, int iterator){
        this.iterator = iterator;
        this.expected = expected;
        this.token = currentToken;
        System.out.println();
    }
}
