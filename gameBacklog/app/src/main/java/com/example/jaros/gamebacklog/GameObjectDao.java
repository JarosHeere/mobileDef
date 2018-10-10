package com.example.jaros.gamebacklog;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface GameObjectDao {

    @Insert
    void insert(GameObject gameObject);

    @Delete
    void delete(GameObject gameObject);

    @Query("SELECT * from gameobject_table ORDER BY title ASC")
    LiveData<List<GameObject>> getAllGames();

    @Update
    void update(GameObject gameObject);


}