package com.company.ticketservice.enumeration;

import lombok.Getter;

@Getter
public enum PriorityType {
    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private final String label;

    PriorityType(String label) {
        this.label = label;
    }
}
