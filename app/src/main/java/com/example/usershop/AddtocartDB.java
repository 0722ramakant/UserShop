package com.example.usershop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class AddtocartDB  extends SQLiteOpenHelper {

    static  final  private String DB_NAME="CartDB";
    static  final  private String DB_TABLE="Carttable";
    static  final  private  int DB_VERSION=1;

    ArrayList<Addtocartitem> item=new ArrayList<>();
    ArrayList<String> sum=new ArrayList<>();

    public ArrayList<Addtocartitem> getItem() {
        return item;
    }

    public void setItem(ArrayList<Addtocartitem> item) {
        this.item = item;
    }

    Context ctx;
    SQLiteDatabase mydb;
  public   AddtocartDB(Context ct)
  {
      super(ct,DB_NAME,null,DB_VERSION);
  }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+DB_TABLE+" (_id integer primary key autoincrement,itemname text,itemid text,brandname text,itemimageurl text,itemdescription text,onelariprice text,onelariquantity text, onelariunit text, onecartoonprice text, onecartoonquantity text, onecartoonunit text,onecartoonweight text, oneboxprice text,oneboxquantity text,oneboxunit text,onebagprice text,onebagquantity text,onebagweight text,onebagunit text,itempriceperkg text,itempriceperpice text,itemweight text, itemunit text,itemCategory text, itemquantity text,noofbox_pices_kg text, noof_bag_cartoon text,noofbox_pices_kg_price text, noof_bag_cartoon_price text,totalprice text);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

      sqLiteDatabase.execSQL("drop table if exists "+DB_TABLE);
      onCreate(sqLiteDatabase);
    }


    void insertdata(String itemname, String itemid, String brandname, String itemimageurl, String itemdescription, String onelariprice, String onelariquantity, String onelariunit, String onecartoonprice, String onecartoonquantity, String onecartoonunit, String onecartoonweight, String oneboxprice, String oneboxquantity, String oneboxunit, String onebagprice, String onebagquantity, String onebagweight, String onebagunit, String itempriceperkg, String itempriceperpice, String itemweight, String itemunit, String itemCategory, String itemquantity, String noofbox_pices_kg, String noof_bag_cartoon, String noofbox_pices_kg_price, String noof_bag_cartoon_price, String totalprice)
    {
        mydb=getWritableDatabase();
        mydb.execSQL("insert into "+DB_TABLE+" (itemname,itemid,brandname,itemimageurl,itemdescription,onelariprice,onelariquantity,onelariunit,onecartoonprice,onecartoonquantity, onecartoonunit,onecartoonweight, oneboxprice,oneboxquantity,oneboxunit,onebagprice,onebagquantity,onebagweight,onebagunit,itempriceperkg,itempriceperpice,itemweight, itemunit,itemCategory, itemquantity,noofbox_pices_kg,noof_bag_cartoon,noofbox_pices_kg_price, noof_bag_cartoon_price,totalprice)" +
                " values('"+itemname+"','"+itemid+"','"+brandname+"','"+itemimageurl+"','"+itemdescription+"','"+onelariprice+"','"+onelariquantity+"','"+onelariunit+"','"+onecartoonprice+"','"+onecartoonquantity+"','"+onecartoonunit+"','"+onecartoonweight+"','"+oneboxprice+"','"+oneboxquantity+"','"+oneboxunit+"','"+onebagprice+"','"+onebagquantity+"','"+onebagweight+"','"+onebagunit+"','"+itempriceperkg+"','"+itempriceperpice+"','"+itemweight+"','"+itemunit+"','"+itemCategory+"','"+itemquantity+"','"+noofbox_pices_kg+"','"+noof_bag_cartoon+"','"+noofbox_pices_kg_price+"','"+noof_bag_cartoon_price+"','"+totalprice+"');");


    }

    void update(String id,String noofbox,String noofboxprice,String noofcartoon,String noofcartoonprice,String total)
    {




        mydb=getWritableDatabase();
        String whereArgs[] = {id};
        ContentValues newValues = new ContentValues();
        newValues.put("noofbox_pices_kg", noofbox);
        newValues.put("noof_bag_cartoon", noofcartoon);
        newValues.put("noofbox_pices_kg_price", noofboxprice);
        newValues.put("noof_bag_cartoon_price", noofcartoonprice);
        newValues.put("totalprice", total);

        mydb.update(DB_TABLE, newValues, "itemid=?", whereArgs);

    }
    public void deleteItem(String id1) {
        mydb=getWritableDatabase();
        String whereClause = "itemid=?";
        String whereArgs[] = {id1};
        mydb.delete(DB_TABLE, whereClause, whereArgs);
    }




    void getAlldata()
    {
        item.clear();
        mydb=getReadableDatabase();
        Cursor cr=mydb.rawQuery("Select * from "+DB_TABLE,null);
        while (cr.moveToNext())
        {
           Addtocartitem addtocartitem=new Addtocartitem(cr.getString(1),cr.getString(2),cr.getString(3),cr.getString(4),cr.getString(5),cr.getString(6),cr.getString(7),cr.getString(8),cr.getString(9),cr.getString(10),cr.getString(11),cr.getString(12),cr.getString(13),cr.getString(14),cr.getString(15),cr.getString(16),cr.getString(17),cr.getString(18),cr.getString(19),cr.getString(20),cr.getString(21),cr.getString(22),cr.getString(23),cr.getString(24),cr.getString(25),cr.getString(26),cr.getString(27),cr.getString(28),cr.getString(29),cr.getString(30));
           item.add(addtocartitem);

        }
    }

    void getsum()
    {
        sum.clear();
        mydb=getReadableDatabase();
        Cursor cr=mydb.rawQuery("Select * from "+DB_TABLE,null);
        while (cr.moveToNext())
        {
        String s=cr.getString(30);
        sum.add(s);

        }

        totalsum();

    }

    int b,total=0;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    void totalsum()
    {

        for(String a:sum)
        {
          b=Integer.parseInt(a);
            total=total+b;
        }

    }


}
