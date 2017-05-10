package com.example.noe.btrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EditProfile extends AppCompatActivity {

    public static String currentUser;
    ImageView imageProfile;
    ImageView imageBackground;

    private TextView name;
    private TextView userid;
    private TextView phone;
    private TextView email;
    private TextView address;
    private TextView genre;

    String[] userGenBooks;
    ArrayList<Item> items = new ArrayList<Item>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        imageProfile = (ImageView)findViewById(R.id.circle_profile);
        imageProfile.setImageResource(R.drawable.jirachi);

        imageBackground = (ImageView)findViewById(R.id.backg);
        imageBackground.setImageResource(R.drawable.bg);

        currentUser = "user1";
        initComponents();
        DataProfile(currentUser);

        String arrayNames = currentUser+"_genBook";
        int resArrayName = getResources().getIdentifier(arrayNames,"array",getPackageName());
        userGenBooks = getResources().getStringArray(resArrayName);

        String genId, genName;
        int resImage;
        for (int i = 0; i < userGenBooks.length; i++) {
            genId = "@string/"+userGenBooks[i];
            genName = getString(getResources().getIdentifier(genId,"string", getPackageName()));
            genId = "@drawable/"+userGenBooks[i];
            resImage = getResources().getIdentifier(genId, "drawable", getPackageName());
            Item item = new Item(genName, resImage);
            items.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        AdapterGB adapter = new AdapterGB(this, items);
        listView.setAdapter(adapter);
        justifyListViewHeightBasedOnChildren(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.editprofile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.check_p:
                //metodoEdit()
                Intent intent1 = new Intent(this, Profile.class);
                startActivity(intent1);
                return true;

            case R.id.cancel_p:
                //metodoEdit()
                Intent intent2 = new Intent(this, Profile.class);;
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static void justifyListViewHeightBasedOnChildren (ListView listView) {

        ListAdapter adapter = listView.getAdapter();

        if (adapter == null) {
            return;
        }
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (adapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
    }

    private void initComponents() {
        name = (TextView) findViewById(R.id.name);
        userid = (TextView) findViewById(R.id.userid);
        phone = (TextView) findViewById(R.id.phonenumber);
        email = (TextView) findViewById(R.id.emailaddress);
        address = (TextView) findViewById(R.id.location);
        genre = (TextView) findViewById(R.id.gen);

    }

    private void DataProfile (String id) {
        String name, userid, phone, email, address, genre;
        int resName, resUserId, resPhone, resEmail, resAddress, resGenre;

        name = "@string/"+id+"_name";
        userid = "@string/"+id+"_id";
        phone = "@string/"+id+"_phone";
        email = "@string/"+id+"_email";
        address = "@string/"+id+"_address";
        genre = "@string/"+id+"_genre";

        resName = getResources().getIdentifier(name, "string", getPackageName());
        resUserId = getResources().getIdentifier(userid, "string", getPackageName());
        resPhone = getResources().getIdentifier(phone, "string", getPackageName());
        resEmail = getResources().getIdentifier(email, "string", getPackageName());
        resAddress = getResources().getIdentifier(address, "string", getPackageName());
        resGenre = getResources().getIdentifier(genre, "string", getPackageName());

        setComponents(resName, resUserId, resPhone, resEmail, resAddress, resGenre);

    }

    private void setComponents(int rName, int rUserId, int rPhone, int rEmail, int rAddress, int rGenre) {
        name.setText(getString(rName));
        userid.setText(getString(rUserId));
        phone.setText(getString(rPhone));
        email.setText(getString(rEmail));
        address.setText(getString(rAddress));
        genre.setText(getString(rGenre));
    }
}
