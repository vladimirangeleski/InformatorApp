package rotaryinformatorapp.com.rotaryinformatorapp.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import rotaryinformatorapp.com.rotaryinformatorapp.R;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class Util {
    private static final String TAG = "Util";

    public static int calculateNumberOfCategoryColums(Context context) {
        boolean isTablet = context.getResources().getBoolean(R.bool.isTablet);
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (isTablet) {
                return 3;
            } else {
                return 2;
            }
        } else {
            if (isTablet) {
                return 4;
            } else {
                return 3;
            }
        }
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
        LogWrapper.d(TAG, "copyFile() in=" + in.available() + ", out=" + out);
    }

    public static File getAssetFile(Context context, String fileName) throws IOException {
        AssetManager assetManager = context.getAssets();
        InputStream in = null;
        OutputStream out = null;
        File file = new File(context.getExternalFilesDir(null), fileName);
        try {
            in = assetManager.open(fileName);
            out = new FileOutputStream(new File(context.getExternalFilesDir(null), fileName));
            copyFile(in, out);
        } catch (Exception e) {
            LogWrapper.e(TAG, e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.flush();
            }
            if (out != null) {
                out.close();
            }
        }
        LogWrapper.d(TAG, "file=" + file + " ,size=" + file.length() / 1024);
        return file;
    }
}