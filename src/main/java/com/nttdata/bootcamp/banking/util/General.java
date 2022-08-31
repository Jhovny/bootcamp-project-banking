package com.nttdata.bootcamp.banking.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

public class General {

    static Function<Integer, String> addCeros= x -> x <10 ?"0"+x:String.valueOf(x);
    static TruFunction<Integer, Integer, Integer, LocalDate> parseDate =
            (day,month, year)
                    -> LocalDate.parse(year +"-"+
                    addCeros.apply(month) + "-" +
                    addCeros.apply(day));

    static TruFunction<Integer, Integer, Integer, Integer> calculateAge=
            (day,month,year) ->
                    Period.between(parseDate.Appply(day,month,year),
                            LocalDate.now()).getYears();

    public static int calculateTiem(Integer day, Integer month, Integer year){
       return calculateAge.Appply(day,month, year);
    }


    @FunctionalInterface
    interface TruFunction<T,U,V,R>{
        R Appply(T t,U u,V v);
    }

}
