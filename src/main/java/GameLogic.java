import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {

    private int generatedNumber = 0;
    private String computerMove;
    private String playerMove;
    private String winner = "";
    private List<String> winnerList = new ArrayList<>();
    Random randomGenerator = new Random();
    private MoveReceiver moveReceiver;
    private FinishCondition finishCondition;

    public GameLogic(MoveReceiver moveReceiver, FinishCondition finishCondition) {
        this.moveReceiver = moveReceiver;
        this.finishCondition = finishCondition;
    }

    public List<String> getWinnerList() {
        return winnerList;
    }

    private String computerTurn() {
        generatedNumber = randomGenerator.nextInt(3);

        if (generatedNumber == 0) {
            computerMove = "Rock";
        }
        if (generatedNumber == 1) {
            computerMove = "Paper";
        }
        if (generatedNumber == 2) {
            computerMove = "Scissors";
        }
        return computerMove;
    }

    private void oneTurn() {
        playerMove = moveReceiver.getMove();
        computerTurn();
        System.out.println("Player move: " + playerMove);
        System.out.println("Computer move: " + computerMove);
    }

    public void game() {
        oneTurn();
        winnerChecker(finishCondition);
    }

    private void winnerChecker(FinishCondition finishCondition) {
        if (playerMove .equals("Scissors") && computerMove .equals("Scissors")) {
            System.out.println("TIE");
        }
        if (playerMove .equals("Rock") && computerMove .equals("Rock")) {
            System.out.println("TIE");
        }
        if (playerMove .equals("Paper") && computerMove .equals("Paper")) {
            System.out.println("TIE");
        }
        if (playerMove .equals("Scissors") && computerMove .equals("Rock")) {
            System.out.println("Computer won");
            winnerList.add("computer");
            finishCondition.countingGames();
        }
        if (playerMove .equals("Scissors") && computerMove .equals("Paper")) {
            System.out.println("Player won");
            winnerList.add("player");
            finishCondition.countingGames();
        }
        if (playerMove .equals("Rock") && computerMove .equals("Paper")) {
            System.out.println("Computer won");
            winnerList.add("computer");
            finishCondition.countingGames();
        }
        if (playerMove .equals("Rock") && computerMove .equals("Scissors")) {
            System.out.println("Player won");
            winnerList.add("player");
            finishCondition.countingGames();
        }
        if (playerMove .equals("Paper") && computerMove .equals("Scissors")) {
            System.out.println("Computer won");
            winnerList.add("computer");
            finishCondition.countingGames();
        }
        if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            System.out.println("Player won");
            winnerList.add("player");
            finishCondition.countingGames();
        }
    }

    public String winnerInfo() {
        int playerCount = 0;
        int computerCount = 0;

        for (String n : winnerList) {
            if (n.equals("player")){
                playerCount = playerCount + 1;
            }
            if (n.equals("computer")){
                computerCount = computerCount + 1;
            }
        }

        if (playerCount > computerCount) {
            winner = "player";
        }
        if (playerCount < computerCount) {
            winner = "computer";
        }
        if (playerCount == computerCount) {
            winner = "tie";
        }
        return winner;
    }
}
