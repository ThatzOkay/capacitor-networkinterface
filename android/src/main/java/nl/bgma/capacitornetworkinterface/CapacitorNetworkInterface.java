package nl.bgma.capacitornetworkinterface;

import android.util.Log;

public class CapacitorNetworkInterface {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
