import java.util.ArrayList;
import java.util.List;
// encounters can be a location, a fight, it can have exits, it can have monsters. The first encounter will probably be to assign equiptment. 
public class encounters {
    int number;
    String name;
    List<String> desc = new ArrayList<String>();
    List<String> exits = new ArrayList<String>();
    List<monsters> Monsters = new ArrayList<monsters>();
    List<items> Items = new ArrayList<items>();

    public encounters(int x) {
        number = x;
    }
}
