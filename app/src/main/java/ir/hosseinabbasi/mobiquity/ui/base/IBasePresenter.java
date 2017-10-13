package ir.hosseinabbasi.mobiquity.ui.base;

public interface IBasePresenter<V extends BaseView> {

    void onAttach(V baseView);

    void onDetach();
}
