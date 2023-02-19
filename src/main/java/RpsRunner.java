public class RpsRunner {

    public static void main(String[] args) {

        Input input = new Input();
        AgainRunner againRunner = new AgainRunner(input);
        do {
            new GamePlay().playGame();
        }
        while (againRunner.runner());
    }
}