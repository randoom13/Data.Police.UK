package com.amber.random.datapoliceuk.model.neighbourhood;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class NeighbourhoodLocate {
    public static TypeAdapter<NeighbourhoodLocate> typeAdapter(Gson gson) {
        return new AutoValue_NeighbourhoodLocate.GsonTypeAdapter(gson);
    }

    public abstract String force();

    public abstract String neighbourhood();
}
