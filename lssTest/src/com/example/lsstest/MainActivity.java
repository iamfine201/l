package com.example.lsstest;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView iv,iv2;
	Button btCamera, btImages;
	final static int CAMERA_RESULT = 0;
	private final int RESULT_CODE = 1;
	private final int SAVE_CODE = 2;
	PopupWindow pw;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// imageView点击事件
		iv = (ImageView) findViewById(R.id.iv);
		iv2 = (ImageView) findViewById(R.id.iv2);
		
		iv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				LayoutInflater inflater = getLayoutInflater();
				View view = inflater.inflate(R.layout.popup, null);
				pw = new PopupWindow(view, 360, 150);

				pw.showAsDropDown(view, 0, 140);
				pw.setFocusable(true);
				btCamera = (Button) view.findViewById(R.id.bt_camera);
				btImages = (Button) view.findViewById(R.id.bt_images);

				btCamera.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						Toast.makeText(MainActivity.this, "打开相机", 0).show();
						Intent intent = new Intent(
								android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
						startActivityForResult(intent, RESULT_CODE);
					}
				});

				btImages.setOnClickListener(new OnClickListener() {

					//裁剪图片
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "打开相册", 0).show();
						Intent intent =new Intent(Intent.ACTION_PICK,null);   
					    intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,  "image/*"); 
					    intent.putExtra("crop","true"); 
					    intent.putExtra("aspectX",10);   
					    intent.putExtra("aspectY",10);   
					    intent.putExtra("outputX",380);  
					    intent.putExtra("scale",true); 
					    intent.putExtra("return-data",true); 
					    startActivityForResult(intent,1); 
					}
				});
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case RESULT_CODE:
			if(resultCode==RESULT_OK){
				Bundle bundle = data.getExtras();
				Bitmap bitmap = (Bitmap) bundle.get("data");
				iv2.setImageBitmap(bitmap);
			}
			break;

		case  SAVE_CODE:
			if(resultCode==RESULT_OK){
				Uri uri = data.getData();
				iv2.setImageURI(uri);
			}
			break;
		default:
			break;
		}
	}

}
