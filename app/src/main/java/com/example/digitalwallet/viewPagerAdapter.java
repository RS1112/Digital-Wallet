package com.example.digitalwallet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class viewPagerAdapter extends PagerAdapter {

    Context context;
    int images[]={
            R.drawable.pay,
            R.drawable.scan_img,
            R.drawable.vouchers,
    };
    String headings[]={
            "Quick and easy payment!!",
            "Scan and pay!!",
            "Redeem exciting vouchers!!",
    };
    String description[]={
            "Send or receive money anytime and anywhere in the form of e-RUPI.",
            "Scanning option for secure, cashless and contactless payment.",
            "Transactions through this digital voucher are fast and reliable as the voucher is already pre-paid with the required amount."
    };

    public viewPagerAdapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slider_layout,container,false);
        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.titleImg);
        TextView slideHeading = (TextView) view.findViewById(R.id.titleText);
        TextView slideDescription = (TextView) view.findViewById(R.id.descriptionText);

        slidetitleimage.setImageResource(images[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
