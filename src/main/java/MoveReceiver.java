public class MoveReceiver {

    private int intMove = 0;
    private String stringMove = null;
    private Input input;

    public MoveReceiver(Input input) {
        this.input = input;
    }

    public String getMove() {
        boolean correct = false;

        while (!correct) {
            try {
                intMove = input.scanInt();
                while (intMove < 1 || intMove > 3) {
                    System.out.println("""
                            Available moves are: 
                            1 - Rock
                            2 - Paper
                            3- Scissors""");
                    intMove = input.scanInt();
                }
                input.scanReset();
                playerMoveMapping();
                correct = true;
            } catch (Exception e) {
                System.out.println("Wrong input, only numbers from 1 to 3");
                input.scanReset();
            }
        }
        return stringMove;
    }

    private void playerMoveMapping() {
        if (intMove == 1) {
            stringMove = "Rock";
        }
        if (intMove == 2) {
            stringMove = "Paper";
        }
        if (intMove == 3) {
            stringMove = "Scissors";
        }
    }

}
