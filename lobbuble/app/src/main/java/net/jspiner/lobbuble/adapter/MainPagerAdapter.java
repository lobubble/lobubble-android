package net.jspiner.lobbuble.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.jspiner.lobbuble.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainPagerAdapter extends PagerAdapter {

    public final String TAG = this.getClass().getSimpleName();

    LayoutInflater inflater;

    public MainPagerAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }


    class ViewHolder{

        public ViewHolder(View view, int position){
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                }
            });
        }
    }

    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d(TAG, "position " + position);
        View view = null;

        view = inflater.inflate(R.layout.item_pager_profile, null);

        ViewHolder holder = new ViewHolder(view, position);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public float getPageWidth(int position) {
        return 0.2f;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }
}
