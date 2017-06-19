package com.example.myjsondemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by peacock on 4/6/16.
 */
public class Databasehelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UserProduct";
    public static final String TABLEUSER = "Product";
    public static final String KEY_NAME = "Name";
    public static final String KEY_IMAGE = "Image";
    public static final String KEY_PRICE = "Price";
    public static final String KEY_ProductID = "ProductID";
    public static final String KEY_PackageID = "PackageID";
    public static final String KEY_SKU = "SKU";
    public static final String KEY_LastModified = "LastModified";
    public static final String KEY_CategoryIDs = "CategoryIDs";

    SQLiteDatabase db;

    public Databasehelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void open() {
        db = this.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_PRODUCT = "CREATE TABLE " + TABLEUSER + "("
                + KEY_NAME + " TEXT,"
                + KEY_ProductID + " TEXT,"
                + KEY_PackageID + " TEXT,"
                + KEY_IMAGE + " TEXT,"
                + KEY_SKU + " TEXT,"
                + KEY_LastModified + " TEXT,"
                + KEY_PRICE + " TEXT,"
                + KEY_CategoryIDs + " TEXT" + ")";
        db.execSQL(CREATE_TABLE_PRODUCT);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLEUSER);
    }

    public void addproduct(product product) {
        open();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getName());
        values.put(KEY_IMAGE, product.getImageName());
        values.put(KEY_PRICE, product.getPrice());
        db.insert(TABLEUSER, null, values);
        close();
    }

    public ArrayList<product> getproduct() {
        ArrayList<product> productlist = new ArrayList<product>();
        open();
        Cursor c = db.rawQuery(" SELECT * FROM " + TABLEUSER, null);
        if (c != null) {
            if (c.moveToFirst()) {
                do {
                    product product = new product();
                    product.setName(c.getString(c.getColumnIndex(KEY_NAME)));
                    product.setImageName(c.getString(c.getColumnIndex(KEY_IMAGE)));
                    product.setPrice(c.getLong(c.getColumnIndex(KEY_PRICE)));
                    //product.setName(c.getColumnName(c.getColumnIndex(KEY_NAME))); //give columnname
                  //  product.setProductID(c.getString(c.getColumnIndex(KEY_ProductID)));
                  //  product.setPackageID(c.getString(c.getColumnIndex(KEY_PackageID)));
                   // product.setImageName(c.getColumnName(c.getColumnIndex(KEY_IMAGE)));//Columnname
                  //  product.setSKU(c.getColumnName(c.getColumnIndex(KEY_SKU))); //Give column Name
                  // product.setSKU(c.getString(c.getColumnIndex(KEY_SKU)));
                 //   product.setLastModified(c.getString(c.getColumnIndex(KEY_LastModified)));

                  //  product.setCategoryIDs(c.getString(c.getColumnIndex(KEY_CategoryIDs)));

                    productlist.add(product);

                } while (c.moveToNext());
            }
        }
        c.close();
        close();
        return productlist;
    }
}
