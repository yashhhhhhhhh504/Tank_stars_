package com.gamesfromscratch;

// Polymorphism
public class SelectTank {
    private static Tank tank;
    public static Tank Select(int i){
        if(i == 1 ){
            tank = new Abramas();
        } else if (i == 2) {
            tank = new Frost();
        } else if (i== 3) {
            tank = new Buratino();
        }
        return tank;
    }
}
