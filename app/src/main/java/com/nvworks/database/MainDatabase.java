package com.nvworks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;



/**
 * Created by user on 7/20/2015.
 */
public class MainDatabase extends SQLiteOpenHelper {

    String[][] columnName, columnTypes;
    int[] columnNo;

    Context context;
    //toast maketoast;
    String[] CreateSQL, TABLE_NAME, DropSQL;
    SQLiteDatabase db;
    RecyclerView mRecyclerView;

    TextView timetext;


    private static final String DATABASE_SCHEMA = "MyDataBase";
    private static int DATABASE_VERSION = 1;

    public MainDatabase(Context context) {
        super(context, DATABASE_SCHEMA, null, DATABASE_VERSION);
        this.context = context;

    }

    public void intialisecreatesql() {
        CreateSQL = new String[TABLE_NAME.length];

        for (int i = 0; i < TABLE_NAME.length; i++) {
            CreateSQL[i] = "Create table " + TABLE_NAME[i] + " ( " + columnName[i][0] + " INTEGER PRIMARY KEY AUTOINCREMENT , ";

            for (int j = 1; j < columnNo[i]; j++) {
                String temp = columnName[i][j] + " " + columnTypes[i][j] + " ";
                if ((j + 1) != columnNo[i])
                    temp = temp.concat(" , ");

                CreateSQL[i] = CreateSQL[i].concat(temp);
            }
            CreateSQL[i] = CreateSQL[i].concat(" );");

        }
    }

    public void intialisedrop() {
        DropSQL = new String[TABLE_NAME.length];

        for (int i = 0; i < TABLE_NAME.length; i++) {

            DropSQL[i] = "Drop table if exists " + TABLE_NAME[i] + " ;";
        }

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        intialisecreatesql();
        for (int i = 0; i < CreateSQL.length; i++) {

            try {
                db.execSQL(CreateSQL[i]);
                Log.i("drop ", CreateSQL[i]);


            } catch (SQLException e) {

                Log.d("oncreate ", "exception " + e);
            }


        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        intialisedrop();
        for (int i = 0; i < DropSQL.length; i++) {
            try {

                db.execSQL(DropSQL[i]);
                Log.d("drop ", DropSQL[i]);
                //  Toast.makeText(context, "Upgrade" + DropSQL[i], Toast.LENGTH_LONG).show();

            } catch (SQLException e) {
                // Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
                Log.i("onUpgrade", "exception " + e);
            }
        }

        onCreate(db);

    }

    public SQLiteDatabase settingDatabase() {

        String columnName[][] = {

        };
        this.columnName = columnName;
        String columnTypes[][] = {
             };

        this.columnTypes = columnTypes;


        int columnNo0[] = {};
        columnNo = columnNo0;
        String[] tableName0 = {};
        TABLE_NAME = tableName0;

        db = getWritableDatabase();
        return db;
    }

    public long insert(SQLiteDatabase db , ContentValues contentValues , String  tableName)
    {
        try {

            return db.insert(tableName, null, contentValues);

        } catch (Exception e) {
            // TODO Auto-generated catch block
           // maketoast.makeText(""+e);
        }
        return 0;
    }

    public  int update(SQLiteDatabase db, String tableName, ContentValues contentValues , String selection , String[] selectionArgs)
    {

        if(db!=null)
        {
            return db.update(tableName,contentValues,selection,selectionArgs);
        }

        return  -1;
    }
    public Cursor select(SQLiteDatabase db, String tableName,String[] columnNamesRequired, String selection, String[] selectionArgs,String groupBy,String having,String orderBy)
    {
        if(db!=null)
        {
            return db.query(tableName,columnNamesRequired,selection,selectionArgs,groupBy,having,orderBy);
        }
        else
            return null;

    }

    public int deleterow(SQLiteDatabase db,String tablename,String whereclause, String[] whereArgs)
    {
        return  db.delete(tablename ,whereclause, whereArgs);
    }




}
