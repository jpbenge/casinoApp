import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.*;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

public class PlayerSpec {

    @Test
    public void gettNameTest() {
        Player p1 = new Player();
        assertEquals("getName = ", "Peter", p1.getName());
    }
    @Test
    public void setNameTest() {
        Player p2 = new Player();
        String testName = "Peter";
        assertEquals("Name equal to test : ",testName, p2.getName());
    }
    @Test
    public void getNPC() {
        Player p3 = new Player();
        assertEquals("get nPC ",false,p3.isNPC());

    }
    @Test
    public void addChips() {
        Player p4 = new Player();
        long getChips = p4.getChips();
        assertEquals("chips = ",100,getChips);
     //   long testChips = p4.addChips(10);
    //    assertEquals("add chips ",getChips,testChips);
    }
}

