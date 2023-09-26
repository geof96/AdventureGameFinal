import java.util.Scanner;

public class UserInterFace {
    Adventure adventure = new Adventure();
    Room r;
    Scanner command = new Scanner(System.in);
    boolean isRunning = true;
    String waitCommand = "Waiting for your command";
    String choice;

    public void startAdventure() {
        adventure.buildRoom();


        do {
            choice = command.nextLine();
            System.out.println(waitCommand);
            switch (choice) {
                case "go north", "north", "GO NORTH", "NORTH", "N", "n" -> System.out.println("going north");
                case "go south", "south", "GO SOUTH", "SOUTH", "S", "s" -> System.out.println("going south");
                case "go east", "east", "GO EAST", "EAST", "E", "e" -> System.out.println("going east");
                case "go west", "west", "GO WEST", "WEST", "W", "w" -> System.out.println("going west");
                case "look", "l", "L" -> System.out.println("fail");
                case "help", "h", "H" -> System.out.println("Type either west, east, north or south to navigate. Press l or type look to get the describtion of the room");
                case "exit" -> {System.out.println("Thanks for playing");
                isRunning = false;}
                default -> System.out.println("Invalid input!");

            }
        }
        while (isRunning);
    }
}
