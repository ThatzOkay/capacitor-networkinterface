package nl.thatzokay.capacitornetworkinterface;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;

import com.getcapacitor.PermissionState;

import java.net.InetAddress;
import java.util.Locale;

public class CapacitorNetworkInterface {

    private Context context;

    static final String NETWORK_INTERFACE = "receive";

    public CapacitorNetworkInterface(Context context) {
        this.context = context;
    }

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
    public String getWiFiIPAddress() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (context.checkSelfPermission(Manifest.permission.ACCESS_WIFI_STATE)
                    == PackageManager.PERMISSION_GRANTED) {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                int ip = wifiInfo.getIpAddress();

                return String.format(Locale.ROOT,
                        "%d.%d.%d.%d",
                        (ip & 0xff),
                        (ip >> 8 & 0xff),
                        (ip >> 16 & 0xff),
                        (ip >> 24 & 0xff)
                );
            } else {
                return "No permission";
            }
        } else {
            return "Not supported";
        }
    }
}
