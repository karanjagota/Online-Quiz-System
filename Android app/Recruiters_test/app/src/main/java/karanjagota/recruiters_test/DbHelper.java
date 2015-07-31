package karanjagota.recruiters_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "questionDB.db";
    private static final String TABLE_QUESTIONS = "questions";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_QUESTION_NAME = "question_name";
    public static final String COLUMN_ANSWERS = "answer";

    // constructer method and set the return database name and version ... ...

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    // In On create method create table to execute the table in database when first instantiated ...

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_QUESTION_TABLE = "CREATE TABLE " +
                TABLE_QUESTIONS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_QUESTION_NAME
                + " TEXT," + COLUMN_ANSWERS + " INTEGER" + ")";
        db.execSQL(CREATE_QUESTION_TABLE);

    }

    // before update first drop all the values and then build again the new/updated database .... ..

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);

    }

    // method to be used while aading a questions in the table ... ... ..-

    public void addQuestion(Questions question) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_NAME, question.getQuestionName());
        values.put(COLUMN_ANSWERS, question.getAnswer());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_QUESTIONS, null, values);
        db.close();
    }

    // Method to retreive the questions  from hte database with the query ... ..

    public Questions findQuestion(String questionname) {

        String query = "Select * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_QUESTION_NAME + " =  \"" + questionname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Questions question = new Questions();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            question.setID(Integer.parseInt(cursor.getString(0)));
            question.setQuestionName(cursor.getString(1));
            question.setAnswer(cursor.getString(2));
            cursor.close();
        } else {
            question = null;
        }
        db.close();
        return question;
    }



    // Method to delete a question if wanted though not in use  from the database ...

    public boolean deleteQuestion(String questionname) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_QUESTION_NAME + " =  \"" + questionname + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Questions question = new Questions();

        if (cursor.moveToFirst()) {
            question.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_QUESTIONS, COLUMN_ID + " = ?",
                    new String[] { String.valueOf(question.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }
}




