public class Adventure {

    public Room current;
    private Map drawMap;
    public Player player;

    //Calling the method in adventure.
    public Adventure(Map map, Player player) {
        this.drawMap = map;
        current = drawMap.room1;
    }

    public Adventure(Player player) {
        this.player = player;

    }

    public Room getCurrent() {
        return current;
    }
}