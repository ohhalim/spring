package com.tobyspring.hellospring;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SortTest {
    Sort sort;
    
    @BeforeEach
    void beforeEach() {
        sort = new Sort();

    }
    @Test
    void Sort(){
        // given

        // when
        List<String> list = sort.sortByLength(Arrays.asList("aa", "b"));
        // then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa"));
    }
    @Test
    void sort3Items() {
        // given
        // when
        List<String> list = sort.sortByLength(Arrays.asList("aa", "ccc", "b"));

        // then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("b", "aa", "ccc"));
    }

    @Test
    void sortAlreadySorted() {
        // given
        // when
        List<String> list = sort.sortByLength(Arrays.asList("b", "aa", "cc"));

        // then
        Assertions.assertThat(list).isEqualTo(Arrays.asList("c", "aa", "ccc"));
    }
}
