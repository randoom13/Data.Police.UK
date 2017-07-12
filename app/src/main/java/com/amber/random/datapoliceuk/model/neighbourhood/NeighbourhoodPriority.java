package com.amber.random.datapoliceuk.model.neighbourhood;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class NeighbourhoodPriority {
    @Nullable
    public abstract String action();
    @SerializedName("issue-date")
    public abstract String issueDate();
    @Nullable
    @SerializedName("action-date")
    public abstract String actionDate();
    public abstract String issue();
}
