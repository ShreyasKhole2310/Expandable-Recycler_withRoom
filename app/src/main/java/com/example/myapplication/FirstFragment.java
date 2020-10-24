package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapters.RecyclerAdapter;
import com.example.myapplication.beanclasses.BrandAndDetails;
import com.example.myapplication.beanclasses.BrandList;
import com.example.myapplication.beanclasses.BrandsTable;
import com.example.myapplication.beanclasses.PhoneDetailsList;
import com.example.myapplication.viewmodels.FirstFragmentVM;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private RecyclerView rvPhonesList;
    private RecyclerAdapter rvPhonesAdapter;
    private List<BrandList> lstBrands;
    private FirstFragmentVM firstFragmentVM;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPhonesList = view.findViewById(R.id.rvRecycler);
        rvPhonesList.setLayoutManager(new LinearLayoutManager(getContext()));

        lstBrands = new ArrayList<>();
        firstFragmentVM = new ViewModelProvider(this).get(FirstFragmentVM.class);

        firstFragmentVM.getAllBrands().observe(getViewLifecycleOwner(), lstData -> {
            for (BrandsTable brandsTable : lstData) {
                BrandList brandList = new BrandList(brandsTable.getTxtBrandName());
                brandList.setLstHealthCheckPersons(firstFragmentVM.getPhones(brandsTable.getIntBrandId()));
                lstBrands.add(brandList);
            }

            rvPhonesAdapter = new RecyclerAdapter(lstBrands, getContext());
            rvPhonesList.setAdapter(rvPhonesAdapter);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.action_date:
                setList(firstFragmentVM.getPhones("txtDate"));
                break;
            case R.id.action_ratings:
                setList(firstFragmentVM.getPhones("starRatingCount"));
                break;
            case R.id.action_quantit:
                setList(firstFragmentVM.getPhones("txtQuantity"));
                break;
        }



        return super.onOptionsItemSelected(item);

    }

    private void setList(List<BrandAndDetails> lstData) {
        try {
            lstBrands = new ArrayList<>();

            for (BrandAndDetails brandsTable : lstData) {
                boolean foundData = false;

                for (BrandList brandList : lstBrands) {
                    if (brandsTable.getBrandsTable().getTxtBrandName().equals(brandList.getTxtBrandName())) {
                        foundData = true;
                    }
                }

                if (!foundData) {
                    BrandList brandList = new BrandList(brandsTable.getBrandsTable().getTxtBrandName());
                    brandList.setLstHealthCheckPersons(brandsTable.getLstPhoneDetails());
                    lstBrands.add(brandList);
                }
            }

            rvPhonesAdapter = new RecyclerAdapter(lstBrands, getContext());
            rvPhonesList.setAdapter(rvPhonesAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
