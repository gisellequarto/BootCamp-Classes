package org.academiadecodigo.com;

public class Hotel {

    private String name;
    private Accommodation [] rooms;

    public Hotel (String name, int numberOfRooms) {
        this.name = name;
        rooms = new Accommodation[numberOfRooms];
        buildRooms();
    }

    public int checkIn() {
        for(int i = 0; i < rooms.length; i++) {
            if (rooms[i].isOccupied() == false){
                System.out.println("We have Room number " + i + ". Here is your key!");
                rooms[i].setOcuppation(true);
                return i;
            }
        }
        System.out.println("Unfortunately, there is no room available");
        return -1;
    }

    public void checkOut(int guestRoomNumber) {
        rooms[guestRoomNumber].setOcuppation(false);
    }


    private void buildRooms () {
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Accommodation();
        }
    }





}
