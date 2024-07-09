package work9_5;

//TrumpパッケージのCardクラスをインポート
import Trump.Card;
import Trump.FantanMaster;
import Trump.Hand;
import Trump.Master;
import Trump.Player;
import Trump.Rule;
import Trump.Table;
import work9_2.FantanTable;
import work9_3.FantanRule;
import work9_4.FantanPlayer;

/*クラス名:Fantan
 *概要:七並べを実行
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class Fantan {

	/*関数名:main
	 *概要:3人と1人の進行役で七並べを行う
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public static void main(String[] args) {
		//進行役のインスタンスを生成
		Master gameMaster = new FantanMaster();
		//七並べのテーブルのインスタンスを生成
		Table gameTable = new FantanTable();
		//七並べのルールのインスタンスを生成
		Rule gameRule = new FantanRule();
		//村田さんのインスタンスを生成
		Player playerMurata = new FantanPlayer("村田", gameMaster, gameTable, gameRule);
		//山田さんのインスタンスを生成
		Player playerYamada = new FantanPlayer("山田", gameMaster, gameTable, gameRule);
		//斎藤さんのインスタンスを生成
		Player playerSaitoh = new FantanPlayer("斎藤", gameMaster, gameTable, gameRule);
		//村田さんの情報を登録
		gameMaster.registerPlayer(playerMurata);
		//山田さんの情報を登録
		gameMaster.registerPlayer(playerYamada);
		//斎藤さんの情報を登録
		gameMaster.registerPlayer(playerSaitoh);
		//トランプを生成
		Hand trumpGame = createTrump();
		//ゲームの準備を行う
		gameMaster.prepareGame(trumpGame);
		//ゲームを実行する
		gameMaster.startGame();

	}

	/*関数名:createTrump
	 *概要:トランプを生成して返却
	 *引数:なし
	 *戻り値:生成したトランプ(Hand)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	private static Hand createTrump() {
		//トランプのインスタンスを生成
		Hand trumpValue = new Hand();
		//トランプを生成
		for (int i = 1; i <= Card.CARD_NUMBER; i++) {
			//クラブの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_CLUB, i));
			//ダイヤの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_DIAMOND, i));
			//ハートの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_HEART, i));
			//スペードの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_SPADE, i));
		} //トランプのインスタンスを返却
		return trumpValue;
	}

}
