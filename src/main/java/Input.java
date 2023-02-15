import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);
    private  String scanLine;

    public String scanString() {
        scanLine = scanner.nextLine();
        return scanLine;
    }

    public String getScanLine() {
        return scanLine;
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
