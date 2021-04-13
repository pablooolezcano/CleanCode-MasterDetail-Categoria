package es.ulpgc.eite.cleancode.catalog.app;


public class ProductItem {

  public final int id;
  public final int id2;
  public final String content;
  public final String details;

  public ProductItem(int id, int id2, String content, String details) {
    this.id = id;
    this.id2 = id2;
    this.content = content;
    this.details = details;
  }

  @Override
  public String toString() {
    return content;
  }
}