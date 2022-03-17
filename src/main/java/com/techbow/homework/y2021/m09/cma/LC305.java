package com.techbow.homework.y2021.m09.cma;

public class LC305 {
    class Solution {
        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            List<Integer> res = new ArrayList<Integer>();
            if(positions == null) return res;

            int row = m;
            int col = n;
            UnionFind uf = new UnionFind(row, col);
            for(int[] point : positions){
                int i = point[0];
                int j = point[1];
                int p = uf.index(i,j);
                uf.addIsland(p);

                List<int[]> neis = getNeighbour(i, j, row, col);
                for(int[] nei : neis){
                    int q = uf.index(nei[0], nei[1]);
                    if(uf.isIsland(q) && ! uf.find(p,q)){ // if not in the same group
                        uf.union(p,q); // then union
                    }
                }
                res.add(uf.size);
            }
            return res;
        }

        private List<int[]> getNeighbour(int i, int j, int row, int col){
            List<int[]> res = new ArrayList<int[]>();
            if(i - 1 >= 0){
                int[] one = new int[2];
                one[0] = i - 1;
                one[1] = j;
                res.add(one);
            }

            if(i + 1 < row){
                int[] one = new int[2];
                one[0] = i + 1;
                one[1] = j;
                res.add(one);
            }

            if(j - 1 >= 0){
                int[] one = new int[2];
                one[0] = i;
                one[1] = j - 1;
                res.add(one);
            }

            if(j + 1 < col){
                int[] one = new int[2];
                one[0] = i;
                one[1] = j + 1;
                res.add(one);
            }
            return res;
        }

    }

    class UnionFind{
        public int size, row, col;
        public int[] ids, sz;

        public UnionFind(int row, int col){
            this.size = 0;
            this.row = row;
            this.col = col;
            int len = row * col;
            ids = new int[len];
            sz = new int[len];

            for(int i = 0; i < len; i++){
                ids[i] = -1;
                sz[i] = 1;
            }
        }

        public boolean find(int p, int q){
            return root(p) == root(q);
        }

        public void union(int p, int q){
            int rootP = root(p);
            int rootQ = root(q);
            if(sz[rootP] < sz[rootQ]){
                union(q,p);
            } else{
                ids[rootQ] = rootP;
                sz[rootP] += sz[rootQ];
                this.size--;
            }
        }

        private int root(int p){
            int tempP = p;
            while(ids[p] != p){
                ids[p] = ids[ids[p]]; //p.parent = p.parent.parent
                p = ids[p];
            }
            ids[tempP] = p;
            return p;
        }

        public int index(int i, int j){
            return i* col + j;
        }

        public void addIsland(int p){
            if(ids[p] == -1){
                ids[p] = p;
                this.size++;
            }
        }

        public boolean isIsland(int p){
            return ids[p] != -1;
        }
    }
}
