# DAY 12 : SqliteApp
# SQLite Database Helper in Android (Java)

## Overview
This guide provides a helper class for using SQLite in an Android Java project. The class includes methods for inserting data using `insert()` and selecting data using `rawQuery()`.

## Instructions
1. Create a new class `DatabaseHelper.java` in your project.
2. Extend `SQLiteOpenHelper` to manage database creation and upgrades.
3. Implement the following methods:
   - `onCreate(SQLiteDatabase db)`: Creates the required database tables.
   - `onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)`: Handles database version upgrades.
   - `insertUser(String name, String email)`: Inserts a new user into the database using `insert()`.
   - `getAllUsers()`: Retrieves all users from the database using `rawQuery()`.
4. Use the helper class in your activities to perform database operations.

## SQLite Helper Class
```java
public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "mydatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }

    public boolean insertUser(String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        long result = db.insert("users", null, values);
        db.close();
        return result != -1;
    }

    public Cursor getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM users", null);
    }
}
```
