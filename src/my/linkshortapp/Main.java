package my.linkshortapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LinkShortHelper lsh = new LinkShortHelper();

        while (true) {
            System.out.println("type 'shorten <URL>' to shorten link");
            System.out.println("type 'get <URL>' to get full link");
            System.out.println("type 'exit' to end execution");

            String s = System.console().readLine();

            if (s.equals("exit")) {
                return;
            } else {
                if (s.startsWith("shorten ")) {
                    lsh.shortenLink(s.split(" ")[1]);
                } else if (s.startsWith("get ")) {
                    lsh.getFullLink(s.split(" ")[1]);
                }
            }
        }
    }
}