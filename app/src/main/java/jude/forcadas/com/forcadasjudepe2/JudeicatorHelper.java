package jude.forcadas.com.forcadasjudepe2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class JudeicatorHelper extends SQLiteOpenHelper {

    final static String DBName = "Test.db";
    final static int Version = 1;
    final static String TABLE = "Ex";

    public JudeicatorHelper(@Nullable Context context) {
        super(context, DBName, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE Ex (ID INTEGER PRIMARY KEY AUTOINCREMENT, Fullname TEXT, Age TEXT, Gender TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String deleteTable = "DROP TABLE IF EXISTS Ex";
        db.execSQL(deleteTable);
        onCreate(db);
    }

    public boolean insert(String Fullname, String Age, String Gender){
        SQLiteDatabase DB = this.getReadableDatabase();
        ContentValues CV = new ContentValues();
        CV.put("Fullname",Fullname);
        CV.put("Age",Age);
        CV.put("Gender",Gender);
        long inserted = DB.insert(TABLE,null,CV);
        if (inserted == -1){
            return false;
        }
        else return true;
    }

    public Cursor selectAllRecords(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM Ex", null);
    }
}
