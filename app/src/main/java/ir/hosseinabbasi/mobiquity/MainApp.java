package ir.hosseinabbasi.mobiquity;

import android.app.Application;
import android.content.Context;
import ir.hosseinabbasi.mobiquity.di.component.ApplicationComponent;
import ir.hosseinabbasi.mobiquity.di.component.DaggerApplicationComponent;
import ir.hosseinabbasi.mobiquity.di.module.ApplicationModule;

public class MainApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponents();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public static MainApp get(Context context) {
        return (MainApp) context.getApplicationContext();
    }

    private void initComponents() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }
}
