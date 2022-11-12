package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    public static final String SHOPPINGTASK = "SHOPPINGTASK";
    public static final String PAINTINGTASK = "PAINTINGTASK";
    public static final String DRIVINGTASK = "DRIVINGTASK";
    public final Task makeTask(String taskClass){
        return switch (taskClass){
            case SHOPPINGTASK -> new ShoppingTask("ShoppingTask number 1","Shovels",2);
            case PAINTINGTASK -> new PaintingTask("PaintingTask number 1","purple","car");
            case DRIVINGTASK -> new DrivingTask("DrivingTask number 1","beach","bicycle");
            default -> null;
        };
    }
}
