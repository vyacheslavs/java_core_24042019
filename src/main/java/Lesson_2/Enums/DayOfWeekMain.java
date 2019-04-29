package Lesson_2.Enums;

public class DayOfWeekMain {

    static String getWorkingHours(DayOfWeek dow) {
        switch (dow) {
            case SATURDAY:
            case SUNDAY:
                return "выходные";
            default:
                return String.valueOf(dow.getHoursToRest());
        }
    }

    public static void main(String[] args) {
        for (DayOfWeek dow : DayOfWeek.values()) {
            System.out.println(dow.getTranslation()+": "+getWorkingHours(dow));
        }

    }

}
