package org.example.toyS;

import java.util.ArrayList;
import java.util.Random;

public class ToyS {
    public ArrayList<Toy> toyS;
    private Prizes prizes;
    public ToyS(ArrayList<Toy> toyS, Prizes prizes) {
        this.toyS = toyS;
        this.prizes = prizes;
    }
    private void findPrize(){
        Random random = new Random();
        for (Toy toy : toyS) {
            for (int i = 0; i <= toy.getToyWinningFrequency(); i++){
                Toy prize = new Toy(toy.getToyId(), toy.getToyTitle(), random.nextInt(1, 10));
                prizes.add(prize);
            }
        }
    }
    public Toy getPrize(){
        prizes.clear();
        findPrize();
        Toy prize = prizes.poll();
        toyS.remove(prize);
        return prize;
    }
    public String getAllInfo(){
        StringBuilder out = new StringBuilder();
        for(Toy toy : toyS){
            out.append(toy.getInfo());
            out.append("\n");
        }
        return out.toString();
    }

    public boolean contains(Toy toy) {
        return toyS.contains(toy);
    }

    public void add(Toy toy){
        toyS.add(toy);
    }

    public int size(){
        return toyS.size();
    }

    public Toy get(int id){
        return toyS.get(id);
    }



}
