package work5_2;

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
          Player murata = new Player("村田さん");
          //村田さんに渡す戦略クラスを生成する
          Tactics murataTactics = new CicleTactics();
          //村田さんに戦略クラスを渡す
          murata.setTactics(murataTactics);
        //プレイヤー2(山田さん)のインスタンスを生成
          Player yamada = new Player("村田さん");
          //山田さんに渡す戦略クラスを生成する
          Tactics yamadaTactics = new CicleTactics();
          //山田さんに戦略クラスを渡す
          yamada.setTactics(yamadaTactics);
          //二人でジャンケンを開始
          saito.startJanken(murata, yamada);

         



    }



}
