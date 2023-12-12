package com.guner.springbootjpaaudit.repository;

import com.guner.springbootjpaaudit.entity.Inventory;
import com.guner.springbootjpaaudit.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Optional<Inventory> findByName(String name);
}