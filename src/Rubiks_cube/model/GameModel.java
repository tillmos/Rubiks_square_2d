package Rubiks_cube.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameModel {
    private int size;
    private RubikTabla Tabla;

    public RubikTabla getTabla() {
        return Tabla;
    }
    public GameModel(int size) {
        this.size = size;
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.ORANGE);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.WHITE);


        ArrayList<Sor> sorok = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<NegyzetModel> sorList = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                sorList.add(new NegyzetModel(colors.get(i)));
            }

            Sor sor = new Sor(sorList);
            sorok.add(sor);
        }
        RubikTabla tabla = new RubikTabla(sorok);
        this.Tabla = tabla;
    }

    public void generateRandomTable(int size){



        ArrayList<IranyokEnum> iranyok = new ArrayList<>();
        iranyok.add(0,IranyokEnum.FEL);
        iranyok.add(1,IranyokEnum.LE);
        iranyok.add(2,IranyokEnum.BALRA);
        iranyok.add(3,IranyokEnum.JOBBRA);

        for(int i = 0; i < 30; i++){
            Random rand = new Random();

            int rand_int1 = rand.nextInt(4);
            int rand_int2 = rand.nextInt(size-1);
            this.getTabla().rotate(iranyok.get(rand_int1),rand_int2);
        }



        //Testing the rotations
        /*
        this.getTabla().rotate(iranyok.get(1),3);
        this.getTabla().rotate(iranyok.get(3),3);
        this.getTabla().rotate(iranyok.get(3),3);
        this.getTabla().rotate(iranyok.get(3),3);
        this.getTabla().rotate(iranyok.get(3),3);
        this.getTabla().rotate(iranyok.get(3),3);
        this.getTabla().rotate(iranyok.get(2),3);
        this.getTabla().rotate(iranyok.get(2),3);
        this.getTabla().rotate(iranyok.get(1),3);
        this.getTabla().rotate(iranyok.get(2),1);
        this.getTabla().rotate(iranyok.get(1),2);

         */



    }

    public void rotate(IranyokEnum irany, int index) {
        this.Tabla.rotate(irany, index);
    }

}