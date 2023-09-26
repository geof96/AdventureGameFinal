public class Adventure {

    public Room current;

    public void buildRoom() {
        Room room1 = new Room("Room1", "You are entering the cave of eternal pain and suffering. There a different rooms to explore. There are pathways towards east and south. ");
        Room room2 = new Room("Room 2", "You have entered into a dark and abandoned dungeon.");
        Room room3 = new Room("Room 3", " you are in room 3");
        Room room4 = new Room("Room 4", "you are in room 4 ");
        Room room5 = new Room("Room 5", " you are in room 5");
        Room room6 = new Room("Room 6", " you are in room 6");
        Room room7 = new Room("Room 7", " you are in room 7");
        Room room8 = new Room("Room 8", " you are in room 8");
        Room room9 = new Room("Room 9", " you are in room 9");


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

        //Room3
        room3.setEast(null);
        room3.setSouth(room6);
        room3.setNorth(null);
        room3.setWest(room2);

        //Room4
        room4.setEast(room5);
        room4.setSouth(room7);
        room4.setNorth(room1);
        room4.setWest(null);

        //Room5
        room5.setEast(null);
        room5.setSouth(room8);
        room5.setNorth(null);
        room5.setWest(null);

        //Room6
        room6.setEast(null);
        room6.setSouth(room9);
        room6.setNorth(room3);
        room6.setWest(room5);

        //Room7
        room7.setEast(room8);
        room7.setSouth(null);
        room7.setNorth(room4);
        room7.setWest(null);

        //Room8
        room8.setEast(room9);
        room8.setSouth(null);
        room8.setNorth(room5);
        room8.setWest(room7);
        //Room9
        room9.setEast(null);
        room9.setSouth(null);
        room9.setNorth(room6);
        room9.setWest(room8);



    }
    public void walk(String direction){
        Room newRoom = findRoom(direction);
        if (newRoom != null){
            current = newRoom;
            System.out.println(current.getName() + current.getDescription());
        } else {
            System.out.println("You can't walk this way! Take another route.");
        }
    }


    public Room getCurrent(){
        return current;
    }

    public Room findRoom(String direction) {
        switch (direction) {
            case "North" -> {
                return current.getNorth();
            }
            case "South" ->{
                return current.getSouth();
            }
            case "West" ->{
                return current.getWest();
            }
            case "East" ->{
                return current.getEast();
            }
            default -> {
                return null;
            }

        }

}
}
