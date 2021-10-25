package me.brennan.textverified;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.brennan.textverified.model.Target;
import me.brennan.textverified.model.Verification;
import me.brennan.textverified.request.JsonBody;
import okhttp3.*;

/**
 * @author Brennan
 * @since 10/24/2021
 **/
public class TextVerified {
    private final OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

    private final Headers headers;

    private final Gson GSON = new GsonBuilder().create();

    public TextVerified(String clientKey, String clientSecret) throws Exception {
        final String token = generateToken(Credentials.basic(clientKey, clientSecret));

        if (token != null) {
            this.headers = new Headers.Builder()
                    .add("Authorization", "Bearer " + token)
                    .build();
        } else {
            throw new RuntimeException("Failed to generate token!");
        }
    }

    public Verification getVerification(String id) throws Exception {
        final Request request = new Request.Builder()
                .url("https://www.textverified.com/api/Verifications/" + id)
                .headers(headers)
                .get()
                .build();

        try(Response response = okHttpClient.newCall(request).execute()) {
            if (response.code() == 200) {
                final JsonObject responseObject = JsonParser.parseString(response.body().string()).getAsJsonObject();

                return GSON.fromJson(responseObject, Verification.class);
            }
        }

        return null;
    }

    public Verification createVerification(Target target) throws Exception {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", target.getTargetID());

        final Request request = new Request.Builder()
                .url("https://www.textverified.com/api/Verifications")
                .headers(headers)
                .post(new JsonBody(jsonObject))
                .build();

        try(Response response = okHttpClient.newCall(request).execute()) {
            if (response.code() == 200) {
                final JsonObject responseObject = JsonParser.parseString(response.body().string()).getAsJsonObject();

                return GSON.fromJson(responseObject, Verification.class);
            }
        }

        return null;
    }

    public Target getTarget(int id) throws Exception {
        final Request request = new Request.Builder()
                .url("https://www.textverified.com/api/Targets/" + id)
                .headers(headers)
                .get()
                .build();

        try(Response response = okHttpClient.newCall(request).execute()) {
            if (response.code() == 200) {
                final JsonObject jsonObject = JsonParser.parseString(response.body().string()).getAsJsonObject();

                return GSON.fromJson(jsonObject, Target.class);
            }
        }

        return null;
    }

    private String generateToken(String simpleApiKey) throws Exception {
        final Request request = new Request.Builder()
                .url("https://www.textverified.com/Api/Authentication")
                .header("Authorization", simpleApiKey)
                .post(RequestBody.create(null, new byte[]{}))
                .build();

        try(Response response = okHttpClient.newCall(request).execute()) {
            if (response.code() == 200) {
                final JsonObject jsonObject = JsonParser.parseString(response.body().string()).getAsJsonObject();

                return jsonObject.get("bearer_token").getAsString();
            }
        }

        return null;
    }

}
