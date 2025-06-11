package com.example.demo.controllers;

import com.example.demo.entities.Room;
import com.example.demo.entities.Workspace;
import com.example.demo.repositories.RoomRepository;
import com.example.demo.repositories.WorkspaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomRepository roomRepository;
    private final WorkspaceRepository workspaceRepository;

    public RoomController(RoomRepository roomRepository, WorkspaceRepository workspaceRepository) {
        this.roomRepository = roomRepository;
        this.workspaceRepository = workspaceRepository;
    }

    // Отримати всі кімнати
    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Отримати кімнату за ID
    @GetMapping("/{id}")
    public Optional<Room> getRoomById(@PathVariable Long id) {
        return roomRepository.findById(id);
    }

    // Додати нову кімнату до workspace
    @PostMapping("/workspace/{workspaceId}")
    public Room createRoom(@PathVariable Long workspaceId, @RequestBody Room room) {
        Workspace workspace = workspaceRepository.findById(workspaceId)
            .orElseThrow(() -> new RuntimeException("Workspace not found"));
        room.setWorkspace(workspace);
        return roomRepository.save(room);
    }

    // Оновити кімнату
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
        Room room = roomRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setName(updatedRoom.getName());
        room.setType(updatedRoom.getType());
        room.setHourlyRate(updatedRoom.getHourlyRate());

        return roomRepository.save(room);
    }

    // Видалити кімнату
    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomRepository.deleteById(id);
    }
}
