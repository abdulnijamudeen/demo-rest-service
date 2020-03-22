package com.example.nizam.app.data.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.example.nizam.app.config.security.AppUserDetails;
import com.example.nizam.app.data.entity.User;

import org.springframework.security.core.context.SecurityContextHolder;

import lombok.var;

public interface AppUtils {

    DateTimeFormatter formatterDDMMYYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static Date getInstant() {
        return Date.from(Instant.now());
    }
    
    static String localDateStringAsDDMMYYYY(LocalDate localDate) {
        return localDate.format(formatterDDMMYYYY);
    }
    
    static LocalDate getLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    static String getCurrentUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    
    static User getCurrentUser() {
        var appUserDetails = (AppUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appUserDetails.getCurrentUser();
    }

    static long timestamp() {
        return Instant.now().toEpochMilli();
    }

}
