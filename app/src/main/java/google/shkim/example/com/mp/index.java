package google.shkim.example.com.mp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.skt.Tmap.TMapView;

public class index extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        RelativeLayout relativeLayout = new RelativeLayout(this);
        TMapView tMapView = new TMapView(this);

        tMapView.setSKTMapApiKey( "34382003-0b4e-4cfc-846d-4bcef9b6d7ce" );
        tMapView.setCompassMode(true);
        tMapView.setIconVisibility(true);
        tMapView.setZoom(15);
        tMapView.setMapType(TMapView.MAPTYPE_STANDARD);
        tMapView.setLanguage(TMapView.LANGUAGE_KOREAN);
        tMapView.setTrackingMode(true);
        tMapView.setSightVisible(true);
        relativeLayout.addView(tMapView);
        setContentView(relativeLayout);
    }
}
