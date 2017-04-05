package views.myviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import views.myviewdemo.views.LinearGridView;

/**
 * Created by ly on 2017/4/5.
 */

public class LinearGridActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    LinearGridView linearGridView;
    List<String> dataList = new ArrayList<>();
    int numerCount ;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_grid);
       initView();
    }

    private void initView(){
        editText = (EditText) findViewById(R.id.edit);
        button = (Button) findViewById(R.id.btn);
        linearGridView = (LinearGridView) findViewById(R.id.lingrid);
        button.setOnClickListener(this);
        adapter = new MyAdapter();
        linearGridView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                if(!TextUtils.isEmpty(editText.getText().toString())){
                    int number = Integer.valueOf(editText.getText().toString());
                    if(number >0){
                        numerCount = number;
                        resetData();
                    }
                }
                break;
        }
    }

    private void resetData(){
        dataList.clear();
        for(int i =0;i<numerCount;i++){
            dataList.add("测试"+i);
        }
        adapter.notifyDataSetChanged();

    }

    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return numerCount;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if(convertView == null){
                convertView = LayoutInflater.from(LinearGridActivity.this).inflate(R.layout.item_linear_grid,null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.tv.setText(dataList.get(position));

            return convertView;
        }
        class ViewHolder{
            TextView tv;
            public ViewHolder(View view){
                tv = (TextView) view.findViewById(R.id.tv_item);
            }

        }
    }
}
