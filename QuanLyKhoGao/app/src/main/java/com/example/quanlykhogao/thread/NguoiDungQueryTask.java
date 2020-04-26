package com.example.quanlykhogao.thread;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.AsyncTask;

import androidx.room.Room;

import com.example.quanlykhogao.model.NguoiDung;
import com.example.quanlykhogao.sqlite.AppDatabase;

import java.util.List;

public class NguoiDungQueryTask {
    public AppDatabase appDatabase;
    public NguoiDungQueryTask(Context context){
        appDatabase = Room.databaseBuilder(context,AppDatabase.class,"NguoiDung.db").build();
    }
    public interface OnQuery<T>{
        void onResult(T t);
    }
    public void getAllNguoiDung(OnQuery<List<NguoiDung>> onQuery){
        new GetNguoiDungAsyncTask(onQuery).execute();
    }
    public void insertNguoiDung(OnQuery<long[]> onQuery, NguoiDung nguoiDung){
        new InsertNguoiDungAsyncTask(onQuery).execute();
    }
    public void deleteNguoiDung(OnQuery<List<NguoiDung>> onQuery){
        new DeleteNguoiDung(onQuery);
    }


    public class  DeleteNguoiDung extends  AsyncTask<Void, Void, List<NguoiDung> >{
OnQuery onQuery;

        public DeleteNguoiDung(OnQuery onQuery) {
            this.onQuery = onQuery;
        }

        @Override
        protected List<NguoiDung> doInBackground(Void... voids) {
           return null;
        }

    }
    public  class GetNguoiDungAsyncTask extends AsyncTask<Void, Void, List<NguoiDung>>{
        OnQuery onQuery;

        public GetNguoiDungAsyncTask(OnQuery onQuery) {
            this.onQuery = onQuery;
        }

        @Override
        protected List<NguoiDung> doInBackground(Void... voids) {
            return appDatabase.nguoiDungDAO().getAll();
        }

        @Override
        protected void onPostExecute(List<NguoiDung> nguoiDungs) {
            super.onPostExecute(nguoiDungs);
            onQuery.onResult(nguoiDungs);
        }
    }
    private class InsertNguoiDungAsyncTask extends AsyncTask<NguoiDung, Void, long[]>{
        OnQuery onQuery;

        public InsertNguoiDungAsyncTask(OnQuery onQuery) {
            this.onQuery = onQuery;
        }

        @Override
        protected long[] doInBackground(NguoiDung... nguoiDungs) {
            return appDatabase.nguoiDungDAO().insertND(nguoiDungs);
        }

        @Override
        protected void onPostExecute(long[] longs) {
            super.onPostExecute(longs);
            this.onQuery.onResult(longs);
        }
    }
}
