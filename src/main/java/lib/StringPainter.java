package lib;

public class StringPainter {

    public static final String RESET = "\u001B[0m";

    public static String paint(String text) {
        return text + RESET;
    }

    public static String paint(String text, TextColor textColor) {
        return textColor.getColor() + text + RESET;
    }

    public static String paint(String text, TextColor textColor, BackgroundColor backgroundColor) {
        return backgroundColor.getColor() + textColor.getColor() + text + RESET;
    }

    public enum TextColor {
        TXT_BLACK("\u001B[30m"),
        TXT_RED("\u001B[31m"),
        TXT_GREEN("\u001B[32m"),
        TXT_YELLOW("\u001B[33m"),
        TXT_BLUE("\u001B[34m"),
        TXT_PURPLE("\u001B[35m"),
        TXT_CYAN("\u001B[36m"),
        TXT_WHITE("\u001B[37m");

        private final String color;

        TextColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return this.color;
        }
    }

    public enum BackgroundColor {
        BG_BLACK("\u001B[40m"),
        BG_RED("\u001B[41m"),
        BG_GREEN("\u001B[42m"),
        BG_YELLOW("\u001B[43m"),
        BG_BLUE("\u001B[44m"),
        BG_PURPLE("\u001B[45m"),
        BG_CYAN("\u001B[46m"),
        BG_WHITE("\u001B[47m");

        private final String color;

        BackgroundColor(String color) {
            this.color = color;
        }

        public String getColor() {
            return this.color;
        }
    }
}
