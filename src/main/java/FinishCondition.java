public class FinishCondition {

    private Input input;

    public FinishCondition(Input input) {
        this.input = input;
    }

    boolean continuing = false;
    String ending = null;

    public void setContinuing(boolean continuing) {
        this.continuing = continuing;
    }

    public void setEnding(String ending) {
        this.ending = ending;
    }

    public void playerEnded(Input input){

        setEnding(input.scanString());
        System.out.println(ending);

        if (ending.equals("n")) {
            System.out.println("""
            Are You sure you want to finnish?
            'y' - yes
            'n' - no""");

            String makingSure = input.scanString();

            if (makingSure.equals("y")) {
                continuing = false;
                System.out.println("Ending game");
            } if (makingSure.equals("n")) {
                System.out.println("Ending game canceled");
                continuing = true;
            }
        }
    }

    public boolean checkingToContinue(){
        playerEnded(input);
        return continuing;
    }
}

