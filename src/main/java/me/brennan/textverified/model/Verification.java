package me.brennan.textverified.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author Brennan
 * @since 10/24/2021
 **/
public class Verification {

    @SerializedName("id")
    private String id;

    @SerializedName("cost")
    private double cost;

    @SerializedName("target_name")
    private String targetName;

    @SerializedName("number")
    private String number;

    @SerializedName("time_remaining")
    private String timeRemaining;

    @SerializedName("reuse_window")
    private String reuseWindow;

    @SerializedName("status")
    private String status;

    @SerializedName("sms")
    private String sms;

    @SerializedName("code")
    private String code;

    @SerializedName("verification_uri")
    private String verificationUri;

    @SerializedName("cancel_uri")
    private String cancelUri;

    @SerializedName("report_uri")
    private String reportUri;

    @SerializedName("reuse_uri")
    private String reuseUri;

    public String getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public String getTargetName() {
        return targetName;
    }

    public String getNumber() {
        return number;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public String getReuseWindow() {
        return reuseWindow;
    }

    public String getStatus() {
        return status;
    }

    public String getSms() {
        return sms;
    }

    public String getCode() {
        return code;
    }

    public String getVerificationUri() {
        return verificationUri;
    }

    public String getCancelUri() {
        return cancelUri;
    }

    public String getReportUri() {
        return reportUri;
    }

    public String getReuseUri() {
        return reuseUri;
    }
}
