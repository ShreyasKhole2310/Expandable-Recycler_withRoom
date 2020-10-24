package com.example.myapplication.beanclasses;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BrandAndDetails {

    @Embedded
    private BrandsTable brandsTable;

    @Relation(parentColumn = "intBrandId", entityColumn = "intBrandId", entity = PhoneDetailsList.class)
    private List<PhoneDetailsList> lstPhoneDetails;

    public BrandsTable getBrandsTable() {
        return brandsTable;
    }

    public void setBrandsTable(BrandsTable brandsTable) {
        this.brandsTable = brandsTable;
    }

    public List<PhoneDetailsList> getLstPhoneDetails() {
        return lstPhoneDetails;
    }

    public void setLstPhoneDetails(List<PhoneDetailsList> lstPhoneDetails) {
        this.lstPhoneDetails = lstPhoneDetails;
    }
}
