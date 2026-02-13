package com.example.bazydanych;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface WypiekiDao {
    @Insert
    public void wstawWypiekiDoBazy(Wypieki wypieki);
    @Insert
    public void wstawKilkaWypiekow(Wypieki wypieki);
    @Delete
    public void usunZBazy(Wypieki wypieki);
    @Update
    public void zaktualizuj(Wypieki wypieki);
    @Query("Select *  From `wypieki_tabela`")
    List<Wypieki> zwrocWszystkieWypiekiZBazy();

    @Query("Select `nazwa` From `wypieki_tabela` Where czas_pieczenia < :czas")
    List<String> zwrocNazwyWypiekow(int czas);

}
