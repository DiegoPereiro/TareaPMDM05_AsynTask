package freijo.castro.diego.tareapmdm05_asyntask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {

    private WeakReference<TextView> mTextView;
    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }
    @Override
    protected String doInBackground(Void... voids) {
        // generar un numero entre 0 y 10
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 200;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "¡Despierta por fin después de dormir durante " + s + " milisegundos!";
    }

    @Override
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);

    }
}
