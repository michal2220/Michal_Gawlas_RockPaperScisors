public class Player {

    String name;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String whatIsPlayersName(Input input, SimpleText text){
        text.provideName();
        setName(input.scanString());
        return getName();
    }


}
