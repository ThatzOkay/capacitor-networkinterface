export interface CapacitorNetworkInterfacePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getWiFiIPAddress(): Promise<{ value: string }>;
  requestPermission(): Promise<{ receive: string }>;
  checkPermissions(): Promise<{ status: string }>;
}
