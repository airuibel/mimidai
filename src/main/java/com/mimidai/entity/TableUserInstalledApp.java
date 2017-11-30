package com.mimidai.entity;

/**
 * 用户安装APP的实体类
 * Created by 孟庆艺 on 2017-07-13.
 */
public class TableUserInstalledApp {
    // private Long userId;
    // private String imei;
    private String appLabel;
    private String pkgName;
    private String uid;

    // public Long getUserId() {
    //     return userId;
    // }
    //
    // public void setUserId(Long userId) {
    //     this.userId = userId;
    // }
    //
    // public String getImei() {
    //     return imei;
    // }
    //
    // public void setImei(String imei) {
    //     this.imei = imei;
    // }

    public String getAppLabel() {
        return appLabel;
    }

    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TableUserInstalledApp tableUserInstalledApp = (TableUserInstalledApp) obj;
        // if (userId != tableUserInstalledApp.userId) {
        //     return false;
        // }
        // if (imei != null ? !imei.equals(tableUserInstalledApp.imei) : tableUserInstalledApp.imei != null) {
        //     return false;
        // }
        if (pkgName != null ? !pkgName.equals(tableUserInstalledApp.pkgName) : tableUserInstalledApp.pkgName != null) {
            return false;
        }
        return true;
    }
}
