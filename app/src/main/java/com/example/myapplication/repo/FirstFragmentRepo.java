package com.example.myapplication.repo;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.beanclasses.BrandAndDetails;
import com.example.myapplication.beanclasses.BrandList;
import com.example.myapplication.beanclasses.BrandsTable;
import com.example.myapplication.beanclasses.PhoneDetailsList;
import com.example.myapplication.interfaces.Branddao;
import com.example.myapplication.roomdb.BrandsDatabase;

import java.util.List;

public class FirstFragmentRepo {

    private static FirstFragmentRepo instance;
    private BrandsDatabase brandsDatabase;
    private List<PhoneDetailsList> phoneDetailsLists;
    private PhoneDetailsList phoneDetailsList;
    private Branddao branddao;
    private LiveData<List<BrandsTable>> lstBrands;

    private FirstFragmentRepo(Context mContext){
        brandsDatabase = BrandsDatabase.getDatabase(mContext);
        branddao = brandsDatabase.branddao();
        lstBrands = branddao.getAllList();
    }

    public static FirstFragmentRepo getInstance(Context mContext){
        if(instance == null){
            return new FirstFragmentRepo(mContext);
        }
        return instance;
    }

    public LiveData<List<BrandsTable>> getBrandList(){
        return lstBrands;
    }

    public List<PhoneDetailsList> getPhoneList(long id){
        return branddao.getPhoneDetails(id);
    }

    public List<BrandAndDetails> getPhoneList(String cond){
        return branddao.getPhoneDetails(cond);
    }

}
