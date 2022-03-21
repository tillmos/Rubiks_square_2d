package Rubiks_cube.model;

import java.util.ArrayList;

public class RubikTabla {
    private ArrayList<Sor> Sorok;

    public ArrayList<Sor> getSorok() {
        return Sorok;
    }
    public void setSorok(ArrayList<Sor> sorok) {
        this.Sorok = sorok;
    }

    public RubikTabla(ArrayList<Sor> sorok) {
        this.Sorok = sorok;
    }

    public void rotate(IranyokEnum irany, int index) {
        if(irany == IranyokEnum.BALRA) {
            Sorok.get(index).rotate(irany);
        }
        if(irany == IranyokEnum.JOBBRA){
            Sorok.get(index).rotate(irany);
        }
        ArrayList<Sor> tmp = (ArrayList<Sor>) Sorok.clone();
        NegyzetModel plusOne;
        if(irany == IranyokEnum.FEL){
            plusOne = Sorok.get(0).getElemek().get(index);
            for(int j = 0; j < Sorok.size(); j++){
                if (j == Sorok.size() - 1){
                    Sorok.get(j).getElemek().set(index, plusOne);
                }
                else {
                    Sorok.get(j).getElemek().set(index, tmp.get(j + 1).getElemek().get(index));
                }
            }
        }

        if(irany == IranyokEnum.LE){
            plusOne = Sorok.get(Sorok.size() - 1).getElemek().get(index);
            for(int j = Sorok.size() - 1; j >= 0; j--){
                if (j == 0){
                    Sorok.get(j).getElemek().set(index, plusOne);
                }
                else {
                    Sorok.get(j).getElemek().set(index, tmp.get(j - 1).getElemek().get(index));
                }
            }
        }
    }
}
