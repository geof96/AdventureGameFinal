public class Adventure {





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

