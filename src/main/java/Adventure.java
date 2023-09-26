public class Adventure {

    public Room current;

    public void buildRoom() {
        Room room1 = new Room("Entrance of Time Travel: ", "You step into a time machine and find yourself in ancient Rome during a grand gladiator tournament. The coliseum roars with excitement. Paths lead east and south.");
        Room room2 = new Room("Gladiator's Arena: ", "You are now in the heart of the gladiator arena. Gladiators clash swords while the crowd cheers. You find an ancient sword and a water flask.");
        Room room3 = new Room("Renaissance Courtyard: ", "You've traveled to the Renaissance era. Da Vinci's artworks adorn the walls. A table holds a bottle of fine wine and a flask of coffee.");
        Room room4 = new Room("Egyptian Treasure Chamber: ", "You're in ancient Egypt, inside a treasure chamber filled with priceless artifacts. A mummy case stands against one wall.");
        Room room5 = new Room("World Cup Final 2023: ", "You've arrived at the 2023 World Cup final match. The stadium roars as Messi scores a goal. You see the fabled Infinity Gauntlet.");
        Room room6 = new Room("Renaissance Art Studio: ", "In this Renaissance-era art studio, you find vibrant paintings and sculptures. There's a palette and a brush on a worktable.");
        Room room7 = new Room("1920s Speakeasy: ", " You're in a 1920s speakeasy during the Prohibition era. Jazz music fills the air. You spot a violin and a bottle of bootleg whiskey.");
        Room room8 = new Room("Rock 'n' Roll Stage: ", " You're on the stage of a rock 'n' roll concert from the 1960s. The crowd goes wild. You find an electric guitar and a harmonica.");
        Room room9 = new Room("Library of Alexandria: ", " You've traveled back to ancient Alexandria, home to the great library. There are scrolls and books of wisdom. A pair of reading glasses sits on a table.");

        // peg på starter room
        current = room1;

        //Room1 directions
        room1.setEast(room2);
        room1.setSouth(room4);
        room1.setNorth(null);
        room1.setWest(null);

        //Room2 directions
        room2.setEast(room3);
        room2.setSouth(room5);
        room2.setNorth(null);
        room2.setWest(room1);

        //Room3 directions
        room3.setEast(null);
        room3.setSouth(room6);
        room3.setNorth(null);
        room3.setWest(room2);

        //Room4 directions
        room4.setEast(room5);
        room4.setSouth(room7);
        room4.setNorth(room1);
        room4.setWest(null);

        //Room5 directions
        room5.setEast(null);
        room5.setSouth(room8);
        room5.setNorth(null);
        room5.setWest(null);

        //Room6 directions
        room6.setEast(null);
        room6.setSouth(room9);
        room6.setNorth(room3);
        room6.setWest(room5);

        //Room7 directions
        room7.setEast(room8);
        room7.setSouth(null);
        room7.setNorth(room4);
        room7.setWest(null);

        //Room8 directions
        room8.setEast(room9);
        room8.setSouth(null);
        room8.setNorth(room5);
        room8.setWest(room7);

        //Room9 directions
        room9.setEast(null);
        room9.setSouth(null);
        room9.setNorth(room6);
        room9.setWest(room8);


    }

    public void walk(String direction) {
        Room newRoom = findRoom(direction);
        if (newRoom != null) {
            current = newRoom;
            System.out.println(current.getName() + current.getDescription());
        } else {
            System.out.println("You can't walk this way! Take another route.");
        }
    }


    public Room getCurrent() {
        return current;
    }

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
