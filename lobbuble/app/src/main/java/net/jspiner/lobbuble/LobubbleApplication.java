package net.jspiner.lobbuble;

import android.app.Application;

/**
 * Created by jspiner on 2017. 4. 29..
 */

public class LobubbleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Prefer.init(this, "caly");
    }
}
