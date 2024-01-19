import Model.Room;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private List<Room> rooms;

    public RoomService() {
        this.rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomNumber) {
        rooms.removeIf(room -> room.getRoomNumber() == roomNumber);
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    // Dodaj inne metody, takie jak sprawdzanie dostępności pokoi, rezerwowanie itp.
}
