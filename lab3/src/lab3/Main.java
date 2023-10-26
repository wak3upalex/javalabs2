package lab3;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection <Chordal> srcCollection = Arrays.asList();       //TODO: вписать значения в коллекцию для теста

        //объявление коллекций для ежовых, манулов и рысей
        Collection <CommonHedgehog> collection1 = new ArrayList<>();
        Collection <Manul> collection2 = new ArrayList<>();
        Collection <Lynx> collection3 = new ArrayList<>();


        //вызов метода segregate

    }

    //реализация метода segregate
    public static void segregate(
            Collection<? extends Chordal> srcCollection,
            Collection<? super CommonHedgehog> collection1, //collection1 for Commonhedgehog and parents
            Collection<? super Manul> collection2,   //collection2 for Manuls and parents
            Collection<? super Lynx> collection3)
    {
        for (Chordal animal : srcCollection){
            if (animal instanceof CommonHedgehog) {
                collection1.add((CommonHedgehog) animal);
            }
            if (animal instanceof Manul){
                collection2.add((Manul) animal);
            }
            if (animal instanceof Lynx){
                collection3.add((Lynx) animal);
            }
        }

    }
}