package com.chaitu.rdbms_project.controller;

import com.chaitu.rdbms_project.models.TableMetaData;
import com.chaitu.rdbms_project.service.RdbmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@ComponentScan("com.chaitu.rdbms_project.service")
public class UserController {

    private final RdbmsService rdbmsService;
    @Autowired
    public UserController(RdbmsService rdbmsService) {
        this.rdbmsService = rdbmsService;
    }

    @PostMapping("/create-table")
    public String createTable(@RequestBody TableMetaData tableMetaData){
        rdbmsService.createTable(tableMetaData);
        return "Table created successfully";
    }

    @PostMapping("/insert-data/{table-name}")
    public String insertDataIntoTable(@PathVariable("table-name") String tableName, @RequestBody Map<String, Object> data){
        rdbmsService.insertData(tableName, data);
        return "Data inserted successfully";
    }

    @GetMapping("getData/{table-name}")
    public List<Map<String, Object>> getData(@PathVariable("table-name") String tableName){
        return rdbmsService.getData(tableName);
    }
    
}
