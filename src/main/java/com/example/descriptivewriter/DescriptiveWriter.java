package com.example.descriptivewriter;

public class DescriptiveWriter {

    private static final TextAlignment DEFAULT_TEXT_ALIGNMENT  = TextAlignment.CENTER;
    private static final int           DEFAULT_LINE_LENGTH     = 20;
    private static final boolean       DEFAULT_ADD_EXTRA_LINES = true;
    private static final String        FIRST_LINE_EXTRA_STRING = "/*";
    private static final String        LAST_LINE_EXTRA_STRING  = "*/";

    public static String buildDescriptiveText(String text,
                                              String comment) {
        return buildDescriptiveText(text,
                                    comment,
                                    DEFAULT_TEXT_ALIGNMENT,
                                    DEFAULT_LINE_LENGTH,
                                    DEFAULT_ADD_EXTRA_LINES);
    }

    public static String buildDescriptiveText(String text,
                                              String comment,
                                              TextAlignment textAlignment) {
        return buildDescriptiveText(text,
                                    comment,
                                    textAlignment,
                                    DEFAULT_LINE_LENGTH,
                                    DEFAULT_ADD_EXTRA_LINES);
    }

    public static String buildDescriptiveText(String text,
                                              String comment,
                                              TextAlignment textAlignment,
                                              int lineLength) {
        return buildDescriptiveText(text,
                                    comment,
                                    textAlignment,
                                    lineLength,
                                    DEFAULT_ADD_EXTRA_LINES);
    }

    public static String buildDescriptiveText(String text,
                                              String comment,
                                              TextAlignment textAlignment,
                                              boolean addExtraLines) {
        return buildDescriptiveText(text,
                                    comment,
                                    textAlignment,
                                    DEFAULT_LINE_LENGTH,
                                    addExtraLines);
    }

    public static String buildDescriptiveText(String text,
                                              String comment,
                                              TextAlignment textAlignment,
                                              int lineLength,
                                              boolean addExtraLines) {
        if (lineLength < 0) {
            throw new IllegalArgumentException("Max line length must be grater than 0.");
        }

        StringBuilder sb = new StringBuilder();
        appendFirstLine(sb, lineLength);

        if (addExtraLines) {
            appendEmptyLine(sb, lineLength);
        }

        appendDescriptiveComment(sb, comment, textAlignment, lineLength);

        if (addExtraLines) {
            appendEmptyLine(sb, lineLength);
        }

        appendLastLine(sb, lineLength);

        int totalLengthOfLine = lineLength
                + FIRST_LINE_EXTRA_STRING.length()
                + LAST_LINE_EXTRA_STRING.length();
        appendDescriptiveText(sb, text, textAlignment, totalLengthOfLine);

        return sb.toString();
    }

    private static void appendDescriptiveComment(StringBuilder sb,
                                                 String comment,
                                                 TextAlignment textAlignment,
                                                 int lineLength) {
        String[] split = comment.split("\n");
        for (String string : split) {
            int stringLength      = string.length();
            int stringInLineCount = stringLength / lineLength;
            int i                 = 0;
            do {
                appendStartLine(sb);

                int startIndex = i * lineLength;
                int endIndex   = Math.min(startIndex + lineLength, stringLength);
                textAlignment.appendAligned(sb, string.substring(startIndex, endIndex), lineLength);

                appendEndLine(sb);
            } while (i++ < stringInLineCount);
        }
    }

    private static void appendDescriptiveText(StringBuilder sb,
                                              String comment,
                                              TextAlignment textAlignment,
                                              int lineLength) {
        String[] split = comment.split("\n");
        for (String string : split) {
            int stringLength      = string.length();
            int stringInLineCount = stringLength / lineLength;
            int i                 = 0;
            do {
                int startIndex = i * lineLength;
                int endIndex   = Math.min(startIndex + lineLength, stringLength);
                textAlignment.appendAligned(sb, string.substring(startIndex, endIndex), lineLength);
                sb.append("\n");
            } while (i++ < stringInLineCount);
        }
    }

    private static void appendFirstLine(StringBuilder sb, int length) {
        sb.append("/");
        appendAsterisks(sb, length + 2);
        sb.append("\n");
    }

    private static void appendLastLine(StringBuilder sb, int length) {
        sb.append(" *");
        appendAsterisks(sb, length);
        sb.append("*/\n");
    }

    private static void appendAsterisks(StringBuilder sb, int count) {
        while (count-- > 0) {
            sb.append("*");
        }
    }

    private static void appendStartLine(StringBuilder sb) {
        sb.append(" *");
    }

    private static void appendEndLine(StringBuilder sb) {
        sb.append("*\n");
    }

    private static void appendEmptyLine(StringBuilder sb, int lineLength) {
        appendStartLine(sb);
        TextAlignment.NONE.appendAligned(sb, "", lineLength);
        appendEndLine(sb);
    }
}
