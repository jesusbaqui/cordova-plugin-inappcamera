package cordova.plugin.inappcamera;

import android.content.pm.PackageManager;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.net.Uri;

import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import android.provider.MediaStore;

public class PreviewActivity  extends Activity {

    static final int RESULT_OK = 1;
    static final int RESULT_KO = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getResources().getIdentifier("previewwindow", "layout", getPackageName()));

        Uri fileUri = (Uri) getIntent().getExtras().get(MediaStore.EXTRA_OUTPUT);

        ImageView imgDisplay = (ImageView) findViewById(getResources().getIdentifier("imgDisplay", "id", getPackageName()));
        ImageButton btnClose = (ImageButton) findViewById(getResources().getIdentifier("btnCancel", "id", getPackageName()));
        ImageButton btnAccept = (ImageButton) findViewById(getResources().getIdentifier("btnAccept", "id", getPackageName()));

        Picasso
            .with(getApplicationContext())
            .load(fileUri)
            .memoryPolicy(MemoryPolicy.NO_CACHE)
            .networkPolicy(NetworkPolicy.NO_CACHE)
            .into(imgDisplay);

        btnClose.setOnClickListener(new View.OnClickListener() {            
            public void onClick(View v) {
                setResult(RESULT_KO);
                finish();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {            
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}