package com.amber.random.datapoliceuk.model.force;

import android.support.annotation.Nullable;

import com.amber.random.datapoliceuk.model.base.ContactDetails;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class SeniorOfficerItem {
    public static TypeAdapter<SeniorOfficerItem> typeAdapter(Gson gson) {
        return new AutoValue_SeniorOfficerItem.GsonTypeAdapter(gson);
    }

    @Nullable
    @SerializedName("bio")
    public abstract String biography();

    @SerializedName("contact_details")
    public abstract ContactDetails contactDetails();

    public abstract String name();

    public abstract String rank();
}
