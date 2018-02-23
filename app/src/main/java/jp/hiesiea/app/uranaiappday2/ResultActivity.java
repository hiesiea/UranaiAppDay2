package jp.hiesiea.app.uranaiappday2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // レイアウト(activity_result.xml)より、名前と占い結果のテキストビューを取得
        TextView textViewName = findViewById(R.id.result_text_view_name);
        TextView textViewResult = findViewById(R.id.result_text_view_result);

        // 遷移元のIntentを取得
        Intent intent = getIntent();

        // 遷移元でセットした氏名を取得し、TextViewに設定する
        String name = intent.getStringExtra(MainActivity.INPUT_NAME);
        textViewName.setText(name);

        // 遷移元でセットした計算値を取得し、それに対応する結果をTextViewに設定する
        // 第二引数: インテントから値を取得できなかったときの代わりの値
        int resultNumber = intent.getIntExtra(MainActivity.RESULT_NUMBER, 0);

        // Resource(resフォルダのstrings.xml)より、String型の配列データを取得
        String[] divineData = getResources().getStringArray(R.array.result_text_view_results);
        textViewResult.setText(divineData[resultNumber]);
    }
}
