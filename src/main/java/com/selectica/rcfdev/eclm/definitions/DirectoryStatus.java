package com.selectica.rcfdev.eclm.definitions;

/**
 * Created by vshilkin on 12/01/2015.
 */
public enum DirectoryStatus {

    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String status;

    DirectoryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

