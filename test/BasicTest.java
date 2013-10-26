import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Test
    public void aVeryImportantThingToTest() {
        new Producto("chocolates",10.5).save();
        new Producto("papas",9.5).save();
        new Producto("refresco",8.0).save();
        new Producto("mazapan",1.5).save();
    }

}
