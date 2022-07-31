package commonsense.leapyear;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } if (year % 400 == 0) {
            return true;
        } if (year % 100 == 0) {
            return false;
        } else {
            return true;
        }
    }
}
