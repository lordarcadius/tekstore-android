package com.codebreakers.tekstore.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codebreakers.tekstore.ProductRecycler;
import com.codebreakers.tekstore.R;
import com.codebreakers.tekstore.RecyclerViewAdapter;

import java.util.ArrayList;

public class ProductFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);


        ArrayList<ProductRecycler> exampleList1 = new ArrayList<>();
        exampleList1.add(new ProductRecycler(R.drawable.header, "Laptop", "Vllll",500));
        exampleList1.add(new ProductRecycler(R.drawable.header, "Laptop", "Vllll",500));

        exampleList1.add(new ProductRecycler(R.drawable.header, "Laptop", "Vllll",500));

        exampleList1.add(new ProductRecycler(R.drawable.delivery, "Laptop", "Vllll",500));

        exampleList1.add(new ProductRecycler(R.drawable.delivery, "Laptop", "Vllll",500));

        exampleList1.add(new ProductRecycler(R.drawable.delivery, "Laptop", "Vllll",500));
        exampleList1.add(new ProductRecycler(R.drawable.delivery, "Laptop", "Vllll",500));
        exampleList1.add(new ProductRecycler(R.drawable.delivery, "Laptop", "Vllll",500));



        mRecyclerView = view.findViewById(R.id.products_recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new RecyclerViewAdapter(exampleList1);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



        return view;
    }
}
