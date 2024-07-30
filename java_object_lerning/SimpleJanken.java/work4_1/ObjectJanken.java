package work4_1;
//work3_3パッケージのJudgeクラスをインポート
import work3_3.Judge;

/*クラス名:ObjectJanken
 *概要:村田さんと山田さんでジャンケンを実施
 *作成者:K.Asakura
 *作成日:2024/06/28
 */
public class ObjectJanken {
	 
	/*関数名:main
	 *概要:村田さんと山田さんでジャンケンを実施
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/06/28
	 */
    public static void main(String[] args) {
          //審判(斎藤さん)のインスタンスを生成
          Judge saito = new Judge();
          //プレイヤー1(村田さん)のインスタンスを生成
          Murata murata = new Murata("村田さん");
          //プレイヤー2(山田さん)のインスタンスを生成
          Yamada yamada = new Yamada("山田さん");
          //村田さんと山田さんでジャンケンを行う*Playerクラスを継承していないためエラーが起こる
          saito.startJanken(murata, yamada);

         



    }



}
