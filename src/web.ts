import { WebPlugin } from '@capacitor/core';

import type { CapacitorNetworkInterfacePlugin } from './definitions';

export class CapacitorNetworkInterfaceWeb extends WebPlugin implements CapacitorNetworkInterfacePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
