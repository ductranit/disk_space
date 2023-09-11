package de.appgewaltig.disk_space

import android.os.Environment
import android.os.StatFs
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

class MethodHandlerImpl : MethodChannel.MethodCallHandler {
    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when(call.method) {
            "getFreeDiskSpace" -> result.success(getFreeDiskSpace())
            "getTotalDiskSpace" -> result.success(getTotalDiskSpace())
            "getFreeDiskSpaceForPath" -> result.success(getFreeDiskSpaceForPath(call.argument<String>("path")!!))
            else -> result.notImplemented()
        }
    }

    private fun getFreeDiskSpace(): Double {
        val stat = StatFs(Environment.getDataDirectory().path)
        val bytesAvailable = stat.freeBytes
        return (bytesAvailable / (1024f * 1024f)).toDouble()
    }

    private fun getFreeDiskSpaceForPath(path: String): Double {
        val stat = StatFs(path)
        val bytesAvailable = stat.blockSizeLong * stat.availableBlocksLong
        return (bytesAvailable / (1024f * 1024f)).toDouble()
    }

    private fun getTotalDiskSpace(): Double {
        val stat = StatFs(Environment.getDataDirectory().path)
        val bytesAvailable = stat.totalBytes
        return (bytesAvailable / (1024f * 1024f)).toDouble()
    }
}