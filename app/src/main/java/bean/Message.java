package bean;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public abstract class Message {
    static public void message(Context context, String string){
        Log.d("DEBJYOTI: ",string);
        Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
    }
}
