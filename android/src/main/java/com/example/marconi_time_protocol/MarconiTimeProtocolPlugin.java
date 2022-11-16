package com.example.marconi_time_protocol;

import android.content.Context;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.StreamHandler;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/**
 * MarconiTimeProtocolPlugin
 */
public class MarconiTimeProtocolPlugin implements FlutterPlugin, MethodCallHandler, StreamHandler {
    private static MarconiTimeProtocolMethod marconiTimeProtocolMethod;
    private MethodChannel methodChannel;
    private EventChannel eventChannel;
    private Context context;


    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        context = flutterPluginBinding.getApplicationContext();
        methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "marconi_time_protocol");
        eventChannel = new EventChannel(flutterPluginBinding.getBinaryMessenger(), "marconi_time_protocol_events");
        eventChannel.setStreamHandler(this);
        marconiTimeProtocolMethod =
                new MarconiTimeProtocolMethod(context);
        methodChannel.setMethodCallHandler(this);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        switch (call.method) {
            case "getPlatformVersion" -> result.success("Android " + android.os.Build.VERSION.RELEASE);
            case "sendPacket" -> {




            }
            default -> result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        methodChannel.setMethodCallHandler(null);
    }

    @Override
    public void onListen(Object arguments, EventChannel.EventSink events) {

    }

    @Override
    public void onCancel(Object arguments) {

    }
}
