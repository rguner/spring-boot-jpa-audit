package com.guner.springbootjpaaudit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Inventory {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    private String name; 
    private String description;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @ManyToOne
    //@JoinColumn(name = "inventory_owner", insertable = true, updatable = false) // insert-update durumunda bu alana yazmaz.
    @JoinColumn(name = "inventory_owner")
    private InventoryOwner inventoryOwner;
  
} 