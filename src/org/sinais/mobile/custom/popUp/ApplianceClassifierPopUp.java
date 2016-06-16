package org.sinais.mobile.custom.popUp;

import org.sinais.mobile.R;

import android.view.View;
import android.widget.Button;

/**
 * class responsible for displaying a pop-up window that allows the user to change the default system guess
 */
public class ApplianceClassifierPopUp extends PopupWindowScreen {

	private static final String MODULE = "Appliance Classifier PopUp";
	
	public ApplianceClassifierPopUp(View v){
		super(v, R.layout.classifier_popup);
	}

	@Override
	protected void setButtonsClickListeners() {
		// TODO Auto-generated method stub
		Button b = (Button)findPopupWidget(R.id.back_popUp);
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					dismissPopupWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
