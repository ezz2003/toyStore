package org.example.raffleView;

public class View implements IView{
    ViewRequest viewRequest;
    ViewOut viewShow;


    public View(ViewRequest viewRequest, ViewOut viewShow) {
        this.viewRequest = viewRequest;
        this.viewShow = viewShow;
    }

    public String inputNotEmptyString() {
        String value;
        while (true){
            value = viewRequest.inputString();
            if(!value.isEmpty()){
                return value;
            } else {
                this.viewShow.showString("Введённое значение не должно быть пустым." + TRYAGAINRU + "\n");
            }
        }
    }

    public int inputCheckedInt(String messade){
        int inputInt;
        while (true){
            this.viewShow.showString(messade);
            String value = inputNotEmptyString();
            if (!isDigit(value)){
                this.viewShow.showString("Введено не числовое значение. " + TRYAGAINRU + "\n");
            } else {
                inputInt = Integer.parseInt(value);
                if (inputInt < 0){
                    this.viewShow.showString("Значение не " +
                            "должно быть меньше  нуля! " + TRYAGAINRU +"\n");
                } else {
                    return inputInt;
                }
            }
        }
    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String inputString() {
        return viewRequest.inputString();
    }
}
