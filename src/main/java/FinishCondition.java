public class FinishCondition {

    private int counter = 0;
    private boolean ending = false;
    private Input input;
    private GamesQuantityReceiver gamesQuantityReceiver;

    public FinishCondition(Input input, GamesQuantityReceiver gamesQuantityReceiver) {
        this.input = input;
        this.gamesQuantityReceiver = gamesQuantityReceiver;
    }

    public void playerEnded(Input input) {

        if (input.getScanLine().equals("x")) {
            System.out.println("""
                    Are You sure you want to finnish?
                    'y' - yes
                    'n' - no""");

            String makingSure = input.scanString();

            if (makingSure.equals("y")) {
                ending = true;
                System.out.println("Ending game");
            }
            if (makingSure.equals("n")) {
                System.out.println("Ending game canceled");
                ending = false;
            }
        }
    }

    public int countingGames() {
        counter++;
        return counter;
    }

    public void gamesLeftInfo() {
        System.out.println("Games left: " + (gamesQuantityReceiver.getGamesQuantity() - counter));
    }

    public boolean quantityEnding(GamesQuantityReceiver gamesQuantityReceiver) {
        if (gamesQuantityReceiver.getGamesQuantity() == counter) {
            ending = true;
        }
        return ending;
    }

    public boolean checkingToContinue() {
        quantityEnding(gamesQuantityReceiver);
        playerEnded(input);
        return ending;
    }
}

