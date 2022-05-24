package com.techbow.homework.y2021.m09.cma;

import com.techbow.homework.y2021.m09.QiyueWang.LC146LRUCache;

public class DistributedCache<K, V> {
    private static final int MAX_SIZE = 10, SINGLE_CACHE_SIZE = 256;
    private LRUCache<K, V>[] caches;
    private LoadBalancer<K, V> loadBalancerr;

    public DistributedCache(){
        this.caches = (LRUCache<K, V>[]) new LRUCache[MAX_SIZE];
        for(int i = 0; i < this.caches.length; i++){
            caches[i] = new LRUCache<K, V>(this, SINGLE_CACHE_SIZE);
        }
        this.loadBalancer = new LoadBalancer<K, V>(caches);
    }

    public V get(K key){
        LRUCache<K, V> cache = loadBalancer.get(key);

        if(cache == null){
            return null;
        } else{
            return cache.get(key);
        }
    }

    public void set(K key, V value) throws Exception{
        LRUCache<K, V> cache = loadBalancer.assign(key);

        if(cache == null){
            throw new Exception("Fail to load balance!");
        } else{
            cache.set(key, value);
        }
    }

    public void update(K removedKey) throws Exception{
        this.loadBalancer.update(removedKey);
    }
}
