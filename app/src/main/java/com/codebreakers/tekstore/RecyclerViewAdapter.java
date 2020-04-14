package com.codebreakers.tekstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ExampleViewHolder> {
    private ArrayList<ProductRecycler> mExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;

        public TextView mTextView3;


        public ExampleViewHolder(View itemView) {
            super(itemView);
          //  mImageView = itemView.findViewById(R.id.products_Image);
          //  mTextView1 = itemView.findViewById(R.id.product_name);
            //mTextView2 = itemView.findViewById(R.id.product_description);
          //  mTextView3 = itemView.findViewById(R.id.product_price);



        }
    }

    public RecyclerViewAdapter(ArrayList<ProductRecycler> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public RecyclerViewAdapter.ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items, parent, false);
        RecyclerViewAdapter.ExampleViewHolder evh = new RecyclerViewAdapter.ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ProductRecycler currentItem = mExampleList.get(position);

        //older.mImageView.setImageResource(currentItem.getProductImage());
       // holder.mTextView1.setText(currentItem.getProductName());
      //  holder.mTextView2.setText(currentItem.getProductDescription());
       // holder.mTextView2.setText(currentItem.getProductPrice());

    }





    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
