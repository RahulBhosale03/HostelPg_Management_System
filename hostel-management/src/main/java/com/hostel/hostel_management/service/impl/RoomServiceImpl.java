package com.hostel.hostel_management.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostel.hostel_management.model.Room;
import com.hostel.hostel_management.repository.RoomRepository;
import com.hostel.hostel_management.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository roomRepository;

	@Override
	public Room saveRoom(Room room) {
		return roomRepository.save(room);
	}

	@Override
	public Optional<Room> getRoomById(Long id) {
		
		return roomRepository.findById(id);
	}

	@Override
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room updateRoom(Long id, Room room) {
		Optional<Room> existingRoom = roomRepository.findById(id);
		if (existingRoom.isPresent()) {
            Room updatedRoom = existingRoom.get();
            updatedRoom.setRoomNumber(room.getRoomNumber());
            updatedRoom.setRoomtype(room.getRoomtype());
            updatedRoom.setCapacity(room.getCapacity());
            updatedRoom.setOccupied(room.getOccupied());
            updatedRoom.setPricePerMonth(room.getPricePerMonth());
            updatedRoom.setStatus(room.getStatus());
            return roomRepository.save(updatedRoom);
		}else {
		return null;
		}
	}

	@Override
	public void deleteRoom(Long id) {
		roomRepository.deleteById(id);
	}

	@Override
	public Optional<Room> getRoomByRoomNumber(String roomNumber) {
		return Optional.ofNullable(roomRepository.findByRoomNumber(roomNumber));
	}
}
