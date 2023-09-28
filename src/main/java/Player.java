public class Player {

    public Room current;

    public Room getCurrent() {
        return current;
    }

    public void setCurrent(Room room) {
        current = room;
    }

    //Navigation
    public void walk(String direction) {
        Room newRoom = findRoom(direction);
        if (newRoom != null) {
            current = newRoom;
            System.out.println(current.getName() + current.getDescription());
        } else {
            System.out.println("You can't walk this way! Take another route.");
        }
    }

    //Finds current room
    public Room findRoom(String direction) {
        switch (direction) {
            case "North" -> {
                return current.getNorth();
            }
            case "South" -> {
                return current.getSouth();
            }
            case "West" -> {
                return current.getWest();
            }
            case "East" -> {
                return current.getEast();
            }
            default -> {
                return null;
            }

        }

    }
}