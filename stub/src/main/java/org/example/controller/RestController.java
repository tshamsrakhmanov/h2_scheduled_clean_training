package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.Model.EntryClass;
import org.example.Repository.EntryDB;
import org.example.RequestDTO.HandlerRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    EntryDB repository;

    // handler to add entry to internal DB
    @PostMapping(value = "/handler1")
    public String handler1 (@RequestBody HandlerRequestDTO handler1RequestDTO) {

        EntryClass entryClass = new EntryClass();
        entryClass.setMdmCode(handler1RequestDTO.getMdmCode());
        entryClass.setCorrespondId(handler1RequestDTO.getCorrespondId());
        
        repository.save(entryClass);

        return "null";
    }

    // handler to return count of entries in locale DB
    @GetMapping(value = "/handler2")
    public String handler2 () {
        return "Count of entries in DB:" + String.valueOf(repository.count());
    }


    // handler to return ALL entries in the way they're saved
    @GetMapping(value = "/handler3")
    public String handler3 () {
        return repository.findAll().toString();
    }
}
