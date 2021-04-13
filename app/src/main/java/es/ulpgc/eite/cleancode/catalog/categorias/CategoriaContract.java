package es.ulpgc.eite.cleancode.catalog.categorias;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategoriaItem;

public interface CategoriaContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(CategoriaViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);

//        void onResume();
//
//        void onStart();
//
//        void onRestart();

//        void onBackPressed();
//
//        void onPause();
//
//        void onDestroy();

        void pasarAProductListData(CategoriaItem item);
        void cogerCategoryData();
    }

    interface Model {
        String getStoredData();

        List<CategoriaItem> cogerProductListData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}