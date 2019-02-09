package bean;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.Random;

public abstract class SendTextMessage {

    private static String formURL(String mobile,String message){
        String username = "wawasan.in";
        String password = "9182096413";
        return "https://www.txtguru.in/imobile/api.php?username="+username+"&password="+password+"&source=Senderid&dmobile=91"+mobile+"&message="+message+"&mt=u";
    }

    public static  int getRandom(){
        int max = 999999;
        int min = 100000;
        Random r = new Random();
        return r.nextInt(max - min) + min;
    }

    public static void sendMessage(String response, String mobileNumber, final Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url =formURL(mobileNumber,response);
        Message.message(context,url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       Message.message(context,"Success");
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Message.message(context,"Failed");
            }
        });
        queue.add(stringRequest);
    }
}
