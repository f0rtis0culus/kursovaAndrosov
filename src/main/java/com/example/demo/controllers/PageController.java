package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/w")
public class PageController {

  @GetMapping
  public String workspacesPage() {
    return "workspace"; // возвращает workspaces.html
  }
}
