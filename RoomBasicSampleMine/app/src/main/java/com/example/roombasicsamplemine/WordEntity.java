package com.example.roombasicsamplemine;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class WordEntity {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private final String mWord;

    public WordEntity(@NonNull String word) {this.mWord = word;}

    public String getWord(){return this.mWord;}
}