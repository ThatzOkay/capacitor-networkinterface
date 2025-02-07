package nl.thatzokay.capacitornetworkinterface;

import android.Manifest;
import android.os.Build;

import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(name = "CapacitorNetworkInterface",
permissions = @Permission(strings = {Manifest.permission.ACCESS_WIFI_STATE}, alias = CapacitorNetworkInterface.NETWORK_INTERFACE))
public class CapacitorNetworkInterfacePlugin extends Plugin {

    private CapacitorNetworkInterface implementation;


    @Override
    public void load() {
        implementation = new CapacitorNetworkInterface(getContext());
    }

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void checkPermissions(PluginCall call) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            JSObject ret = new JSObject();
            ret.put("receive", "granted");
            call.resolve(ret);
        } else {
            super.checkPermissions(call);
        }
    }

    @PluginMethod
    public void requestPermissions(PluginCall call) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU || getPermissionState(CapacitorNetworkInterface.NETWORK_INTERFACE) == PermissionState.GRANTED) {
            JSObject ret = new JSObject();
            ret.put("receive", "granted");
            call.resolve(ret);
        } else {
            requestPermissionForAlias(CapacitorNetworkInterface.NETWORK_INTERFACE, call, "permissionsCallback");
        }
    }

    @PluginMethod
    public void getWiFiIPAddress(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("value", implementation.getWiFiIPAddress());
        call.resolve(ret);
    }

    @PermissionCallback
    private void permissionsCallback(PluginCall call) {
        this.checkPermissions(call);
    }
}
