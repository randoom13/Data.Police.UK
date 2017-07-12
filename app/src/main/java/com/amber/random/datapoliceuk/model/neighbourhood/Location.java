package com.amber.random.datapoliceuk.model.neighbourhood;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class Location {
    public static TypeAdapter<Location> typeAdapter(Gson gson) {
        return new AutoValue_Location.GsonTypeAdapter(gson);
    }

    @Nullable
    public abstract String name();

    @Nullable
    public abstract Double latitude();

    @Nullable
    public abstract Double longitude();

    @Nullable
    public abstract String postcode();

    @Nullable
    public abstract String address();

    @Nullable
    public abstract String telephone();

    @Nullable
    public abstract String type();

    @Nullable
    public abstract String description();
}
