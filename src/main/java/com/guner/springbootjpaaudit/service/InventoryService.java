
package com.guner.springbootjpaaudit.service;

import com.guner.springbootjpaaudit.entity.Inventory;
import com.guner.springbootjpaaudit.entity.InventoryOwner;
import com.guner.springbootjpaaudit.entity.UserInfo;
import com.guner.springbootjpaaudit.model.UserInfoDetails;
import com.guner.springbootjpaaudit.repository.InventoryOwnerRepository;
import com.guner.springbootjpaaudit.repository.InventoryRepository;
import com.guner.springbootjpaaudit.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService  {
  
    private final InventoryRepository inventoryRepository;
    private final InventoryOwnerRepository inventoryOwnerRepository;

    public Inventory addInventory(Inventory inventory) {
        Inventory inventorySaved = inventoryRepository.save(inventory);
        return inventorySaved;
    }

    public Inventory addInventoryWithCheck(Inventory inventory) {
        Optional<InventoryOwner> inventoryOwnerOptional = inventoryOwnerRepository.findById(inventory.getInventoryOwner().getId());

        if (inventoryOwnerOptional.isPresent()) {
            inventory.setInventoryOwner(inventoryOwnerOptional.get());
        }
        Inventory inventorySaved = inventoryRepository.save(inventory);

        Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventorySaved.getId());

        if (inventoryOptional.isPresent()) {
            log.info("inventoryOptional.get() : " + inventoryOptional.get());
            return inventoryOptional.get();
        } else {
            log.info("inventoryOptional.get() : " + inventoryOptional);
            return null;
        }
    }

    @Transactional
    public Inventory addInventoryWithCheckTransactional(Inventory inventory) {
        Optional<InventoryOwner> inventoryOwnerOptional = inventoryOwnerRepository.findById(inventory.getInventoryOwner().getId());

        if (inventoryOwnerOptional.isPresent()) {
            inventory.setInventoryOwner(inventoryOwnerOptional.get());
        }
        Inventory inventorySaved = inventoryRepository.save(inventory);

        Optional<Inventory> inventoryOptional = inventoryRepository.findById(inventorySaved.getId());

        if (inventoryOptional.isPresent()) {
            log.info("inventoryOptional.get() : " + inventoryOptional.get());
            return inventoryOptional.get();
        } else {
            log.info("inventoryOptional.get() : " + inventoryOptional);
            return null;
        }
    }


    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
}