package com.amber.random.datapoliceuk.model.stop_and_search;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by akhlivnyuk on 7/7/2017.
 */
@AutoValue
public abstract class Street {
    public static TypeAdapter<Street> typeAdapter(Gson gson) {
        return new AutoValue_Street.GsonTypeAdapter(gson);
    }

    public abstract Integer id();

    public abstract String name();
}
