package com.example.myapplication.beanclasses;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "PhoneDetails")
public class PhoneDetailsList {

    @PrimaryKey(autoGenerate = true)
    private int intDetailsId;

    private String txtPhoneName;

    private String txtQuantity;

    private String txtDate;

    private int starRatingCount;

    @ForeignKey(entity = BrandsTable.class,
            parentColumns = "intBrandId",
            childColumns = "intBrandId", onDelete = CASCADE)
    private long intBrandId;

    public int getIntDetailsId() {
        return intDetailsId;
    }

    public void setIntDetailsId(int intDetailsId) {
        this.intDetailsId = intDetailsId;
    }

    public long getIntBrandId() {
        return intBrandId;
    }

    public void setIntBrandId(long intBrandId) {
        this.intBrandId = intBrandId;
    }

    public String getTxtPhoneName() {
        return txtPhoneName;
    }

    public void setTxtPhoneName(String txtPhoneName) {
        this.txtPhoneName = txtPhoneName;
    }

    public String getTxtQuantity() {
        return txtQuantity;
    }

    public void setTxtQuantity(String txtQuantity) {
        this.txtQuantity = txtQuantity;
    }

    public String getTxtDate() {
        return txtDate;
    }

    public void setTxtDate(String txtDate) {
        this.txtDate = txtDate;
    }

    public int getStarRatingCount() {
        return starRatingCount;
    }

    public void setStarRatingCount(int starRatingCount) {
        this.starRatingCount = starRatingCount;
    }
}
