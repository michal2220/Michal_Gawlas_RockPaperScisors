import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String scanString() {
        String in = scanner.nextLine();
        return in;
    }

    public int scanInt() {
        int in = scanner.nextInt();
        return in;
    }

    public void scanReset() {
        scanner.nextLine();
    }

    @Override
    public String toString() {
        return "Input{" +
                "scanner=" + scanner +
                '}';
    }
}
