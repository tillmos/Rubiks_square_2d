package Rubiks_cube.model;

import java.util.ArrayList;
import java.util.List;

public class Sor {
    private ArrayList<NegyzetModel> Elemek;

    public ArrayList<NegyzetModel> getElemek() {
        return Elemek;
    }

    public void setElemek(ArrayList<NegyzetModel> elemek) {
        this.Elemek = elemek;
    }

    public void rotate(IranyokEnum irany) {
        ArrayList<NegyzetModel> tmp = Elemek;
        if (irany == IranyokEnum.BALRA) {
            NegyzetModel plusOne =tmp.get(0);
            for (int i = 0; i < Elemek.size(); i ++) {
                if (i == Elemek.size() - 1) {
                    Elemek.set(i, plusOne);
                }
                else {
                    Elemek.set(i, tmp.get(i + 1));
                }
            }
        }
        if (irany == IranyokEnum.JOBBRA) {
            NegyzetModel plusOne = tmp.get(tmp.size() - 1);
            for (int i = Elemek.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    Elemek.set(i, plusOne);
                }
                else {
                    Elemek.set(i, tmp.get(i - 1));
                }

            }
        }
    }
    public Sor(ArrayList<NegyzetModel> elemek) {
        this.Elemek = elemek;
    }
}
