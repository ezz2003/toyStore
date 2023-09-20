package org.example;

import org.example.raffleView.IView;
import org.example.raffleView.View;
import org.example.toyS.Prizes;
import org.example.toyS.Toy;
import org.example.toyS.ToyS;

public class Raffle implements IView {

    View view;
    ToyS toyS;
    Prizes prizeS;

    public Raffle(View view, ToyS toyS, Prizes prizeS) {
        this.toyS = toyS;
        this.view = view;
        this.prizeS = prizeS;
    }

    //    private static ArrayList<Toy> toys = new ArrayList<>();
//    private static PriorityQueue<Toy> prizes = new PriorityQueue<>();
    private static int idCounter = 0;

    public void addToy() {
        view.showString("Введите название игрушки: ");
        String title = this.view.inputNotEmptyString();
        int frequency = view.inputCheckedInt("Введите Вероятность выпадения: ");
        Toy toy = new Toy(idCounter, title, frequency);
        if (!toyS.contains(toy)) {     //  || toys.size() == 0
            idCounter++;
            toyS.add(toy);
            view.showString("\nНовая игрушка добавлена в розыгрыш.\n");
        } else {
            view.showString("\nЭта игрушка уже участвует в розыгрыше."
                    + view.TRYAGAINRU + "\n");
        }
    }
    public void setFrequency() {
        int selectedId = view.inputCheckedInt("Введите ID игрушки: ");
        if (selectedId >= 0 && selectedId < toyS.size()) {
            String message = String.format("Для игрушки %s назначена частота выпадения %d\n",
                    toyS.get(selectedId).getToyTitle(), toyS.get(selectedId).getToyWinningFrequency());
            view.showString(message);
            int newFrequency = view.inputCheckedInt("Введите новую частоту выпадения: ");
            toyS.get(selectedId).setToyWinningFrequency(newFrequency);
            view.showString("Частота выпадения игрушки успешно изменена.\n");
        } else {
            view.showString("В призовом фонде нет игрушки с таким ID. " + view.TRYAGAINRU + "\n");
        }
    }
    public void printAllToys(){
        view.showString(toyS.getAllInfo());
    }
    public void saveAllToys(){
        view.saveResult(toyS.getAllInfo(),"allToys.txt", false);
    }
    public void raffle() {
        if (toyS.size() >= 2) {
            Toy prize = toyS.getPrize();
            String message = String.format("Ваш приз: %s", prize.getToyTitle());
            view.showString(message);
            view.saveResult(prize.getInfo(), "gameResult.txt", true);
        } else {
            view.showString("Для начала розыгрыша в призовом " +
                    "фонде должно быть не менее двух игрушек."
                    + view.TRYAGAINRU + "\n");
        }
    }
}
