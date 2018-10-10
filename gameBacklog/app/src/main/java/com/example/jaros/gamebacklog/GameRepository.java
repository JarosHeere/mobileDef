package com.example.jaros.gamebacklog;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class GameRepository {

    private GameObjectDao gameObjectDao;


    GameRepository(Context context) {
        GameRoomDatabase db = GameRoomDatabase.getDatabase(context);
        gameObjectDao = db.gameObjectDao();


    }

    LiveData<List<GameObject>> getAllObjects() {
        return gameObjectDao.getAllGames();
    }

    public void insert(GameObject object) {
        new insertAsyncTask(gameObjectDao).execute(object);
    }


    public void update(GameObject object) {
        new updateAsyncTask(gameObjectDao).execute(object);
    }

    public void delete(GameObject object) {
        new deleteAsyncTask(gameObjectDao).execute(object);
    }

    private static class deleteAsyncTask extends AsyncTask<GameObject, Void, Void> {
        private GameObjectDao mAsyncTaskDao;

        public deleteAsyncTask(GameObjectDao mAsyncTaskDao) {
            this.mAsyncTaskDao = mAsyncTaskDao;
        }

        @Override
        protected Void doInBackground(final GameObject... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }


    private static class updateAsyncTask extends AsyncTask<GameObject, Void, Void> {
        private GameObjectDao mAsyncTaskDao;

        updateAsyncTask(GameObjectDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GameObject... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }

    }

    private static class insertAsyncTask extends AsyncTask<GameObject, Void, Void> {

        private GameObjectDao mAsyncTaskDao;

        insertAsyncTask(GameObjectDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final GameObject... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }


}

