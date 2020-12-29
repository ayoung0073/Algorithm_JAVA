package com.may.datastructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

public class ListClientExampleTest {


    @Test
    public void testListClientExample() {
        ListClientExample lce = new ListClientExample();
        @SuppressWarnings("rawtypes")
        List list = lce.getList();
        assertThat(list, instanceOf(ArrayList.class) );
        // ArrayList : 테스트 통과
        // LinkedList : 테스트 실패
    }

}
