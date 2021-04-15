package com.redislabs.mesclun.search;

import lombok.Data;

@Data
public class Suggestion<V> {

    private V string;
    private Double score;
    private V payload;

}
