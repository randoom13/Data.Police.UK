package com.amber.random.datapoliceuk.model.crime;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class OutcomeStatus {
    public static TypeAdapter<OutcomeStatus> typeAdapter(Gson gson) {
        return new AutoValue_OutcomeStatus.GsonTypeAdapter(gson);
    }

    public abstract String category();

    public abstract String date();
}
