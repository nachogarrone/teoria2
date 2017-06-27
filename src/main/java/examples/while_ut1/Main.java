package examples.while_ut1;

import examples.while_ut1.ast.Exp;
import examples.while_ut1.parser.Parser;
import java_cup.runtime.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
//    public static void showTokens(String input) throws Exception {
//        Lexer lexer = Parser.makeLexer(input);
//        Symbol token = lexer.next_token();
//        while (token.sym != Tokens.EOF) {
//            System.out.println(token.sym + ": " + token.value);
//            token = lexer.next_token();
//        }
//        System.out.println("FIN");
//    }

    public static void showParse(String input) throws Exception {
        Exp exp = (Exp) (Parser.parse(input).value);
//        Symbol result = parser.parse();
//        System.out.println(result.sym + ": " + result.value);


        System.out.println(exp);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder source = new StringBuilder();
        for (String line = stdIn.readLine(); line != null; line = stdIn.readLine()) {
            if (line.length() > 0) {
                source.append(line).append("\n");
            } else { // Empty line means input ends.
//                showTokens(source.toString());
                showParse(source.toString());
            }
        }
    }
}

