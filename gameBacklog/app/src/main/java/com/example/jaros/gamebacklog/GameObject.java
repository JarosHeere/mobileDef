package com.example.jaros.gamebacklog;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "gameobject_table")
public class GameObject implements Serializable {


    @PrimaryKey
    @NonNull
    private String title;

    @NonNull
    private String platform;

    @NonNull
    private String notes;

    @NonNull
    private String status;

    @NonNull
    private String date;


    public GameObject(String title, String platform, String notes, String status, String date) {
        this.title = title;
        this.platform = platform;
        this.notes = notes;
        this.status = status;
        this.date = date;
    }


    public String getTitle() {
        return title;
    }

    public String getPlatform() {
        return platform;
    }

    public String getNotes() {
        return notes;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setPlatform(@NonNull String platform) {
        this.platform = platform;
    }

    public void setNotes(@NonNull String notes) {
        this.notes = notes;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }
}
