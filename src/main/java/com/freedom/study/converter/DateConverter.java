package com.freedom.study.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {



  @Override
  public Date convert(String s) {
    //字符串转日期
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = format.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }
}
