package org.example.raffleView;

import java.util.Scanner;

public interface IViewReqest extends IViewBace{
    default String inputString(){
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }
}
