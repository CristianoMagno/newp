package org.magnodev.j4j;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrgMagnodevJ4j {

    public static void main(String[] args) {
        J4J j = new J4J("my.json");
        try {
            Json json = j.read();
            System.out.println(json.valueAt("nome"));
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (JsonException ex) {
            Logger.getLogger(OrgMagnodevJ4j.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
