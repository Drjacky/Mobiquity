package ir.hosseinabbasi.mobiquity.ui.category;

import ir.hosseinabbasi.mobiquity.ui.base.IBasePresenter;

public interface ICategoryListPresenter<V extends ICategoryListView> extends IBasePresenter<V> {

    void getCategoryList();

}
