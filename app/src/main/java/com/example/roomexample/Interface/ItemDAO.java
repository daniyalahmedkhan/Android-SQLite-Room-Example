package com.example.roomexample.Interface;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomexample.Entities.Item;

import java.util.List;

    @Dao
    public interface ItemDAO {
    @Insert
    public void insert(Item... items);

   @Query("UPDATE items set description = :description where id = :id")
   void update(String description , String id);

    @Query("DELETE from items where id = :id")
    void delete(String id);


    @Query("SELECT * FROM items")
    public List<Item> getItems();

   }
