package android.csulb.edu.zoodirectoryapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dhwani on 2/26/2016.
 */
public class AnimalDetails extends AppCompatActivity {
    @Override
    // Called when the activity is first created.
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.animal_details);

    TextView heading = (TextView) findViewById(R.id.title);
    ImageView image = (ImageView) findViewById(R.id.image);
    TextView description = (TextView) findViewById(R.id.description);
    Bundle value = this.getIntent().getExtras();
    int index = value.getInt("Animal");
    //Display animal details according to index
    if (index == 1) {
        heading.setText("KOALA");
        image.setImageResource(R.drawable.koala_largeimg);
        description.setText("The koala is an arboreal herbivorous marsupial native to Australia." +
                "Koalas typically inhabit open eucalypt woodlands, and the leaves of these trees make up most of their diet."+
                "Koalas are asocial animals and spend just 15 minutes a day on social behaviours.");
        }
        if (index == 2) {
            heading.setText("MACAW");
            image.setImageResource(R.drawable.macaw_largeimg);
            description.setText("The scarlet macaw is a large, red, yellow and blue South American parrot, a member of a large group of Neotropical parrots called macaws." +
                    "Macaws eat a variety of foods including seeds, nuts, fruits, palm fruits, leaves, flowers, and stems." +
                    "The majority of macaws are now endangered in the wild and a few are extinct. ");
        }

        if (index == 3) {
            heading.setText("PANDA");
            image.setImageResource(R.drawable.panda_largeimg);
            description.setText("The giant Panda is a bear native to south central China." +
                    "Giant pandas in the wild will occasionally eat other grasses, wild tubers, or even meat in the form of birds, rodents or carrion." +
                    "Pandas communicate through vocalization and scent marking such as clawing trees or spraying urine.");
        }

        if (index == 4) {
            heading.setText("PEACOCK");
            image.setImageResource(R.drawable.peacock_largeimg);
            description.setText("The Indian peacock has iridescent blue and green plumage. The peacock tail has quill feathers but highly elongated upper tail coverts." +
                    "Peafowl are omnivores and eat most plant parts, flower petals, seed heads, insects and other arthropods.");
        }

        if (index == 5) {
            heading.setText("RABBIT");
            image.setImageResource(R.drawable.rabbit_largeimg);
            description.setText("Rabbits are small mammals in the family Leporidae of the order Lagomorpha, found in several parts of the world.  " +
                    "Rabbit habitats include meadows, woods, forests, grasslands, deserts and wetlands. " +
                    "Rabbits are herbivores that feed by grazing on grass, forbs, and leafy weeds.");
        }
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
            Intent My_intent = new Intent(AnimalDetails.this,ZooInformation.class);
            startActivity(My_intent);
        }
        if(id == R.id.action_settings1)
        {
            String uri = "package:android.csulb.edu.zoodirectoryapplication";
            Intent uninstall = new Intent(Intent.ACTION_DELETE, Uri.parse(uri));
            startActivity(uninstall);
        }

        return super.onOptionsItemSelected(item);
    }
}

