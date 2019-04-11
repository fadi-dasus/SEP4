package com.example.legalizeco2.business.data.database.dao;

import com.example.legalizeco2.business.model.Customer;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CustomerDao {

    @Insert
    void insert(Customer customer);

    @Query("DELETE FROM Customer_table")
    void deleteAll();

    @Query("SELECT * FROM Customer_table ORDER BY customer ASC")
    LiveData<List<Customer>> getAllCustomers();
}
