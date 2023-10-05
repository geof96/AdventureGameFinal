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


    public String surroundings() {

        player.currentRoom.getDescription();
        return player.currentRoom.getDescription() + player.currentRoom.getItems();
    }

    public void takeAllocatedItem(String itemName) {
        player.takeItem(itemName);
    }

    public ArrayList<Item> seeInventory() {
        System.out.println("These are your items: ");
        player.getInventory();
        return player.getInventory();

    }

    public void healthPoints(int healthPoints){
        player.showHealthPoints(healthPoints);
    }

    public void dropFromInventory(String itemName) {
        player.dropItem(itemName);

    }

    public void eat(String itemName){
        player.eatFood(itemName);
    }
}

