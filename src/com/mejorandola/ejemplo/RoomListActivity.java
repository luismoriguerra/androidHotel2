package com.mejorandola.ejemplo;

import java.util.ArrayList;

import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshAttacher.OnRefreshListener;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.mejorandola.ejemplo.data.CustomAdapter;
import com.mejorandola.ejemplo.models.Room;

public class RoomListActivity extends ListActivity  implements OnRefreshListener {
	
	private PullToRefreshAttacher pull_to_refresh_attacher;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_room_list);
		
		ListView list = getListView();
		ArrayList<Room> rooms = new ArrayList<Room>();
		pull_to_refresh_attacher = PullToRefreshAttacher.get(this);  
		pull_to_refresh_attacher.addRefreshableView(list, this);
		
		for(String room : getResources().getStringArray(R.array.array_rooms_standard)){
			Room one_room = new Room(room, Room.STANDARD_ROOM);
			rooms.add(one_room);
		}
		
		for(String room : getResources().getStringArray(R.array.array_rooms_luxury)){
			Room one_room = new Room(room, Room.LUXURY_ROOM);
			rooms.add(one_room);
		}
		
		CustomAdapter adapter = new CustomAdapter(this, rooms);
		setListAdapter(adapter);
		
	}

	@Override
	public void onRefreshStarted(View view) {
		// TODO Auto-generated method stub
		new AsyncTask<Void, Void, Void>() {

			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
					return null;
				}
				
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				// TODO Auto-generated method stub
				super.onPostExecute(result); 
				pull_to_refresh_attacher.setRefreshComplete();
				
			}
			
		}.execute();
		
		
	}
}
