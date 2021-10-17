package com.waqas.daggerpractice.ui.auth.viewmodel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.waqas.daggerpractice.models.User;
import com.waqas.daggerpractice.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AuthViewModel extends ViewModel {

    final AuthApi authApi;

    MediatorLiveData<User> authUser = new MediatorLiveData<>();

    @Inject
    public AuthViewModel(AuthApi authApi){
        this.authApi = authApi;
        Log.e("TestText","AuthViewModel is working");
    }

    public void authenticateWithId(int id){
        final LiveData<User> source = LiveDataReactiveStreams.fromPublisher(
                authApi.getUser(id).subscribeOn(Schedulers.io()));

        authUser.addSource(source, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                authUser.setValue(user);
                authUser.removeSource(source);
            }
        });
    }

    public LiveData<User> observerUser() {
        return authUser;
    }

}
