package com.amber.random.datapoliceuk.model.force;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class SpecificForceItem {
    public static TypeAdapter<SpecificForceItem> typeAdapter(Gson gson) {
        return new AutoValue_SpecificForceItem.GsonTypeAdapter(gson);
    }

    @SerializedName("description")
    public abstract String description();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("engagement-methods")
    public abstract List<EngagementMethodItem> engagementMethods();

    @SerializedName("telephone")
    public abstract String telephone();

    @SerializedName("id")
    public abstract String id();

    @SerializedName("name")
    public abstract String name();
}
