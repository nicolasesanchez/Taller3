package tp1.utils.inifiles;

import tp1.utils.textfiles.*;
import java.util.HashMap;
import java.util.Map.Entry;

public class IniManager {
    private String filename;
    private HashMap<String, Section> sections;

    public IniManager() {
        this.sections = new HashMap<>();
    }

    public IniManager(String line) {
        this();
        this.filename = line;
    }

    public String getPath() {
        return this.filename;
    }

    public int getSectionsCount() {
        return sections.size();
    }

    public void list() {
        for (Entry<String, Section> it : this.sections.entrySet()) {
            System.out.println(it.toString());
        }
    }

    public void setItem(String section, String key, String value) {
        getSection(section).setItem(key, value);
    }

    public String getValueOf(String section, String item) {
        return getSection(section).getValue(item);
    }

    public Section removeSection(String section) {
        return this.sections.remove(section);
    }

    public boolean removeItem(String section, String item) {
        return getSection(section).remove(item);
    }

    public void save() {
        TextWriter tw = new BufferedTextWriter(this.filename);
        for (Section section : this.sections.values()) {
            try {
                section.save(tw);
            } catch (Exception e) {
                e.getMessage();
            }
        }
        tw.close();
    }

    private void load() {
        try {
            TextReader tr = new BufferedTextReader(this.filename);
            String line = tr.readLine();
            while (line != null) {
                System.out.println(line);
                line = tr.readLine();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    private Section getSection(String section) {
        return sections.get(section);
    }

    private String getSectionName(String name) {
        return getSection(name).toString();
    }

    private boolean isSection(String line) {
        line = line.trim();
        return (line.startsWith("[") && line.endsWith("]"));
    }

    private boolean isItem(String line) {
        return line.trim().matches("[a-z]\\w* *=.*");
    }

    private boolean isComentario(String line) {
        return line.trim().startsWith(";");
    }

}
