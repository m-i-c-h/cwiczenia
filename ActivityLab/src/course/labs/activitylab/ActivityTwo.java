package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
	private int mCreate, mRestart, mStart, mResume;

	// variables for each of the TextViews, called
	private TextView mTvCreate, mTvStart, mTvResume, mTvRestart;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);




		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCreate = savedInstanceState.getInt(CREATE_KEY);
			mRestart = savedInstanceState.getInt(RESTART_KEY);
			mStart = savedInstanceState.getInt(START_KEY);
			mResume = savedInstanceState.getInt(RESUME_KEY);
		}

		// Emit LogCat message
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		Log.i(TAG, "Entered the onCreate() method");
		mCreate++;
		displayCounts();

	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();
		Log.i(TAG, "Entered the onStart() method");
		mStart++;
		displayCounts();
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.i(TAG, "Entered the onResume() method");
		mResume++;
		displayCounts();
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.i(TAG, "Entered the onPause() method");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.i(TAG, "Entered the onStop() method");
	}

	@Override
	public void onRestart() {
		super.onRestart();
		Log.i(TAG, "Entered the onRestart() method");
		mRestart++;
		displayCounts();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i(TAG, "Entered the onDestroy() method");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt(RESTART_KEY, mRestart);
		savedInstanceState.putInt(RESUME_KEY, mResume);
		savedInstanceState.putInt(START_KEY, mStart);
		savedInstanceState.putInt(CREATE_KEY, mCreate);

		 // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
