import java.util.Scanner;

public class UserInterFace {

    Adventure adventure = new Adventure();
    Scanner command = new Scanner(System.in);
    boolean isRunning = true;
    String waitCommand = "Waiting for your command...";
    String welcomeMessage = "Welcome To Cave of Time Travel! \nIn this game you have to find your way to the infamous Infinity Gauntlet.\nYou start from the cave entrance and make sure to search around for items. \nProgram is not case sensitive, so don't worry about CAPS LOCK. \nType |help| for further control information. \nFor starters i would recommend that you look around. \nEnjoy the game!\n";


    public void startAdventure() {
        System.out.println(welcomeMessage + waitCommand);
        String choice;
        do {
            System.out.print(">");
            choice = command.nextLine().trim();
            String[] commands = choice.split("\\s+");

            if (commands.length == 1) {
                switch (commands[0]) {
                    case "look", "l", "L" -> {
                        System.out.println(adventure.surroundings());
                        System.out.println(waitCommand);
                    }
                    case "inventory", "INVENTORY", "i", "I", "inven", "INVEN" -> {
                        System.out.println(adventure.seeInventory());
                        System.out.println(waitCommand);
                    }
                    case "health" -> {
                        System.out.println(adventure.healthPoints());
                        System.out.println(waitCommand);
                    }
                    case "attack" -> {
                        System.out.println(adventure.attackIt());
                        System.out.println(waitCommand);
                    }
                    case "help", "h", "H" -> {
                        System.out.println("Type |go| followed with direction of choice( |west|, |east|, |north| or |south|) to navigate. \nType |l| or |look| to search for items, food or weapons in each room. \nType |health| to see health points (you start with 100). \nType |attack| to melee or shoot. \nIf you find items in a room, you can; \n1. Type |take| followed by the name of the item. Item will be stored in your inventory. \n2. Type |drop| followed by the name of the item. Item will be dropped from inventory. \n3. Type |eat| followed by the name of the food. This will make you eat a food from your inventory and gain health. \n4. Type |equip| followed by the name of the weapon. This will make you ready to attack.");
                        System.out.println(waitCommand);
                    }
                    case "exit" -> {
                        System.out.println("Thanks for playing!");
                        isRunning = false;
                    }
                    default -> System.out.println("Unknown command!");
                }

            } else if (commands.length >= 2) {
                switch (commands[0]) {
                    case "go" -> {
                        String direction = commands[1];
                        adventure.go(direction);
                        System.out.println(waitCommand);
                    }
                    case "take", "Take", "t", "T" -> {
                        String itemName = commands[1];
                        adventure.takeAllocatedItem(itemName);
                        System.out.println("You've added " + itemName + " to your inventory.");
                        System.out.println(waitCommand);
                    }
                    case "d", "D", "drop", "Drop" -> {
                        String itemName = commands[1];
                        adventure.dropFromInventory(itemName);
                        System.out.println("You've dropped " + itemName + " from your inventory.");
                        System.out.println(waitCommand);
                    }
                    case "eat", "Eat" -> {
                        String itemName = commands[1];
                        adventure.eat(itemName);
                        System.out.println(waitCommand);
                    }
                    case "equip", "Equip" -> {
                        String itemName = commands[1];
                        adventure.equipIt(itemName);
                        System.out.println(waitCommand);
                    }

                }
            } else {
                System.out.println("Unknown command!");
            }
        }
        while (isRunning);
    }
}