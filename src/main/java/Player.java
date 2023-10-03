import java.util.ArrayList;

public class Player {
    public Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

/*    public void addToInventory(Item item) {
        inventory.add(item);
    }*/

    public ArrayList<Item> getInventory() {
        return inventory;
    }


  /*  public Item searchItem(String itemName) {
        for (Item item : inventory) {
            return item;
        }
        return null;
    }*/

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
        boolean isNull = false;
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            getCurrentRoom().addItem(item);
            getInventory().remove(item);

            isNull = true;
        }
        return isNull;


    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

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