package com.example.studerande.a412open_websites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.attr.name;
import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Defined Array values to show in ListView
       String[] items = new String[]{
                "http://dn.se",
                "http://thejapaneserap.com",
                "http://google.com",
                "http://example.com"
        };
        /*Website[] items = new Website[3];*/

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        final ListView listView = (ListView) findViewById(R.id.websiteslist);
        listView.setAdapter(itemsAdapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                // http://androidexample.com/Create_A_Simple_Listview_-_Android_Example/index.php?view=article_discription&aid=65
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                       "Loading " + itemValue + " for you", Toast.LENGTH_LONG)
                        .show();

                WebView mainwebview = (WebView) findViewById(R.id.websitewindow);

                // prevents using the browser from the and makes the web view client to our WebView
                mainwebview.setWebViewClient(new WebViewClient());
                mainwebview.loadUrl(itemValue);
            }
        });
    }
}
