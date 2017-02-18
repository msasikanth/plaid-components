package com.pddstudio.plaid.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AspectImageView extends ImageView {

    private float aspectWidth = 0f;
    private float aspectHeight = 0f;

    public AspectImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AspectImageView);

        aspectWidth = a.getFloat(R.styleable.AspectImageView_aspectWidth, 4f);
        aspectHeight = a.getFloat(R.styleable.AspectImageView_aspectHeight, 3f);

        a.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int newHeight = MeasureSpec.makeMeasureSpec((int) (MeasureSpec.getSize(widthMeasureSpec) * aspectWidth / aspectHeight), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, newHeight);
    }
}
