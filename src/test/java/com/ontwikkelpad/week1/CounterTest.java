package com.ontwikkelpad.week1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CounterTest {

    @Test
    void increment_increases_value() {
        // Arrange
        Counter counter = new Counter();

        // Act
        counter.increment(5);

        // Assert
        assertEquals(5, counter.getValue());
    }

    @Test
    void decrement_decreases_value() {
        // Arrange
        Counter counter = new Counter();
        counter.increment(10);

        // Act
        counter.decrement(4);

        // Assert
        assertEquals(6, counter.getValue());
    }

    @Test
    void decrement_with_too_large_amount_throws_exception() {
        // Arrange
        Counter counter = new Counter();
        counter.increment(5);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            counter.decrement(10);
        });
    }

    @Test
    void increment_with_zero_throws_exception() {
        // Arrange
        Counter counter = new Counter();

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            counter.increment(0);
        });
    }
}
