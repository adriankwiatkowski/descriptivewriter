package com.example.descriptivewriter;

import com.example.logcolor.color.models.AnsiColor;
import com.example.logcolor.printers.PrintableManager;
import com.example.logcolor.printers.Printer;
import com.example.logcolor.printers.models.PrintableType;

import static com.example.descriptivewriter.DescriptiveWriter.buildDescriptiveText;

public class Main {

    public static void main(String[] args) {
        PrintableManager.getInstance().setNightTheme();
        PrintableManager.getInstance().setPrintable(PrintableType.WINDOW);
        Printer.println(
                AnsiColor.ANSI_BRIGHT_BLUE,
                AnsiColor.ANSI_BG_BLACK,
                buildDescriptiveText("i=i+1;",
                                     "Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i",
                                     TextAlignment.CENTER,
                                     60));
        Printer.println(
                AnsiColor.ANSI_BRIGHT_BLUE,
                AnsiColor.ANSI_BG_BLACK,
                buildDescriptiveText("i=i+1;",
                                     "Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i",
                                     TextAlignment.LEFT,
                                     60));
        Printer.println(
                AnsiColor.ANSI_BRIGHT_BLUE,
                AnsiColor.ANSI_BG_BLACK,
                buildDescriptiveText("i=i+1;",
                                     "Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i Add one to i",
                                     TextAlignment.RIGHT,
                                     60));
        Printer.println(
                AnsiColor.ANSI_BRIGHT_BLUE,
                AnsiColor.ANSI_BG_BLACK,
                buildDescriptiveText("i=i+1;\ni=i+1;",
                                     "Add one to i\nAdd one to i\nAdd\none\nto\ni",
                                     TextAlignment.CENTER));
    }
}
