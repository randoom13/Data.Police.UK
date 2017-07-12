package com.amber.random.datapoliceuk.model.crime;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class LastUpdated {
    public static TypeAdapter<LastUpdated> typeAdapter(Gson gson) {
        return new AutoValue_LastUpdated.GsonTypeAdapter(gson);
    }

    public abstract String date();
}
