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
public class Maquina {
    
    private final ProductList productos;
    private final CoinList introducidos;
    private Deposito deposit;
    private Cambio cambioActual;
    private final CambioSimple cambioNoite;
    private CambioDeposito cambioDia;
    
    public Maquina(){
        this.productos = new ProductList();
        this.introducidos= new CoinList();
        this.deposit = new Deposito();
        this.cambioDia= new CambioDeposito(this.deposit);
        this.cambioNoite= CambioSimple.get();
        this.cambioActual=this.cambioDia;
    }
    
    public void insertProduct(String product, int price){
        productos.insert(product, price);
    }
    
    public void insertCoin(Coin c){
        introducidos.insert(c);
    }
    
    public List<Coin> cancel(){
        List<Coin> l = this.introducidos.copy();
        this.introducidos.vaciar();
        return l;
    }
    
    public List<Coin> buy(String product){
        int total = this.introducidos.total();
        int precio = this.productos.findPrice(product);
        if (total>=precio && precio>-1){
           this.deposit.ingreso(this.introducidos.copy());
           List<Coin> l = this.cambioActual.cambiar(introducidos,total-precio);
           if (l==null){
               l=this.cambioNoite.cambiar(introducidos,total-precio);
               this.noite();
           }
           this.introducidos.vaciar();
           this.deposit.retirada(l);
           return l;
        }
        return null ; // Se non hai saldo suficiente non se devolve nada
    }
    
    public void dia(){
        this.cambioActual=this.cambioDia;
    }
    
    public void noite(){
        this.cambioActual=this.cambioNoite;
    }
    
    public void cambioTemporal(Cambio c){
        this.cambioActual=c;
    }
    
    public void cambiarDeposito(Deposito d){
        this.deposit=d;
        this.cambioDia= new CambioDeposito(d);
        if (this.cambioActual!=this.cambioNoite) this.cambioActual=this.cambioDia;
        
        
    }
    
}
