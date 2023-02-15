public class RpsRunner {

    public static void main(String[] args) {

        Input input = new Input();
        Player player = new Player();
        GamesQuantityReceiver gamesQuantityReceiver = new GamesQuantityReceiver(input);
        FinishCondition finishCondition = new FinishCondition(input, gamesQuantityReceiver);
        MoveReceiver moveReceiver = new MoveReceiver(input);
        GameLogic gameLogic = new GameLogic(moveReceiver, finishCondition);

        boolean isFinished = false;

        System.out.println("Hello!");
        System.out.println("Player: " + player.whatIsPlayersName(input));
        System.out.println("You will play: " + gamesQuantityReceiver.howManyGames() + " games");
        System.out.println("""
                
                Game is played via keyboard:
                1 - Rock
                2 - Paper
                3- Scissors
                """);

        while (!isFinished) {
            for (int i = 0; i < gamesQuantityReceiver.getGamesQuantity() && !isFinished; i++) {
                isFinished = finishCondition.checkingToContinue();
                if (!isFinished) {
                    finishCondition.gamesLeftInfo();
                    gameLogic.game();
                }
            }
        }
        System.out.println(gameLogic.getWinnerList());
        System.out.println("Winner is: " + gameLogic.winnerInfo());
    }
}
