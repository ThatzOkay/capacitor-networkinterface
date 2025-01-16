import { WebPlugin } from '@capacitor/core';

import type { CapacitorNetworkInterfacePlugin } from './definitions';

export class CapacitorNetworkInterfaceWeb extends WebPlugin implements CapacitorNetworkInterfacePlugin {
  requestPermission(): Promise<{ receive: string; }> {
    throw new Error('Method not implemented.');
  }
  checkPermissions(): Promise<{ status: string; }> {
    throw new Error('Method not implemented.');
  }
  getWiFiIPAddress(): Promise<{ value: string; }> {
    return new Promise((resolve, reject) => {
      const ips: Set<string> = new Set(); // Use a Set to avoid duplicates.

      const rtcPeerConnection =
        window.RTCPeerConnection || (window && {
          mozRTCPeerConnection: RTCPeerConnection,
        }).mozRTCPeerConnection || (window && {
          webkitRTCPeerConnection: RTCPeerConnection,
        }).webkitRTCPeerConnection;

      if (!RTCPeerConnection) {
        return reject(new Error('WebRTC is not supported in this browser.'));
      }

      const pc = new rtcPeerConnection({ iceServers: [] });

      pc.createDataChannel(''); // Create a data channel.

      pc.onicecandidate = (e) => {
        if (!e.candidate) {
          // No more candidates, resolve the promise.
          pc.close();
          resolve({ value: Array.from(ips)[0] || '' });
          return;
        }

        const parts = e.candidate.candidate.split(' ');
        const ip = parts[4]; // Extract the IP address.

        if (ip?.match(/^\d+\.\d+\.\d+\.\d+$/)) {
          ips.add(ip);
        }
      };

      pc.createOffer()
        .then((offer) => pc.setLocalDescription(offer))
        .catch((err) => {
          pc.close();
          reject(err);
        });
    });
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
