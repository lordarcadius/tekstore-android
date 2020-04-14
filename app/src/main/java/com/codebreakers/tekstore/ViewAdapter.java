package com.codebreakers.tekstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

class ViewAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};
    private String[] texts = {"Fast & safe delivery across India. Get all your products at your doorsteps. We also provide one day delivery at reasonable prices.", "All the products available on The TekStore are from trusted brands only with full brand warranty and up to 30 days of return period. ", "Stuck at something? Do you have any query? We have our customer support available 24x7. Reach us by Call or Email.", "Pay using Cash/Card/UPI/Wallet. We accept multiple modes of payments for your convenience. EMI is also available up to 24 months."};

    ViewAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return images.length & texts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item, null);
        ImageView imageView = view.findViewById(R.id.image_View);
        TextView textView = view.findViewById(R.id.text_view);
        imageView.setImageResource(images[position]);
        textView.setText(texts[position]);
        ViewPager viewPager = (ViewPager) container;
        viewPager.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
