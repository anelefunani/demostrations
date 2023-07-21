package za.co.code.rockpaperscissors;

import za.co.code.rockpaperscissors.adapter.impl.RoundsComplex;
import za.co.code.rockpaperscissors.adapter.impl.RoundsSimple;
import za.co.code.rockpaperscissors.controller.RpsController;

public class Application {

    public static void main(String[] args) {

        Application application = new Application();
        String fileLocation = "rock-paper-scissors/src/main/resources/rockpaperscissors.txt";

        application.run(new RpsController(fileLocation, new RoundsSimple()), "The simple score is: ");
        application.run(new RpsController(fileLocation, new RoundsComplex()), "The complex score is: ");
    }

    public void run(RpsController controller, String message) {
        System.out.println(message + controller.getScore());
    }
}
