package com.example.demo.services;

import com.example.demo.entities.Room;
import com.example.demo.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getByWorkspace(Long workspaceId) {
        return roomRepository.findByWorkspaceId(workspaceId);  // 💡 Исправлено!
    }

    public Room create(Room room) {
        return roomRepository.save(room);
    }
}
