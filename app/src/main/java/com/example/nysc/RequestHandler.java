package com.example.nysc;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestHandler {

    private static RequestHandler mInstance;
    private RequestQueue requestQueue;
    private static Context mcontext;

    private RequestHandler(Context context){
        mcontext = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized RequestHandler getInstance(Context context){
        if (mInstance == null){
            mInstance = new RequestHandler(context);
        }
        return  mInstance;
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(mcontext.getApplicationContext());
        }
        return requestQueue;
    }
    public <T> void addToRequestQueue(Request <T> req){
        getRequestQueue().add(req);
    }
}
