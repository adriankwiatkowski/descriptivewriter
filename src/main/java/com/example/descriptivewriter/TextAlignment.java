package com.example.descriptivewriter;

public enum TextAlignment {
    NONE {
        @Override
        public void appendAligned(StringBuilder sb, String text, int totalSpace) {
            LEFT.appendAligned(sb, text, totalSpace);
        }
    },
    LEFT {
        @Override
        public void appendAligned(StringBuilder sb, String text, int totalSpace) {
            // Append text on left side.
            sb.append(text);
            // Append white spaces to right to align text to left.
            appendWhiteSpace_numToTextLength(sb, getTextLength(text), totalSpace);
        }
    },
    RIGHT {
        @Override
        public void appendAligned(StringBuilder sb, String text, int totalSpace) {
            // Append white spaces to left to align text to right.
            appendWhiteSpace_numToTextLength(sb, getTextLength(text), totalSpace);
            // Append text on right side.
            sb.append(text);
        }
    },
    CENTER {
        @Override
        public void appendAligned(StringBuilder sb, String text, int totalSpace) {
            // Calculate count on left and right side
            // simply by dividing by 2.
            int diff            = totalSpace - getTextLength(text);
            int leftSpaceCount  = diff / 2;
            int rightSpaceCount = leftSpaceCount;

            // If number is not even add extra space to left side.
            if (diff % 2 == 1)
                ++leftSpaceCount;

            // Append white spaces to left side.
            appendWhiteSpace_count(sb, leftSpaceCount);
            // Append text to center.
            sb.append(text);
            // Append white spaces to right side.
            appendWhiteSpace_count(sb, rightSpaceCount);
        }
    };

    public abstract void appendAligned(StringBuilder sb, String text, int extraSpace);

    /**
     * Appends white spaces on <c>StringBuilder</c>.
     * Used to align text.
     *
     * @param length        number od digits or letters.
     * @param maxTextLength number of max digits or letters in text.
     * @throws IllegalArgumentException if length is grater than max length.
     */
    private static void appendWhiteSpace_numToTextLength(StringBuilder sb,
                                                         int length,
                                                         int maxTextLength) {
        int diff = maxTextLength - length;
        if (diff < 0)
            throw new IllegalArgumentException("Length cannot be grater than max length.");

        appendWhiteSpace_count(sb, diff);
    }

    private static void appendWhiteSpace_count(StringBuilder sb, int count) {
        while (count-- > 0) {
            sb.append(' ');
        }
    }

    /**
     * Uses String built in method to return length.
     *
     * @param text String text.
     * @return Returns length of text.
     */
    private static int getTextLength(String text) {
        return text.length();
    }
}
