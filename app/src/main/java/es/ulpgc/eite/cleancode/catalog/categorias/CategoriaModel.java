package es.ulpgc.eite.cleancode.catalog.categorias;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoriaItem;

public class CategoriaModel implements CategoriaContract.Model {

    public static String TAG = CategoriaModel.class.getSimpleName();

    private final List<CategoriaItem> itemList = new ArrayList<>();
    private final int COUNT = 20;

    private String data;

    public CategoriaModel() {
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }
    private void addProduct(CategoriaItem item) {
        itemList.add(item);
    }

    private CategoriaItem createProduct(int position) {
        String content = "Categoría " + position;

        return new CategoriaItem(
                position, content, buscarProductDetails(position)
        );

    }
    @Override
    public List<CategoriaItem> cogerProductListData() {
        Log.e(TAG, "fetchProductListData()");
        return itemList;
    }

    private String buscarProductDetails(int position) {
        String content = "PRODUCTS:  " + position;
        StringBuilder builder = new StringBuilder();
        builder.append(content);

        for (int index = 0; index < position; index++) {
            builder.append("\nMore details information here.");
        }

        return builder.toString();
    }
    @Override
    public String getStoredData() {
        // Log.e(TAG, "getStoredData()");
        return data;
    }

    @Override
    public void onRestartScreen(String data) {
        // Log.e(TAG, "onRestartScreen()");
    }

    @Override
    public void onDataFromNextScreen(String data) {
        // Log.e(TAG, "onDataFromNextScreen()");
    }

    @Override
    public void onDataFromPreviousScreen(String data) {
        // Log.e(TAG, "onDataFromPreviousScreen()");
    }
}