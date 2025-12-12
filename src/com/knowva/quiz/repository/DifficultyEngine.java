package com.knowva.quiz.repository;

public class DifficultyEngine {
    /**
     * Service which calculates the difficulty of
     * the following question to select.
     */
    private static final int MAX_DIFFICULTY = 10;
    private static final int MIN_DIFFICULTY = 0;

    public int calculateNextDifficulty(int current_level, boolean isCorrect) {
        int final_level = isCorrect ? current_level++ : current_level - 2;
        if (final_level > MAX_DIFFICULTY) {
            final_level = MAX_DIFFICULTY;
        }
        if (final_level < MIN_DIFFICULTY) {
            final_level = MIN_DIFFICULTY;
        }
        return final_level;
    }

}
