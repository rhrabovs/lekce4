import com.engeto.shopping.Item;
import com.engeto.shopping.ShoppingCart;
import com.engeto.shopping.ShoppingCartException;

import java.math.BigDecimal;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    /*
    throw  klucove slovo pro vynimku
    kdyz nastane throw, tak sa vyskoci von

    try tu pisem ake chyby mozu nastat
    catch vyskoci mi to sem aby som zobrazil co sa stalo
    */
        /*
        chybove informace posielat cez System.err.println
        hlasenie vypise cervenou farbou

        e.printStackTrace()
        - vypise postupnost volanie fci ktora viedla k chybe

        throw new RunTimeException("Error")
        - vychozi reakce naseptavacu
        - aplikace havaruje

        ! nikdy nenechavat blok catch bez reakce (bez toho aby jsem to osetril)
        pokial je catch{ } teda len prazdne zavorky, aplikace pokracuje dalej
        radsej catch { } nedavat, aby to standardne spadlo

        za try muze nasledovat nekolik catch

          */
        //Item item = new Item("Sample Item", new BigDecimal("15.50"));

    Item item = null;
    try {
            item = new Item("Sample Item", new BigDecimal("15.50"));
            item.setPrice(new BigDecimal("-20.10"));
    } catch (ShoppingCartException e) {
            System.err.println("Chyba pri nastavovani ceny: " + e.getMessage());
    }
    System.out.println("Tohle se vypise vzdycky");
    System.out.println("Kategorie polozky: "+ item.getCategory());

    /*
    v jave su hlidane a nehlidane vyjimky
    hlidane vyjimky maji za slovem extends jen klicove slovo Exception
    nehlidane vyjimky maji klicove slovo
     */
        try {
            ShoppingCart cart = new ShoppingCart("Jan Novak");
            cart.addItem(new Item("Rohliky 5ks",new BigDecimal("19.80")));
            cart.addItem(new Item("Chleba 1/2",new BigDecimal("35")));
            cart.addItem(new Item("Maslo",new BigDecimal("55")));
            cart.addItem(new Item("Syr 30dkg",new BigDecimal("98")));

            System.out.println(cart);
            cart.sortItems();
            System.out.println("(1) == Po serazeni podle popisu ==");
            System.out.println(cart);

            cart.sortItems(Comparator.comparing(Item::getPrice));
            // tady rekneme comparatoru podle ceho ma radit
            // to je ta druha metoda v ShoppingCart.java, ktera ma komparator primo ve volani metody
            // jsem z toho uplny trotl a vubec tomu nerozumim

            // dalo by se pouzit jeste v tomhle kontextu
            // cart.sortItems(Comparator.comparing(Item::getPrice).thenComparing)
            // (Pr.) seradit podle ceny, ale v pripade ze je cena stejna serad podle nazvu, to je ten thenComparing
            // (Pr.) cart.sortItems(Comparator.comparing(Item::getPrice).reversed()) >> seradi v opacnem poradi ode nejvyssi k nejnizsi
            System.out.println("(2) == Po serazeni podle ceny ==");
            System.out.println(cart);
        } catch (ShoppingCartException e) {
            throw new RuntimeException(e);
        }

    }
}
