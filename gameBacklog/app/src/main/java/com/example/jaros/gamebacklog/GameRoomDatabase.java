package com.example.jaros.gamebacklog;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {GameObject.class}, version = 1)
public abstract class GameRoomDatabase extends RoomDatabase {

    private static volatile GameRoomDatabase INSTANCE;

    static GameRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (GameRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GameRoomDatabase.class, "gameobject_table")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    abstract GameObjectDao gameObjectDao();

}
