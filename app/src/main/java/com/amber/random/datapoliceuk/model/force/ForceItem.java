package com.amber.random.datapoliceuk.model.force;

import android.support.annotation.VisibleForTesting;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import static android.support.annotation.VisibleForTesting.NONE;

@AutoValue
public abstract class ForceItem {
    @VisibleForTesting(otherwise = NONE)
    public static ForceItem create(String id, String name) {
        return new AutoValue_ForceItem(id, name);
    }

    public static TypeAdapter<ForceItem> typeAdapter(Gson gson) {
        return new AutoValue_ForceItem.GsonTypeAdapter(gson);
    }

    public abstract String id();

    public abstract String name();
}
