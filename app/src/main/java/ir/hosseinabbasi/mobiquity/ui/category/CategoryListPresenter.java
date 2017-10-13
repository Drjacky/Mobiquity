package ir.hosseinabbasi.mobiquity.ui.category;

import android.util.Log;
import javax.inject.Inject;
import ir.hosseinabbasi.mobiquity.data.DataManager;
import ir.hosseinabbasi.mobiquity.ui.base.BasePresenter;
import ir.hosseinabbasi.mobiquity.utils.rx.RxDisposableFactory;
import ir.hosseinabbasi.mobiquity.utils.rx.RxDisposables;
import ir.hosseinabbasi.mobiquity.utils.rx.ThreadTransformer;

public final class CategoryListPresenter<V extends CategoryListView> extends BasePresenter<V> implements ICategoryListPresenter<V> {

    private final ThreadTransformer threadTransformer;
    private final RxDisposables disposables;

    @Inject
    public CategoryListPresenter(DataManager dataManager,
                                 ThreadTransformer threadTransformer,
                                 RxDisposableFactory rxDisposableFactory) {
        super(dataManager, threadTransformer, rxDisposableFactory);
        this.threadTransformer = getThreadTransformer();
        this.disposables = getRxDisposables();
    }

    @Override
    public void getCategoryList() {
        getMvpView().showLoading();
        disposables.add(getDataManager().getCategories()
                .compose(threadTransformer.applySchedulers())
                .subscribe(categoryModel -> {
                    getMvpView().hideLoading();
                    getMvpView().loadCategoryList(categoryModel);
                }, throwable -> {
                    getMvpView().hideLoading();
                    Log.e("getCategoryList", throwable.getMessage());
                }));
    }

}
