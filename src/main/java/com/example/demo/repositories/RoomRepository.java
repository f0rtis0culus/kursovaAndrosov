package com.example.demo.repositories;

import com.example.demo.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByWorkspaceId(Long workspaceId);


}
