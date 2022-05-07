package com.techbow.homework.y2021.m09.cma;

public class LC622 {
    class MyCircularQueue {
        private int[] array;
        private int head;
        private int tail;
        private int capacity;
        private int size;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.size = 0;
            this.array = new int[k];
            this.head = 0;
            this.tail = 0;
        }

        public boolean enQueue(int value) {
            if(this.size == this.capacity){
                return false;
            }
            // this.tail %= this.capacity;
            this.array[this.tail] = value;
            this.tail = (this.tail + 1) % this.capacity;//
            this.size++;
            return true;
        }

        public boolean deQueue() {
            if(this.size == 0){
                return false;
            }
            int res = array[this.head];
            this.head = (this.head + 1) % this.capacity;
            this.size--;
            return true;
        }

        public int Front() {
            if(this.size == 0){
                return -1;
            }
            return this.array[this.head];
        }

        public int Rear() {
            if(this.size == 0){
                return -1;
            }
            int tail = (this.head + this.size -1) % this.capacity;
            // System.out.println(tail);
            // System.out.println(this.tail);
            return this.array[tail]; // 不能用this.tail,因为this.tail按老刘那么写，已经是下一个位置了
            // 但如果按其他写法，还要考虑越界的问题，不如直接用head和size得到当前tail位置
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size == this.capacity;
        }
    }
}
