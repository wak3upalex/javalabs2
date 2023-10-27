package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        //collections to test programm
        Collection <Chordal> srcCollection1 = Arrays.asList(new CommonHedgehog(),
                new Manul(),
                new Lynx(),
                new CommonHedgehog(),
                new Lynx(),
                new Lynx());

        Collection <Chordal> srcCollection2 = Arrays.asList(new Manul(),
                new Manul(),
                new Feline());

        Collection <Chordal> srcCollection3 = Arrays.asList(new Lynx(), new Lynx());

        //объявление коллекций для ежовых, манулов и рысей
        Collection <CommonHedgehog> collection1 = new ArrayList<>();
        Collection <Manul> collection2 = new ArrayList<>();
        Collection <Lynx> collection3 = new ArrayList<>();


        //вызов метода segregate
        segregate(srcCollection1, collection1, collection2, collection3);
        System.out.println("Обыкновенных ежей: " + collection1.size()); //amount of CommonHedgehogs
        System.out.println("Манулы: "+ collection2.size());             //amount of Manul
        System.out.println("Рыси: " + collection3.size());              //amount of Lynx
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