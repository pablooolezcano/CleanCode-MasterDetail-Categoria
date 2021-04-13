package es.ulpgc.eite.cleancode.catalog.categorias;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategoriaItem;

public class CategoriaPresenter implements CategoriaContract.Presenter {

    public static String TAG = CategoriaPresenter.class.getSimpleName();

    private WeakReference<CategoriaContract.View> view;
    private CategoriaState state;
    private CategoriaContract.Model model;
    private CatalogMediator mediator;

    public CategoriaPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoriaState();
    }



    @Override
    public void cogerCategoryData() {
        // Log.e(TAG, "fetchProductListData()");

        // call the model


        state.categoria = model.cogerProductListData();
        view.get().onDataUpdated(state);



    }

    @Override
    public void pasarAProductListData(CategoriaItem item) {
        passDataToNextScreen(item);
        view.get().navigateToNextScreen();
    }

    private void passDataToNextScreen(CategoriaItem item) {

        mediator.setCategory(item);
    }




    @Override
    public void injectView(WeakReference<CategoriaContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoriaContract.Model model) {
        this.model = model;
    }

}