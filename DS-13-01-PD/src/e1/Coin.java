
package e1;


//--------------------------------¡¡IMPORTANTE!!--------------------------------

//Como para este exercicio non se van necesitar a maioría dos atibutos e funcións
// de EuroCion, creouse esta clase Coin que resulta dunha simplificación de EuroCoin


import java.util.Objects;

public final class Coin {
    private final Valor valor;
    private final Color color;
    private final Pais pais;
    private final String diseño;
    private final int año;

    /*
    public Coin(Valor valor, String diseño, int año, Pais pais) {
        this.valor = valor;
        switch (valor.getCentimos()){  //decidese o color en base ao valor da moneda
            case 1: case 2: case 5: this.color=Color.BRONCE;break;
            case 10: case 20: case 50: this.color=Color.ORO;break;
            default:this.color=Color.ORO_PLATA;break;
        }
        this.pais = pais;
        this.diseño = diseño;
        this.año = año;
    }
    */
    
    public Coin(int p){
        this.valor = Valor.transform(p);
        switch (p){  //decidese o color en base ao valor da moneda
            case 1: case 2: case 5: this.color=Color.BRONCE;break;
            case 10: case 20: case 50: this.color=Color.ORO;break;
            default:this.color=Color.ORO_PLATA;break;
        }
        this.pais = Pais.AUSTRIA;
        this.diseño = "Un dibuxo";
        this.año = 2000;
    }

    public int getValor() {
        return valor.getCentimos();
    } 
    
    /*
    @Override
    public int hashCode() {
        int hash = 3;
        hash= hash* this.valor.getCentimos();
        return hash;
    }
    */
    
    //Equals simplificado, pois solo fai falta para o test e solo é necesaria esta ccomprobación
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        final Coin other = (Coin) obj;
        return this.valor == other.valor;
    }
    
}

enum Color{
    ORO("O"),BRONCE("B"),ORO_PLATA("OP") ;
    
    private final String inicial;
    
    Color(String color){
        this.inicial=color; 
    }
}


enum Pais{
   AUSTRIA("AT"),BELGIUM("BE"),CYPRUS("CY"),NETHERLANDS("NL"),ESTONIA("EE"),FINLAND("FI"),FRANCE("FR"),
   GERMANY("DE"),GREECE("GR"),IRELAND("IE"),ITALY("IT"),LATVIA("LV"),LITHUANIA("LT"),LUXEMBOURG("LU"),
   MALTA("MT"),MONACO("MC"),PORTUGAL("PT"),SAN_MARINO("SM"),SLOVAKIA("SK"),SLOVENIA("SI"),SPAIN("ES"),
   VATICAN_CITY("VA");
   
    private final String code;
    

    Pais(String code){
        this.code=code;
    }

    
    
}


enum Valor{
    EUROS_2(200),EUROS_1(100),CENTIMOS_50(50),CENTIMOS_20(20),CENTIMOS_10(10),CENTIMOS_5(5),CENTIMOS_2(2),CENTIMOS_1(1) ;
    
    private final int centimos;
    
    Valor(int valor){
        this.centimos=valor; 
    }
    
    public static Valor transform(int p){
        switch (p) {
            case 200 : return Valor.EUROS_2;
            case 100 : return Valor.EUROS_1;
            case 50 : return Valor.CENTIMOS_50;
            case 20 : return Valor.CENTIMOS_20;
            case 10 : return Valor.CENTIMOS_10;
            case 5 : return Valor.CENTIMOS_5;
            case 2 : return Valor.CENTIMOS_2;
            case 1 : return Valor.CENTIMOS_1;
            default : throw new IllegalArgumentException("Non existen monedas de ese valor");
        }
    }

    public int getCentimos() {
        return centimos;
    }
    
}
