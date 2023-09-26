import java.util.Scanner;

public class UserInterFace {
    private Adventure adventure = new Adventure();

    Scanner command = new Scanner(System.in);
    boolean isRunning = true;
    String waitCommand = "Waiting for your command";
    String choice;

    public void startAdventure() {
        adventure.buildRoom();


        do {
            Room current = adventure.getCurrent();
            System.out.println(waitCommand);
            choice = command.nextLine();

            switch (choice) {
                case "go north", "north", "GO NORTH", "NORTH", "N", "n" -> adventure.walk("North");
                case "go south", "south", "GO SOUTH", "SOUTH", "S", "s" -> adventure.walk("South");
                case "go east", "east", "GO EAST", "EAST", "E", "e" -> adventure.walk("East");
                case "go west", "west", "GO WEST", "WEST", "W", "w" -> adventure.walk("West");
                case "look", "l", "L" -> System.out.println(current.getDescription());
                case "help", "h", "H" -> System.out.println("Type either west, east, north or south to navigate. Press l or type look to get the describtion of the room");
                case "exit" -> {System.out.println("Thanks for playing");
                isRunning = false;}
                default -> System.out.println("Invalid input!");

            }
        }
        while (isRunning);
    }
}
