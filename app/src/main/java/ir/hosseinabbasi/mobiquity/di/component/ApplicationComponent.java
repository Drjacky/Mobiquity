package ir.hosseinabbasi.mobiquity.di.component;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;
import dagger.Component;
import ir.hosseinabbasi.mobiquity.MainApp;
import ir.hosseinabbasi.mobiquity.data.DataManager;
import ir.hosseinabbasi.mobiquity.di.ApplicationContext;
import ir.hosseinabbasi.mobiquity.di.module.ApplicationModule;
import ir.hosseinabbasi.mobiquity.di.module.DataModule;
import ir.hosseinabbasi.mobiquity.utils.UtilsComponent;
import ir.hosseinabbasi.mobiquity.utils.UtilsModule;

@Singleton
@Component(modules = {ApplicationModule.class, UtilsModule.class,  DataModule.class})
public interface ApplicationComponent extends UtilsComponent, DataComponent{

    void inject(MainApp app);

    @ApplicationContext
    Context context();

    Resources exposeResources();

    Application application();

    DataManager getDataManager();
}
