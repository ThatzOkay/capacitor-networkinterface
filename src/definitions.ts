export interface CapacitorNetworkInterfacePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
