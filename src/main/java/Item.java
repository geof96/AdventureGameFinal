public class Item {


    private final String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }


    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                '}';
    }
}
