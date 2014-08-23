package com.suthar.rentel.domain.strategy;

import com.suthar.rentel.domain.model.MovieType;

/**
 * Rakesh Kumar Suthar (rksuthar19@gmail.com)
 */
public class ChargeStrategy {
    public static double getCharge(MovieType movieType, final int daysRented) {
        if (movieType == MovieType.NEW) {                                //TODO remove magic number
            return daysRented < 2 ? 2 : (daysRented - 2) * .5 + 2;
        } else if (movieType == MovieType.CLASSICAL) {
            return daysRented / 7 * 3 + daysRented % 7 * .5;
        } else {
            return daysRented;
        }
    }
}
