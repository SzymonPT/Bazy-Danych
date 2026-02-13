package com.example.bazydanych;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "wypieki_tabela")
public class Wypieki {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String nazwa;
    private String skladniki;
    @ColumnInfo(name = "temperatura_pieczenia")
    private int TemperaturaPieczenia;
    @ColumnInfo(name = "czas_pieczenia")
    private int czasPieczenia;

    public Wypieki(int id, String nazwa, String skladniki, int temperaturaPieczenia, int czasPieczenia) {
        this.id = id;
        this.nazwa = nazwa;
        this.skladniki = skladniki;
        TemperaturaPieczenia = temperaturaPieczenia;
        this.czasPieczenia = czasPieczenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getTemperaturaPieczenia() {
        return TemperaturaPieczenia;
    }

    public void setTemperaturaPieczenia(int temperaturaPieczenia) {
        TemperaturaPieczenia = temperaturaPieczenia;
    }

    public String getSkladniki() {
        return skladniki;
    }

    public void setSkladniki(String skladniki) {
        this.skladniki = skladniki;
    }

    public int getCzasPieczenia() {
        return czasPieczenia;
    }

    public void setCzasPieczenia(int czasPieczenia) {
        this.czasPieczenia = czasPieczenia;
    }
}
