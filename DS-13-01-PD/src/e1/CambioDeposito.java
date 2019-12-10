/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brais
 */
public class CambioDeposito implements Cambio {
    private Deposito deposito;
    
    public CambioDeposito(Deposito d){
        this.deposito=d;
    }
    
    @Override
    public List<Coin> cambiar(CoinList x , int sobrante){
        ArrayList<Coin> volto = new ArrayList<>();
        int[] monedas = new int[8];
        for (int i=0; i<8;i++) monedas[i]=0;
        
        while (sobrante>0) {
            if(sobrante>199 && deposito.check(0, monedas[0]+1)) {sobrante-=200; monedas[0]+=1;volto.add(new Coin(200));}
            else if(sobrante>99 && deposito.check(1, monedas[1]+1)) {sobrante-=100; monedas[1]+=1;volto.add(new Coin(100));}
            else if(sobrante>49 && deposito.check(2, monedas[2]+1)) {sobrante-=50; monedas[2]+=1;volto.add(new Coin(50));}
            else if(sobrante>19 && deposito.check(3, monedas[3]+1)) {sobrante-=20; monedas[3]+=1;volto.add(new Coin(20));}
            else if(sobrante>9 && deposito.check(4, monedas[4]+1)) {sobrante-=10; monedas[4]+=1;volto.add(new Coin(10));}
            else if(sobrante>4 && deposito.check(5, monedas[5]+1)) {sobrante-=5; monedas[5]+=1;volto.add(new Coin(5));}
            else if(sobrante>1 && deposito.check(6, monedas[6]+1)) {sobrante-=2; monedas[6]+=1;volto.add(new Coin(2));}
            else if(deposito.check(7, monedas[7]+1)) {sobrante-=1; monedas[7]+=1;volto.add(new Coin(1));}
            else return null;
        }
        return volto;
    }
    
}
