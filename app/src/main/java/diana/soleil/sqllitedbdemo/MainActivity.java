package diana.soleil.sqllitedbdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Party", MODE_PRIVATE, null);
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS party (name VARCHAR, date INT (3))");
        sqLiteDatabase.execSQL("INSERT INTO party (name,date) VALUES ('Hossein',10)");
        sqLiteDatabase.execSQL("INSERT INTO party (name,date) VALUES ('Reza',20)");

        Cursor c = sqLiteDatabase.rawQuery("SELECT * FROM party" , null);

        int nameColumn = c.getColumnIndex("name");
        int dateColumn = c.getColumnIndex("date");
        c.moveToFirst();
        while (c.moveToNext()) {
            Log.i("Name" , c.getString(nameColumn));
            Log.i("Date" , c.getString(dateColumn));
            c.moveToNext();
        }
    }
}