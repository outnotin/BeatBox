package com.augmentis.ayp.beatbox;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Noppharat on 8/8/2016.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity{


    @LayoutRes
    protected int getLayoutResId(){
        return
                R.layout.activity_single_fragment;
    }

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //create container and put fragment
            //CrimeListActivity is responsed in create fragment
            setContentView(getLayoutResId());

//            Log.d(CrimeListFragment.TAG, "On create activity");
            FragmentManager fm = getSupportFragmentManager();
            Fragment f = fm.findFragmentById(R.id.fragment_container);

            if(f == null){
                f = onCreateFragment();
                fm.beginTransaction()
                        .add(R.id.fragment_container,f)
                        .commit();
//                Log.d(CrimeListFragment.TAG, "Fragment is created");
            }else{
//                Log.d(CrimeListFragment.TAG, "Fragment have already created");
            }
        }

        protected abstract Fragment onCreateFragment();
    }

