package com.example.myapplication.interfaces;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.myapplication.beanclasses.BrandAndDetails;
import com.example.myapplication.beanclasses.BrandList;
import com.example.myapplication.beanclasses.BrandsTable;
import com.example.myapplication.beanclasses.PhoneDetailsList;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface Branddao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertBrands(BrandsTable brandList);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertBrands(PhoneDetailsList brandList);

    @Query("Select * from brandNames")
    LiveData<List<BrandsTable>> getAllList();

    @Query("DELETE FROM brandNames")
    void deleteAll();

    @Query("DELETE FROM phonedetails")
    void deleteAllPhones();

    @Query("Select * from brandNames where txtBrandName = :name")
    LiveData<List<BrandsTable>> getlstBrands(String name);

    @Query("Select * from phonedetails where intBrandId = :id")
    List<PhoneDetailsList> getPhoneDetails(long id);

    @Query("select * from phoneDetails pd order by :cond ASC")
    List<BrandAndDetails> getPhoneDetails(String cond);
}
