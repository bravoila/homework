package com.techbow.homework.y2021.m09.cma;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache<K, V> {
//    Double linked ListNode
    private class DLL<K, V>{
        public K key;
        public V value;
        public DLL<K, V> prev;
        public DLL<K, V> next;
    }

    public DLL(K key, V value){
        this.key = key;
        this.value = value;
    }

    public void set(V value){
        this.value = value;
    }
    private int capacity;
    private int curSize;
    private HashMap<K, DLL<K, V>> map = new HashMap<K, DLL<K, V>>();
    private DLL<K, V> head;
    private DLL<K, V> tail;
    private DistributedCache<K, V> master;
    private Lock lock;

    public LRUCache(DistributedCache<K, V> master, int capacity){
        this.capacity = capacity;
        curSize = 0;
        head = new DLL<K, V>(null, null);
        tail = new DLL<K, V>(null, null);
        head.next = tail;
        tail.prev = head;
        this.master = master;
        this.lock = new ReentrantLock;
    }

    public V get(K key){
        lock.lock();
        V ret = null;
        if(map.containsKey(Key)){
            DLL<K, V> node = map.get(key);
            moveToHead(node);
            ret = node.value;
        }
        lock.unlock();
        return ret;
    }

    public void set(K key, V value) throws Exception {
        lock.lock();
        DLL<K, V> removeMe = null;
        if(!map.containsKey(Key)) {
            DLL<K, V> node = new DLL<K, V>(key, value);
            map.put(key, node);
            if (curSize < capacity) {
                curSize++;
            } else {
                // remove
                removeMe = tail.prev;
                removeMe.prev.next = tail;
                tail.prev = removeMe.prev;
                map.remove(removeMe.key);
            }
            moveToHead(node);
        } else{
            DLL<K, V> node = map.get(key);
            node.set(value);
            moveToHead(node);
        }

        if(removeMe != null){
            try{
                this.master.update(removeMe.key);
            } catch(Exception e){
                rollBack();
                throw new Exception("Fail to load balance!");
            } finally{
                lock.unlock();
            }
        }
        private void rollBack() {
            lock.lock();
            // roll back the recent ransaction;
            lock.unlock();
        }
        public void moveTohead(DLL<K, V> node){
            // remove
            DLL<K, V> prev = node.prev;
            DLL<K, V> next = node.next;
            if(prev != null) prev.next = next;
            if(next != null) next.prev = prev;

            // move to head
            node.next = head.next;
            head.next = node;
            node.prev = head;
            node.next.prev = node;
        }
    }
}
