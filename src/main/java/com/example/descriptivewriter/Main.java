package com.example.descriptivewriter;

import static com.example.descriptivewriter.DescriptiveWriter.buildDescriptiveText;

public class Main {

    public static void main(String[] args) {
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.CENTER));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.LEFT));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.RIGHT));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i",
                                                TextAlignment.CENTER,
                                                5));
        System.out.println(buildDescriptiveText("i=i+1;",
                                                "Add one to i\nAdd one to i\nAdd\none\nto\ni",
                                                TextAlignment.CENTER));
        System.out.println(buildDescriptiveText("i=i+1;\ni=i+1;",
                                                "Add one to i\nAdd one to i\nAdd\none\nto\ni",
                                                TextAlignment.CENTER));
    }
}
