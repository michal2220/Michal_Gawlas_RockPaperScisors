import java.util.InputMismatchException;

public class GamesQuantityReceiver {

    private int gamesQuantity;

    private Input input;

    public GamesQuantityReceiver(Input input) {
        this.input = input;
    }

    public int getGamesQuantity() {
        return gamesQuantity;
    }

    private void setGamesQuantity(int gamesQuantity) {
        this.gamesQuantity = gamesQuantity;
    }

    public int howManyGames() {
        System.out.println("""
                Please enter how many games would You like to play
                Note that only winning games count
                Ties like "Paper - Paper" doesn't count
                """);
        boolean correct = false;

        while (!correct) {
            try {
                int quantity = input.scanInt();
                if (quantity <= 0) {
                    while (quantity <= 0) {
                        System.out.println("Enter number higher then 0");
                        quantity = input.scanInt();
                    }
                }
                setGamesQuantity(quantity);
                correct = true;
            } catch (Exception e) {
                System.out.println("Wrong input, only numbers");
                input.scanReset();
            }
        }
        input.scanReset();
        return getGamesQuantity();
    }
}
