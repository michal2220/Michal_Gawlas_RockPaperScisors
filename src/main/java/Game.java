public class Game {

    int gamesQuantity;

    private int getGamesQuantity() {
        return gamesQuantity;
    }

    private void setGamesQuantity(int gamesQuantity) {
        this.gamesQuantity = gamesQuantity;
    }

    public int howManyGames(Input input, SimpleText text) {
        text.provideGamesQuantity();
        setGamesQuantity(input.scanInt());
        input.scanReset();
        return getGamesQuantity();
    }
}
