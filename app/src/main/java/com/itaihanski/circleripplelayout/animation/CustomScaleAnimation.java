/*
 * Copyright (C) 2014 Itai Hanski
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.itaihanski.circleripplelayout.animation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;

/**
 * A {@link android.view.animation.ScaleAnimation} that provides extra information.
 *
 * @author Itai Hanski
 */
public class CustomScaleAnimation extends ScaleAnimation {

    private float mLastInterpolatedTime;
    private boolean mIsCanceled;

    public CustomScaleAnimation(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScaleAnimation(float fromX, float toX, float fromY, float toY) {
        super(fromX, toX, fromY, toY);
    }

    public CustomScaleAnimation(float fromX, float toX, float fromY, float toY, float pivotX, float pivotY) {
        super(fromX, toX, fromY, toY, pivotX, pivotY);
    }

    public CustomScaleAnimation(float fromX, float toX, float fromY, float toY, int pivotXType, float pivotXValue, int pivotYType, float pivotYValue) {
        super(fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        mLastInterpolatedTime = interpolatedTime;
        super.applyTransformation(interpolatedTime, t);
    }

    @Override
    public void cancel() {
        mIsCanceled = true;
        super.cancel();
    }

    @Override
    public void setStartTime(long startTimeMillis) {
        mIsCanceled = false;
        super.setStartTime(startTimeMillis);
    }

    public float getLastInterpolatedTime() {
        return mLastInterpolatedTime;
    }

    public boolean isCanceled() {
        return mIsCanceled;
    }
}