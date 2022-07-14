package com.myapplicationdev.android.dbrevision;

import androidx.annotation.NonNull;

public class Note {
    private int id;
    private String content;
    private String priority;

    public Note(int id, String content, String priority) {
        this.id = id;
        this.content = content;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getPriority() {
        return priority;
    }

    //What's here?

}
