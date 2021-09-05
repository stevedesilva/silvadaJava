package dsa.section8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ChunkArrayTest {
    @Test
    public void shouldReturnEmpty() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{}, 1);
        List<List<Integer>> expected = new ArrayList<>();
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnOneOneChunkList() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1}, 1);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1));
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnTwoOneChunkLists() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1, 2}, 1);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1));
        expected.add(List.of(2));
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnOneTwoChunkList() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1, 2}, 2);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2));
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnTwoTwoChunksLists() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1, 2, 3, 4}, 2);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2));
        expected.add(List.of(3, 4));
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnThreeTwoChunksLists() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1, 2, 3, 4, 5}, 2);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2));
        expected.add(List.of(3, 4));
        expected.add(List.of(5));
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnThreeThreeChunksLists() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 3);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2, 3));
        expected.add(List.of(4, 5, 6));
        expected.add(List.of(7, 8));
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnTwoFourChunksLists() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1, 2, 3, 4, 5}, 4);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2, 3, 4));
        expected.add(List.of(5));
        Assertions.assertEquals(expected, got);
    }

    @Test
    public void shouldReturnOneTenChunkLists() {
        ChunkArray chunkArray = new ChunkArray();
        List<List<Integer>> got = chunkArray.separateListIntoChunks(new int[]{1, 2, 3, 4, 5}, 10);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(1, 2, 3, 4, 5));
        Assertions.assertEquals(expected, got);
    }
}