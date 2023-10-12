import java.util.ArrayList;

public class Adventure {
    private Map map;
    private Player player;

    //Calling the method in adventure.
    public Adventure() {
        player = new Player();
        map = new Map();
        map.buildMap();
        player.setCurrentRoom(map.getCurrentRoom());
    }

    public void go(String direction) {

        player.walk(direction);
    }

public String observe(){
        return player.surroundings();
}

    public void takeAllocatedItem(String itemName) {
        player.takeItem(itemName);
    }

    public ArrayList<Item> seeInventory() {
        System.out.println("These are your items: ");
        player.getInventory();
        return player.getInventory();
    }

    public int healthPoints() {
        return player.getHealthPoints();
    }

    public void dropFromInventory(String itemName) {
        player.dropItem(itemName);

    }

    public void eat(String itemName) {
        player.eatFood(itemName);
    }

    public void equipIt(String itemName) {
        player.equipWeapon(itemName);
    }

    public void attackIt() {
        player.attackAll();
    }

    public void unEquipWeapon() {
        player.unEquip();
    }

    public boolean powerOfInfinity(){
        return player.equippedGauntlet();
    }
}

