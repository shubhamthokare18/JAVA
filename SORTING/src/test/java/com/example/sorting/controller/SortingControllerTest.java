package com.example.sorting.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SortingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSort() throws Exception {
        String json = "{\"algorithm\":\"bubble\",\"numbers\":[3,1,2]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("bubble"))
                .andExpect(jsonPath("$.sortedNumbers").isArray());
    }

    @Test
    void testGetAlgorithms() throws Exception {
        mockMvc.perform(get("/api/sorting/algorithms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0]").value("bubble"));
    }

    @Test
    void testSortWithMergeSort() throws Exception {
        String json = "{\"algorithm\":\"merge\",\"numbers\":[8, 3, 1, 7, 4]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("merge"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(1, 3, 4, 7, 8)));
    }

    @Test
    void testSortWithQuickSort() throws Exception {
        String json = "{\"algorithm\":\"quick\",\"numbers\":[9, 2, 6, 1, 5]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("quick"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(1, 2, 5, 6, 9)));
    }

    @Test
    void testSortWithHeapSort() throws Exception {
        String json = "{\"algorithm\":\"heap\",\"numbers\":[4, 10, 3, 5, 1]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("heap"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(1, 3, 4, 5, 10)));
    }

    @Test
    void testSortWithCountingSort() throws Exception {
        String json = "{\"algorithm\":\"counting\",\"numbers\":[4, 2, 2, 8, 3, 3, 1]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("counting"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(1, 2, 2, 3, 3, 4, 8)));
    }

    @Test
    void testSortWithRadixSort() throws Exception {
        String json = "{\"algorithm\":\"radix\",\"numbers\":[170, 45, 75, 90, 802, 24, 2, 66]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("radix"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(2, 24, 45, 66, 75, 90, 170, 802)));
    }

    @Test
    void testSortWithShellSort() throws Exception {
        String json = "{\"algorithm\":\"shell\",\"numbers\":[12, 34, 54, 2, 3]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("shell"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(2, 3, 12, 34, 54)));
    }

    @Test
    void testSortWithSelectionSort() throws Exception {
        String json = "{\"algorithm\":\"selection\",\"numbers\":[64, 25, 12, 22, 11]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("selection"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(11, 12, 22, 25, 64)));
    }

    @Test
    void testSortWithInsertionSort() throws Exception {
        String json = "{\"algorithm\":\"insertion\",\"numbers\":[9, 5, 1, 4, 3]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("insertion"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(1, 3, 4, 5, 9)));
    }

    @Test
    void testSortEmptyArray() throws Exception {
        String json = "{\"algorithm\":\"bubble\",\"numbers\":[]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("bubble"))
                .andExpect(jsonPath("$.sortedNumbers").isEmpty());
    }

    @Test
    void testSortSingleElement() throws Exception {
        String json = "{\"algorithm\":\"bubble\",\"numbers\":[42]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("bubble"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(42)));
    }

    @Test
    void testSortWithNegatives() throws Exception {
        String json = "{\"algorithm\":\"merge\",\"numbers\":[-3, 5, -1, 0, 2]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.algorithm").value("merge"))
                .andExpect(jsonPath("$.sortedNumbers").value(List.of(-3, -1, 0, 2, 5)));
    }

    @Test
    void testSortCountingWithNegativesThrows() throws Exception {
        String json = "{\"algorithm\":\"counting\",\"numbers\":[-1, 2, 3]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"));
    }

    @Test
    void testSortRadixWithNegativesThrows() throws Exception {
        String json = "{\"algorithm\":\"radix\",\"numbers\":[-5, 10, 3]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"));
    }

    @Test
    void testSortInvalidAlgorithm() throws Exception {
        String json = "{\"algorithm\":\"unknown\",\"numbers\":[1,2]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Bad Request"));
    }

    @Test
    void testSortBlankAlgorithm() throws Exception {
        String json = "{\"algorithm\":\"\",\"numbers\":[1,2]}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSortNullNumbers() throws Exception {
        String json = "{\"algorithm\":\"bubble\"}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSortEmptyNumbers() throws Exception {
        String json = "{\"algorithm\":\"bubble\",\"numbers\":null}";
        mockMvc.perform(post("/api/sorting/sort")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest());
    }
}
