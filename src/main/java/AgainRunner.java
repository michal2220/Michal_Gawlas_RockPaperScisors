import java.util.Scanner;

public class AgainRunner {

    private boolean runAgain = true;
    private String makingSure;
    private Input scanner;

    public AgainRunner(Input scanner) {
        this.scanner = scanner;
    }

    public boolean runner() {
        makingSure = scanner.scanString();
        while (!makingSure.equals("x") && !makingSure.equals("n")) {
            System.out.println("Enter x or n");
            makingSure = scanner.scanString();
        }
        if (makingSure.equals("x")) {
            System.out.println("""
                    Are You sure you want to finnish?
                    'y' - yes
                    else - no, play again
                    """);

            makingSure = scanner.scanString();

            if (makingSure.equals("y")) {
                runAgain = false;
                System.out.println("Ending game");
            } else {
                runAgain = true;
            }
        }
        if (makingSure.equals("n")) {
            runAgain = true;
        }
        return runAgain;
    }
}
