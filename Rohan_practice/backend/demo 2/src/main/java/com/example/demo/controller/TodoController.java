package com.example.demo.controller;

import com.example.demo.model.todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {


 @Autowired
 private TodoService service;


//@GetMapping
// public String getAll(){
// return "Hello";
//}
 @GetMapping
 public List<todo> getAllTask() {
  return service.getAllTask();
 }


 @PostMapping
 public ResponseEntity<Boolean> addTask(@RequestBody todo task) {
  System.out.println("Received Task: " + task);
  return ResponseEntity.ok(service.addTask(task));
 }


 @DeleteMapping
 public ResponseEntity<String> deleteTask(@RequestParam Long taskid) {
  boolean taskDeleted = service.deleteTask(taskid);

  if (!taskDeleted) {
   return ResponseEntity.status(HttpStatus.NOT_FOUND)
           .body("Task not found");
  }

  return ResponseEntity.status(HttpStatus.NO_CONTENT)
          .body("Task deleted successfully");
 }
}
