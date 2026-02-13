package com.example.bazydanych;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PrzepisyDataBase przepisyDataBase;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        przepisyDataBase = PrzepisyDataBase.zwrocInstancjeBazyDanych(MainActivity.this);
        przepisyDataBase.zwrocWypiekiDao().wstawWypiekiDoBazy(new Wypieki("sernik","ser, kartofle, cukier",100, 120));
    }
}