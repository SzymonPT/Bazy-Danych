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
    private int temperaturaPieczenia;
    @ColumnInfo(name = "czas_pieczenia")
    private int czasPieczenia;

    public Wypieki(String nazwa, String skladniki, int temperaturaPieczenia, int czasPieczenia) {
        id = 0;
        this.nazwa = nazwa;
        this.skladniki = skladniki;
        this.temperaturaPieczenia = temperaturaPieczenia;
        this.czasPieczenia = czasPieczenia;
    }

    @Override
    public String toString() {
        return "Wypieki{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\n' +
                ", skladniki='" + skladniki + '\n'+
                ", temperaturaPieczenia=" + temperaturaPieczenia + '\n'+
                ", czasPieczenia=" + czasPieczenia +
                '}';
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
        return temperaturaPieczenia;
    }

    public void setTemperaturaPieczenia(int temperaturaPieczenia) {
        temperaturaPieczenia = temperaturaPieczenia;
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
