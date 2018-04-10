package com.sahi.registration;

/**
 * Created by DELL on 3/7/2017.
 */

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class VregisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://ecultivation.000webhostapp.com/vregister.php";
    private Map<String, String> params;

   public VregisterRequest(String name, String email, String password, String phone, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
        params.put("phone", phone);
    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
