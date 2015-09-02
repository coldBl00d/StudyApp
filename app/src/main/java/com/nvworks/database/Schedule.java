package com.nvworks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;

import com.nvworks.helpers.toast;

/**
 * Created by user on 9/3/2015.
 */
public class Schedule {

        MainDatabase tdatabaseCreater;
        Context context;
        SQLiteDatabase db;
        String[][] columnNames, columnTypes;
        String[] tableNames;
        int[] columnNos;
        toast maketext;

        public Schedule(Context context) {
            this.context = context;
            maketext = new toast(context);
            tdatabaseCreater = new MainDatabase(context);
        }

        public SQLiteDatabase settingDatabase() {
            String[][] columnNames = {
                    {"_id","sid","date","subname","isnotify","fromtimehr","fromtimemin","totimemhr","totimemin"},//add more tables as we procceed
                    {"_id","sid","notifyhr","notifymin","isalarm"},


            };
            String[][] columnTypes = {
                    {"INTEGER","INTEGER","VARCHAR(200)","VARCHAR(200)","INTEGER","INTEGER","INTEGER","INTEGER","INTEGER"},
                    {"INTEGER","INTEGER","INTEGER","INTEGER","INTEGER"}

            };
            String[] tableNames = {"schedule","notification"};
            int[] columnNos = {9,5};

            this.columnNames = columnNames;
            this.columnTypes = columnTypes;
            this.tableNames = tableNames;
            this.columnNos = columnNos;

            db = tdatabaseCreater.getWritableDatabase();

            return db;
        }

        public Cursor select(SQLiteDatabase db, int tableno, int[] columnno, String selection, String[] selectionArgs, String groupby, String having, String orderby) {
            if (db != null) {
                String[] reqcolumns = new String[columnno.length];
                //  reqcolumns = null;
                for (int i = 0; i < columnno.length; i++) {
                    reqcolumns[i] = columnNames[tableno][columnno[i]];
                }

                Cursor tempcursor = tdatabaseCreater.select(db, tableNames[tableno], reqcolumns, selection, selectionArgs, groupby, having, orderby);
                return tempcursor;
            } else {
                return null;
            }


        }

        public void insert(String[] stringvalues,int[] values) {
            Asyncinsert asyncinsert = new Asyncinsert(stringvalues,values);
            asyncinsert.execute();
        }

        public class Asyncinsert extends AsyncTask<Void, String, Void> {
            int[] values;
            String[] stringvalues;
            ContentValues contentValues;

            Asyncinsert(String[] stringvalues, int values[]) {
                this.values = values;
                this.stringvalues = stringvalues;

            }

            @Override
            protected Void doInBackground(Void... params) {

                contentValues = new ContentValues();
                int i, j = 0;


                Log.d("schedule", "second value " + values[5] + " " + values[5] / 100);
                for (i = 1; i < columnNos[0]; i++) {

                    if (columnTypes[0][i].equals("INTEGER")) {
                        contentValues.put(columnNames[0][i], values[j++]);


                    } else {
                        contentValues.put(columnNames[0][i], stringvalues[0]);
                    }


                }

                //     contentValues.put(columnNames[0][i], notifytime);

                Log.d("schedule", "schedule getting inserted " + tdatabaseCreater.insert(db, contentValues, tableNames[0]));

                Log.d("schedule", "");

                String[] reqcolumnNames = {columnNames[0][0]};
                String datetimings;
                String selection = "" + columnNames[0][1] + " = ? and " + columnNames[0][2] + " = ?  and " + columnNames[0][3] + " = ?";
                String ff = Integer.toString(values[0]);
                String fff = Integer.toString(values[1]);
                String selectionArgs[] = {ff, fff, stringvalues[0]};
                Cursor tempcursor = tdatabaseCreater.select(db, tableNames[0], reqcolumnNames, selection, selectionArgs, null, null, null);
                int tid = -1;
                while (tempcursor.moveToNext()) {
                    tid = tempcursor.getInt(tempcursor.getColumnIndex(columnNames[0][0]));// use tid for later tables..probably need to change
                    //selection string to smthing betr
                }

                return null;
            }

            public void deleterow(String valuess , int intvalues, String[] whereArgs, SQLiteDatabase db) {

                String[] values = {tableNames[intvalues],valuess };
                Asyncdeleterow asyncdeleterow = new Asyncdeleterow(values,whereArgs,db);
                asyncdeleterow.execute();

            }

            public class Asyncdeleterow extends AsyncTask<Void, Void, Void>
            {
                SQLiteDatabase db;
                String[] values , whereArgs;
                Asyncdeleterow(String[] values,String[] whereArgs,SQLiteDatabase db)
                {
                    this.values = values;
                    this.whereArgs = whereArgs;
                    this.db = db;
                }
                @Override
                protected Void doInBackground(Void... params) {

                    tdatabaseCreater.deleterow(db, values[0], values[1], whereArgs);
                    return null;
                }
            }
        }


    }

