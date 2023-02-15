public class Player {

    private String name;
    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String whatIsPlayersName(Input input) {
        System.out.println("Please enter Your name");
        setName(input.scanString());
        return getName();
    }
}
