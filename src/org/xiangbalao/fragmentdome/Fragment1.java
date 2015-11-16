package org.xiangbalao.fragmentdome;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class Fragment1 extends Fragment {
	private Button button1;

	private GridView mGridView;

	private ImageAdapter mImageAdapter;

	private Fragment2 mFragment2;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment1, container, false);
		initView(view);
		return view;

	}

	public class ImageAdapter extends BaseAdapter {
		public ImageAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return mThumbIds.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(mContext);
				imageView.setLayoutParams(new GridView.LayoutParams(45, 45));
				imageView.setAdjustViewBounds(false);
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}

			imageView.setImageResource(mThumbIds[position]);

			return imageView;
		}

		private Context mContext;

		private Integer[] mThumbIds = { R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5, R.drawable.sample_thumb_6,
				R.drawable.sample_thumb_7, R.drawable.sample_thumb_0,
				R.drawable.sample_thumb_1, R.drawable.sample_thumb_2,
				R.drawable.sample_thumb_3, R.drawable.sample_thumb_4,
				R.drawable.sample_thumb_5,

		};
	}

	private void initView(View view) {
		button1 = (Button) view.findViewById(R.id.button1);
		mGridView = (GridView) view.findViewById(R.id.gridView1);
		mImageAdapter = new ImageAdapter(getActivity());
		mGridView.setAdapter(mImageAdapter);

		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				mFragment2 = new Fragment2();
				FragmentManager fm = getFragmentManager();
				FragmentTransaction tx = fm.beginTransaction();
				// 替换
				tx.replace(R.id.id_content, mFragment2,
						Fragment2.class.getSimpleName());
				// 回退的
				// tx.addToBackStack(Fragment1.class.getSimpleName());
				tx.addToBackStack(null);

				tx.commit();

			}
		});

	}

}
