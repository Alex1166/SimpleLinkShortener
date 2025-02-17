package my.linkshortapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LinkShortHelper ls = new LinkShortHelper();
        InputOutputHelper io = new InputOutputHelper();

        io.printHelpMessage();

        while (true) {
            String s = io.readInput();

            if (s.equals("exit")) {
                return;
            } else {
                if (s.startsWith("shorten ")) {
                    try {
                        io.printResult(ls.shortenLink(s.split(" ")[1]));
                    } catch (Exception e) {
                        io.printResult(e.getMessage());
                    }
                } else if (s.startsWith("get ")) {
                    io.printResult(ls.getFullLink(s.split(" ")[1]));
                }
            }
        }
    }
}