package com.company.ticketservice.enumeration;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("open"),
    IN_PROGRESS("inProgress"),
    RESOLVED("resolved"),
    CLOSED("closed");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
