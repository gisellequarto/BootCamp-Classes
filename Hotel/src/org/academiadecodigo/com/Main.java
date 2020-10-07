package org.academiadecodigo.com;

public class Main {

    public static void main(String[] args) {

    Hotel hotel1 = new Hotel("Beijing Station", 2);

    Guest guest1 = new Guest("Giselle", hotel1);
    Guest guest2 = new Guest("Rodrigo", hotel1);
    Guest guest3 = new Guest("AfeganistanFriend", hotel1);


    guest1.checkIn();
    guest2.checkIn();
    guest3.checkIn();

    guest3.getRoomNumber();

    guest2.checkOut(guest2.getRoomNumber());

    guest3.checkIn();

    System.out.println(guest3.getRoomNumber());


    }
}
