public class RpsRunner {

    public static void main(String[] args) {

        Input input = new Input();
        Player player = new Player();
        Game game = new Game();
        FinishCondition finishCondition = new FinishCondition(input);
        SimpleText text = new SimpleText();
        boolean isFinished = true;

        System.out.println("Hello!");

        System.out.println("Player: " + player.whatIsPlayersName(input, text));
        System.out.println("You will play: " + game.howManyGames(input, text) + " games");

        while (isFinished) {
            isFinished = finishCondition.checkingToContinue();
        }
    }
}
