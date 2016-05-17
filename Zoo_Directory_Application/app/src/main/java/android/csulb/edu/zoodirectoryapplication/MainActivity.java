package android.csulb.edu.zoodirectoryapplication;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listvalues;
    String[] names ={"Koala",
        "Macaw",
        "Panda",
        "Peacock",
        "Rabbit",};

Integer[] images ={R.drawable.koala_thumbnail,R.drawable.macaw_thumbnail,R.drawable.panda_thumbnail,
        R.drawable.peacock_thumbnail,R.drawable.rabbit_thumbnail};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Method 2
        // Sir notes code try later
       // ListView listView = (ListView) findViewById(R.id.animallist);
       // List<Animal> animal =new ArrayList<>();
       // animal.add(new Animal("Koala", "koala_thumbnail.jpg"));
       // listView.setAdapter(new CustomAdapterList(this, R.layout.animal_list_row, animal));
        CustomAdapterList adapterList = new CustomAdapterList(this,names,images);
        listvalues = (ListView)findViewById(R.id.animallist);
        listvalues.setAdapter(adapterList);

        listvalues.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int index = position + 1;
                if (index < 5) {
                    Intent My_intent = new Intent(MainActivity.this, AnimalDetails.class);
                    Bundle my_bundle = new Bundle();
                    my_bundle.putInt("Animal", index);
                    My_intent.putExtras(my_bundle);
                    startActivity(My_intent);
                }
                else {
                    AlertDialog.Builder alertbox = new AlertDialog.Builder(MainActivity.this);
                    alertbox.setTitle("Warning!!");
                    alertbox.setMessage("This animal is very scary. Do you still want to proceed ?");
                    alertbox.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent My_intent = new Intent(MainActivity.this, AnimalDetails.class);
                            Bundle my_bundle = new Bundle();
                            my_bundle.putInt("Animal", 5);
                            My_intent.putExtras(my_bundle);
                            startActivity(My_intent);

                        }
                    });
                    alertbox.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog box = alertbox.create();
                    box.show();
                }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent My_intent = new Intent(MainActivity.this,ZooInformation.class);

            startActivity(My_intent);


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



