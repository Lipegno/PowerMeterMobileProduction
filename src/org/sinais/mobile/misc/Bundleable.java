package org.sinais.mobile.misc;

import android.os.Bundle;

public interface Bundleable {

	public Bundle toBundle();
	
	public void fromBundle(Bundle b);
	
}
