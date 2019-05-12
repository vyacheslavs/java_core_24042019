package Lesson_2.Enums;

public enum DayOfWeek {
    MONDAY ("Понедельник",40),
    TUESDAY ("Вторник",32),
    WEDNESDAY ("Среда", 24),
    THURSDAY ("Четверг",16),
    FRIDAY ("Пятница",8),
    SATURDAY ("Суббота",0),
    SUNDAY ("Воскресение",0);

    private int hoursToRest;
    private String translation;

    DayOfWeek(String translation, int hoursToRest) {
        this.translation = translation;
        this.hoursToRest = hoursToRest;
    }

    public int getHoursToRest() {
        return hoursToRest;
    }

    public String getTranslation() {
        return translation;
    }
}
