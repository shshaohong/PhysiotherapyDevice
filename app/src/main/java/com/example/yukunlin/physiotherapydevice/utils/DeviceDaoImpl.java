package com.example.yukunlin.physiotherapydevice.utils;

import android.content.Context;

import com.example.yukunlin.physiotherapydevice.module.Device;
import com.example.yukunlin.physiotherapydevice.module.History;

import java.sql.SQLException;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by yukunlin on 2016/11/14.
 */

public class DeviceDaoImpl implements DeviceDao {
    private Context context;
    private Realm mRealm;

    public DeviceDaoImpl(Context context) {
        this.context = context;
        mRealm = RealmUtils.getInstance(context).getRealm();
    }

    @Override
    public void insert(Device device) throws SQLException {
        mRealm.beginTransaction();//必须先开启事务
        Device device1 = mRealm.copyToRealm(device);//把Device对象复制到Realm
        mRealm.commitTransaction();//提交事务
//        mRealm.close();//必须关闭，不然会造成内存泄漏
    }

    @Override
    public void insertHistory(History history) throws SQLException {
        mRealm.beginTransaction();
        mRealm.copyToRealm(history);
        mRealm.commitTransaction();
    }

    @Override
    public List<Device> getAllDevice() throws SQLException {
        List<Device> list = null;
        RealmResults<Device> results = mRealm.where(Device.class).findAll();
        list = results;
//        mRealm.close();
        return list;
    }

    @Override
    public List<History> getHistory(String macAddress) throws SQLException {
        RealmResults<History> results = mRealm.where(History.class).equalTo("macAddress", macAddress).findAll();
        List<History> list = null;
        list = results;
        return list;
    }


    @Override
    public void updateMachineId(String id, String machineId) throws SQLException {
        mRealm.beginTransaction();//开启事务
        mRealm.where(Device.class)
                .equalTo("id", id)//根据id查询
                .findFirst()
                .setMachineId(machineId);//修改machineId
        mRealm.commitTransaction();
//        mRealm.close();
    }

    @Override
    public void updateMachineName(String id, String name) throws SQLException {
        mRealm.beginTransaction();//开启事务
        mRealm.where(Device.class)
                .equalTo("id", id)//根据id查询
                .findFirst()
                .setName(name);//修改machineId
        mRealm.commitTransaction();
    }

    @Override
    public String getMachineId(String id) throws SQLException {
        mRealm.beginTransaction();
        String machineId = mRealm.where(Device.class)
                .equalTo("id", id)
                .findFirst()
                .getMachineId();
        mRealm.commitTransaction();
        return machineId;
    }

    @Override
    public void deleteDevice(String id) throws SQLException {
        Device device = mRealm.where(Device.class).equalTo("id", id).findFirst();//删除id列值为id的行
        mRealm.beginTransaction();
        device.deleteFromRealm();//从数据库删除
        mRealm.commitTransaction();
    }

    @Override
    public void closeRealm() {
        mRealm.close();
    }
}
