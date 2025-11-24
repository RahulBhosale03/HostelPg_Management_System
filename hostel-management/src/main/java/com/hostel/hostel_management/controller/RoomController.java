package com.hostel.hostel_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostel.hostel_management.model.Room;
import com.hostel.hostel_management.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	 @PostMapping
	    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
	        return ResponseEntity.ok(roomService.saveRoom(room));
	    }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
	        Optional<Room> room = roomService.getRoomById(id);
	        return room.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }
	 @GetMapping
	    public List<Room> getAllRooms() {
	        return roomService.getAllRooms();
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
	        Room updated = roomService.updateRoom(id, room);
	        if (updated == null) {
	            return ResponseEntity.notFound().build();
	        }
	        return ResponseEntity.ok(updated);
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
	        roomService.deleteRoom(id);
	        return ResponseEntity.noContent().build();
	    }
	
}
