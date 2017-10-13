package ir.hosseinabbasi.mobiquity.di.component;

import dagger.Component;
import ir.hosseinabbasi.mobiquity.di.PerActivity;
import ir.hosseinabbasi.mobiquity.di.module.ActivityModule;
import ir.hosseinabbasi.mobiquity.ui.category.CategoryListView;
import ir.hosseinabbasi.mobiquity.ui.detail.DetailView;
import ir.hosseinabbasi.mobiquity.ui.main.MainActivity;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity activity);
    void inject(CategoryListView fragment);
    void inject(DetailView fragment);
}
