package Model;


public class Room {
    private int roomNumber;
    private boolean available;

    // Konstruktor, gettery, settery i inne metody

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
