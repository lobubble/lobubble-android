package net.jspiner.lobbuble.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class RecoResponse {

    @SerializedName("")
    public ArrayList<Data> data;

    public class Data{
        @SerializedName("id")
        public int id;

        @SerializedName("fb_id")
        public String fb_id;

        @SerializedName("target_id")
        public String target_id;

        @SerializedName("name")
        public String name;

        @SerializedName("picture")
        public String picture;
    }
}
