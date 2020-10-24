package com.example.myapplication.beanclasses;

import com.example.myapplication.interfaces.ParentListItem;

import java.util.List;

public class BrandList implements ParentListItem {

    private List<PhoneDetailsList> lstHealthCheckPersons;

    public BrandList(String txtBrandName) {
        this.txtBrandName = txtBrandName;
    }

    public List<PhoneDetailsList> getLstHealthCheckPersons() {
        return lstHealthCheckPersons;
    }

    public void setLstHealthCheckPersons(List<PhoneDetailsList> lstHealthCheckPersons) {
        this.lstHealthCheckPersons = lstHealthCheckPersons;
    }

    private String txtBrandName;

    public String getTxtBrandName() {
        return txtBrandName;
    }

    public void setTxtBrandName(String txtBrandName) {
        this.txtBrandName = txtBrandName;
    }

    @Override
    public List<PhoneDetailsList> getChildItemList() {
        return lstHealthCheckPersons;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
