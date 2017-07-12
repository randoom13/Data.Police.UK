package com.amber.random.datapoliceuk.model.crime;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class CrimeOutcome {
    public static TypeAdapter<CrimeOutcome> typeAdapter(Gson gson) {
        return new AutoValue_CrimeOutcome.GsonTypeAdapter(gson);
    }

    public abstract OutcomeCategory category();

    public abstract String date();

    @Nullable
    @SerializedName("person_id")
    public abstract String personId();

    public abstract Crime crime();
}
