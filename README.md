Features
==========================
Native InApp Camera in custom activity basic features:

*Zoom
*Flash ON/OFF/AUTO.
*Image review screen.
*Title of image, the camera will show a title for camera ativity (optional if is sent in options)


Installation
==========================
Use: cordova plugin add cordova-plugin-inappcamera


Basic Usage
==========================

	navigator.Camera.takePicture(options).then(function(result){
		//result is image location on cache.
	});

	var options = {
	    quality: 50, // between 0-100 (default: 50)
	    targetWidth: 600,
	    targetHeight: 600,
	    imageText: "" //optional for show a title in camera activity.
	};

Information
==========================
This is a fork of the official camera plugin from Apache. The custom camera portion is specifically for Android. It is stock iOS / WP8 Camera calls otherwise.

It uses a custom activity to run in the foreground in Android to prevent Cordova from being killed.

It is adapted from https://code.google.com/p/foreground-camera-plugin/


