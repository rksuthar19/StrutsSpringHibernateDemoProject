package com.suthar.rentel.domain.strategy;

import com.suthar.rentel.domain.model.MovieType;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class RewardPointsStrategy {
    public static double getRewardPoints(MovieType movieType, final int daysRented) {
        if (movieType == MovieType.NEW) {
            return daysRented * 2;
        } else
            return 3 + daysRented * .5; //TODO check from story
    }
}
