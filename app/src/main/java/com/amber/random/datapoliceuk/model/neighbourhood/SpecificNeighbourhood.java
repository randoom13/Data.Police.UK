package com.amber.random.datapoliceuk.model.neighbourhood;

import android.support.annotation.Nullable;

import com.amber.random.datapoliceuk.model.base.ContactDetails;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class SpecificNeighbourhood {
    public static TypeAdapter<SpecificNeighbourhood> typeAdapter(Gson gson) {
        return new AutoValue_SpecificNeighbourhood.GsonTypeAdapter(gson);
    }

    @SerializedName("url_force")
    public abstract String urlForce();

    @SerializedName("contact_details")
    public abstract ContactDetails contactDetails();

    public abstract String name();

    @SerializedName("welcome_message")
    public abstract String welcomeMessage();

    public abstract List<Link> links();

    public abstract Coordinate centre();

    public abstract List<Location> locations();

    public abstract Integer population();

    public abstract String id();

    @Nullable
    public abstract String description();
}
