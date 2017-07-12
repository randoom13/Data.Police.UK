package com.amber.random.datapoliceuk.model.neighbourhood;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Link {
    public static TypeAdapter<Link> typeAdapter(Gson gson) {
        return new AutoValue_Link.GsonTypeAdapter(gson);
    }

    public abstract String url();

    public abstract String description();

    public abstract String title();
}
