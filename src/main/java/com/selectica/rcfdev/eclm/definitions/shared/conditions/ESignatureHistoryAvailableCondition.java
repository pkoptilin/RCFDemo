package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import java.util.Arrays;
import java.util.List;

/**
 * Expression to evaluate availability of the {@code View History} button
 *
 * @author Andrey Paslavsky
 */
public class ESignatureHistoryAvailableCondition extends ESignatureButtonAvailabilityCondition {
    private final static List<String> AVAILABLE = Arrays.asList("SENT", "OUT_FOR_SIGNATURE");

    @Override
    protected List<String> getStatusesWhenButtonIsAvailable() {
        return AVAILABLE;
    }
}
