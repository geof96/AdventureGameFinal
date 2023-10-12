public class Map {

    private Room currentRoom;

    public void buildMap() {

        //Rooms descriptions
        Room room1 = new Room("Entrance of Time Travel: ", "You step into a time machine and find yourself in ancient Rome during a grand gladiator tournament. The coliseum roars with excitement. Paths lead east and south...");
        Room room2 = new Room("Gladiator's Arena: ", "You are now in the heart of the gladiator arena. Swords clash while the crowd cheers. Gladiator gear scattered all over the arena could come in handy...");
        Room room3 = new Room("Renaissance Courtyard: ", "You've traveled to the Renaissance era. Da Vinci's artworks adorn the walls. A table holds a bottle of an rather odd drink not from this time...");
        Room room4 = new Room("Egyptian Treasure Chamber: ", "You're in ancient Egypt, inside a treasure chamber filled with priceless artifacts. Shiny treasure blinding you from every angle...");
        Room room5 = new Room("World Cup Final 2022: ", "You've arrived at Qatar, it's the 2022 World Cup final match. The stadium roars as Messi scores a goal. Your eyes widen as you see the infamous Infinity Gauntlet...");
        Room room6 = new Room("Ancient Samurai Dojo: ", " You find yourself in the courtyard of an ancient Japanese samurai dojo. Cherry blossoms falling from the trees. A samurai challenges you...");
        Room room7 = new Room("1920s Speakeasy: ", " You're in a 1920s speakeasy during the Prohibition era. It's late evening and jazz music fills the air. Only thing missing is a refreshing drink...");
        Room room8 = new Room("Rock 'n' Roll Stage: ", " You're on the stage of a rock 'n' roll concert from the 1960s. The crowd goes wild. Suddenly you are confronted by a somewhat familiar man...");
        Room room9 = new Room("Library of Alexandria: ", " You've traveled back in time to ancient Alexandria, home to the great library. Massive halls with scrolls of eternal wisdom on every shelf. This place even has a dining room...");

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


        //Items in specified room
        room4.allocateItem("coins");



        //Food in specified room
        room3.allocateFood("redbull", 40);
        room7.allocateFood("whiskey", 20);
        room4.allocateFood("nuggets", 30);
        room1.allocateFood("peanuts", 15);
        room9.allocateFood("wagyu", 35);

        //Ranged weapons
        room8.allocateRangedWeapons("sniper", 20, 10);

        //Melee weapons
        room2.allocateMeleeWeapons("sword", 15);
        room5.allocateMeleeWeapons("gauntlet", 20000);

        //Enemies in the map
        // Enemy 1
        MeleeWeapon samuraiWeapon = new MeleeWeapon("katana", 20);
        room6.allocateEnemy("Samurai Jack", 80, samuraiWeapon);

        //Enemy 2
        MeleeWeapon netenyahuWeapon = new MeleeWeapon("zionism", 25);
        room8.allocateEnemy("Benjamin Netenhayu", 100, netenyahuWeapon);


        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}

