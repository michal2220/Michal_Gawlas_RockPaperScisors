import java.util.Scanner;

public class AgainRunner {

    Scanner scanner = new Scanner(System.in);
    private boolean runAgain = true;
    private String makingSure;

    public boolean runner() {
        makingSure = scanner.nextLine();
        while (!makingSure.equals("x") && !makingSure.equals("n")) {
            System.out.println("Enter x or n");
            makingSure = scanner.nextLine();
        }
        if (makingSure.equals("x")) {
            System.out.println("""
                    Are You sure you want to finnish?
                    'y' - yes
                    else - no, play again
                    """);

            makingSure = scanner.nextLine();

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
