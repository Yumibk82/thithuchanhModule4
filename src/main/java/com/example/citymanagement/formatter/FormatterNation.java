package com.example.citymanagement.formatter;

import com.example.citymanagement.model.Nation;
import com.example.citymanagement.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class FormatterNation implements Formatter<Nation> {

    private NationService nationService;

    @Autowired
    public FormatterNation(NationService nationService){
        this.nationService = nationService;
    }

    @Override
    public Nation parse(String text, Locale locale) throws ParseException {
        return nationService.findById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Nation object, Locale locale) {
        return null;
    }
}
