package org.semenovao.bd_work.service;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public interface DateTimeService {
    Timestamp parseTimestamp(String date);
}
