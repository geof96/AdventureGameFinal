import java.util.ArrayList;

public class Room {
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String name;
    private String description;
    private ArrayList<Item> items = new ArrayList<>();


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.north = null;
        this.south = null;
        this.east = null;
        this.west = null;

    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    /*public void setDescription(String description) {
        this.description = description;
    }*/

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void allocateItem(String itemName) {
        items.add(new Item(itemName));
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }


    //Methods for allocating food:
    public void allocateFood(String foodName, int healthPoints) {
        items.add(new Food(foodName, healthPoints));
    }

    //Methods for allocating Ranged weapons and Melee weapons:
    public void allocateMeleeWeapons(String weaponName, int weaponDamage){
        items.add(new MeleeWeapon(weaponName, weaponDamage));
    }
    public void allocateRangedWeapons(String weaponName, int weaponDamage, int weaponAmmo){
        items.add(new RangedWeapon(weaponName, weaponDamage, weaponAmmo));
    }
}

