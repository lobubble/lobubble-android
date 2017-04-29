package net.jspiner.lobbuble.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.activity.DetailActivity;
import net.jspiner.lobbuble.model.RecoResponse;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainPagerAdapter extends PagerAdapter {

    public final String TAG = this.getClass().getSimpleName();

    LayoutInflater inflater;
    Context context;
    RecoResponse.Data[] dataList;

    public MainPagerAdapter(Context context, LayoutInflater inflater, RecoResponse.Data[] dataList){
        this.context = context;
        this.inflater = inflater;
        this.dataList = dataList;
    }


    class ViewHolder{

        @Bind(R.id.imv_profile)
        ImageView imvProfile;

        public ViewHolder(View view, final int position){
            ButterKnife.bind(this, view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("data", new Gson().toJson(dataList[position]));
                    context.startActivity(intent);

                    ((Activity)context).overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                }
            });

            Picasso.with(context)
                    .load(dataList[position].picture)
                    .fit()
                    .into(imvProfile);
        }
    }

    @Override
    public int getCount() {
        return dataList.length;
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
