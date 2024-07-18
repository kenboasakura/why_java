package work9_4;
//TrumpパッケージのCardクラスをインポート
import Trump.Card;
//TrumpパッケージのFantanMasterクラスをインポート
import Trump.FantanMaster;
//TrumpパッケージのMasterクラスをインポート
import Trump.Master;
//TrumpパッケージのPlayerクラスをインポート
import Trump.Player;
//TrumpパッケージのRuleクラスをインポート
import Trump.Rule;
//TrumpパッケージのTableクラスをインポート
import Trump.Table;

/*クラス名:FantanPlayer
 *概要:七並べを行うプレイヤーを管理
 *作成者:K.Asakura
 *作成日:2024/07/03
 */
public class FantanPlayer extends Player {
	//パスした回数を表すint型のフィールドを初期化して宣言
	private int passCount = 0;

	/*コンストラクタ名:FantanPlayer
	 *概要:七並べを行うプレイヤーを管理するフィールドを仮引数で初期化
	 *引数:名前(String)、進行役(Master)、試合中のテーブル(Table)、トランプのルール(Rule)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public FantanPlayer(String plyerName, Master gameMaster, Table gameTable, Rule gameRule) {
		//スーパークラスのコンストラクタを呼び出す
		super(plyerName, gameMaster, gameTable, gameRule);
	}

	/*関数名:receiveCard
	 *概要:7が配られたらテーブルに置き、それ以外は手札に加える
	 *引数:配られたカード(Card)
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void receiveCard(Card playerCard) {
		//カードの数字7を定数化
		final int CARD_NUMBER_SEVEN = 7;
		//受け取ったカードが7の場合
		if (playerCard.getNumber() == CARD_NUMBER_SEVEN) {
			//7を置いた人を表示
			System.out.println(plyerName+"さんが"+playerCard+"を置きました");
			//テーブルに置く
			gameTable.putCard(new Card[] { playerCard });
			//違う場合
		} else {
			//カードを手札に加える
			super.receiveCard(playerCard);
		}
	}

	/*関数名:playGame
	 *概要:ゲームを開始する
	 *引数:なし
	 *戻り値:なし
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public void playGame(Player nextPlayer) {
		//先頭のインデックスを定数化
		final int INDEX_NUMBER_ZERO = 0;
		//手札を表示
		System.out.println(" "+myHand);
		//テーブルに出せるカードを探す配列を生成
		Card[] canPutON = gameRule.findCandidate(myHand, gameTable);
		//置けるカードがある場合
		if (canPutON != null) {
			//置いたカードを表示
			System.out.println(canPutON[INDEX_NUMBER_ZERO]+ "を置きました");
			gameTable.putCard(canPutON);
			//テーブルを表示
			System.out.println(gameTable);
			//手札がなくなった場合
			if(myHand.getNumberOfCards() == 0) {
				//勝ちを宣言しそのプレイヤーを除外
				gameMaster.declareWin(this);
			}
			//置けるカードがない場合
		} else {
			//パス回数を1増加
			passCount++;
			//パス回数を宣告
			((FantanMaster)gameMaster).passDeclaration(this);
			//パス上限を超えた場合
			if (passCount > FantanMaster.PASS_LIMIT) {
				//手札を数えて代入
				int numberOfHand = myHand.getNumberOfCards();
				//もっていたカードを全てテーブルに置く
				for(int i = 0;i < numberOfHand;i++) {
					//1枚ずつテーブルに置く
					gameTable.putCard(new Card[] {myHand.pickCard(0)});
				}
			}
		}

	}

	/*関数名:getPass
	 *概要:パス回数を取得
	 *引数:なし
	 *戻り値:パス回数(int)
	 *作成者:K.Asakura
	 *作成日:2024/07/03
	 */
	public int getPass() {
		//パス回数を返却
		return passCount;
	}


}
