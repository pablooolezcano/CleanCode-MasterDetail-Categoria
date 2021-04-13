package es.ulpgc.eite.cleancode.catalog.categorias;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;

public class CategoriaScreen {

    public static void configure(CategoriaContract.View view) {

        WeakReference<FragmentActivity> context =
                new WeakReference<>((FragmentActivity) view);

        String data = context.get().getString(R.string.app_name);

        CatalogMediator mediator = CatalogMediator.getInstance();

        CategoriaContract.Presenter presenter = new CategoriaPresenter(mediator);
        CategoriaContract.Model model = new CategoriaModel();
        presenter.injectModel(model);
        presenter.injectView(new WeakReference<>(view));

        view.injectPresenter(presenter);

    }
}
