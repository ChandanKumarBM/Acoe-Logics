package acoeLogics;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class ISOminutes {

    public static void main(String[] args) {
        String inputDateTimeStr = "2024-02-24T12:43:00.000Z";
        OffsetDateTime inputDateTime = OffsetDateTime.parse(inputDateTimeStr, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        int minutesToAdd = 8;
        OffsetDateTime resultDateTime = inputDateTime.plusMinutes(minutesToAdd);
        String resultDateTimeStr = resultDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        System.out.println("Input DateTime: " + inputDateTimeStr);
        System.out.println("Result DateTime: " + resultDateTimeStr);
    }
}
