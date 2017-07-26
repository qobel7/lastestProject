package com.example.qobel.organizator;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.qobel.organizator.Adapter.OrganizationRecyclerAdapter;
import com.example.qobel.organizator.entity.OrganizationEntity;
import com.example.qobel.organizator.network.ServisGenerater;
import com.example.qobel.organizator.network.UserService;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganizationListActivity extends AppCompatActivity implements OrganizationRecyclerAdapter.ClickListener{

    UserService userService;
    ServisGenerater servisGenerater;
    RecyclerView recyclerView;
    Call<List<OrganizationEntity>> entityCall;
    OrganizationRecyclerAdapter organizationRecyclerAdapter;
    BottomSheetBehavior bottomSheetDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_list);
        recyclerView = (RecyclerView) findViewById(R.id.recycleOrg);
        RecyclerView.LayoutManager  layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        userService  = servisGenerater.createService(UserService.class);
        entityCall  = userService.getOrganizationList();
        entityCall.enqueue(getOrganizationList);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;


            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                System.out.println(rv);
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                System.out.println(disallowIntercept);
            }
        });
    }
    private Callback<List<OrganizationEntity>> getOrganizationList = new Callback<List<OrganizationEntity>>() {
        @Override
        public void onResponse(Call<List<OrganizationEntity>> call, Response<List<OrganizationEntity>> response) {
            List<OrganizationEntity> organizationEntityList =  response.body();
            organizationRecyclerAdapter = new OrganizationRecyclerAdapter(organizationEntityList,getApplicationContext());

            recyclerView.setAdapter(organizationRecyclerAdapter);
            organizationRecyclerAdapter.setClickListener(OrganizationListActivity.this);

        }

        @Override
        public void onFailure(Call<List<OrganizationEntity>> call, Throwable t) {
            System.out.println(call);
            System.out.println("Caner ;ERROR : "+t.getMessage());
        }
    };

    @Override
    public void showItemBottomSheets(OrganizationEntity organizationEntity) {
        System.out.println(organizationEntity);
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(OrganizationListActivity.this);
        View viewParentView = getLayoutInflater().inflate(R.layout.bottom_sheet_main,null);
        bottomSheetDialog.setContentView(viewParentView);

        bottomSheetDialogFragment = BottomSheetBehavior.from((View) viewParentView.getParent());
        bottomSheetDialogFragment.setPeekHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,300,getResources().getDisplayMetrics()));
        TextView textView  = (TextView) viewParentView.findViewById(R.id.textView);
        ImageSwitcher imageSwitcher = (ImageSwitcher) viewParentView.findViewById(R.id.imageSwitcher);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(GridLayoutManager.LayoutParams.WRAP_CONTENT,
                        GridLayoutManager.LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });
        Picasso.with(getApplicationContext()).load(organizationEntity.getImages().get(0)).into((Target) imageSwitcher);

        textView.setText(organizationEntity.getName());
        bottomSheetDialog.show();
    }
}
