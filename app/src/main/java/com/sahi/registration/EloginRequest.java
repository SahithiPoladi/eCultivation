package com.sahi.registration;

/**
 * Created by Yashwanth on 3/3/2017.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class EloginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "https://ecultivation.000webhostapp.com/elogin.php";
    private Map<String, String> params;

    public EloginRequest(String email, String password, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
