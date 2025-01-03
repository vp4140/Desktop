package com.example.demo.service;

import com.example.demo.model.todo;
import com.example.demo.repository.DataInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private DataInt repository;

    public List<todo> getAllTask(){
        return repository.findAll();
    }

    public boolean addTask(todo task) {
        try{
            repository.save(task);
            return true;
        }catch (Exception e){

            return false;
        }

    }
    public  boolean deleteTask(Long id){
       if(repository.findById(id).isEmpty()){
           return false;
       }else{
           repository.deleteById(id);
           return true;
       }

    }

}
