package de.itemis.advent.day2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Password {

    Range range;
    Character character;
    String password;
}
