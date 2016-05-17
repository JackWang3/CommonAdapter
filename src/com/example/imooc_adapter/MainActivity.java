package com.example.imooc_adapter;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private ListView mListView;
	private List<NewsBean> mDatas;
	private BaseAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}

	private void initView() {
		for (int i = 0; i < 20; i++) {
			NewsBean bean = new NewsBean(R.drawable.ic_launcher, "wangju", "guoshuang");
			mDatas.add(bean);
		}
		
		mListView = (ListView) findViewById(R.id.lv);
		mAdapter = new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder holder = null;
				if (convertView == null) {
					holder = new ViewHolder();
					convertView = LayoutInflater.from(getApplication()).inflate(R.layout.item_layout, null);
					holder.title = (TextView) convertView.findViewById(R.id.tv_title);
					holder.content = (TextView) findViewById(R.id.tv_content);
					holder.imageView = (ImageView) findViewById(R.id.iv_icon);
					convertView.setTag(holder);
				} else {
					holder = (ViewHolder) convertView.getTag();
				}
				holder.title.setText(mDatas.get(position).newsTitle);
				holder.content.setText(mDatas.get(position).newsContent);
				holder.imageView.setImageResource(mDatas.get(position).newsIconUrl);
				
				return convertView;
			}
			
			@Override
			public long getItemId(int arg0) {
				return arg0;
			}
			
			@Override
			public Object getItem(int arg0) {
				return mDatas.get(arg0);
			}
			
			@Override
			public int getCount() {
				return mDatas.size();
			}
		};
		
		mListView.setAdapter(mAdapter);
	}

	class ViewHolder {
		public TextView title, content;
		public ImageView imageView;
	}
}
