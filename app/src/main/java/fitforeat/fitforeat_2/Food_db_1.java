package fitforeat.fitforeat_2;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class Food_db_1 {

    private MyOpenHelper_1 objMyOpenHelper;
    private SQLiteDatabase writeSQLite, readSQLite;

    public static final String TABLE_FOOD = "foodTABLE";
    public static final String COLUMN_ID_FOOD = "_id";
    public static final String COLUMN_NAME_FOOD = "namefood";
    public static final String COLUMN_CAL_FOOD = "calfood";
    public static final String COLUMN_ABOUT_FOOD = "aboutfood";

    public Food_db_1(Context context) {

        objMyOpenHelper = new MyOpenHelper_1(context);
        writeSQLite = objMyOpenHelper.getWritableDatabase();
        readSQLite = objMyOpenHelper.getReadableDatabase();

    } // Contructor

    //Read All Data
    public String[] readAllDataFood(int intColumn) {

        String[] strResult = null;
        Cursor objCursor = readSQLite.query(TABLE_FOOD,
                new String[] {COLUMN_ID_FOOD, COLUMN_NAME_FOOD, COLUMN_CAL_FOOD, COLUMN_ABOUT_FOOD},
                null, null, null, null, null);
        if (objCursor != null) {

            strResult = new String[objCursor.getCount()];
            objCursor.moveToFirst();

            for (int i=0; i<objCursor.getCount(); i++) {

                switch (intColumn) {
                    case 1:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_NAME_FOOD));
                        break;
                    case 2:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_CAL_FOOD));
                        break;
                    case 3:
                        strResult[i] = objCursor.getString(objCursor.getColumnIndex(COLUMN_ABOUT_FOOD));
                        break;
                }   // switch

                objCursor.moveToNext();

            }    // for
        }   // if
        objCursor.close();


        return strResult;
    }


    //Add New Value To SQLite
    public long addNewFoodToSQLite (String strNameFood, double douCalFood, String strAboutFood) {

        ContentValues objContentValue = new ContentValues();
        objContentValue.put(COLUMN_NAME_FOOD, strNameFood);
        objContentValue.put(COLUMN_CAL_FOOD, douCalFood);
        objContentValue.put(COLUMN_ABOUT_FOOD, strAboutFood);

        return writeSQLite.insert(TABLE_FOOD, null, objContentValue);
    }   //addNewValueToSQLite

} // FoodTABLE
