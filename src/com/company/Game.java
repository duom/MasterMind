package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    boolean ganador = true;
    int totalIntentos;

    ArrayList<Integer> combinacionServer = new ArrayList<>();
    int colores[] = {1, 2, 3, 4};
    ArrayList<Integer> combinacionUsuario = new ArrayList<>();

    ArrayList<Integer> comprobacion = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void play(){
        totalIntentos=5;
        generarRandom();
        init();
        check();
    }


    public void init() {
        System.out.println(combinacionServer);
        System.out.println("Elige una combinación:");
        System.out.println("1= Rojo, 2= Azul, 3= Verde, 4= Amarillo");

        System.out.println("Primer color");
        int uno = scanner.nextInt();
        combinacionUsuario.add(uno);

        System.out.println("Segundo color");
        int dos = scanner.nextInt();
        combinacionUsuario.add(dos);

        System.out.println("Tercer color");
        int tres = scanner.nextInt();
        combinacionUsuario.add(tres);

        System.out.println("Cuarto color");
        int cuatro = scanner.nextInt();
        combinacionUsuario.add(cuatro);

    }

    public void generarRandom() {

        for (int i = 0; i < 4; i++) {
            int x = (int) Math.floor(Math.random() * 4);
            combinacionServer.add(Integer.valueOf(colores[x]));
        }
    }
//
    public void check() {

        //Bucle para comparar lo que el usuario ha introducido con el resultado final

    do{
        for (int i = 0; i < combinacionServer.size(); i++) {
            if (combinacionServer.get(i) == combinacionUsuario.get(i)) {
            comprobacion.add(combinacionServer.get(i));
            }
         }
         if (comprobacion.size() == 4) {
            System.out.println("YOU WIN :)");
            System.out.println(combinacionServer);
            ganador = false;

         } else {
            System.out.println("YOU LOSE :( " + "Te quedan "+ totalIntentos+ " intentos");
            comprobacion.clear();
            combinacionUsuario.clear();
            totalIntentos--;
            if(totalIntentos>=0){
                init();
            }else{
                System.out.println("GAME OVER");
                System.out.println("Te has quedado sin intentos");
                System.out.println("La combinación ganadora era:");
                System.out.println(combinacionServer);
                ganador = false;

            }

         }

    }while(ganador);
    }
}





