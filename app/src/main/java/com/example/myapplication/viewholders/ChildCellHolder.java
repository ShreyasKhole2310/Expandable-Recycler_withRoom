package com.example.myapplication.viewholders;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.beanclasses.PhoneDetailsList;

/**
 * Created by shreyask on 21/8/17.
 */

public class ChildCellHolder extends RecyclerView.ViewHolder {
    private AppCompatImageView imgPhone;
    private AppCompatTextView txtType, txtQuantity, txtDate;
    private AppCompatRatingBar ratingBar;

    public ChildCellHolder(View itemView) {
        super(itemView);
        imgPhone = itemView.findViewById(R.id.phoneImage);
        txtType = itemView.findViewById(R.id.txtType);
        txtQuantity = itemView.findViewById(R.id.txtQuantity);
        txtDate = itemView.findViewById(R.id.txtDate);
        ratingBar = itemView.findViewById(R.id.ratingBar);
    }

    public void bind(PhoneDetailsList phoneDetailsList){
        txtType.setText(phoneDetailsList.getTxtPhoneName());
        txtQuantity.setText(new StringBuilder().append("Quantity :").append(phoneDetailsList.getTxtQuantity()).toString());
        txtDate.setText(phoneDetailsList.getTxtDate());
        ratingBar.setRating(phoneDetailsList.getStarRatingCount());
    }

}
