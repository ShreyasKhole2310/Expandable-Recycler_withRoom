package com.example.myapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.beanclasses.BrandAndDetails;
import com.example.myapplication.beanclasses.BrandList;
import com.example.myapplication.beanclasses.BrandsTable;
import com.example.myapplication.beanclasses.PhoneDetailsList;
import com.example.myapplication.repo.FirstFragmentRepo;

import java.util.List;

public class FirstFragmentVM extends AndroidViewModel {

    private FirstFragmentRepo firstFragmentRepo;

    public FirstFragmentVM(@NonNull Application application) {
        super(application);
        firstFragmentRepo = FirstFragmentRepo.getInstance(application);
    }

    public LiveData<List<BrandsTable>> getAllBrands(){
       return firstFragmentRepo.getBrandList();
    }

    public List<PhoneDetailsList> getPhones(long id){
        return firstFragmentRepo.getPhoneList(id);
    }

    public List<BrandAndDetails> getPhones(String cond){
        return firstFragmentRepo.getPhoneList(cond);
    }

}
