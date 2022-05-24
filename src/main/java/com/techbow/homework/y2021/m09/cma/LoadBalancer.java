package com.techbow.homework.y2021.m09.cma;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoadBalancer<K, V> {
    private ConcurrentHashMap<K, LRUCache<K, V>> map;
    private LRUCache<K, V>[] caches;
    private int token, size;
    private Lock lock;

    public LoadBalancer(LRUCache<K, V>[] caches){
        this.map = new ConcurrentHashMap<K, LRUCache<K, V>>();
        this.caches = caches;
        this.token = 0;
        this.size = caches.length;
        this.lock = new ReentrantLock();
    }

    public LRUCache<K, V> assign(K key){
        lock.lock();
        LRUCache<K, V> ret = null;
        if(map.containsKey(key)){
            ret = map.get(key);
        } else{
            ret = caches[token];
            map.put(key, ret);
            token = (token + 1) % size;
        }

        lock.unlock();
        return ret;
    }

    public void update(K removedKey) throws Exception{
        lock.lock();
        try{
            map.remove(removedKey);
        } catch (Exception e){
            throw new Exception("Failed to update. Should roll back!");
        } finally{
            lock.unlock();
        }
    }
}
