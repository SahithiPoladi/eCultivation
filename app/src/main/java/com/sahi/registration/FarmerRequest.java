package com.sahi.registration;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 3/17/2017.
 */

public class FarmerRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://ecultivation.000webhostapp.com/form.php";
    private Map<String, String> params;

    public FarmerRequest(String fname, String lname, int age, int years, String phone, String gender, String village, String district, int pin, int acre1, int acre2, String irrigation, String practice, String name1, String variety1, String yield1, String name2, String variety2, String yield2, String name3, String variety3, String yield3, String name4, String variety4, String yield4, String name5, String variety5, String yield5, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("fname", fname);
        params.put("lname", lname);
        params.put("age", age + "");
        params.put("years", years + "");
        params.put("phone", phone);
        params.put("gender", gender);
        params.put("village", village);
        params.put("district", district);
        params.put("pin", pin + "");
        params.put("acre1", acre1 + "");
        params.put("acre2", acre2 + "");
        params.put("irrigation", irrigation);
        params.put("practice", practice);
        params.put("name1", name1);
        params.put("variety1", variety1);
        params.put("yield1", yield1);
        params.put("name2", name2);
        params.put("variety2", variety2);
        params.put("yield2", yield2);
        params.put("name3", name3);
        params.put("variety3", variety3);
        params.put("yield3", yield3);
        params.put("name4", name4);
        params.put("variety4", variety4);
        params.put("yield4", yield4);
        params.put("name5", name5);
        params.put("variety5", variety5);
        params.put("yield5", yield5);

    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}

