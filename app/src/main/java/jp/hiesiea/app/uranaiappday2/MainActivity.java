package jp.hiesiea.app.uranaiappday2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

/**
 * 占いアプリ メイン画面クラス
 * アクティビティ : 画面の単位
 * AppCompatActivity : 画面を表現するための一通りの機能を持つクラス
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 結果の総数
    private static final int RESULTS_NUM = 10;

    // 入力された名前に対応するキー名(定数)
    static final String INPUT_NAME = "InputName";

    // 占い結果の計算値に対応するキー名(定数)
    static final String RESULT_NUMBER = "ResultNumber";

    // オーバーライドされてきたonCreateメソッド
    // 最低限onCreateメソッドだけオーバーライドしておけばOK
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main.xmlのデータを読み込んで画面を生成
        // R : Resource、res
        // layout
        setContentView(R.layout.activity_main);

        // レイアウト(activity_main.xml)より、「占う」ボタン(IDがmain_btn_divine)を取得
        // ViewとButtonは親子関係
        Button buttonSubmit = findViewById(R.id.main_button_submit);

        // イベントを取得するためのリスナーを設定
        // this:このクラス自身(MainActivity)
        buttonSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // Intentクラスのオブジェクトを生成し、遷移先をResultActivityクラスとする
        Intent intent = new Intent(this, ResultActivity.class);

        // レイアウト(activity_main.xml)より、名前入力欄の情報を取得
        EditText editTextName = findViewById(R.id.main_edit_text_name);

        // 入力されている名前を文字列として取得
        String inputName = editTextName.getText().toString();

        // 遷移先に渡すデータをセット
        // 1. 取り出すときに指定するキー
        // 2. 実際のデータ
        intent.putExtra(INPUT_NAME, inputName);

        // 占い結果を乱数で算出(0~9)
        Random random = new Random();
        int resultNumber = random.nextInt(RESULTS_NUM);
        intent.putExtra(RESULT_NUMBER, resultNumber);

        // 画面遷移開始
        startActivity(intent);
    }
}
