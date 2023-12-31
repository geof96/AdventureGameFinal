import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int healthPoints = 100;
    private Item equipped;

    public int getHealthPoints() {
        return healthPoints;
    }

    public String surroundings() {
        return currentRoom.getDescription() + currentRoom.getItems();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    //Take item and drop item methods:
    public boolean takeItem(String itemName) {
        boolean found = false;
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeItem(item);
            found = true;
        }
        return found;
    }

    //Drop item method
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
                    System.out.println("You have consumed " + itemName + " and you have gained " + ((Food) item).getHealth() + " healthpoints.");

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

    //Equip weapon method
    public void equipWeapon(String itemName) {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            if (item.getItemName().equalsIgnoreCase(itemName) && equipped == null) {
                if (item instanceof Weapon) {
                    inventory.remove(item);
                    equipped = item;
                    System.out.println(itemName + " has been equipped.");
                } else {
                    System.out.println("Item cannot be equipped.");
                }
            } else {
                System.out.println("Unequip " + equipped.getItemName() + " to equip another weapon");

            }
        }
    }


    //Unequip weapon method
    public void unEquip() {
        if (equipped != null) {
            Weapon currentWeapon = ((Weapon) equipped);
            inventory.add(currentWeapon);
            equipped = null;
            System.out.println("You have unequipped: " + currentWeapon.getItemName());


        }
    }

    public boolean equippedGauntlet() {
        for (Item item : inventory) {
            if (item.getItemName().equals("gauntlet")) {
                return true;
            }

        }
        return false;
    }

    //Attack method
    public void attackAll() {
        if (equipped != null && !currentRoom.getEnemyList().isEmpty()) {
            Weapon currentWeapon = ((Weapon) equipped);
            Enemy enemy = currentRoom.getEnemyList().get(0);
            if (currentWeapon.canUse()) {
                enemy.setEnemyHealth(enemy.getEnemyHealth() - currentWeapon.getWeaponDamage());
                healthPoints -= enemy.getEnemyWeapon().getWeaponDamage();
                System.out.println("You have traded hits with: " + enemy.getEnemyName() + " Remaining enemy health " + enemy.getEnemyHealth() + ". ");
                System.out.println("Your health: " + healthPoints);
            } else {
                System.out.println("You do not have anymore ammo. ");
            }
            //Enemy deaths
            if (enemy.getEnemyHealth() <= 0) {
                currentRoom.getEnemyList().remove(enemy);
                currentRoom.addItem(enemy.getEnemyWeapon());
                System.out.println("You have defeated " + enemy.getEnemyName() + " and weapon has been dropped: " + enemy.getEnemyWeapon());
            }
        }
    }


    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    //Navigation method
    public void walk(String direction) {
        Room newRoom = findRoom(direction);
        if (newRoom != null) {
            currentRoom = newRoom;
            System.out.println(currentRoom.getName() + currentRoom.getDescription() + currentRoom.getEnemyList());
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