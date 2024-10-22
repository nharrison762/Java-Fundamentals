package model;

public class FreeRoom extends Room {

    public FreeRoom(String roomNumber, RoomType enumeration) {
        super(roomNumber, 0.0, enumeration);
    }

    @Override
    public String getRoomNumber() {
        return super.getRoomNumber().toString();
    }

}
