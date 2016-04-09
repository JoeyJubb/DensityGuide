package uk.co.bubblebearapps.densityguide;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DensityGuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_density_guide);


        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int widthPixels = size.x;
        final int heightPixels = size.y;

        final int widthDps = convertPixelsToDp(widthPixels, this);
        final int heightDps = convertPixelsToDp(heightPixels, this);


        Resources resources = getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        int dotsPerInch = metrics.densityDpi;

        TextView screenHeightPx = (TextView) findViewById(R.id.height_pixels);
        TextView screenHeightDP = (TextView) findViewById(R.id.height_dps);
        TextView screenWidthPx = (TextView) findViewById(R.id.width_pixels);
        TextView screenWidthDP = (TextView) findViewById(R.id.width_dps);
        TextView screenDpi = (TextView) findViewById(R.id.text_dpi);

        screenHeightPx.setText(String.valueOf(heightPixels));
        screenHeightDP.setText(String.valueOf(heightDps));
        screenWidthPx.setText(String.valueOf(widthPixels));
        screenWidthDP.setText(String.valueOf(widthDps));
        screenDpi.setText(String.valueOf(dotsPerInch));
    }

    public static int convertPixelsToDp(float px, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return (int) dp;
    }
}
