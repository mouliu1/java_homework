package test;

import org.junit.Assert;
import org.junit.Test;
import ui.Main;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testMain() {
        Main m = new Main();
        Main.main(null);
        Assert.assertEquals(0,m.playerBlood);
    }

}