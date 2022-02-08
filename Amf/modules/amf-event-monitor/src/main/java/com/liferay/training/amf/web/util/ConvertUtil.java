package com.liferay.training.amf.web.util;

import com.liferay.portal.security.audit.AuditEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConvertUtil {

    public static String convertDate(Date date) {
        return date.getDate() + "/" + (date.getMonth() + 1) + "/" + (date.getYear() + 1900);
    }

    public static String convertTime(Date date) {
        return date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    }

    public static List<AuditEvent> getAllEvents(List<AuditEvent> auditEvents) {

        List<AuditEvent> result = new ArrayList<>();
        for(AuditEvent auditEvent : auditEvents) {
            if(auditEvent.getEventType().equals("LOGIN") || auditEvent.getEventType().equals("ADD")) {
                result.add(auditEvent);
            }
        }
        return result;
    }

    public static List<AuditEvent> getEventsByCategory(List<AuditEvent> auditEvents, String tabName) {

        if(tabName.equals("registration")) {
            tabName = "ADD";
        }

        if(tabName.equals("all")) {
            return auditEvents;
        }

        List<AuditEvent> result = new ArrayList<>();
        for(AuditEvent auditEvent : auditEvents) {
            if(auditEvent.getEventType().equals(tabName.toUpperCase())) {
                result.add(auditEvent);
            }
        }

        return result;
    }
}