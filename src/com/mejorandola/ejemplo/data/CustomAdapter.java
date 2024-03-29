package com.mejorandola.ejemplo.data;

import java.util.ArrayList;

import android.R.bool;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.mejorandola.ejemplo.R;
import com.mejorandola.ejemplo.models.Room;

public class  CustomAdapter extends ArrayAdapter<Room> {
	
	ArrayList<Room> data;
	LayoutInflater inflater;
	
	boolean is_list;

	public CustomAdapter(Context context, ArrayList<Room> objects,boolean is_list) {
		super(context, -1, objects);
		// TODO Auto-generated constructor stub
		this.data = objects;
		this.inflater = LayoutInflater.from(context);
		this.is_list = is_list;
	}
	
	
	
	//se usa en adaptadoes
	//se llama para sobrecargar cada uno de los registros
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
//	super.getView(position, convertView, parent);
	
	ViewHolder holder; 
	Room current_room = data.get(position);
	String room_type = current_room.getRoomType();
	
	int img_resource = 0;
	if(room_type.equals(Room.STANDARD_ROOM)){
		img_resource = R.drawable.hotel1;
	}else{
		img_resource = R.drawable.hotel2;
		
	}
	
	int layout = is_list? R.layout.list_row : R.layout.grid_element;
	 
	if(convertView == null){
		convertView = inflater.inflate(layout, null);
		
		holder = new ViewHolder();
		holder.img = (ImageView)convertView.findViewById(R.id.img_row);
		holder.title = (TextView)convertView.findViewById(R.id.txt_row_title);
		holder.subtitle = (TextView)convertView.findViewById(R.id.txt_row_subtitle);
		
		//el hoder se asigna al converview
		convertView.setTag(holder);
		
	}else{
		
		holder = (ViewHolder)convertView.getTag();
	}
	
	holder.title.setText(current_room.getRoomNumber());
	holder.subtitle.setText(room_type);
	holder.img.setImageResource(img_resource); 
	
	
	
	return convertView;
	}




	private static class ViewHolder{
		public ImageView img;
		public TextView title;
		public TextView subtitle;
	}
	
	
}
