package com.example.demo.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.util.Calendar.DAY_OF_MONTH;

/**
 * @author {曹炳全}
 * @Description
 * @date 2021/2/18 16:00
 */
@Slf4j
public class DateTest {
    /**
     * 当月第一天,今天0点
     */
    @Test
    void a1() {
        Integer zx =null;
        Integer aaaaaa = 1;
        if (aaaaaa.equals(zx)){
            System.out.println("n");
        }else {
            System.out.println("y");
        }

        Date now = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String nowStr = sdf.format(now)+" 00:00:00"; //得到今天凌晨时间

//        calendar.set(DAY_OF_MONTH, 1);

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);//这是将当天的【时】设置为0
        calendar.set(Calendar.MINUTE, 0);//这是将当天的【分】设置为0
        calendar.set(Calendar.SECOND, 0);//这是将当天的【秒】设置为0
        Date today = calendar.getTime();

        calendar.add(Calendar.DATE,1); //当前日期加一
//        calendar.set(DAY_OF_MONTH,calendar.get(DAY_OF_MONTH) +1);
        Date tomorrow =calendar.getTime();
        calendar.set(DAY_OF_MONTH, 1);
        Date monthFirstDay =calendar.getTime();

        String todayString = format.format(today);
        String tomorrowString = format.format(tomorrow);
        String monthFirstDayString = format.format(monthFirstDay);
        System.out.println(todayString);
        System.out.println(tomorrowString);
        System.out.println(monthFirstDayString);


        String testBeginTime = new SimpleDateFormat("-yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        System.out.println(testBeginTime);

    }


}
