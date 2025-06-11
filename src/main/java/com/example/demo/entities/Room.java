package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;        // Наприклад: "Місце №5" або "Стіл B3"
    private String type;        // Тип: Open-space, Private, Meeting-room
    private Double hourlyRate;  // Вартість за годину

    @ManyToOne
    @JoinColumn(name = "workspace_id")
    private Workspace workspace;
}
