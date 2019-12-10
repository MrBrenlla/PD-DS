/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Brais
 */
public class CambioSimple implements Cambio {
    
    private static final CambioSimple instancia = new CambioSimple();
    
    private CambioSimple(){}
    
    public static CambioSimple get(){
        return instancia;
    }
    
    @Override
    public List<Coin> cambiar(CoinList introducido, int sobrante){
        List<Coin> l = introducido.copy();
        int v[]=new int[l.size()];
        for (int i = 0; i<l.size();i++) v[i]=l.get(i).getValor();
        return calcularTabla(v,sobrante);
    }
    
    private List<Coin> calcularTabla(int v[],int sob){
        int tabla[][] = new int[v.length][sob];
        for(int i=0;i<sob;i++) if (i+1<v[0]) tabla[0][i]=0;
        else tabla[0][i]=v[0];
        
        for(int i = 1; i<v.length;i++)
            for (int j = 0; j<sob; j++){
                if (j+1<=v[i]) tabla[i][j]=tabla[i-1][j];
                else{
                    int arriba=tabla[i-1][j];
                    int outro=tabla[i-1][j-v[i]]+v[i];
                    if (outro>arriba && outro<sob) tabla[i][j]=outro;
                    else tabla[i][j]=arriba;
                }
            }
        
        return decod(v,tabla,tabla.length,tabla[1].length);
    }
    
    private List<Coin> decod(int v[],int tabla[][], int filas , int col){
        List<Coin> l = new ArrayList<>();
        int j=col-1;
        
        for (int i=filas-1 ; i>0 && j>-1; i--)
            if(tabla[i][j]!=tabla[i-1][j]){
                j-=v[i];
                l.add(new Coin(v[i]));
            }
        
        if(j>-1 && tabla[0][j]>0)l.add(new Coin(v[0]));
        return l;
    }
}
