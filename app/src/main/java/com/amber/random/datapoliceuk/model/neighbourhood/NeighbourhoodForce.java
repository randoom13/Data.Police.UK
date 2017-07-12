package com.amber.random.datapoliceuk.model.neighbourhood;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class NeighbourhoodForce {
    public static TypeAdapter<NeighbourhoodForce> typeAdapter(Gson gson) {
        return new AutoValue_NeighbourhoodForce.GsonTypeAdapter(gson);
    }

    @SerializedName("id")
    public abstract String specificForceId();

    @SerializedName("name")
    public abstract String neighbourhoodName();
}
