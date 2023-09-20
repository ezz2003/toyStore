package org.example;

import org.example.raffleView.View;
import org.example.raffleView.ViewRequest;
import org.example.raffleView.ViewOut;
import org.example.toyS.Toy;
import org.example.toyS.ToyS;
import org.example.toyS.Prizes;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void onStartButton(Raffle raffle, View view) {
        while (true) {
            view.showString("\nMain menu:\n");
            view.showString("1 - Добавить новую игрушку в призовой фонд. " +
                    "\t\t 2 - Изменить частоту выпадения определённой игрушки.\n");
            view.showString("3 - Провести розыгрыш и сохранить результаты. " +
                    "\t\t 4 - распечатать весь призовой фонд\n");
            view.showString("5 - Сохранить в файл призовой фонд. \t\t\t\t 9 - Выход из программы.\n");
            int selection = view.inputCheckedInt("ввод->");
            switch (selection) {
                case 1 -> raffle.addToy();
                case 2 -> raffle.setFrequency();
                case 3 -> raffle.raffle();
                case 4 -> raffle.printAllToys();
                case 5 -> raffle.saveAllToys();
                case 9 -> {
                    view.showString("Bye.");
                    System.exit(0);
                }
                default -> view.showString("Непредвиденная команда. " + view.TRYAGAINRU + "\n");
            }
        }
    }

    public static void main(String[] args) {
        ViewRequest viewRequest = new ViewRequest();
        ViewOut viewShow = new ViewOut();
        View view = new View(viewRequest, viewShow);
        PriorityQueue<Toy> prizes = new PriorityQueue<>();
        Prizes prizeS = new Prizes(prizes);
        ArrayList<Toy> toys = new ArrayList<>();
        ToyS toyS = new ToyS(toys, prizeS);
        Raffle raffle = new Raffle(view, toyS, prizeS);

        onStartButton(raffle, view);
    }
}