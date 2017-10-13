package ir.hosseinabbasi.mobiquity.di.module;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import ir.hosseinabbasi.mobiquity.data.network.ApiEndPoint;
import ir.hosseinabbasi.mobiquity.data.network.ApiHelper;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    @Provides
    @Singleton
    public ApiHelper provideApi(Retrofit retrofit) {
        return retrofit.create(ApiHelper.class);
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiEndPoint.ENDPOINT_AMAZONAWS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
