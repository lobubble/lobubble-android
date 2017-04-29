package net.jspiner.lobbuble.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class LoginResponse {


    @SerializedName("id")
    public String id;

    @SerializedName("name")
    public String name;

    @SerializedName("picture")
    public String picture;

    @SerializedName("gender")
    public String gender;

}
