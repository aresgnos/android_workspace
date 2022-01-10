package kr.or.dshrd.splash_screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.OrderAdapter;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.OrderHelperClass;
import kr.or.dshrd.splash_screen.HelperClass.HomeAdapter.ProAdapter;

public class Main_page extends AppCompatActivity {

    // 선언
    RecyclerView orderRecycler;
    RecyclerView.Adapter adapter;
    RecyclerView proRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        // hooks
        orderRecycler = findViewById(R.id.order_recycler);

        orderRecycler();

        proRecycler = findViewById(R.id.pro_recycler);

        proRecycler();



    }

    // recyclerview 노출할 화면 사이즈 fix
    private void orderRecycler() {

        orderRecycler.setHasFixedSize(true);
        orderRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<OrderHelperClass> orderLocation = new ArrayList<>();
        orderLocation.add(new OrderHelperClass(R.drawable.order_01, "Apple Watch", "Available when you purchase any new iPhone, iPad, iPod Touch."));
        orderLocation.add(new OrderHelperClass(R.drawable.order_02, "Apple iPad Air", "Available when you purchase any new iPhone, iPad, iPod Touch."));
        orderLocation.add(new OrderHelperClass(R.drawable.order_03, "Macbook", "Available when you purchase any new iPhone, iPad, iPod Touch."));

        // Adapter

        adapter = new OrderAdapter(orderLocation);
        orderRecycler.setAdapter(adapter);

    }

    private void proRecycler() {

        proRecycler.setHasFixedSize(true);
        proRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        ArrayList<OrderHelperClass> proLocation = new ArrayList<>();
        proLocation.add(new OrderHelperClass(R.drawable.pro_01, "Apple Watch", "Available when you purchase any new iPhone, iPad, iPod Touch."));
        proLocation.add(new OrderHelperClass(R.drawable.order_02, "Apple iPad Air", "Available when you purchase any new iPhone, iPad, iPod Touch."));
        proLocation.add(new OrderHelperClass(R.drawable.order_03, "Macbook", "Available when you purchase any new iPhone, iPad, iPod Touch."));

        // Adapter

        adapter = new ProAdapter(proLocation);
        proRecycler.setAdapter(adapter);

    }

}