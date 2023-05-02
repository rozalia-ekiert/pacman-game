package model;

public class NumberFormatter {
    //utility class

    public static String changeScoreToString(int score) {
        int howManyDigits = String.valueOf(score).length();
        String current = String.valueOf(score);

        if (howManyDigits >= 6) return String.valueOf(score);

        StringBuilder result = new StringBuilder(current);
        do {
            result.insert(0, "0");
        } while (result.length() != 6);

        return result.toString();
    }

    public static String changeTimeToString(long time) {
        long seconds = time / 1000;
        long minutes = seconds / 60;
        long finalSeconds = seconds % 60;

        if (minutes > 60) return ">1 hour";

        String StrMinutes = null;
        if (minutes > 9) StrMinutes = String.valueOf(minutes);
        if (minutes < 9) StrMinutes = "0" + String.valueOf(minutes);

        String StrSeconds = null;
        if (finalSeconds > 9) StrSeconds = String.valueOf(finalSeconds);
        if (finalSeconds < 9) StrSeconds = "0" + String.valueOf(finalSeconds);

        return StrMinutes + ":" + StrSeconds;
    }
}
