package com.syndicate.cgpacalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;


    public ImageAdapter(Context c) {
        this.mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      //  ImageView imageView;
        View gridViewAndroid;
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view==null){
//            imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new GridView.LayoutParams(600,600));
//            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageView.setPadding(8,8,8,8);
            gridViewAndroid = new View(mContext);
            gridViewAndroid = inflater.inflate(R.layout.gridview_layout,null);
            TextView textView = gridViewAndroid.findViewById(R.id.gridview_text);
            ImageView imageView = gridViewAndroid.findViewById(R.id.gridview_image);
            textView.setText(mString[i]);
            imageView.setImageResource(mThumbIds[i]);

        }else{
            gridViewAndroid = (View)  view;
        }
      //  imageView.setImageResource(mThumbIds[i]);
        return gridViewAndroid;
    }
    public Integer[] mThumbIds = {
      R.drawable.cse_logo,R.drawable.ece_logo,R.drawable.eee_logo,R.drawable.mech_logo,R.drawable.civil_logo,R.drawable.cse_logo
    };
    public String[] mString ={
      "CSE","ECE","EEE","MECH","CIVIL","IT"
    };
}
