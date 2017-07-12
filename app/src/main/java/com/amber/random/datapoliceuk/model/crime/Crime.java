package com.amber.random.datapoliceuk.model.crime;

import android.support.annotation.Nullable;

import com.amber.random.datapoliceuk.model.base.Location;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Crime {
    public static TypeAdapter<Crime> typeAdapter(Gson gson) {
        return new AutoValue_Crime.GsonTypeAdapter(gson);
    }

    public abstract CrimesCategory category();

    @SerializedName("location_type")
    public abstract String locationType();

    @SerializedName("location_subtype")
    public abstract String locationSubtype();

    @SerializedName("persistent_id")
    public abstract String persistentId();

    public abstract String month();

    public abstract Location location();

    @Nullable
    public abstract String context();

    public abstract Integer id();

    @Nullable
    @SerializedName("outcome_status")
    public abstract OutcomeStatus outcomeStatus();
}
