package com.amber.random.datapoliceuk.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

//https://stackoverflow.com/questions/2201925/converting-iso-8601-compliant-string-to-java-util-date
@AutoValue
public abstract class AvailableDataSet {
    public static TypeAdapter<AvailableDataSet> typeAdapter(Gson gson) {
        return new AutoValue_AvailableDataSet.GsonTypeAdapter(gson);
    }

    @SerializedName("date")
    public abstract Date date();

    @SerializedName("stop-and-search")
    public abstract List<String> forceIDs();
}
