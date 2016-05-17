package android.csulb.edu.zoodirectoryapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dhwani on 2/26/2016.
 */
@SuppressWarnings("ALL")
public class ZooInformation extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_information);
        Button Call = (Button) findViewById(R.id.button);
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = "tel:888-8888";
                Intent calling = new Intent(Intent.ACTION_CALL, Uri.parse(number));
                startActivity(calling);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return  true;

        }
        if(id == R.id.action_settings1)
        {
            String uri = "package:android.csulb.edu.zoodirectory";
            Intent uninstall = new Intent(Intent.ACTION_DELETE, Uri.parse(uri));
            startActivity(uninstall);
        }

        return super.onOptionsItemSelected(item);
    }
}
