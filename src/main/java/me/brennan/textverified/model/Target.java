package me.brennan.textverified.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Brennan
 * @since 10/24/2021
 **/
public class Target {

    @SerializedName("targetId")
    private int targetID;

    @SerializedName("name")
    private String name;

    @SerializedName("normalizedName")
    private String normalizedName;

    @SerializedName("cost")
    private double cost;

    @SerializedName("status")
    private int status;

    @SerializedName("pricingMode")
    private int pricingMode;

    public int getTargetID() {
        return targetID;
    }

    public String getName() {
        return name;
    }

    public String getNormalizedName() {
        return normalizedName;
    }

    public double getCost() {
        return cost;
    }

    public int getStatus() {
        return status;
    }

    public int getPricingMode() {
        return pricingMode;
    }
}
