package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Facility {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name; // наприклад: Wi-Fi, Projector, Printer

  @ManyToOne
  @JoinColumn(name = "workspace_id")
  private Workspace workspace;
}
