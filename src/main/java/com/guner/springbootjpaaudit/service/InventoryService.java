
package com.guner.springbootjpaaudit.service;

import com.guner.springbootjpaaudit.entity.Inventory;
import com.guner.springbootjpaaudit.entity.UserInfo;
import com.guner.springbootjpaaudit.model.UserInfoDetails;
import com.guner.springbootjpaaudit.repository.InventoryRepository;
import com.guner.springbootjpaaudit.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService  {
  
    private final InventoryRepository inventoryRepository;

    public Inventory addInventory(Inventory inventory) {
        Inventory inventorySaved = inventoryRepository.save(inventory);
        return inventorySaved;
    }


    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}