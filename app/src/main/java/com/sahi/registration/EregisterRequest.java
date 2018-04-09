package com.sahi.registration;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class EregisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://ecultivation.000webhostapp.com/eregister.php";
    private Map<String, String> params;

    public EregisterRequest(String name, String email, String password, String phone, String spec, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("email", email);
        params.put("password", password);
        params.put("phone", phone);
        params.put("spec", spec);
    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}
