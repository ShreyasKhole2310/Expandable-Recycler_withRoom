package com.example.myapplication.viewholders;

import android.view.View;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myapplication.R;
import com.example.myapplication.beanclasses.BrandList;

public class ParentCellHeader extends ParentViewHolder {

    private AppCompatTextView txtBrandName;
    private ConstraintLayout llHeader;
    private boolean setExpanded = false;

    /**
     * Default constructor.
     *
     * @param itemView The {@link View} being hosted in this MyViewHolder
     */
    public ParentCellHeader(View itemView) {
        super(itemView);
        txtBrandName = itemView.findViewById(R.id.txtBrandName);
        llHeader = itemView.findViewById(R.id.llHeader);
        llHeader.setOnClickListener(view -> {
            if(setExpanded) {
                setExpanded = false;
                collapseView();
            }else{
                setExpanded = true;
                expandView();
            }
        });
    }

    public void bind(BrandList brandList){
        txtBrandName.setText(brandList.getTxtBrandName());
    }


}
