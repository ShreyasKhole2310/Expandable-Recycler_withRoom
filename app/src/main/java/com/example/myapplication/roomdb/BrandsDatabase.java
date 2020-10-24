package com.example.myapplication.roomdb;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.beanclasses.BrandsTable;
import com.example.myapplication.beanclasses.PhoneDetailsList;
import com.example.myapplication.interfaces.Branddao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {BrandsTable.class, PhoneDetailsList.class}, version = 1, exportSchema = false)
public abstract class BrandsDatabase extends RoomDatabase {

    private static volatile BrandsDatabase instance;
    public abstract Branddao branddao();
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(2);

    public static BrandsDatabase getDatabase(final Context context){
        if(instance == null){
            synchronized (BrandsDatabase.class){
                if(instance == null){
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            BrandsDatabase.class, "brand_database")
                            .allowMainThreadQueries()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                Branddao dao = instance.branddao();
//                dao.deleteAll();

                dao.deleteAll();
                dao.deleteAllPhones();

                BrandsTable word = new BrandsTable("Samsung");
                long id = dao.insertBrands(word);

                PhoneDetailsList phoneDetailsList = new PhoneDetailsList();

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-20");
                phoneDetailsList.setTxtPhoneName("Note 1");
                phoneDetailsList.setStarRatingCount(4);
                phoneDetailsList.setTxtQuantity("1");
                dao.insertBrands(phoneDetailsList);

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-21");
                phoneDetailsList.setTxtPhoneName("Note 2");
                phoneDetailsList.setStarRatingCount(2);
                phoneDetailsList.setTxtQuantity("8");
                dao.insertBrands(phoneDetailsList);

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-22");
                phoneDetailsList.setTxtPhoneName("Note 3");
                phoneDetailsList.setStarRatingCount(3);
                phoneDetailsList.setTxtQuantity("7");
                dao.insertBrands(phoneDetailsList);

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-23");
                phoneDetailsList.setTxtPhoneName("Note 4");
                phoneDetailsList.setStarRatingCount(1);
                phoneDetailsList.setTxtQuantity("3");
                dao.insertBrands(phoneDetailsList);

                word = new BrandsTable("Apple");
                id = dao.insertBrands(word);

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-20");
                phoneDetailsList.setTxtPhoneName("IPhone 1");
                phoneDetailsList.setStarRatingCount(1);
                phoneDetailsList.setTxtQuantity("1");
                dao.insertBrands(phoneDetailsList);

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-21");
                phoneDetailsList.setTxtPhoneName("IPhone 2");
                phoneDetailsList.setStarRatingCount(2);
                phoneDetailsList.setTxtQuantity("8");
                dao.insertBrands(phoneDetailsList);

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-22");
                phoneDetailsList.setTxtPhoneName("Iphone 3");
                phoneDetailsList.setStarRatingCount(3);
                phoneDetailsList.setTxtQuantity("7");
                dao.insertBrands(phoneDetailsList);

                phoneDetailsList.setIntBrandId(id);
                phoneDetailsList.setTxtDate("2020-10-23");
                phoneDetailsList.setTxtPhoneName("Iphone 4");
                phoneDetailsList.setStarRatingCount(3);
                phoneDetailsList.setTxtQuantity("3");
                dao.insertBrands(phoneDetailsList);

            });
        }
    };

}
