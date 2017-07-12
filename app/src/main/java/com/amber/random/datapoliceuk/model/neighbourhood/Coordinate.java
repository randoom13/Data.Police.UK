package com.amber.random.datapoliceuk.model.neighbourhood;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Coordinate {
    public static TypeAdapter<Coordinate> typeAdapter(Gson gson) {
        return new AutoValue_Coordinate.GsonTypeAdapter(gson);
    }

    public abstract Double latitude();

    public abstract Double longitude();
}
