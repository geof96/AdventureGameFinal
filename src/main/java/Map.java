public class Map {

    private Room currentRoom;


    public void buildMap() {

        // peg på starter room
        Room room1 = new Room("Entrance of Time Travel: ", "You step into a time machine and find yourself in ancient Rome during a grand gladiator tournament. The coliseum roars with excitement. Paths lead east and south.");
        Room room2 = new Room("Gladiator's Arena: ", "You are now in the heart of the gladiator arena. Gladiators clash swords while the crowd cheers. You find an ancient sword and a water flask.");
        Room room3 = new Room("Renaissance Courtyard: ", "You've traveled to the Renaissance era. Da Vinci's artworks adorn the walls. A table holds a bottle of fine wine and a flask of coffee.");
        Room room4 = new Room("Egyptian Treasure Chamber: ", "You're in ancient Egypt, inside a treasure chamber filled with priceless artifacts. A mummy case stands against one wall.");
        Room room5 = new Room("World Cup Final 2023: ", "You've arrived at the 2023 World Cup final match. The stadium roars as Messi scores a goal. You see the fabled Infinity Gauntlet.");
        Room room6 = new Room("Renaissance Art Studio: ", "In this Renaissance-era art studio, you find vibrant paintings and sculptures. There's a palette and a brush on a worktable.");
        Room room7 = new Room("1920s Speakeasy: ", " You're in a 1920s speakeasy during the Prohibition era. Jazz music fills the air. You spot a violin and a bottle of bootleg whiskey.");
        Room room8 = new Room("Rock 'n' Roll Stage: ", " You're on the stage of a rock 'n' roll concert from the 1960s. The crowd goes wild. You find an electric guitar and a harmonica.");
        Room room9 = new Room("Library of Alexandria: ", " You've traveled back to ancient Alexandria, home to the great library. There are scrolls and books of wisdom. A pair of reading glasses sits on a table.");
        Room room10 = new Room();
        Room room11 = new Room();
        Room room12 =  new Room();

        //Room1 directions
        room1.setEast(room2);
        room1.setSouth(room4);


        //Room2 directions
        room2.setEast(room3);
        room2.setWest(room1);

        //Room3

        room3.setSouth(room6);
        room3.setWest(room2);

        //Room4
        room4.setSouth(room7);
        room4.setNorth(room1);


        //Room5
        room5.setSouth(room8);

        //Room6
        room6.setSouth(room9);
        room6.setNorth(room3);


        //Room7
        room7.setEast(room8);
        room7.setNorth(room4);


        //Room8
        room8.setEast(room9);
        room8.setNorth(room5);
        room8.setWest(room7);
        //Room9

        room9.setNorth(room6);
        room9.setWest(room8);

        currentRoom = room1;

        room4.allocateItem("coins");
        room2.allocateItem("sword");
        room5.allocateItem("Infinity Gauntlet");
        room7.allocateItem();
        room8.allocateItem("Kar98K");

    }

    //    public String itemRemoval(){
//    currentRoom.removeItem(currentRoom.);
//        return null;
//    }
    public Room getCurrentRoom() {
        return currentRoom;
    }

}