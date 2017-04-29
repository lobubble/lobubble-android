package net.jspiner.lobbuble.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class CustemViewPager extends ViewPager {


    public final String TAG = this.getClass().getSimpleName();

    public CustemViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustemViewPager(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.d(TAG, "onMeasure");

        int height = 0;

        for(int i = 0; i < getChildCount(); i++) {

            View child = getChildAt(i);

            child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));

            int h = child.getMeasuredHeight();

            if(h > height) height = h;

        }



        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);


        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
