package com.amber.random.datapoliceuk.model.force;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class EngagementMethodItem {
    public static TypeAdapter<EngagementMethodItem> typeAdapter(Gson gson) {
        return new AutoValue_EngagementMethodItem.GsonTypeAdapter(gson);
    }

    public abstract String url();

    public abstract String description();

    public abstract String title();
}
