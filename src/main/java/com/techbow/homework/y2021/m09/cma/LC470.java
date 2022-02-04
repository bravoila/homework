package com.techbow.homework.y2021.m09.cma;

public class LC470 {
    /**
     * The rand7() API is already defined in the parent class SolBase.
     * public int rand7();
     * @return a random integer in the range 1 to 7
     */
    class Solution extends SolBase {
        public int rand10() {
            // Idea: rand7() -> rand49() -> rand40() -> rand10()
            int result = 40;
            while (result >= 40) {result = 7 * (rand7() - 1) + (rand7() - 1);}
            return result % 10 + 1;
        }
    }
}
