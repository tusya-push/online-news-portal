package com.example.onlinenewsportal.utils;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FormatterUtils {

    public String getNiceDate(Date date) {
        return new SimpleDateFormat("MMM d, yyyy").format(date);
    }
}
