/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

import java.util.HashSet;
import java.util.Set;


public class ProductList {
    private final Set<Product> lista;

    public ProductList() {
        this.lista = new HashSet<>();
    }
    
    public void insert(String nom, int price){
        this.lista.add(new Product(nom,price));
    }
    
    //Devolbe o prezo do producto pedido, que será -1 se non existe
    public int findPrice(String nom){
        Product p2 = new Product(nom,0);
        for (Product p1 : this.lista) if (p1.equals(p2)) return p1.getPrezo();
        return -1;
    }
    
}

class Product {
    private final String nome;
    private final int prezo;
    
    public Product(String nom, int price){
        nome = nom;
        prezo=price;
    }

    public int getPrezo() {
        return prezo;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash=hash * this.nome.length();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        final Product other = (Product) obj;
        return this.nome.equals(other.nome);
    }
    
    
}
