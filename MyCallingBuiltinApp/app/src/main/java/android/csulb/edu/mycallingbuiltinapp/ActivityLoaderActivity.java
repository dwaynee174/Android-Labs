package android.csulb.edu.mycallingbuiltinapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityLoaderActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        Button button1=(Button) findViewById(R.id.button1);
        Button button2=(Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.amazon.com";
                Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                Intent browserIntent = new Intent(getApplicationContext(), ChooserActivity.class);
                Intent chooserIntent = Intent.createChooser(web, "Load http://www.google.com with:");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{browserIntent});
                startActivity(chooserIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "tel:+194912344444";
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                startActivity(phoneIntent);
            }
        });
    }
}
