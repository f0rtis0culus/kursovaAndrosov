package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;              // Назва коворкінгу
    private String location;          // Адреса або місто
    private Integer capacity;         // Кількість доступних місць

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    private List<Room> rooms;         // Робочі місця (кабінети, столи тощо)

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    private List<Facility> facilities; // Умови (Wi-Fi, принтер і т.д.)
}
