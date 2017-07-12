package com.amber.random.datapoliceuk.model.crime;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class OutcomeCategory {
    public static TypeAdapter<OutcomeCategory> typeAdapter(Gson gson) {
        return new AutoValue_OutcomeCategory.GsonTypeAdapter(gson);
    }

    public abstract String code();

    public abstract String name();
}
