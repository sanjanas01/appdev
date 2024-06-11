package com.example.vit.javaeg;

public class Demolambda {
    public static void main(String[] args)
    {
        Msgimp mg=new Msgimp();
        mg.sendmsg();

        Imsg mg1=()->{System.out.println("kjsefkj");};
        mg1.sendmsg();
    }

}
