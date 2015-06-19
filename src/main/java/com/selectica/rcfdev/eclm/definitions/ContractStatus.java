package com.selectica.rcfdev.eclm.definitions;

/**
 * Created by vshilkin on 12/01/2015.
 */
public enum ContractStatus {
    DRAFT("Draft"),
    AWAITING_SIGNATURE("Awaiting Signature"),
    EXECUTED("Executed"),
    TERMINATED("Terminated"),
    EXPIRED("Expired");

    private String status;

    ContractStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

