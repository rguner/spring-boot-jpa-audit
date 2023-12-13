package com.guner.springbootjpaaudit.repository;

import com.guner.springbootjpaaudit.entity.Inventory;
import com.guner.springbootjpaaudit.entity.InventoryOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryOwnerRepository extends JpaRepository<InventoryOwner, Integer> {
}