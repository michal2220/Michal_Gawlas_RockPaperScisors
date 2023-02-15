public class RpsRunner {

    public static void main(String[] args) {

        AgainRunner againRunner = new AgainRunner();
        do {
            new GamePlay().playGame();

        }
        while (againRunner.runner());
    }
}
