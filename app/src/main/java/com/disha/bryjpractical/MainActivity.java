package com.disha.bryjpractical;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.disha.bryjpractical.databinding.ActivityMainBinding;
import com.disha.bryjpractical.ui.fragment.AccountFragment;
import com.disha.bryjpractical.ui.fragment.BagFragment;
import com.disha.bryjpractical.ui.fragment.HomeFragment;
import com.disha.bryjpractical.ui.fragment.ShopFragment;
import com.disha.bryjpractical.ui.listeners.ILoadedListener;
import com.disha.bryjpractical.util.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements ILoadedListener {

    ActivityMainBinding mainActivity;
    Toolbar toolbar;
    DrawerLayout drawer_layout;
    BottomNavigationView bottom_nav_view;
    NavController nav_host_fragment;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = DataBindingUtil.setContentView(this,R.layout.activity_main);

        drawer_layout =  mainActivity.drawerLayout;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        progressBar = mainActivity.progressBar;
        bottom_nav_view =  mainActivity.bottomNavView;

        nav_host_fragment = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottom_nav_view,nav_host_fragment);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment navHostFragment  = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
                Fragment currentFragment = navHostFragment.getChildFragmentManager().getFragments().get(0);

                if(currentFragment instanceof HomeFragment){
                    System.out.println("!!!!!");
                    ((HomeFragment) currentFragment).webView.loadUrl(Constants.CLICK_FUNCTION);
                }else if (currentFragment instanceof ShopFragment){
                    ((ShopFragment) currentFragment).webView.loadUrl(Constants.CLICK_FUNCTION);
                }else if (currentFragment instanceof AccountFragment){
                    ((ShopFragment) currentFragment).webView.loadUrl(Constants.CLICK_FUNCTION);
                }
                else if (currentFragment instanceof BagFragment){
                    ((ShopFragment) currentFragment).webView.loadUrl(Constants.CLICK_FUNCTION);
                }
            }
        });

    }

    @Override
    public void onPageLoaded() {
        Log.d("MT DATA :::","!!!!))))");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onPageStarted() {
        progressBar.setVisibility(View.VISIBLE);
    }


}