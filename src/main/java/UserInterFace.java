import java.util.Scanner;

public class UserInterFace {
    public Map drawMap = new Map();
    public Player player = new Player();
    Adventure adventure;

    Scanner command = new Scanner(System.in);
    boolean isRunning = true;
    String waitCommand = "Waiting for your command";
    String welcomeMessage = "Welcome To Cave of Time Travel. In this game you have to find your way to the Infinity Gauntlet.\nYou start from the cave entrance and type either |go south|, |south| or |s|. \nProgram is not case sensitive, so don't worry about CAPS LOCK. \nEnjoy the game!\n";
    String choice;

    public void startAdventure() {
        adventure = new Adventure(drawMap, player);

        player.setCurrent(adventure.getCurrent());

        //Drawing map, before game start.
        drawMap.map();

        System.out.println(welcomeMessage + waitCommand);

        do {
            choice = command.nextLine();

            switch (choice) {
                case "go north", "north", "GO NORTH", "NORTH", "N", "n" -> player.walk("North");
                case "go south", "south", "GO SOUTH", "SOUTH", "S", "s" -> player.walk("South");
                case "go east", "east", "GO EAST", "EAST", "E", "e" -> player.walk("East");
                case "go west", "west", "GO WEST", "WEST", "W", "w" -> player.walk("West");
                case "look", "l", "L" -> System.out.println(player.getCurrent().getDescription());
                case "inventory", "INVENTORY", "i", "I", "inven", "INVEN" -> System.out.println(player.getInventory());
                case "help", "h", "H" ->
                        System.out.println("Type either west, east, north or south to navigate. Press l or type look to get the describtion of the room");
                case "exit" -> {
                    System.out.println("Thanks for playing");
                    isRunning = false;
                }
                default -> System.out.println("Invalid input!");

            }
        }
        while (isRunning);
    }
}
