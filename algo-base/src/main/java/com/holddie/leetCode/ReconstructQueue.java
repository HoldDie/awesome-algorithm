package com.holddie.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;

public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        if (0 == people.length || 0 == people[0].length) {
            return new int[0][0];
        }
        // 按照身高降序 K升序排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> list = new ArrayList<>();
        // K值定义为 排在h前面且身高大于或等于h的人数
        // 因为从身高降序开始插入，此时所有人身高都大于等于h
        // 因此K值即为需要插入的位置
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][] {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
        int[][] sort = new int[][] {{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}};
        Assertions.assertThat(reconstructQueue(people)).isEqualTo(sort);
    }
}
