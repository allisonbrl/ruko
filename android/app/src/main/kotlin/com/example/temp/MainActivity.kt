package com.sheero.ruko

import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.android.FlutterActivity

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        PhotoUtils.setupMethodChannel(flutterEngine.dartExecutor.binaryMessenger, contentResolver)
    }
}
