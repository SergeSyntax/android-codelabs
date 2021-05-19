package com.example.roombasicsamplemine;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(WordEntity word);

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Query("SELECT * from word_table ORDER BY word ASC")
    LiveData<List<WordEntity>> getAllWords();

    @Query("SELECT * from word_table LIMIT 1")
    WordEntity[] getAnyWord();

    @Delete
    void deleteWord(WordEntity word);


    @Update
    void update(WordEntity... word);
}
