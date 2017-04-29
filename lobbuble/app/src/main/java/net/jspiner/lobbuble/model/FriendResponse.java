package net.jspiner.lobbuble.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class FriendResponse {

    @SerializedName("data")
    public ArrayList<Data> data;


    public class Data{

        @SerializedName("id")
        public String id;

        @SerializedName("name")
        public String name;

        @SerializedName("picture")
        public String picture;

        @SerializedName("gender")
        public String gender;

    }
}
