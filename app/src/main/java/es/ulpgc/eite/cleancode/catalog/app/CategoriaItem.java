package es.ulpgc.eite.cleancode.catalog.app;

public class CategoriaItem {

    public final String content;
    public final String details;
    public final int id;

    public CategoriaItem(int id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }
    @Override
    public String toString() {
        return content;
    }
}

