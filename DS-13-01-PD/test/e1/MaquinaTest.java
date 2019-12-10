
package e1;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

/**
 *
 * @author Brais
 */
public class MaquinaTest {
    private Maquina m;
    private Coin c200,c100,c50,c20,c10,c5,c2,c1,c100_2;
    private ArrayList<Coin> l1,l2,l3,l4,l5,l6;
    
    
    @Before
    public void setUp() {
        
        m= new Maquina();
        m.insertProduct("A", 1);
        m.insertProduct("B", 72);
        m.insertProduct("C", 199);
        m.insertProduct("D", 45);
        
        c200 = new Coin(200);
        c100 = new Coin(100);
        c100_2 = new Coin(100);
        c50 = new Coin(50);
        c20 = new Coin(20);
        c10 = new Coin(10);
        c5 = new Coin(5);
        c2 = new Coin(2);
        c1 = new Coin(1);
        
        l1=new ArrayList<>();
        l2=new ArrayList<>();
        l3=new ArrayList<>();
        l4=new ArrayList<>();
        l5=new ArrayList<>();
        l6=new ArrayList<>();
        
        l1.add(c100);
        for (int i=0; i<2 ; i++) l2.add(c100);
        l3.add(c1);
        l4.add(c20);l4.add(c5);l4.add(c2);l4.add(c1);
        l5.add(c200);l5.add(c100);l5.add(c50);l5.add(c20);l5.add(c10);l5.add(c5);l5.add(c2);l5.add(c1);
        l6.add(c20);l6.add(c20);l6.add(c20);
    }
    
    @Test
    public void testCancel(){
    m.insertCoin(c20);m.insertCoin(c5);m.insertCoin(c2);m.insertCoin(c1);
    assertEquals(l4,m.cancel());
    }
    
    @Test
    public void testFindPrece(){
        m.insertCoin(c20);
        assertEquals(null,m.buy("HG"));
    }
    
    @Test
    public void testCambioDeposito(){
        m.insertCoin(c100);
        assertEquals(l4,m.buy("B"));
        
        m.insertCoin(c100);
        assertEquals(null,m.buy("C"));
        assertEquals(m.cancel(),l1);
        
        m.insertCoin(c200);m.insertCoin(c100);m.insertCoin(c50);m.insertCoin(c10);m.insertCoin(c20);m.insertCoin(c5);m.insertCoin(c2);m.insertCoin(c2);
        assertEquals(l5,m.buy("A"));
        
    }
    
    @Test
    public void testCambioSimple(){
        m.cambioTemporal(CambioSimple.get());
        m.insertCoin(c100);m.insertCoin(c100_2);
        m.dia();
        m.noite();
        assertEquals(l1,m.buy("B"));
    }
    
    @Test
    public void testSaltoDeCambioAutomatico(){
        for (int i = 0 ; i<250;i++){
            m.insertCoin(c200);
            assertEquals(m.buy("C"),l3);
        }
        m.insertCoin(c200);m.insertCoin(c100);
        assertEquals(l1,m.buy("C"));
        
        ArrayList<Coin> tmp = new ArrayList<>();
        for (int i=0 ; i<251 ; i++){
            tmp.add(c200);tmp.add(c100);tmp.add(c50);tmp.add(c20);tmp.add(c10);tmp.add(c5);tmp.add(c2);tmp.add(c1);
        }
        Deposito d = new Deposito();
        d.retirada(tmp);
        m.noite();
        m.cambiarDeposito(d);
        m.dia();
        m.cambiarDeposito(d);
        
        
        m.insertCoin(c200);m.insertCoin(c100);
        assertEquals(l1,m.buy("C"));
        m.dia();
        m.insertCoin(c100);m.insertCoin(c100_2);m.insertCoin(c100_2);m.insertCoin(c100);
        assertEquals(l2,m.buy("C"));
        m.insertCoin(c20);m.insertCoin(c20);m.insertCoin(c20);m.insertCoin(c50);
        assertEquals(l6,m.buy("D"));
    }   
}
