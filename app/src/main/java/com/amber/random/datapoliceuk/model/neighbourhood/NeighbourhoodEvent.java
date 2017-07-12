package com.amber.random.datapoliceuk.model.neighbourhood;

import android.support.annotation.Nullable;

import com.amber.random.datapoliceuk.model.base.ContactDetails;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class NeighbourhoodEvent {
    @Nullable
    @SerializedName("contact_details")
    public abstract ContactDetails contactDetails();
    @Nullable
    public abstract String description();

    public abstract String title();

    public abstract String address();

    public abstract String type();

    @SerializedName("start_date")
    public abstract String startDate();

    @SerializedName("end_date")
    public abstract String endDate();

    public static TypeAdapter<NeighbourhoodEvent> typeAdapter(Gson gson){
        return new AutoValue_NeighbourhoodEvent.GsonTypeAdapter(gson);
    }
}
