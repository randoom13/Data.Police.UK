package com.amber.random.datapoliceuk.model.base;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class ContactDetails {

    public static TypeAdapter<ContactDetails> typeAdapter(Gson gson) {
        return new AutoValue_ContactDetails.GsonTypeAdapter(gson);
    }

    @Nullable
    public abstract String email();

    @Nullable
    public abstract String telephone();

    @Nullable
    public abstract String mobile();

    @Nullable
    public abstract String fax();

    @Nullable
    public abstract String web();

    @Nullable
    public abstract String address();

    @Nullable
    public abstract String facebook();

    @Nullable
    public abstract String twitter();

    @Nullable
    public abstract String youtube();

    @Nullable
    public abstract String myspace();

    @Nullable
    public abstract String bebo();

    @Nullable
    public abstract String flickr();

    @Nullable
    @SerializedName("google-plus")
    public abstract String googlePlus();

    @Nullable
    public abstract String forum();

    @Nullable
    @SerializedName("e-messaging")
    public abstract String eMessaging();

    @Nullable
    public abstract String blog();

    @Nullable
    public abstract String rss();
}
