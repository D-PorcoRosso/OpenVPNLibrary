package ru.drivepixels.openvpn;

import android.app.Activity;
import de.blinkt.openvpn.core.VpnStatus;
import de.blinkt.openvpn.core.VpnStatus.IStatusChanged;

public class OpenVPNStatusListener implements IStatusChanged {
	
	public OpenVPNStatusListener(){
		VpnStatus.setListener(this);
		
	}
	@Override
	public void onStatusAuth() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusConnecting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusWait() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusGetConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusAssignIP() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusAddRoutes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusConnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusDisconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusReconnecting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusExiting() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusResolve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusTCPConnect() {
		// TODO Auto-generated method stub
		
	}

}
