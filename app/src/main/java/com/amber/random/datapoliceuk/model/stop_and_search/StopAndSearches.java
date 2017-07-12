package com.amber.random.datapoliceuk.model.stop_and_search;

import android.support.annotation.Nullable;

import com.amber.random.datapoliceuk.model.base.Location;
import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class StopAndSearches {
    public static TypeAdapter<StopAndSearches> typeAdapter(Gson gson) {
        return new AutoValue_StopAndSearches.GsonTypeAdapter(gson);
    }

    @SerializedName("type")
    public abstract String typeSearch();

    @Nullable
    @SerializedName("involved_person")
    public abstract String involvedPerson();

    @Nullable
    @SerializedName("datetime")
    public abstract String dateTime();

    @Nullable
    public abstract String operation();

    @Nullable
    @SerializedName("operation_name")
    public abstract String operationName();

    @Nullable
    public abstract Location location();

    @Nullable
    public abstract String gender();

    @SerializedName("age_range")
    public abstract String ageRange();

    @SerializedName("self_defined_ethnicity")
    public abstract String selfDefinedEthnicity();

    @SerializedName("officer_defined_ethnicity")
    public abstract String officerDefinedEthnicity();

    public abstract String legislation();

    @SerializedName("object_of_search")
    public abstract String searchObject();

    public abstract String outcome();

    @Nullable
    @SerializedName("outcome_linked_to_object_of_search")
    public abstract String linkedOutcomeToSearchObject();

    @SerializedName("removal_of_more_than_outer_clothing")
    public abstract String searchedReason();
}
