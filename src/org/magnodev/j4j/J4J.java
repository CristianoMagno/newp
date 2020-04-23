package org.magnodev.j4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class J4J {

    private String path = "";
    private File file = null;

    public J4J(String path) {
        this.path = path;
    }

    public J4J(File file) {
        this.file = file;
    }
    
    public J4J() {
        
    }

    public Json read() throws IOException {

        File f = null;

        if (!path.equals("")) {
            f = new File(path);
        } else if (!(file != null)) {
            f = file;
        }

        String jsontext = valJsonText(f);
        Json j = new Json();
        j.put(jsontext);
        
        return j;
    }

    public Json read(String path) throws IOException {

        File f = null;

        if (!path.equals("")) {
            f = new File(path);
        }
        
        String jsontext = valJsonText(f);
        Json j = new Json();
        j.put(jsontext);
        
        return j;
    }

    public Json read(File file) throws IOException {

        File f = null;

        if (!(file != null)) {
            f = file;
        }
        
        String jsontext = valJsonText(f);
        Json j = new Json();
        j.put(jsontext);
        
        return j;
    }
    
    public void write(Json json) throws IOException, JsonException {
        
        if(!json.isJson()) {
            throw new JsonException("Não é um documento Json");
        }
        
        File arq = null;
        
        if(this.file != null) {
            arq = this.file;
        } else if(!this.path.equalsIgnoreCase("")){
            arq = new File(this.path);
        }
        
        writeOf(json.toString(), arq);
    }
    
    public void write(Json json, File file) throws IOException {
        writeOf(json.toString(), file);
    }
    
    private void writeOf(String val, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(val);
        }
    }

    protected String valJsonText(File f) throws FileNotFoundException, IOException {

        String total = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = reader.readLine()) != null) {
                total += line;
            }
        }

        return total;
    }
}
