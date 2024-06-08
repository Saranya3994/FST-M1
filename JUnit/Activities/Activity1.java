import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1
{
   ArrayList list = new ArrayList<String>();

    @BeforeEach
   void setUp(){
        list.add("alpha");
        list.add("beta");
   }
   @Test
   void insertTest(){
       assertEquals(2, list.size(), "Wrong size");
       list.add("charlie");
       assertEquals(3, list.size(), "Wrong size");

       assertEquals("alpha", list.get(0), "Wrong element");
       assertEquals("beta", list.get(1), "Wrong element");
       assertEquals("charlie", list.get(2), "Wrong element");
   }
    @Test
   void replaceTest(){
//        assertEquals(2, list.size(), "Wrong size");
//        list.add("commando");
//        assertEquals(3, list.size(), "Wrong size");
        list.set(1,"delta");
        assertEquals("alpha",list.get(0), "Wrong element");
        assertEquals("delta",list.get(1), "Wrong element");
//        assertEquals("commando",list.get(2), "Wrong element");
   }
}
