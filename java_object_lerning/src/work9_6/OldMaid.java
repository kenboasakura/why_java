package work9_6;
//TrumpパッケージのCardクラスをインポート
import Trump.Card;
//TrumpパッケージのFantanMasterクラスをインポート
import Trump.FantanMaster;
//TrumpパッケージのHandクラスをインポート
import Trump.Hand;
//TrumpパッケージのJokerクラスをインポート
import Trump.Joker;
//TrumpパッケージのMasterクラスをインポート
import Trump.Master;
//TrumpパッケージのPlayerクラスをインポート
import Trump.Player;
//TrumpパッケージのRuleクラスをインポート
import Trump.Rule;
//TrumpパッケージのTableクラスをインポート
import Trump.Table;

/*クラス名:OldMaid
 *概要:ばば抜きを実行する
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class OldMaid {

	/*関数名:main
	 *概要:ばば抜きを進行役と3人で行う
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public static void main(String[] args) {
		//進行役のインスタンスを生成
		Master gameMaster = new FantanMaster();
		//ばば抜きのテーブルのインスタンスを生成
		Table gameTable = new OldMaidTable();
		//ばば抜きのルールのインスタンスを生成
		Rule gameRule = (Rule) new OldMaidRule();
		//村田さんのインスタンスを生成
		Player playerMurata = new OldMaidPlayer("村田", gameMaster, gameTable, gameRule);
		//山田さんのインスタンスを生成
		Player playerYamada = new OldMaidPlayer("山田", gameMaster, gameTable, gameRule);
		//斎藤さんのインスタンスを生成
		Player playerSaitoh = new OldMaidPlayer("斎藤", gameMaster, gameTable, gameRule);
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
		for (int i = Card.NUMBER_ACE; i <= Card.CARD_NUMBER; i++) {
			//クラブの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_CLUB, i));
			//ダイヤの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_DIAMOND, i));
			//ハートの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_HEART, i));
			//スペードの1から13までのトランプを生成
			trumpValue.addCard(new Card(Card.SUIT_SPADE, i));
			
		} 
		//ジョーカーを1枚生成
		trumpValue.addCard(new Joker());
		//トランプのインスタンスを返却
		return trumpValue;
	}

}
