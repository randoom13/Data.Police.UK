package com.amber.random.datapoliceuk.assertions;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.view.View;
import android.widget.TextView;

import org.junit.Assert;

public class TextViewTextAssertion implements ViewAssertion {
    private CharSequence mText;

    public TextViewTextAssertion(CharSequence text) {
        mText = text;
    }

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        Assert.assertTrue(view instanceof TextView);
        Assert.assertEquals(mText, ((TextView) view).getText());
    }
}
