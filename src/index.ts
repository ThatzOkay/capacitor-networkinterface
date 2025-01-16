import { registerPlugin } from '@capacitor/core';

import type { CapacitorNetworkInterfacePlugin } from './definitions';

const CapacitorNetworkInterface = registerPlugin<CapacitorNetworkInterfacePlugin>('CapacitorNetworkInterface', {
  web: () => import('./web').then((m) => new m.CapacitorNetworkInterfaceWeb()),
});

export * from './definitions';
export { CapacitorNetworkInterface };
