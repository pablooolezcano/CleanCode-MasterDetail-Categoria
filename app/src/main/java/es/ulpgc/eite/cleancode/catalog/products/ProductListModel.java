package es.ulpgc.eite.cleancode.catalog.products;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();

  private final List<ProductItem> itemList = new ArrayList<>();
  private final int COUNT = 20;

  private int id;

  public ProductListModel(int id) {
    // Add some sample items
    for (int index = 1; index <= COUNT; index++) {
      addProduct(createProduct(index, id));
    }
  }

  @Override
  public List<ProductItem> fetchProductListData() {
    Log.e(TAG, "fetchProductListData()");
    return itemList;
  }
  @Override
  public String titulo() {
    return "Category " + id;
  }

  private void addProduct(ProductItem item) {
    itemList.add(item);
  }


  private ProductItem createProduct(int position,int id) {
    String content = "Product " + id + "." + position;

    return new ProductItem(
        id, position, content, fetchProductDetails(position,id)
    );

  }


  private String fetchProductDetails(int position, int id) {
    String content = "Details about Product:  " + id + "." + position;
    StringBuilder builder = new StringBuilder();
    builder.append(content);

    for (int index = 0; index < position; index++) {
      builder.append("\nMore details information here.");
    }

    return builder.toString();
  }

}
