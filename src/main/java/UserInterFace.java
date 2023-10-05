import java.util.Scanner;

public class UserInterFace {

    Adventure adventure = new Adventure();
    Scanner command = new Scanner(System.in);
    boolean isRunning = true;
    String waitCommand = "Waiting for your command...";
    String welcomeMessage = "Welcome To Cave of Time Travel. In this game you have to find your way to the Infinity Gauntlet.\nYou start from the cave entrance and type either |go south|, |south| or |s|. \nProgram is not case sensitive, so don't worry about CAPS LOCK. \nEnjoy the game!\n";


    public void startAdventure() {
        System.out.println(welcomeMessage + waitCommand);
        String choice;
        do {
            System.out.print(">");
            choice = command.nextLine().trim();
            String[] commands = choice.split("\\s+");

            if (commands.length == 1) {
                switch (commands[0]) {
                    case "look", "l", "L" -> System.out.println(adventure.surroundings());
                    case "inventory", "INVENTORY", "i", "I", "inven", "INVEN" ->
                            System.out.println(adventure.seeInventory());
                    case "health" -> System.out.println(adventure.healthPoints());
                    case "help", "h", "H" ->
                            System.out.println("Type either west, east, north or south to navigate. Type l or look to get the description of the room");
                    case "exit" -> {
                        System.out.println("Thanks for playing!");
                        isRunning = false;
                    }
                    default -> System.out.println("Unknown command");
                }

            } else if (commands.length >= 2) {
                switch (commands[0]) {
                    case "go" -> {
                        String direction = commands[1];
                        adventure.go(direction);

                    }
                    case "take", "Take", "t", "T" -> {
                        String itemName = commands[1];
                        adventure.takeAllocatedItem(itemName);
                        System.out.println("You've added " + itemName + " to your inventory.");
                    }
                    case "d", "D", "drop", "Drop" -> {
                        String itemName = commands[1];
                        adventure.dropFromInventory(itemName);
                        System.out.println("You've dropped " + itemName + " from your inventory.");

                    }
                    case "e", "E", "eat", "Eat" ->{
                        String itemName = commands[1];
                        adventure.eat(itemName);
                        System.out.println("You have eaten " + itemName + " and you have gained healthpoints.");
                    }

                }
            } else {
                System.out.println("Unknown command");
            }
        }
        while (isRunning);
    }
}
