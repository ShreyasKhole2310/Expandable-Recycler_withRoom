package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.beanclasses.BrandList;
import com.example.myapplication.beanclasses.PhoneDetailsList;
import com.example.myapplication.interfaces.ParentListItem;
import com.example.myapplication.viewholders.ChildCellHolder;
import com.example.myapplication.viewholders.ParentCellHeader;

import java.util.List;

public class RecyclerAdapter extends ExpandRecyclerAdapter<ParentCellHeader, ChildCellHolder> {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<BrandList> lstBrands;

    public RecyclerAdapter(List<BrandList> parentItemList, Context mContext) {
        super(parentItemList);
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        this.lstBrands =  parentItemList;
    }

    @Override
    public ParentCellHeader onCreateParentViewHolder(ViewGroup parentViewGroup) {
        View v = mLayoutInflater.inflate(R.layout.header_cell, parentViewGroup, false);
        return new ParentCellHeader(v);
    }

    @Override
    public ChildCellHolder onCreateChildViewHolder(ViewGroup childViewGroup) {
        View v = mLayoutInflater.inflate(R.layout.child_cell, childViewGroup, false);
        return new ChildCellHolder(v);
    }

    @Override
    public void onBindParentViewHolder(ParentCellHeader parentViewHolder, int position, ParentListItem parentListItem) {
        BrandList lstHealthPackages = (BrandList) parentListItem;
        parentViewHolder.bind(lstHealthPackages);
    }

    @Override
    public void onBindChildViewHolder(ChildCellHolder childViewHolder, int position, Object childListItem) {
        PhoneDetailsList lstChildHolder = (PhoneDetailsList) childListItem;
        childViewHolder.bind(lstChildHolder);
    }
}
