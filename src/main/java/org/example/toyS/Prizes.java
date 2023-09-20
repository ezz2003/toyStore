package org.example.toyS;

import java.util.PriorityQueue;

public class Prizes {
    public PriorityQueue<Toy> prizes;

    public Prizes(PriorityQueue<Toy> prizes) {
        this.prizes = prizes;
    }
    public int size(){
        return prizes.size();
    }
    public void add(Toy prize){
        prizes.add(prize);
    }
    public Toy poll(){
        return prizes.poll();
    }
    public void clear(){
        prizes.clear();
    }
}
