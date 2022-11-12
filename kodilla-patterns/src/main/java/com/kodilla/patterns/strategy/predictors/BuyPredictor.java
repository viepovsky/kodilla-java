package com.kodilla.patterns.strategy.predictors;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import com.kodilla.patterns.strategy.predictors.BalancedPredictor;
import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

public sealed interface BuyPredictor permits AggressivePredictor, BalancedPredictor, ConservativePredictor {
    String predictWhatToBuy();
}
