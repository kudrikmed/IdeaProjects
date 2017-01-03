package com.horo.horoscopeastro;

import android.app.Activity;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by СВК on 21.05.2014.
 */
public class Sender extends Activity {

    public String whatToSend;
    public String whereToSend;
    public String lang;
    public long firstStart;
    public int dayOfPregnancy;
    SharedPreferences mSettings;

    public Sender(String what, String where, String language) {
        whatToSend = what;
        whereToSend = where;
        lang = language;

    }




    public boolean PingServer() {

        boolean online = true;
        try {
            int reachable = Runtime.getRuntime().exec(whereToSend).waitFor();
            if (reachable == 0) {
                online = true;
            } else {
                online = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e1) {
        }
        return online;
    }

    public JSONObject Post() {

        HashMap<String, String> dataDay = new HashMap<String, String>();
        dataDay.put("sign", whatToSend);
        dataDay.put("language", lang);
        AsyncHttpPost asyncHttpPostComplete = new AsyncHttpPost(dataDay);
        asyncHttpPostComplete.execute(whereToSend);
        StringBuilder properString = new StringBuilder("");
        JSONObject resultJSON = new JSONObject();
        try {
            String resultFood = asyncHttpPostComplete.get();
            char[] utf8 = null;


            utf8 = resultFood.toCharArray();

            for (int i = 0; i < utf8.length; i++) {
                if ((int) utf8[i] < 65000) {
                    properString.append(utf8[i]);
                }

            }

            try {
                resultJSON = new JSONObject(properString.toString());
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        return resultJSON;
    }

    public JSONObject Execute() {

        JSONObject result = new JSONObject();
        if (PingServer()) {

            result = Post();

        }

        return result;
    }


}
