public class rpg {
    static game_logic gLogic = new game_logic();
    public static void main(String[] args) {
        objects.initializeEncountersArray();
        objects.initializeMonstersArray();
        objects.intitializeItemsArray();
        while(true) {
        rpg_loop();
        }
    }
    public static void rpg_loop()
    {
        gLogic.getCommand();
    }
    
}
