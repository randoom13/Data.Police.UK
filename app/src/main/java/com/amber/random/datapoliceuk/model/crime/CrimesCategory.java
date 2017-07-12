package com.amber.random.datapoliceuk.model.crime;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class CrimesCategory {
    public static TypeAdapter<CrimesCategory> typeAdapter(Gson gson) {
        return new AutoValue_CrimesCategory.GsonTypeAdapter(gson);
    }

    public abstract String url();

    public abstract String name();
}
