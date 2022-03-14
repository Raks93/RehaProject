package com.project.reha.util.mappers.enumMappers;

import com.project.reha.enums.EventStatus;
import org.springframework.stereotype.Component;

@Component
public class EventStatusMapper {

    public static String mapEventStatusToString(EventStatus status) {
        switch(status) {
            case PLANNED: return "Planned";
            case COMPLETED: return "Completed";
            case CANCELLED: return "Cancelled";
            default: {
                System.out.println("Логирование");
                throw new IllegalArgumentException("Unknown status");
            }

        }
    }

    public static EventStatus mapStringToEventStatus(String status) {
        switch(status) {
            case "Planned": return EventStatus.PLANNED;
            case "Completed": return EventStatus.COMPLETED;
            case "Cancelled": return EventStatus.CANCELLED;
            default: {
                System.out.println("Логирование");
                throw new IllegalArgumentException("Unknown status");
            }

        }
    }
}
