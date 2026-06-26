package com.example.sorting.service;

import com.example.sorting.dto.SortRequest;
import com.example.sorting.dto.SortResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SortingServiceTest {

    @Autowired
    private SortingService service;

    @Test
    void testSortValid() {
        SortRequest request = new SortRequest();
        request.setAlgorithm("bubble");
        request.setNumbers(new int[]{3, 1, 2});
        SortResponse response = service.sort(request);
        assertEquals("bubble", response.getAlgorithm());
        assertArrayEquals(new int[]{3, 1, 2}, response.getOriginalNumbers());
        assertArrayEquals(new int[]{1, 2, 3}, response.getSortedNumbers());
        assertTrue(response.getExecutionTimeInNanos() > 0);
    }

    @Test
    void testSortInvalidAlgorithm() {
        SortRequest request = new SortRequest();
        request.setAlgorithm("invalid");
        request.setNumbers(new int[]{1, 2});
        assertThrows(IllegalArgumentException.class, () -> service.sort(request));
    }
}
