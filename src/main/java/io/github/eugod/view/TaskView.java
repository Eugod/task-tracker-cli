package io.github.eugod.view;

import java.util.Arrays;

public class TaskView {
    public static void gettingArgs(String[] args) {
        switch (args[0].toLowerCase()) {
            case "add":
                System.out.println("Adding" + Arrays.toString(args));
                break;
            case "update":
                System.out.println("Updating" + Arrays.toString(args));
                break;
            case "delete":
                System.out.println("Deleting" + Arrays.toString(args));
                break;
            case "mark-in-progress":
                System.out.println("Marking in progress" + Arrays.toString(args));
                break;
            case "mark-done":
                System.out.println("Marking done" + Arrays.toString(args));
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}
