package com.example.yukunlin.physiotherapydevice.utils;


import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by luohongkun on 15/5/19.
 */
public class Migration implements RealmMigration {

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

        RealmSchema schema = realm.getSchema();

        if (oldVersion == 0) {
            schema.get("History")
                    .addField("gear", String.class);
            oldVersion++;

        }
    }
}
