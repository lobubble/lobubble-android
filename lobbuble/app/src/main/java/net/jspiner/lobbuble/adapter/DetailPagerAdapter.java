package net.jspiner.lobbuble.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.activity.DetailActivity;
import net.jspiner.lobbuble.model.ImageResponse;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class DetailPagerAdapter extends PagerAdapter {

    LayoutInflater inflater;
    Context context;
    String picture;
    ImageResponse.Data[] data;

    public DetailPagerAdapter(Context context, LayoutInflater inflater, String picture, ImageResponse.Data[] data){
        this.context = context;
        this.inflater = inflater;
        this.picture = picture;
        this.data = data;
    }

    class ViewHolder{

        @Bind(R.id.imv_detail_img)
        ImageView imvDetail;


        public ViewHolder(View view, int position){
            ButterKnife.bind(this, view);

            if (data.length -1 < position){

                Picasso.with(context)
                        .load(R.drawable.img_1)
                        .resize(500, 500)
                        .centerCrop()
                        .into(imvDetail);

            }
            else {
                Picasso.with(context)
                        .load(/*"https://lobubble.azurewebsites.net" + */data[position].file)
                        .resize(500, 500)
                        .centerCrop()
                        .into(imvDetail);
            }

        }
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null;

        view = inflater.inflate(R.layout.item_detailpager_item, null);

        ViewHolder holder = new ViewHolder(view, position);

        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((View)object);
    }

}
