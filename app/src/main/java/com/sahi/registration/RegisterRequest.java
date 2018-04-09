package com.sahi.registration;

/**
 * Created by Yashwanth on 3/1/2017.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://ecultivation.000webhostapp.com/register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String phone, String password, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("phone", phone);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
