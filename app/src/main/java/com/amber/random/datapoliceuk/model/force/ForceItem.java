package com.amber.random.datapoliceuk.model.force;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ForceItem {
    public static TypeAdapter<ForceItem> typeAdapter(Gson gson) {
        return new AutoValue_ForceItem.GsonTypeAdapter(gson);
    }

    public abstract String id();

    public abstract String name();
}
