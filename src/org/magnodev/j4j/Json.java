package org.magnodev.j4j;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Json {

    private String texto = "";

    public static final String Object = "0bject";
    public static final String Array = "Array";

    private String start;
    private String end;

    public Json() {
        getType(texto);
    }

    public Json(String type) {

        //super();
        
        if (type.equals(Object)) {
            limit("{", "}");
        } else if (type.equals(Array)) {
            limit("[", "]");
        }

    }

    public List<JAttr> attrs() {

        List<JAttr> lista = null;

        return lista;
    }

    public String jsonType() {
        if (this.start.equals("{") && this.end.equals("}")) {
            return Object;
        } else if (this.start.equals("[") && this.end.equals("}")) {
            return Array;
        }

        return "";
    }

    public Object valueAt(String attrName) throws JsonException{
        String value = value(attrName);
        return value;
    }
    
    private String value(String name) throws JsonException  {
        
        if(!Pattern.compile("\""+name+"\"").matcher(this.texto).find()) {
            throw new JsonException("Atributo não encontrado : " + name);
        }
        
        
        
        return null;
    }

    public Object valueAt(JAttr attr) throws JsonException {
        String name = attr.getName();
        String value = value(name);
        return value;
    }

    public void append(String attr, String value) {

        String forTest = this.texto;

        if (!forTest.trim().equals("")) {
            this.texto += ",\n";
        }

        this.texto += "\"" + attr + "\" : \"" + value + "\"";
        //code
    }

    public void append(String attr, Integer value) {

        String forTest = this.texto;

        if (!forTest.trim().equals("")) {
            this.texto += ",\n";
        }

        this.texto += "\"" + attr + "\" : " + value + "";
        //code
    }

    public void append(String attr, Boolean value) {

        String forTest = this.texto;

        if (!forTest.trim().equals("")) {
            this.texto += ",\n";
        }

        this.texto += "\"" + attr + "\" : " + value + "";
        //code
    }

    public void append(String attr, Double value) {

        String forTest = this.texto;

        if (!forTest.trim().equals("")) {
            this.texto += ",\n";
        }

        this.texto += "\"" + attr + "\" : " + value + "";
        //code
    }

    public void append(String attr, Json value) {

        String forTest = this.texto;
        String realValue = value.toString();

        if (!forTest.trim().equals("")) {
            this.texto += ",\n";
        }

        this.texto += "\"" + attr + "\" : " + realValue + "";
        //code
    }

    public void append(String attr, Object[] value) {

        String forTest = this.texto;
        String datas = "[";
        int tam = value.length, i = 0;

        if (!forTest.trim().equals("")) {
            this.texto += ",\n";
        }

        for (Object v : value) {

            if (v == null) {
                datas += v + "";
            } else {
                try {
                    String ss = (String) v;
                    datas += "\"" + ss + "\"";
                } catch (Exception e) {
                    datas += v + "";
                }
            }

            if ((i + 1) != tam) {
                datas += ",";
            }

            i++;

        }

        datas += "]";
        this.texto += "\"" + attr + "\" : " + datas + "";
        //code
    }

    public void arrayAppend(Integer vaue) {

    }

    public void put(Json json) {
        
        String ownJ = json.toString();
        
        if(!texto.trim().equals("")) {
            ownJ = ",\n" + ownJ;
        }
        
        this.texto += ownJ;
    }

    public void put(String json) {
        String ownJ = json;
        this.texto = ownJ;
    }

    private void A(String code) {
        //code
    }

    private void convert(String newLine) {

    }

    private void limit(String start, String end) {
        this.start = start;
        this.end = end;
    }

    private void getType(String json) {

    }

    @Override
    public String toString() {
        return this.start + "\n" + this.texto + "\n" + this.end;
    }

    public boolean isJson() {
        return true;
    }

}
