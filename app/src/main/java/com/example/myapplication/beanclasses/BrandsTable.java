package com.example.myapplication.beanclasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "brandNames")
public class BrandsTable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int intBrandId;

    private String txtBrandName;

    @Ignore
    private List<PhoneDetailsList> lstDetails;

    public BrandsTable(String txtBrandName) {
        this.txtBrandName = txtBrandName;
    }

    public int getIntBrandId() {
        return intBrandId;
    }

    public void setIntBrandId(int intBrandId) {
        this.intBrandId = intBrandId;
    }

    public String getTxtBrandName() {
        return txtBrandName;
    }

    public void setTxtBrandName(String txtBrandName) {
        this.txtBrandName = txtBrandName;
    }
}
