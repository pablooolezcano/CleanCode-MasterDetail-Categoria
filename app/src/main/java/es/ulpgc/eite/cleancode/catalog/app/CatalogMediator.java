package es.ulpgc.eite.cleancode.catalog.app;

import es.ulpgc.eite.cleancode.catalog.categorias.CategoriaState;
import es.ulpgc.eite.cleancode.catalog.product.ProductDetailState;
import es.ulpgc.eite.cleancode.catalog.products.ProductListState;

public class CatalogMediator {

  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();
  private CategoriaState categoriaState = new CategoriaState();

  private ProductItem product;
  private CategoriaItem categoriaItem;


  private static CatalogMediator INSTANCE;

  private CatalogMediator() {

  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static CatalogMediator getInstance() {
    if(INSTANCE == null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }


  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public CategoriaState getCategoriaState(){ return  categoriaState;}


  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }
  public CategoriaItem getCategory() {
    CategoriaItem item = categoriaItem;
    //product = null;
    return item;
  }

  public void setCategory(CategoriaItem item) {
    categoriaItem = item;
  }

  public void setProduct(ProductItem item) {
    product = item;
  }

}
