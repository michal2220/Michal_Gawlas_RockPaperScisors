public class GamePlay {

    Input input = new Input();
    Player player = new Player();
    GamesQuantityReceiver gamesQuantityReceiver = new GamesQuantityReceiver(input);
    FinishCondition finishCondition = new FinishCondition(input, gamesQuantityReceiver);
    MoveReceiver moveReceiver = new MoveReceiver(input);
    GameLogic gameLogic = new GameLogic(moveReceiver, finishCondition);

    String again = "";
    public void playGame() {
        boolean isFinished = false;

        System.out.println("Hello!");
        System.out.println("Player: " + player.whatIsPlayersName(input));
        System.out.println("You will play: " + gamesQuantityReceiver.howManyGames() + " games");
        System.out.println("""
                                
                Game is played via keyboard:
                1 - Rock
                2 - Paper
                3- Scissors
                x - finishing game
                n - new game
                """);

        while (!isFinished) {
            for (int i = 0; !isFinished; i++) {
                isFinished = finishCondition.checkingToContinue();
                if (!isFinished) {
                    finishCondition.gamesLeftInfo();
                    gameLogic.game();
                }
            }
            isFinished = finishCondition.checkingToContinue();
            System.out.println(gameLogic.getWinnerList());
            System.out.println("Winner is: " + gameLogic.winnerInfo());
            System.out.println("Would You like to play again?");
        }
    }

}
