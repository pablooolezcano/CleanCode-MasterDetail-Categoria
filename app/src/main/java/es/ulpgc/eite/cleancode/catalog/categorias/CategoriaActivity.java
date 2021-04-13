package es.ulpgc.eite.cleancode.catalog.categorias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CategoriaItem;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;

public class CategoriaActivity
        extends AppCompatActivity implements CategoriaContract.View {

    public static String TAG = CategoriaActivity.class.getSimpleName();

    private CategoriaContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        //getSupportActionBar().setTitle(R.string.app_name);
    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.categoria_title));
        }
        listView = findViewById(R.id.product_list);
    /*
    if(savedInstanceState == null) {
      CatalogMediator.resetInstance();
    }
    */
        // do the setup
        CategoriaScreen.configure(this);
        // do some work
        presenter.cogerCategoryData();
    }

    @Override
    public void onDataUpdated(CategoriaViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        listView.setAdapter(new CategoriaAdapter(
                        this, viewModel.categoria, new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        CategoriaItem item = (CategoriaItem) view.getTag();
                        presenter.pasarAProductListData(item);
                    }
                })
        );
    }

    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(CategoriaContract.Presenter presenter) {
        this.presenter = presenter;
    }
}