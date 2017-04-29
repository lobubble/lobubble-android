package net.jspiner.lobbuble.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import net.jspiner.lobbuble.Prefer;
import net.jspiner.lobbuble.R;
import net.jspiner.lobbuble.Util;
import net.jspiner.lobbuble.model.FriendResponse;
import net.jspiner.lobbuble.model.RecoResponse;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<FriendResponse.Data> dataList;

    public MainRecyclerAdapter(Context context, ArrayList<FriendResponse.Data> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public static int defaultHeight = 0;

    public final String TAG = this.getClass().getSimpleName();


    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.imv_profile_img)
        ImageView imvProfile;

        @Bind(R.id.tv_profile_name)
        TextView tvName;

        @Bind(R.id.tv_profile_age)
        TextView tvAge;

        @Bind(R.id.tv_profile_namelist)
        TextView tvNameList;

        @Bind(R.id.pager_main_profile)
        ViewPager pagerMainProfile;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        void bind(final Context context, int position){


            Util.getService().getMyRecommend(
                    Prefer.get("accessToken",""),
                    "all",
                    dataList.get(position).id
            ).enqueue(new Callback<RecoResponse.Data[]>() {
                @Override
                public void onResponse(Call<RecoResponse.Data[]> call, Response<RecoResponse.Data[]> response) {
                    RecoResponse.Data[] body = response.body();

                    Log.d(TAG, new Gson().toJson(body));

                    final MainPagerAdapter adapter = new MainPagerAdapter(context, LayoutInflater.from(context), body);
                    pagerMainProfile.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<RecoResponse.Data[]> call, Throwable t) {
                    Log.e(TAG,"error");
                }
            });

            pagerMainProfile.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    if(positionOffset<0) positionOffset = 0;
                    if(positionOffset>1) positionOffset = 1;
                    Log.i(TAG, "onPageScrolled : " + position + " positionOffset : " + positionOffset);
                    int c = 0;
                    for(int i=position-2;i<position+7;i++){
                        if(i<0) continue;
                        if(i>=pagerMainProfile.getChildCount()) continue;

                        View view = pagerMainProfile.getChildAt(i).findViewById(R.id.imv_profile);
                        float padding = (Math.abs(position - i + positionOffset + 1))*140;
                        if(padding>240) padding = 240;
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();

                        Log.d(TAG, "height : " + params.height);
                        if(params.height>0) {
                            if (defaultHeight == 0) {
                                defaultHeight = params.height;
                            }
                            params.height = (int) (400 - padding);
                            view.setLayoutParams(params);
                        }
                        c++;

                    }
                }

                @Override
                public void onPageSelected(int position) {
                    tvName.setText( ((MainPagerAdapter) pagerMainProfile.getAdapter()).getItem(position +1).name);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });

            FriendResponse.Data profileData = dataList.get(position);

            Picasso.with(context)
                    .load(profileData.picture)
                    .resize(500,500)
                    .centerCrop()
                    .into(imvProfile);
            tvName.setText(profileData.name);
            tvAge.setText(""+(new Random().nextInt(3) + 20));
            tvNameList.setText(profileData.name+"님의 친구 목록");

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_main_list, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(context, position);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
