package com.hostel.hostel_management.service;

import java.util.List;
import java.util.Optional;
import com.hostel.hostel_management.model.Room;

public interface RoomService {
	Room saveRoom(Room room);
	
	Optional<Room> getRoomById(Long id);
	
	List<Room> getAllRooms();
	
	Room updateRoom(Long id,Room room);
	
	void deleteRoom(Long id);
	
	Optional<Room> getRoomByRoomNumber(String roomNumber);
}
