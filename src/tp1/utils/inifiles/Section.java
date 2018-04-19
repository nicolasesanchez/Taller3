package tp1.utils.inifiles;

import tp1.utils.textfiles.*;

import java.util.HashMap;
import java.util.Map.Entry;

public class Section implements TextWriter {
    private String name;
    private HashMap<String, String> items;

    public Section(String section) {
        this.name = section;
        this.items = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public String getValue(String name) {
        return items.get(name);
    }

    public void setItem(String item) {
        if (item.indexOf("=") != -1) {
            String[] values = item.split("=");
            String key = values[0].trim();
            String value = values[1].trim();
            this.setItem(key, value);
        }
    }

    public void setItem(String key, String value) {
        this.items.put(key, value);
    }

    public void list() {
        System.out.printf("[%s]", this.name);
        for (Entry<String, String> item : items.entrySet()) {
            System.out.println(item);
        }
    }

    public void save(TextWriter tw) {
            tw.close(); // TODO revisar
    }

    public boolean remove(String item) {
        return this.items.remove(item) != null;
    }


    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void writeLine(String line) {

    }

    @Override
    public void close() {

    }
}