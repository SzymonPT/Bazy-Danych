package com.example.bazydanych;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        PrzepisyDataBase przepisyDataBase;
        Button button, button2;
        EditText Nazwa, Skladniki, CzasPieczenia, TemperaturaPieczenia;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        przepisyDataBase = PrzepisyDataBase.zwrocInstancjeBazyDanych(MainActivity.this);
        /*przepisyDataBase.zwrocWypiekiDao().wstawWypiekiDoBazy(new Wypieki("sernik","ser, kartofle, cukier",100, 120));*/

        Nazwa = findViewById(R.id.Nazwa);
        Skladniki = findViewById(R.id.Skladniki);
        CzasPieczenia = findViewById(R.id.CzasPieczenia);
        TemperaturaPieczenia = findViewById(R.id.TemperaturaPieczenia);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        ListView listView = findViewById(R.id.listaView);
        List<Wypieki> wszystkieWypiekiList = przepisyDataBase
                .zwrocWypiekiDao()
                .zwrocWszystkieWypiekiZBazy();
        ArrayAdapter<Wypieki> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                wszystkieWypiekiList
        );
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        przepisyDataBase.zwrocWypiekiDao().usunZBazy(wszystkieWypiekiList.get(i));
                        wszystkieWypiekiList.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );
        listView.setOnLongClickListener(
                new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        return false;
                    }
                }
        );
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nazwa = String.valueOf(Nazwa.getText());
                        String skladniki = String.valueOf(Skladniki.getText());
                        int temperaturaPieczenia = Integer.parseInt(String.valueOf(TemperaturaPieczenia.getText()));
                        int czasPieczenia = Integer.parseInt(String.valueOf(CzasPieczenia.getText()));
                        przepisyDataBase.zwrocWypiekiDao().wstawWypiekiDoBazy(new Wypieki(nazwa, skladniki, temperaturaPieczenia, czasPieczenia));
                    }
                }
        );
    }
}