package ir.hosseinabbasi.mobiquity.ui.category;

import java.util.List;

import ir.hosseinabbasi.mobiquity.data.db.model.Category;
import ir.hosseinabbasi.mobiquity.data.db.model.ProductsItem;
import ir.hosseinabbasi.mobiquity.ui.base.BaseView;

public interface ICategoryListView extends BaseView {

    void loadCategoryList(List<Category> providers);

    void loadProductDetail(ProductsItem product);

}
