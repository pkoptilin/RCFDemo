package com.selectica.rcfdev.eclm.definitions.shared.conditions;

import java.util.Arrays;
import java.util.List;

/**
 * Expression to evaluate availability of the {@code DocuSign Correct} button
 *
 * @author Andrey Paslavsky
 */
public class ESignatureCorrectionAvailableCondition extends ESignatureButtonAvailabilityCondition {
    private static final List<String> AVAILABLE = Arrays.asList("OUT_FOR_SIGNATURE");

    @Override
    protected List<String> getStatusesWhenButtonIsAvailable() {
        return AVAILABLE;
    }
}
