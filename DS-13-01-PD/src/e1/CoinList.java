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
public class CoinList {
    private final List<Coin> lista;
    
    public CoinList(){
        this.lista = new ArrayList<>();
    }
    
    public int total(){
        int suma = 0;
        for (Coin c : this.lista) suma+=c.getValor();
        return suma;
    }
    
    public void insert(Coin c){
        lista.add(c);
    }
    
    public void vaciar(){
        lista.clear();
    }
    
    public List<Coin> copy(){
      ArrayList<Coin> l = new ArrayList();
      l.addAll(this.lista);
      return   l;
    }
   
}
