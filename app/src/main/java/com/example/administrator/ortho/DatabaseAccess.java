package com.example.administrator.ortho;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 12/10/2017.
 */

class DatabaseOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "dictionaryenbn.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public List<String> getmeaning(String English){
        List<String> words = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT * FROM DICTIONARY WHERE English='"+English+"';";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                words.add(cursor.getString(2));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning colleges
        return words;
    }
}



//public class DatabaseAccess {
//
//    public SQLiteOpenHelper openHelper;
//    private SQLiteDatabase database;
//    private static DatabaseAccess instance;
//
//    /**
//     * Private constructor to aboid object creation from outside classes.
//     *
//     * @param context
//     */
//    public DatabaseAccess(Context context) {
//        this.openHelper = new DatabaseOpenHelper(context);
//    }
//
//    /**
//     * Return a singleton instance of DatabaseAccess.
//     *
//     * @param context the Context
//     * @return the instance of DabaseAccess
//     */
//    public static DatabaseAccess getInstance(Context context) {
//        if (instance == null) {
//            instance = new DatabaseAccess(context);
//        }
//        return instance;
//    }
//
//    /**
//     * Open the database connection.
//     */
//    public void open() {
//        this.database = openHelper.getWritableDatabase();
//    }
//
//    /**
//     * Close the database connection.
//     */
//    public void close() {
//        if (database != null) {
//            this.database.close();
//        }
//    }
//
//    /**
//     * Read all quotes from the database.
//     *
//     * @return a List of quotes
//     */
//    public List<String> getQuotes(String English) {
//        List<String> list = new ArrayList<>();
//        Cursor cursor = database.rawQuery("SELECT * FROM DICTIONARY WHERE English='"+English+"';", null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            list.add(cursor.getString(0));
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return list;
//    }
//}
