// IRemoteService.aidl
package com.as.serveraidl;

import com.as.serveraidl.Rectangle;

interface IRemoteService {
	int calculateArea(in Rectangle rect);
}