import java.util.ArrayList;

public class Player {
    public Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();

    private int healthPoints = 100;
    private Item equipped;

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


    //Eat food method
    public boolean eatFood(String itemName) {
        boolean isNull = false;
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if (item instanceof Food) {
                    inventory.remove(item);
                    healthPoints += ((Food) item).getHealth();

                    isNull = true;
                    System.out.println("You have eaten " + itemName + " and you have gained " + ((Food) item).getHealth() + " healthpoints.");

                } else if (inventory.isEmpty()) {
                    isNull = false;
                    System.out.println("You don't have this item in your inventory.");
                } else {
                    System.out.println("You can't eat this");
                    isNull = false;
                }
            }

        }
        return isNull;
    }

    public void equipWeapon(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                if (item instanceof Weapon) {
                    inventory.remove(item);
                    equipped = item;
                    System.out.println(itemName + " has been equipped.");
                } else {
                    System.out.println("Item cannot be equipped.");
                }
            }
        }
    }

    public int attackAll() {
        Item item = equipped;
        if (equipped != null) {
            if (((Weapon) item).remainingAmmo() > 0){
                System.out.println("You have attacked and dealt " + ((Weapon) item).getWeaponDamage());
                System.out.println(((((Weapon) item).remainingAmmo())));
                System.out.println("Bang! Bang!");
            }
            else if (((Weapon) item).remainingAmmo() == 0){
                dropItem(equipped.getItemName());
                System.out.println("You don't have anymore ammo.");
            }
            if (((Weapon) item).remainingUses() == 0){
                System.out.println("You have attacked and dealt " + ((Weapon) item).getWeaponDamage());
                System.out.println("Quick melee attack!");
            }
        }


        return healthPoints;
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