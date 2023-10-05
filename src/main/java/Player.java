import java.util.ArrayList;

public class Player {
    public Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    private int healthPoints = 100;

    public int getHealthPoints() {
        System.out.println("This is how much you have: ");
        return healthPoints;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    //Take item and drop item methods:
    public boolean takeItem(String itemName) {
        boolean isNull = false;
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(item);
            isNull = true;
        }
        return isNull;
    }

    public boolean dropItem(String itemName) {
        Item itemToRemove = null;

        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            inventory.remove(itemToRemove);
            currentRoom.addItem(itemToRemove);

            return true;
        }

        return false;
    }

    public void showHealthPoints() {
        System.out.println(getHealthPoints());
    }

    public boolean eatFood(String itemName) {
        boolean isNull = false;
        for (Item item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if (item instanceof Food) {
                    inventory.remove(item);
                    healthPoints += ((Food) item).getHealth();

                    isNull = true;

                } else {
                    System.out.println("You can't eat this");
                    isNull = false;
                }
            }

        }
        return isNull;
    }
//Take food and drop food methods:

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    //Navigation
    public void walk(String direction) {
        Room newRoom = findRoom(direction);
        if (newRoom != null) {
            currentRoom = newRoom;
            System.out.println(currentRoom.getName() + currentRoom.getDescription());
        } else {
            System.out.println("You can't walk this way! Take another route.");
        }
    }

    //Finds current room
    public Room findRoom(String direction) {
        switch (direction) {
            case "North", "north", "n", "N" -> {
                return currentRoom.getNorth();
            }
            case "South", "south", "s", "S" -> {
                return currentRoom.getSouth();
            }
            case "West", "west", "W", "w" -> {
                return currentRoom.getWest();
            }
            case "East", "east", "e", "E" -> {
                return currentRoom.getEast();
            }
            default -> {
                return null;
            }

        }

    }
}