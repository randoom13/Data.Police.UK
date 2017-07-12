package com.amber.random.datapoliceuk.model.base;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Location {
    public static TypeAdapter<Location> typeAdapter(Gson gson) {
        return new AutoValue_Location.GsonTypeAdapter(gson);
    }

    public abstract Double latitude();

    public abstract Double longitude();

    public abstract String street();
}
