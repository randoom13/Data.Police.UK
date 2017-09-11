package com.amber.random.datapoliceuk.assertions;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.junit.Assert;

public class EmptyTextViewTextAssertion implements ViewAssertion {
    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        Assert.assertTrue(view instanceof TextView);
        Assert.assertTrue(TextUtils.isEmpty(((TextView) view).getText()));
    }
}
