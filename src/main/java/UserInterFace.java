import java.util.Scanner;

public class UserInterFace {

    Adventure adventure = new Adventure();
    Scanner command = new Scanner(System.in);
    boolean isRunning = true;
    String welcomeMessage = "\nWelcome To TimeScape Adventure\n \nIn this game you have to find your way to the infamous Infinity Gauntlet.\nYou start from the cave entrance and make sure to search around for items. \nProgram is not case sensitive, so don't worry about CAPS LOCK. \nType |help| for further control information. \nFor starters i would recommend that you look around. \nEnjoy the game!\n";
    String waitCommand = "\nWaiting for your command...";


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
                        adventure.attackIt();
                        System.out.println(waitCommand);
                    }
                    case "unequip" -> adventure.unEquipWeapon();

                    case "help", "h", "H" -> {
                        System.out.println("-Type |go| followed with direction of choice( |west|, |east|, |north| or |south|) to navigate. \n-Type |l| or |look| to search for items, food or weapons in each room. \n-Type |health| to see health points (you start with 100). \n-Type |attack| to melee or shoot. \n-If you find items in a room, you can; \n 1. Type |take| followed by the name of the item. Item will be stored in your inventory. \n 2. Type |drop| followed by the name of the item. Item will be dropped from inventory. \n 3. Type |eat / drink| followed by the name of the food. This will make you eat/drink the food from your inventory and gain health. \n 4. Type |equip| followed by the name of the weapon. This will make you ready to attack. \n 5. Type |unequip| to unequip your current weapon. ");
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
                    case "eat", "Eat", "drink", "Drink" -> {
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
            // Player deaths
            if (adventure.healthPoints() <= 0){
                isRunning = false;
                System.out.println("You have been defeated. Start the game again to find the Infinity Gauntlet");
            }

            //Player wins
            if (adventure.powerOfInfinity()){
                System.out.println("You have optained the Infinity Gauntlet and won the game");
                isRunning = false;

            }
        }
        while (isRunning);
    }
}