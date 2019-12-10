/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.List;

/**
 *
 * @author Brais
 */
public class Deposito {
    private int[] monedas = new int[8];
    
    //inicializase o deposito con 100 monedas de cada
    public Deposito() {
        for(int i=0;i<8;i++) this.monedas[i]=250;
    }
    
    public boolean check(int v,int n){
        return monedas[v]>=n;
    }
    
    public void ingreso(List<Coin> l){
        for (Coin c : l) this.modificarDeposito(c.getValor(),1);
    }
    
    public void retirada(List<Coin> l){
        for (Coin c : l) this.modificarDeposito(c.getValor(),-1);
    }
    
    
    private void modificarDeposito(int v,int x){
        int i;
        switch (v){
            case 200 : i=0; break;
            case 100 : i=1; break;
            case 50 : i=2; break;
            case 20 : i=3; break;
            case 10 : i=4; break;
            case 5 : i=5; break;
            case 2 : i=6; break;
            default : i=7; break;
        }
        this.monedas[i]+=x;
    }
    
    
}
