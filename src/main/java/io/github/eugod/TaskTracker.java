package io.github.eugod;

import io.github.eugod.view.TaskView;

import java.util.Arrays;

public class TaskTracker {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        TaskView.gettingArgs(args);
    }
}