package com.guner.springbootjpaaudit.controller;

import com.guner.springbootjpaaudit.entity.Inventory;
import com.guner.springbootjpaaudit.entity.UserInfo;
import com.guner.springbootjpaaudit.repository.InventoryRepository;
import com.guner.springbootjpaaudit.service.InventoryService;
import com.guner.springbootjpaaudit.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {
  
    private final InventoryService inventoryService;

    @PostMapping("/addNewInventory")
    public Inventory addNewInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventoryWithCheckTransactional(inventory);
    }

    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventory(){
        List<Inventory> inventories= inventoryService.getAllInventory();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }
  
} 