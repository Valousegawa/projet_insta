package com.a2017.dev.insta.insta.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.http.*;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

/**
 * Created by s.mines on 18/04/2017.
 */

public class HttpCustomClient {
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    // constructor
    public HttpCustomClient() {

    }

    // function get json from url
    // by making HTTP POST or GET mehtod
    public static void makeHttpRequest(String url,String method, List<String> params) {

        try {
            URL urlObj = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
            InputStream is = urlConnection.getInputStream();
            int status = urlConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method to return values of request SELECT
    public static String returnHttpRequest(String url,String method, List<String> params){
        makeHttpRequest(url,method,params);
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();

            String result=sb.toString();
            return result;
        }catch(Exception e){
            Log.e("log_tag", "Error converting result "+e.toString());
        }
        return null;
    }
}
