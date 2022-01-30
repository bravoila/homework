package com.techbow.homework.y2021.m09.cma;

public class LC249 {
    public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> result = new ArrayList<>();
            Map<String, List<String>> map = new HashMap<>();
            for(String s: strings){
                String key = getBitMap(s);
                if(!map.containsKey(key))
                    map.put(key, new ArrayList<String>());
                map.get(key).add(s);
            }
            for(String key: map.keySet()){
                List<String> list = map.get(key);
                Collections.sort(list);
                result.add(list);
            }
            return result;
        }
        private String getBitMap(String s){
            int[] arr = new int[s.length()];
            arr[0] = 0;
            for(int i = 1; i < s.length(); i++){
                arr[i] = s.charAt(i)-s.charAt(0) < 0?
                        ((s.charAt(i)-s.charAt(0))%26 + 26): (s.charAt(i)-s.charAt(0));
            }
            return Arrays.toString(arr);
        }
    }

// string builder

    class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            HashMap<String, List<String>> dict = new HashMap<>();
            List<List<String>> res = new ArrayList<>();

            for(String string: strings){
                String mykey = hashKeys(string);
                if(dict.get(mykey) == null){
                    dict.put(mykey, new ArrayList<String>());
                };
                dict.get(mykey).add(string);
            }

            for(String key : dict.keySet()){
                res.add(dict.get(key));
            }
            return res;

        }

        private String hashKeys(String string){
            int myKeyVal = 0;
            StringBuilder myKey = new StringBuilder();
            for(int i = 0; i < string.length(); i++){
                int diff = string.charAt(i) - string.charAt(0);
                if(diff < 0){
                    diff += 26;
                }
                myKeyVal = myKeyVal * 10 + diff;
                myKey.append((char) myKeyVal);
            }
            return myKey.toString();
        }
    }
}
