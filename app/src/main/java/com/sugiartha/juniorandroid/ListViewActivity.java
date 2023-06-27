package com.sugiartha.juniorandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ListView lvResult = (ListView) findViewById(R.id.lvResult);
        WebView webView = (WebView) findViewById(R.id.web);

        String[][] dataNegara = new String[][]{{"Indonesia", "ASIA", "indonesia"},
                {"Malaysia", "ASIA", "malaysia"}, {"Singapore", "ASIA", "singapore"},
                {"Italia", "EROPA", "italia"}, {"Inggris", "EROPA", "inggris"},
                {"Belanda", "EROPA", "belanda"}, {"Argentina", "AMERIKA", "argentina"},
                {"Chile", "AMERIKA", "chile"}, {"Mesir", "AFRIKA", "mesir"},
                {"Uganda", "AFRIKA", "uganda"}};

        NegaraAdapter adapter = new NegaraAdapter(ListViewActivity.this, dataNegara);
        lvResult.setAdapter(adapter);

        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                for (int i = 0; i < dataNegara.length; i++){
                    if (i == position) {
                        webView.loadUrl("https://google.com/search?q=negara+"+dataNegara[i][0]);
                    }
                }
            }
        });
    }
}
