import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {

    public static final String SCISSORS = "Scissors";
    public static final String PAPER = "Paper";
    public static final String ROCK = "Rock";
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
            computerMove = ROCK;
        }
        if (generatedNumber == 1) {
            computerMove = PAPER;
        }
        if (generatedNumber == 2) {
            computerMove = SCISSORS;
        }
        return computerMove;
    }

    private String computerTurnSwitch() {
        generatedNumber = randomGenerator.nextInt(3);

        switch (generatedNumber) {
            case 0 -> computerMove = ROCK;
            case 1 -> computerMove = PAPER;
            case 2 -> computerMove = SCISSORS;
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
        if (playerMove.equals(SCISSORS) && computerMove.equals(SCISSORS)) {
            System.out.println("TIE");
        }
        if (playerMove.equals(ROCK) && computerMove.equals(ROCK)) {
            System.out.println("TIE");
        }
        if (playerMove.equals(PAPER) && computerMove.equals(PAPER)) {
            System.out.println("TIE");
        }
        if (playerMove.equals(SCISSORS) && computerMove.equals(ROCK)) {
            won("Computer won", "computer", finishCondition);
        }
        if (playerMove.equals(SCISSORS) && computerMove.equals(PAPER)) {
            won("Player won", "player", finishCondition);
        }
        if (playerMove.equals(ROCK) && computerMove.equals(PAPER)) {
            won("Computer won", "computer", finishCondition);
        }
        if (playerMove.equals(ROCK) && computerMove.equals(SCISSORS)) {
            won("Player won", "player", finishCondition);
        }
        if (playerMove.equals(PAPER) && computerMove.equals(SCISSORS)) {
            won("Computer won", "computer", finishCondition);
        }
        if (playerMove.equals(PAPER) && computerMove.equals(ROCK)) {
            won("Player won", "player", finishCondition);
        }
    }
    private void won(String Player_won, String player, FinishCondition finishCondition) {
        System.out.println(Player_won);
        winnerList.add(player);
        finishCondition.countingGames();
    }

    public String winnerInfo() {
        int playerCount = 0;
        int computerCount = 0;

        for (String n : winnerList) {
            if (n.equals("player")) {
                playerCount = playerCount + 1;
            }
            if (n.equals("computer")) {
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
        System.out.println("Player: " + playerCount + "\n"
                + "Computer: " + computerCount);
        return winner;
    }
}
