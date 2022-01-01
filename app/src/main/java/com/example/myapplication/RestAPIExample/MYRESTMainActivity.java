package com.example.myapplication.RestAPIExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MYRESTMainActivity extends AppCompatActivity {

    MyRetrofitInteface apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrestmain);
        recyclerView = findViewById(R.id.myrecyclerview1);
        //getList();
        //getComments();
        CreatePost();
    }

    public void CreatePost(){
        apiInterface = MyRetrofit.getMyRetrofit().create(MyRetrofitInteface.class);
        MyRestAPIModel post = new MyRestAPIModel(5, "MY pOst","Body Body");
        apiInterface.createPost(post);
        Call<MyRestAPIModel> myPost = apiInterface.createPost(post);
        myPost.enqueue(new Callback<MyRestAPIModel>() {
            @Override
            public void onResponse(Call<MyRestAPIModel> call, Response<MyRestAPIModel> response) {
                if (response.isSuccessful())
                Log.d("TAG"," " + response.body().getUserId() +" "+ response.body().getTitle() +" "+ response.body().getBody());
            }

            @Override
            public void onFailure(Call<MyRestAPIModel> call, Throwable t) {

            }
        });
    }

    private void getList() {
        apiInterface = MyRetrofit.getMyRetrofit().create(MyRetrofitInteface.class);
        // enqueue is to run on main thread while execute run in the background
        apiInterface.getList().enqueue(new Callback<List<MyRestAPIModel>>() {
            @Override
            public void onResponse(Call<List<MyRestAPIModel>> call, Response<List<MyRestAPIModel>> response) {
                if(response.body().size() >0){
                    List<MyRestAPIModel> list = response.body();
                    MyRestAdapter adapter = new MyRestAdapter(list, getApplicationContext());
                    LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);
                    Toast.makeText(MYRESTMainActivity.this, "Data Retrieved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MYRESTMainActivity.this, "List is empty", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MyRestAPIModel>> call, Throwable t) {
                Toast.makeText(MYRESTMainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void getComments(){
//        Map<String,String> Argument = new HashMap<>();
//        Argument.put("postId","3");
//        Argument.put("_sort","id");
//        Argument.put("_order","desc");
//        apiInterface = MyRetrofit.getMyRetrofit().create(MyRetrofitInteface.class);
//        //Call<List<MyCommentsModel>> list = apiInterface.getComments();
//        Call<List<MyCommentsModel>> list = apiInterface.getComments(2, "id","desc");
//        list.enqueue(new Callback<List<MyCommentsModel>>() {
//            @Override
//            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
//                if (response.isSuccessful()){
//                    for(MyCommentsModel comments: response.body()){
//                        Log.d("TAG","ID: "+ comments.getId()
//                                        + " POSTID: "+ comments.getPostId()
//                                        + " Name: " + comments.getName());
//                    }
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {
//
//            }
//        });
    }
}