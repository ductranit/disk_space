package de.appgewaltig.disk_space_example

import android.os.Bundle
import de.appgewaltig.disk_space.DiskSpacePlugin
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class EmbeddingV1Activity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        flutterEngine.plugins.add(DiskSpacePlugin())
    }
}