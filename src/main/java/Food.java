public class Food extends Item {
    protected int health;

    public Food(String itemName, int healthPoints) {
        super(itemName);
        this.health = healthPoints;
    }

    public int getHealth() {
        return health;
    }
}