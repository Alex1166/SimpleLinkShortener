package my.linkshortapp;

import java.io.IOError;

public class InputOutputHelper {

    public String readInput() {
        String s;
        try {
            s = System.console().readLine();
        } catch (IOError e) {
            System.out.println(e.getMessage());
            s = null;
        }
        return s;
    }

    public void printHelpMessage() {
        System.out.println("""
                type 'shorten <URL>' to shorten link\s
                type 'get <URL>' to get full link\s
                type 'exit' to end execution""");
    }

    public void printResult(String input) {
        System.out.println(input);
    }

}
