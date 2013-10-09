package codepath.apps.tipcalculator;

import java.text.DecimalFormat;

import codepath.apps.tipcalculator.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TipActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        
        EditText etBillAmount = (EditText)
    			findViewById(R.id.etBillAmount);
        //etBillAmount.setFocusableInTouchMode(true);
        //etBillAmount.requestFocus();
        
        etBillAmount.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //showTipAmount(R.layout.activity_tip);
                    return true;
                }
                return false;
            }
        });
        
        /*etBillAmount.setOnKeyListener(new OnKeyListener(
            @override onKey(View v, int keyCode, KeyEvent event) {
        	    if(event.getAction()==KeyEvent.ACTION_UP && keyCode==KeyEvent.KEYCODE_ENTER){
        		// what you need to do when Enter is pressed
        		return true;

        		}
        	    else 
        			return false;

        	}*/
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip, menu);
        return true;
    }
    
    
    public void showTipAmount(View v) {
    	
    //public void showTipAmount() {
    	EditText etBillAmount = (EditText)
    			findViewById(R.id.etBillAmount);
    	RadioGroup rgTipPercent = (RadioGroup) 
    			findViewById(R.id.rgTipPercent);
    	TextView tvTipAmount = (TextView)
    			findViewById(R.id.tvTipAmount);
    	TextView tvTotalAmount = (TextView)
    			findViewById(R.id.tvTotalAmount);
    	
    	//get tip percent from checked radio button value
    	int id= rgTipPercent.getCheckedRadioButtonId();
    	View radioButton = rgTipPercent.findViewById(id);
    	int radioId = rgTipPercent.indexOfChild(radioButton);
    	RadioButton btn = (RadioButton) rgTipPercent.getChildAt(radioId);
    	String tip_percent = (String) btn.getText().toString();
    	int tip_perc = Integer.parseInt( tip_percent.substring(0, tip_percent.length()-1));
    			    	
    	//get bill amount
        double bill = Double.parseDouble(etBillAmount.getText().toString());
    	
        //get tip amount
    	double tip_amount = tip_perc * bill / 100;
        double total = tip_amount + bill;
        
        DecimalFormat df = new DecimalFormat("#.00");
    	
    	tvTipAmount.setText("$" + df.format(tip_amount));
    	tvTotalAmount.setText("$" + df.format(total));
    }
    
    
    /*meditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {

                yourcalc();

                return true;
            }
            return false;
        }
    });*/
    
}
