package org.academiadecodigo.com;

public class Guest {

    private String name;
    private Hotel hotel;
    private int roomNumber = -2;

    public Guest (String name, Hotel hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    public void checkIn () {
        int roomAvailable = hotel.checkIn();
        if (roomAvailable < 0) {
            return;
        }
        roomNumber = roomAvailable;
    }

    public void checkOut(int room) {
        hotel.checkOut(room);
        roomNumber = -2;
    }


    public int getRoomNumber() {
        if(roomNumber < 0) {
            System.out.println("I will sleep in the street!");
        }
        return roomNumber;
    }




}
