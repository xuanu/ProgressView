package views.zeffect.cn.progressview;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import views.zeffect.cn.progresslibrary.CircleProgressView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleProgressView tempCircleProgressView = new CircleProgressView(this);
        int dp32 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 48, getResources().getDisplayMetrics());
        ((LinearLayout) findViewById(R.id.root_ll)).addView(tempCircleProgressView, new ViewGroup.LayoutParams(dp32, dp32));
    }
}
