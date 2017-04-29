package net.jspiner.lobbuble.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jspiner on 2017. 4. 30..
 */

public class ImageResponse {
    public class Data{
        @SerializedName("file")
        public String file;
    }
}
