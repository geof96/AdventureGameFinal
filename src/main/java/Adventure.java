public class Adventure {





    }
    public void walk(String direction){
        Room newRoom = findRoom(direction);
        if (newRoom != null){
            current = newRoom;
            // sout(current.getName + current.getDescription)
        } else {
            // print you cannot do this
        }
    }

