package com.connxun.morui.model.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.connxun.morui.model.entity.Contacts;
import com.connxun.morui.model.entity.User;
import com.connxun.morui.model.local.dao.ContactsDao;
import com.connxun.morui.model.local.dao.UserDao;

/**
 * @author wushange
 * @date 2017/12/14
 */

@Database(entities = {User.class, Contacts.class}, version = 1)
public abstract class BaseAppData extends RoomDatabase {

    private static final String DATABASE_NAME = "morui.db";
    private static BaseAppData Instance;

    public abstract ContactsDao contactsDao();

    public abstract UserDao userDao();

    public static BaseAppData getInstance(final Context context) {
        if (Instance == null) {
            synchronized (BaseAppData.class) {
                if (Instance == null) {
                    Instance = buildDatabase(context);
                }
            }
        }
        return Instance;
    }

    private static BaseAppData buildDatabase(Context context) {
        return (BaseAppData) Room.databaseBuilder(context.getApplicationContext(), BaseAppData.class, DATABASE_NAME).build();
    }
}
