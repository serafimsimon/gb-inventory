package ru.gb.inventory.department.api;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DepartmentError {
    private List<String> messages;
    private Date date;

    public List<String> getMessages() {
        return messages;
    }

    public DepartmentError(List<String> messages) {
        this.messages = messages;
        this.date = new Date();
    }

    public DepartmentError(String message) {
        this(List.of(message));
    }

    public DepartmentError(String... message) {
        this(Arrays.asList(message));
    }
}
