package work9_6;

//TrumpパッケージのCardクラスをインポート
import Trump.Card;
//TrumpパッケージのHandクラスをインポート
import Trump.Hand;
//TrumpパッケージのMasterクラスをインポート
import Trump.Master;
//TrumpパッケージのPlayerクラスをインポート
import Trump.Player;
//TrumpパッケージのRuleクラスをインポート
import Trump.Rule;
//TrumpパッケージのTableクラスをインポート
import Trump.Table;

/*クラス名:OldMaidPlayer
 *概要:ばば抜きのプレイヤーを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class OldMaidPlayer extends Player {

	/*コンストラクタ名:OldMaidPlayer
	 *概要:スーパークラスのコンストラクタで初期化
	 *引数:名前(String)、進行役(Master)、試合中のテーブル(Table)、トランプのルール(Rule)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public OldMaidPlayer(String plyerName, Master gameMaster, Table gameTable, Rule gameRule) {
		//スーパークラスのコンストラクタを呼び出す
		super(plyerName, gameMaster, gameTable, gameRule);
	}

	/*関数名:receiveCard
	 *概要:カードを受け取り同じ数字のカードを捨てる
	 *引数:なし
	 *戻り値:プレイヤーのカード(Card)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void receiveCard(Card playerCard) {
		//カードを受け取る
		myHand.addCard(playerCard);
		//同じ数字のカードを格納する配列を生成
		Card[] sameCards = gameRule.findCandidate(myHand, gameTable);
		//ゲーム開始前に同じ数字のカードが合った場合
		if (sameCards != null) {
			//ペアになっているカードを表示
			System.out.print(this + ":");
			//同じ数字のカードを捨てる
			gameTable.putCard(sameCards);
		}
	}

	/*関数名:playGame
	 *概要:ばば抜きを実行する
	 *引数:次のプレイヤー(Player)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void playGame(Player nextPlayer) {
		//敗者を定数化
		final int GAME_LOSER = 1; 
		//次の人の手札を初期化して宣言
		Hand nextHand = ((OldMaidPlayer) nextPlayer).showHand();
		//次の人の手札を取得
		Card pickedCard = nextHand.pickCard(0);
		//次の人の引いたカードを表示
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");
		//引いたカードを加える
		this.receiveCard(pickedCard);
		//カードを引かれる人が残り手札1枚の場合
		if (nextHand.getNumberOfCards() == 0) {
			//ゲームマスターが勝利を宣言する
			gameMaster.declareWin(nextPlayer);
		}
		//手札がなくなった場合
		if (myHand.getNumberOfCards() == 0) {
			//ゲームマスターが勝利を宣言する
			gameMaster.declareWin(this);

			//手札がまだある場合
		} else if (myHand.getNumberOfCards() != 0 && gameMaster.getNumberOfPlayer() != GAME_LOSER) {
			//残りの手札を表示
			System.out.println(this + ":残りの手札は" + myHand + "です。");
		}

	}

	/*関数名:showHand
	 *概要:手札を見せる
	 *引数:なし
	 *戻り値:自分の手札(Hand)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public Hand showHand() {
		//カードをシャッフルする
		myHand.shuffleCard();
		//自分の手札を返却
		return myHand;

	}
}
