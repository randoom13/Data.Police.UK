package com.amber.random.datapoliceuk.model.neighbourhood;

import android.support.annotation.Nullable;

import com.amber.random.datapoliceuk.model.base.ContactDetails;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class NeighbourhoodTeam {
    public static TypeAdapter<NeighbourhoodTeam> typeAdapter(Gson gson) {
        return new AutoValue_NeighbourhoodTeam.GsonTypeAdapter(gson);
    }

    @SerializedName("bio")
    public abstract String biography();

    @Nullable
    @SerializedName("contact_details")
    public abstract ContactDetails contactDetails();

    @SerializedName("name")
    public abstract String personName();

    @SerializedName("rank")
    public abstract String forceRank();
}
