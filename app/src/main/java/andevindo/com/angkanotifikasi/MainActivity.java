package andevindo.com.angkanotifikasi;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Digunakan untuk menambah angka pada notifikasi
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = Integer.parseInt(mCount.getText().toString());
                //bertambah ketika diklik
                mCount.setText(++count+"");
            }
        });

        //Digunakan untuk mereset angka pada notifikasi menjadi 0
        Button resetButton = (Button)findViewById(R.id.reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //berubah menjadi 0 ketika direset
                mCount.setText("0");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.notification);//Mendapatkan menu notifikasi
        MenuItemCompat.setActionView(menuItem, R.layout.actionbar_notification);//mendefinisikan set action view untuk menu notifikasi dengan actionbar_notification
        RelativeLayout relativeLayout = (RelativeLayout)MenuItemCompat.getActionView(menuItem);//parent dari actionbar_notification adalah relativelayout, kita tangkap parentnya untuk digunakan mencari childnya
        mCount = (TextView)relativeLayout.findViewById(R.id.count);//mendeklarasikan count textview
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }
}
